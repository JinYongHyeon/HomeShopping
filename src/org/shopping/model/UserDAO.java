package org.shopping.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
	private static UserDAO instance = new UserDAO();
	private String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userName = "scott";
	private String userPass = "tiger";

	private UserDAO() {
	}

	public static UserDAO getInstance() {
		return instance;
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();

	}
	/**
	 * Oracle DB연결 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl, userName, userPass);
	}
	
	/**
	 * 회원가입
	 * @param vo
	 * @throws SQLException
	 */
	public void userSingUp(UserVO vo) throws SQLException {
		Connection con= null;
		PreparedStatement pstmt=null;
		try {
			con = getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO HOMESHOPPING_USER(ID,PASSWORD,NAME,TEL,ADDRESS,EMAIL)");
			sb.append(" VALUES(?,?,?,?,?,?)");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getEmail());
			pstmt.executeQuery();
		}finally {
			closeAll(null, pstmt, con);
		}
	}
	
	/**
	 * 로그인
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public UserVO userLogin(UserVO user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO vo = null;
		try {
			con = getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID,NAME FROM HOMESHOPPING_USER");
			sb.append(" WHERE ID=? AND PASSWORD = ? ");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new UserVO();
				vo.setId(rs.getString("ID"));
				vo.setName(rs.getString("NAME"));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	/**
	 * 유저리스트
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<UserVO>userList() throws SQLException{
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		ArrayList<UserVO> userList = new ArrayList<UserVO>();
		try {
			con =getConnection();
			String sql = "SELECT ID,PASSWORD,NAME,TEL,ADDRESS,EMAIL,TOTAL_BUY FROM HOMESHOPPING_USER";
			pstmt =con.prepareStatement(sql);
			rs =pstmt.executeQuery();
			while(rs.next()) {
				UserVO vo = new UserVO(rs.getString("ID"), rs.getString("PASSWORD"), rs.getString("NAME"), rs.getString("TEL"), rs.getString("ADDRESS"), rs.getString("EMAIL"), rs.getInt("TOTAL_BUY"));
				userList.add(vo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return userList;
	}
	/**
	 * 유저 검색
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public UserVO userFindByList(String id) throws SQLException {
		UserVO vo = null;
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			con =getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID,PASSWORD,NAME,TEL,ADDRESS,EMAIL,TOTAL_BUY FROM HOMESHOPPING_USER");
			sb.append(" WHERE ID=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new UserVO(rs.getString("ID"), rs.getString("PASSWORD"), rs.getString("NAME"), rs.getString("TEL"), rs.getString("ADDRESS"), rs.getString("EMAIL"), rs.getInt("TOTAL_BUY"));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
		
	}
}
