package com.syrs.web.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBC {
	public String sql = null;
	public Connection conn = null;
	public PreparedStatement ps =null;
	public ResultSet rs = null;
	
	public JDBC() throws Exception {
		conn = JdbcDataSource.getInstance().getConnection();
	}

	public void rollback(String className,String methodName) throws Exception{
		try {
			conn.rollback();
		} catch (Exception e1) {
			throw new Exception(className+"/"+methodName+",rollback failed\r\n"+e1.getMessage());
		}
	}

	public void close() {
		JdbcDataSource.close(rs, ps, conn);
	}

	public void noParamsUpdate() throws SQLException {
		ps = conn.prepareStatement(sql);
		ps.executeUpdate();
	}

	public void noParamsQuery() throws SQLException {
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
	}
	
}
