package com.syrs.web.DAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;
import com.syrs.web.util.JDBC;

@Component
public class CountDao {
	SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 
	 * @param type   0:main   1:yellow   2:manhua   3:news   4:face
	 * @param listId
	 * @param pc   0否   1是
	 */
	public void setCount(int type, int listId, int pc){
		JDBC jdbc = null;
		int id = 0;
		try {
			jdbc = new JDBC();
			jdbc.conn.setAutoCommit(false);
			jdbc.sql = "SELECT ID, NUM FROM count WHERE DAY = '" + dfs.format(new Date()) + "' and LIST_ID = " + listId +" and TYPE = " + type + " and PC=" +pc+ ";";
			jdbc.noParamsQuery();
	
			if (jdbc.rs.next()) {
				id = jdbc.rs.getInt("ID");
				jdbc.sql = "UPDATE count SET NUM = " + (jdbc.rs.getInt("NUM")+1) + ", PC=" + pc + " WHERE ID = " +id+ ";";
				jdbc.noParamsUpdate();
			}
			else{
				jdbc.sql = "INSERT INTO count (TYPE, LIST_ID, NUM, DAY, PC) VALUES(" +type+ ", " +listId+ ", 1, '" +dfs.format(new Date())+ "', "+ pc+");";
				jdbc.ps = jdbc.conn.prepareStatement(jdbc.sql);
		   		jdbc.ps.executeUpdate();
			}
			jdbc.conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != jdbc)
				jdbc.close();
		}
	}

}
