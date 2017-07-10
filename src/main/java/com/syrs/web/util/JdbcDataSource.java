package com.syrs.web.util;



import java.beans.PropertyVetoException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcDataSource {

	private ComboPooledDataSource pool;
	private ComboPooledDataSource attendancePool;
	private ComboPooledDataSource procedurePool;
	private static JdbcDataSource instance;
	
	
	public static final JdbcDataSource getInstance() throws Exception{
		if (instance == null) {
		 	try {
		 		instance = new JdbcDataSource();
		 	} catch (Exception e) {
		 		e.printStackTrace();
		 		throw new Exception("init pool failed");
		 	}
		}
		return instance;
	}
	
	private JdbcDataSource(){
		try {
			pool = initPool("");
			System.out.println("连接池启动成功");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	private ComboPooledDataSource initPool(String database) throws PropertyVetoException {
		String mysqlFlag = "mysql.";
		String databasePrefix = StringUtils.isEmptyOrWhitespaceOnly(database) ? mysqlFlag : mysqlFlag + database + "_";
		int poolSize = Integer.parseInt(PropUtil.getValue(databasePrefix+"init_pool_size"));
		String url = PropUtil.getValue(databasePrefix+"jdbc_url");
		String username = PropUtil.getValue(databasePrefix+"username");
		String password = PropUtil.getValue(databasePrefix+"password");
		int acquirIncrement = Integer.parseInt(PropUtil.getValue(databasePrefix+"acquir_increment"));
		int minSize = Integer.parseInt(PropUtil.getValue(databasePrefix+"min_size"));
		int maxSize = Integer.parseInt(PropUtil.getValue(databasePrefix+"max_size"));
		return createPool(url,username,password,poolSize,acquirIncrement,minSize,maxSize);
	}

	private ComboPooledDataSource createPool(String url,String username,String password,int initPoolSize,int increment,int minSize,int maxSize) throws PropertyVetoException{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		String driverName = PropUtil.getValue("mysql.driverclass");
		dataSource.setDriverClass(driverName);
		dataSource.setJdbcUrl(url);
		System.out.println(url);
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setAutoCommitOnClose(true);
		dataSource.setInitialPoolSize(initPoolSize);
		dataSource.setIdleConnectionTestPeriod(60*20);//20 minutes
		dataSource.setDebugUnreturnedConnectionStackTraces(true);
		dataSource.setUnreturnedConnectionTimeout(60);
		dataSource.setAcquireRetryAttempts(3);
		dataSource.setCheckoutTimeout(1000*30);//cannot get connection after n seconds, throw SQLException
		dataSource.setAcquireIncrement(increment);// no available connection, get n connections once
		dataSource.setMaxIdleTime(25);// idle time > n (seconds),the connection will expire
		dataSource.setMinPoolSize(minSize);
		dataSource.setMaxPoolSize(maxSize);// can keep mostly maxSize connections
		return dataSource;
	}
	
	public Connection getConnection() throws Exception{
		try {
			return pool.getConnection();
		} catch (Exception e) {
			throw new Exception("no avaliable connection in jdbc connection pool");
		}
	}
	
	public Connection getAttendanceConnection() throws Exception{
		try {
			return attendancePool.getConnection();
		} catch (Exception e) {
			throw new Exception("no avaliable connection in attendance jdbc connection pool");
		}
	}
	
	public Connection getProcedureConnection() throws Exception{
		try {
			return procedurePool.getConnection();
		} catch (Exception e) {
			throw new Exception("no avaliable connection in procedure jdbc connection pool");
		}
	}
	
	public void release(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn){
		try {
			if(null != rs) rs.close();
			if(null != ps) ps.close();
			if(null != conn) conn.close();
		} catch (SQLException e) {
			System.out.println("关闭连接失败");
			e.printStackTrace();
		}
	}
	
}
