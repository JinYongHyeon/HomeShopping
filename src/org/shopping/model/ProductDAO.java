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
	
	
	public int productListCount() throws SQLException {
		int count =0;
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			con =dataSource.getConnection();
			String sql="SELECT COUNT(*) FROM HOMESHOPPING_PRODUCT";
			pstmt = con.prepareStatement(sql);
			rs =pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}
	
	/**
	 * 어드민 페이지(상품리스트)
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ProductVO> productList(PagingBean pagingBean) throws SQLException {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_MAIN_IMG,PRODUCT_POSSESION_COUNT,PRODUCT_DATE,PRODUCT_TOTAL_SALE,PRODUCT_KINDS ");
			sb.append("FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRODUCT_NO ASC) AS RNUM,PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_MAIN_IMG,PRODUCT_POSSESION_COUNT,");
			sb.append("TO_CHAR(PRODUCT_DATE,'YYYY/MM/DD') AS PRODUCT_DATE,PRODUCT_TOTAL_SALE,PRODUCT_KINDS FROM HOMESHOPPING_PRODUCT)H ");
			sb.append("WHERE RNUM BETWEEN ? AND ?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, pagingBean.getStartPageRow());
			pstmt.setInt(2, pagingBean.getEndPageRow());
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
				pvo.setKinds(rs.getNString("PRODUCT_KINDS"));
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
	
	public int productFindByListCount(String name) throws SQLException {
		int count=0;
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql= "SELECT COUNT(*) FROM HOMESHOPPING_PRODUCT WHERE PRODUCT_NAME LIKE ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, '%'+name+'%');
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}
	
	
	/**
	 * 어드민 페이지(상품 검색)
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ProductVO> productFindByList(String name,PagingBean pagingBean) throws SQLException{
		ArrayList<ProductVO> list= new ArrayList<ProductVO>();
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_MAIN_IMG,PRODUCT_POSSESION_COUNT,PRODUCT_DATE,PRODUCT_TOTAL_SALE,PRODUCT_KINDS ");
			sb.append("FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRODUCT_NO ASC) AS RNUM,PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_MAIN_IMG,PRODUCT_POSSESION_COUNT,");
			sb.append("TO_CHAR(PRODUCT_DATE,'YYYY/MM/DD') AS PRODUCT_DATE,PRODUCT_TOTAL_SALE,PRODUCT_KINDS FROM HOMESHOPPING_PRODUCT WHERE PRODUCT_NAME LIKE ?)H ");
			sb.append("WHERE RNUM BETWEEN ? AND ?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, '%'+name+'%');
			pstmt.setInt(2, pagingBean.getStartPageRow());
			pstmt.setInt(3, pagingBean.getEndPageRow());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo= new ProductVO();
				pvo.setProductNo(rs.getString("PRODUCT_NO"));
				pvo.setProductName(rs.getString("PRODUCT_NAME"));
				pvo.setProductPrice(rs.getInt("PRODUCT_PRICE"));
				pvo.setProductMainImg(rs.getString("PRODUCT_MAIN_IMG"));
				pvo.setProductPossesionCount(rs.getInt("PRODUCT_POSSESION_COUNT"));
				pvo.setProductDate(rs.getNString("PRODUCT_DATE"));
				pvo.setProductTotalSale(rs.getInt("PRODUCT_TOTAL_SALE"));
				pvo.setKinds(rs.getNString("PRODUCT_KINDS"));
				list.add(pvo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
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
			sb.append("UPDATE HOMESHOPPING_PRODUCT SET PRODUCT_NAME=?,PRODUCT_PRICE=?,PRODUCT_CONTENT=?,PRODUCT_POSSESION_COUNT=?,PRODUCT_KINDS=?");
			sb.append(" WHERE PRODUCT_NO=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getProductName());
			pstmt.setInt(2, vo.getProductPrice());
			pstmt.setString(3, vo.getProductContent());
			pstmt.setInt(4, vo.getProductPossesionCount());
			pstmt.setString(5, vo.getKinds());
			pstmt.setString(6, vo.getProductNo());
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
			sb.append("INSERT INTO HOMESHOPPING_PRODUCT(PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_CONTENT,product_main_img,product_possesion_count,PRODUCT_DATE,PRODUCT_KINDS)");
			sb.append(" VALUES(product_no_seq.NEXTVAL,?,?,?,?,?,SYSDATE,?)");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getProductName());
			pstmt.setInt(2, vo.getProductPrice());
			pstmt.setString(3, vo.getProductContent());
			pstmt.setString(4, vo.getProductMainImg());
			pstmt.setInt(5, vo.getProductPossesionCount());
			pstmt.setString(6, vo.getKinds());
			pstmt.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			con.rollback();
			throw e;
		}finally {
			closeAll(null, pstmt, con);
		}
	}
	
	public ProductVO productDetail(String productNo) throws SQLException {
		ProductVO pvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT product_no,product_name,product_price,product_content,product_main_img,product_possesion_count,TO_CHAR(PRODUCT_DATE,'YYYY/MM/DD') AS product_date,product_kinds ");
			sb.append("FROM HOMESHOPPING_PRODUCT WHERE product_no=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, productNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pvo = new ProductVO();
				pvo.setProductNo(rs.getString("product_no"));
				pvo.setProductName(rs.getString("product_name"));
				pvo.setProductPrice(rs.getInt("product_price"));
				pvo.setProductContent(rs.getString("product_content"));
				pvo.setProductMainImg(rs.getString("product_main_img"));
				pvo.setProductPossesionCount(rs.getInt("product_possesion_count"));
				pvo.setProductDate(rs.getString("product_date"));
				pvo.setKinds(rs.getString("product_kinds"));
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return pvo;
	}
	

}
