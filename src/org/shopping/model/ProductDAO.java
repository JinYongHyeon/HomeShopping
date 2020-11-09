package org.shopping.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();
	private DataSource dataSource;
	
	private ProductDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static ProductDAO getInstance() {
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
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_MAIN_IMG,PRODUCT_POSSESION_COUNT,");
			sb.append("TO_CHAR(PRODUCT_DATE,'YYYY/MM/DD') AS PRODUCT_DATE,PRODUCT_TOTAL_SALE");
			sb.append(" FROM HOMESHOPPING_PRODUCT");
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO pvo= new ProductVO();
				pvo.setProductNo(rs.getString("PRODUCT_NO"));
				pvo.setProductName(rs.getString("PRODUCT_NAME"));
				pvo.setProductPrice(rs.getInt("PRODUCT_PRICE"));
				pvo.setProductMainImg(rs.getString("PRODUCT_MAIN_IMG"));
				pvo.setProductPossesionCount(rs.getInt("PRODUCT_POSSESION_COUNT"));
				pvo.setProductDate(rs.getNString("PRODUCT_DATE"));
				pvo.setProductTotalSale(rs.getInt("PRODUCT_TOTAL_SALE"));
				list.add(pvo);
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
			con = dataSource.getConnection();
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
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODCUT_MAIN_IMG,PRODUCT_POSSESION_COUNT,TO_CHAR(PRODUCT_DATE,"
					+ "'" + "YYYY/MM/DD" + "'" + ") AS 등록일,PRODUCT_TOTAL_SALE");
			sb.append(" FROM HOMESHOPPING_PRODUCT");
			sb.append(" WHERE PRODUCT_NAME=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo= new ProductVO();
				pvo.setProductNo(rs.getString("PRODUCT_NO"));
				pvo.setProductName(rs.getString("PRODUCT_NAME"));
				pvo.setProductPrice(rs.getInt("PRODUCT_PRICE"));
				pvo.setProductMainImg(rs.getString("PRODCUT_MAIN_IMG"));
				pvo.setProductPossesionCount(rs.getInt("PRODUCT_POSSESION_COUNT"));
				pvo.setProductDate(rs.getNString("등록일"));
				pvo.setProductTotalSale(rs.getInt("PRODUCT_TOTAL_SALE"));
				list.add(pvo);
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
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_CONTENT,PRODCUT_MAIN_IMG,PRODUCT_POSSESION_COUNT");
			sb.append(" FROM HOMESHOPPING_PRODUCT");
			sb.append(" WHERE PRODUCT_NO=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new ProductVO();
				vo.setProductNo(no);
				vo.setProductName(rs.getString("PRODUCT_NAME"));
				vo.setProductPrice(rs.getInt("PRODUCT_PRICE"));
				vo.setProductContent(rs.getString("PRODUCT_CONTENT"));
				vo.setProductMainImg("PRODCUT_MAIN_IMG");
				vo.setProductPossesionCount(rs.getInt("PRODUCT_POSSESION_COUNT"));
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
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE HOMESHOPPING_PRODUCT SET PRODUCT_NAME=?,PRODUCT_PRICE=?,PRODUCT_CONTENT=?,PRODCUT_MAIN_IMG=?,PRODUCT_POSSESION_COUNT=?");
			sb.append(" WHERE PRODUCT_NO=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getProductName());
			pstmt.setInt(2, vo.getProductPrice());
			pstmt.setString(3, vo.getProductContent());
			pstmt.setString(4, vo.getProductMainImg());
			pstmt.setInt(5, vo.getProductPossesionCount());
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
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			StringBuilder sb=  new StringBuilder();
			sb.append("INSERT INTO HOMESHOPPING_PRODUCT(PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_CONTENT,PRODCUT_MAIN_IMG,PRODUCT_POSSESION_COUNT,RODUCT_DATE)");
			sb.append(" VALUES(product_no_seq.NEXTVAL,?,?,?,?,?,SYSDATE)");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getProductName());
			pstmt.setInt(2, vo.getProductPrice());
			pstmt.setString(3, vo.getProductContent());
			pstmt.setString(4, vo.getProductMainImg());
			pstmt.setInt(5, vo.getProductPossesionCount());
			pstmt.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			con.rollback();
			throw e;
		}finally {
			
		}
	}
	

}
