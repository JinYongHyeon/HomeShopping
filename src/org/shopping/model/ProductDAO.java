package org.shopping.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();

	private ProductDAO() {
	}

	public static ProductDAO getInstance() {
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DBInfo.DBURL, DBInfo.USER_NAME, DBInfo.USER_PASS);
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
	 * 어드민 페이지(상품리스트)
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ProductVO> productList() throws SQLException {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(
					"SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODCUT_IMG_PATH,PRODUCT_COUNT,PRODUCT_KINDS_NAME,PRODUCT_NEW,TO_CHAR(PRODUCT_DATE,"
							+ "'" + "YYYY/MM/DD" + "'" + ") AS 등록일");
			sb.append(" FROM HOMESHOPPING_PRODUCT");
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO vo = new ProductVO(rs.getString("PRODUCT_NO"), rs.getString("PRODUCT_NAME"),
						rs.getInt("PRODUCT_PRICE"), rs.getString("PRODCUT_IMG_PATH"), rs.getInt("PRODUCT_COUNT"),
						rs.getString("PRODUCT_KINDS_NAME"), rs.getString("PRODUCT_NEW"), rs.getString("등록일"));
				list.add(vo);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	/**
	 * 어드민 페이지(상품 삭제)
	 * @param no
	 * @throws SQLException
	 */
	public void productDelete(String no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE FROM HOMESHOPPING_PRODUCT WHERE PRODUCT_NO =?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, no);
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			con.rollback();
			throw e;
		} finally {
			closeAll(null, pstmt, con);
		}
	}
	/**
	 * 어드민 페이지(상품 검색)
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ProductVO> productFindByList(String name) throws SQLException{
		ArrayList<ProductVO> list= new ArrayList<ProductVO>();
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			con =getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(
					"SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODCUT_IMG_PATH,PRODUCT_COUNT,PRODUCT_KINDS_NAME,PRODUCT_NEW,TO_CHAR(PRODUCT_DATE,"
							+ "'" + "YYYY/MM/DD" + "'" + ") AS 등록일");
			sb.append(" FROM HOMESHOPPING_PRODUCT");
			sb.append(" WHERE PRODUCT_NAME=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO(rs.getString("PRODUCT_NO"), rs.getString("PRODUCT_NAME"),
						rs.getInt("PRODUCT_PRICE"), rs.getString("PRODCUT_IMG_PATH"), rs.getInt("PRODUCT_COUNT"),
						rs.getString("PRODUCT_KINDS_NAME"), rs.getString("PRODUCT_NEW"), rs.getString("등록일"));
				list.add(vo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	/**
	 * 어드민 페이지(상품 수정 폼)
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public ProductVO productUpdateFrom(String no) throws SQLException{
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		ProductVO vo =null;
		try {
			con =getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(
					"SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODCUT_IMG_PATH,PRODUCT_COUNT,PRODUCT_KINDS_NAME,PRODUCT_NEW,TO_CHAR(PRODUCT_DATE,"
							+ "'" + "YYYY/MM/DD" + "'" + ") AS 등록일");
			sb.append(" FROM HOMESHOPPING_PRODUCT");
			sb.append(" WHERE PRODUCT_NO=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 vo = new ProductVO(rs.getString("PRODUCT_NO"), rs.getString("PRODUCT_NAME"),
						rs.getInt("PRODUCT_PRICE"), rs.getString("PRODCUT_IMG_PATH"), rs.getInt("PRODUCT_COUNT"),
						rs.getString("PRODUCT_KINDS_NAME"), rs.getString("PRODUCT_NEW"), rs.getString("등록일"));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	/**
	 * 어드민 페이지(상품 수정)
	 * @param vo
	 * @throws SQLException
	 */
	public void productUpdate(ProductVO vo) throws SQLException {
		Connection con =null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE HOMESHOPPING_PRODUCT SET PRODUCT_NAME=?,PRODUCT_PRICE=?,PRODCUT_IMG_PATH=?,PRODUCT_COUNT=?,PRODUCT_KINDS_NAME=?,PRODUCT_NEW=?");
			sb.append(" WHERE PRODUCT_NO=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getImgPath());
			pstmt.setInt(4, vo.getCount());
			pstmt.setString(5, vo.getKinds());
			pstmt.setString(6, vo.getProductNew());
			pstmt.setString(7, vo.getNo());
			pstmt.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			con.rollback();
			throw e;
		}finally {
			closeAll(null, pstmt, con);
		}
	}
	/**
	 * 어드민 페이지(상품 추가)
	 * @param vo
	 * @throws SQLException
	 */
	public void productInsert(ProductVO vo)throws SQLException {
		Connection con =null;
		PreparedStatement pstmt =null;
		try {	
			con =getConnection();
			con.setAutoCommit(false);
			StringBuilder sb=  new StringBuilder();
			sb.append("INSERT INTO HOMESHOPPING_PRODUCT(PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_CONTENT,PRODCUT_IMG_PATH,PRODUCT_COUNT,PRODUCT_KINDS_NAME,PRODUCT_NEW,PRODUCT_DATE)");
			sb.append(" VALUES(HOMESHOPPING_PRODUCT_SEQ.NEXTVAL,?,?,?,?,?,?,?,SYSDATE)");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getImgPath());
			pstmt.setInt(5, vo.getCount());
			pstmt.setString(6, vo.getKinds());
			pstmt.setString(7, vo.getProductNew());
			pstmt.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			con.rollback();
			throw e;
		}finally {
			
		}
	}
	

}
