package org.shopping.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class UserDAO {
	private static UserDAO instance = new UserDAO();
	private DataSource dataSource;

	private UserDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
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
	 * 회원가입
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void userSingUp(UserVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO HOMESHOPPING_USER(ID,PASSWORD,NAME,ADDRESS,TELEPHONE,EMAIL)");
			sb.append(" VALUES(?,?,?,?,?,?)");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getTelephone());
			pstmt.setString(6, vo.getEmail());
			pstmt.executeQuery();
		} finally {
			closeAll(null, pstmt, con);
		}
	}

	/**
	 * 로그인
	 * 
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
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID,PASSWORD,NAME,ADDRESS,TELEPHONE,EMAIL,TOTAL_PURCHASE FROM HOMESHOPPING_USER");
			sb.append(" WHERE ID=? AND PASSWORD = ? ");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new UserVO();
				vo.setId(rs.getString("ID"));
				vo.setPassword(rs.getString("PASSWORD"));
				vo.setName(rs.getString("NAME"));
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setTelephone(rs.getString("TELEPHONE"));
				vo.setEmail( rs.getString("EMAIL"));
				vo.setTotalPurchase(rs.getInt("TOTAL_PURCHASE"));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}

	/**
	 * 유저리스트
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<UserVO> userList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UserVO> userList = new ArrayList<UserVO>();
		try {
			con = dataSource.getConnection();
			String sql = "SELECT ID,PASSWORD,NAME,ADDRESS,TELEPHONE,EMAIL,TOTAL_PURCHASE FROM HOMESHOPPING_USER";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserVO vo = new UserVO(rs.getString("ID"), rs.getString("PASSWORD"), rs.getString("NAME"),
						rs.getString("TELEPHONE"), rs.getString("ADDRESS"), rs.getString("EMAIL"), rs.getInt("TOTAL_PURCHASE"));
				userList.add(vo);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return userList;
	}

	/**
	 * 유저 검색
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<UserVO> userFindByList(String id) throws SQLException {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		UserVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT id,PASSWORD,NAME,ADDRESS,TELEPHONE,EMAIL,TOTAL_PURCHASE FROM HOMESHOPPING_USER");
			sb.append(" WHERE ID LIKE ?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,'%'+id+'%');
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new UserVO(rs.getString("id") , rs.getString("PASSWORD"), rs.getString("NAME"), rs.getString("TELEPHONE"),
						rs.getString("ADDRESS"), rs.getString("EMAIL"), rs.getInt("TOTAL_PURCHASE"));
				list.add(vo);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;

	}
	/**
	 * 회원정보 수정
	 * @param vo
	 * @throws SQLException
	 */
	public void userImformationUpdate(UserVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb= new StringBuilder();
			sb.append("UPDATE HOMESHOPPING_USER SET PASSWORD=?,NAME=?,TELEPHONE=?,ADDRESS=?,EMAIL=?");
			sb.append(" WHERE ID=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,vo.getPassword());
			pstmt.setString(2,vo.getName());
			pstmt.setString(3,vo.getTelephone());
			pstmt.setString(4,vo.getAddress());
			pstmt.setString(5,vo.getEmail());
			pstmt.setString(6,vo.getId());
			pstmt.executeUpdate();
		}finally {
			closeAll(null, pstmt, con);
					
		}
	}
	
}
