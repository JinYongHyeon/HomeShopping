package org.shopping.model;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;



public class DataSourceManager {
	private static DataSourceManager instance = new DataSourceManager();
	private DataSource datasource = null;
	
	private DataSourceManager() {
		BasicDataSource dbcp = new BasicDataSource();
		dbcp.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dbcp.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dbcp.setUsername("dotory2");
		dbcp.setPassword("kosta");
		dbcp.setInitialSize(4);
		dbcp.setMaxTotal(10);
		this.datasource = dbcp;
	}
	
	public static DataSourceManager getInstance() {
		return instance;
	}
	
	public DataSource getDataSource() {
		return datasource;
	}
}
