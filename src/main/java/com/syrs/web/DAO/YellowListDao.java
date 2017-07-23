package com.syrs.web.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.syrs.web.entity.YellowImg;
import com.syrs.web.entity.YellowList;
import com.syrs.web.util.JDBC;


@Component
public class YellowListDao {
	
	/**
	 * 按时间降序获取List
	 * @param index		页码（从0开始）
	 * @param lenth		数量
	 * @return
	 */
	public List<YellowList> getList(int index, int lenth){
		JDBC jdbc = null;
		ArrayList<YellowList> yellowLists = new ArrayList<>();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM yellow_list ORDER BY CREATE_TIME DESC LIMIT " + index*lenth + ", " + lenth + ";";
			jdbc.noParamsQuery();
	   		while(jdbc.rs.next()){
				YellowList yellowList = new YellowList();
	   			yellowList.setId(jdbc.rs.getInt("ID"));
	   			yellowList.setTitle(jdbc.rs.getString("TITLE"));
	   			yellowList.setType(jdbc.rs.getInt("TYPE"));
	   			yellowList.setImgNum(jdbc.rs.getInt("IMG_NUM"));
	   			yellowList.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			yellowList.setPath(jdbc.rs.getString("PATH"));
	   			yellowList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			yellowList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			yellowList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			yellowList.setCreatTime(jdbc.rs.getDate("CREATE_TIME"));
	   			yellowLists.add(yellowList);
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return yellowLists;
		}			
	}

	/**
	 * 根据ID获取List
	 * @param listId
	 * @return
	 */
	public YellowList getList(Integer listId){
		JDBC jdbc = null;
		YellowList yellowList = new YellowList();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM yellow_list where ID = " + listId + ";";
			jdbc.noParamsQuery();
	   		if(jdbc.rs.next()){
	   			yellowList.setId(jdbc.rs.getInt("ID"));
	   			yellowList.setTitle(jdbc.rs.getString("TITLE"));
	   			yellowList.setType(jdbc.rs.getInt("TYPE"));
	   			yellowList.setImgNum(jdbc.rs.getInt("IMG_NUM"));
	   			yellowList.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			yellowList.setPath(jdbc.rs.getString("PATH"));
	   			yellowList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			yellowList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			yellowList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			yellowList.setCreatTime(jdbc.rs.getDate("CREATE_TIME"));
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return yellowList;
		}			
	}
	
	
	/**
	 * 随机获取一定数量的List
	 * @param num
	 * @return
	 */
	public List<YellowList> getListRand(int num ){
		JDBC jdbc = null;
		ArrayList<YellowList> yellowLists = new ArrayList<>();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM yellow_list ORDER BY rand() LIMIT " + num + ";";
			jdbc.noParamsQuery();
	   		while(jdbc.rs.next()){
				YellowList yellowList = new YellowList();
	   			yellowList.setId(jdbc.rs.getInt("ID"));
	   			yellowList.setTitle(jdbc.rs.getString("TITLE"));
	   			yellowList.setType(jdbc.rs.getInt("TYPE"));
	   			yellowList.setImgNum(jdbc.rs.getInt("IMG_NUM"));
	   			yellowList.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			yellowList.setPath(jdbc.rs.getString("PATH"));
	   			yellowList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			yellowList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			yellowList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			yellowList.setCreatTime(jdbc.rs.getDate("CREATE_TIME"));
	   			yellowLists.add(yellowList);
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return yellowLists;
		}			
	}
	
	/**
	 * 获取下一条记录
	 * @param yellowListId
	 * @return
	 */
	public YellowList getListNext(int yellowListId ){
		JDBC jdbc = null;
		YellowList yellowList = new YellowList();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM yellow_list WHERE ID = (SELECT MAX(ID) As ID FROM yellow_list WHERE ID < "+ yellowListId +"  ORDER BY ID LIMIT 1);";
			jdbc.noParamsQuery();
	   		if(jdbc.rs.next()){
	   			yellowList.setId(jdbc.rs.getInt("ID"));
	   			yellowList.setTitle(jdbc.rs.getString("TITLE"));
	   			yellowList.setType(jdbc.rs.getInt("TYPE"));
	   			yellowList.setImgNum(jdbc.rs.getInt("IMG_NUM"));
	   			yellowList.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			yellowList.setPath(jdbc.rs.getString("PATH"));
	   			yellowList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			yellowList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			yellowList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			yellowList.setCreatTime(jdbc.rs.getDate("CREATE_TIME"));
	   			
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return yellowList;
		}			
	}
	
	/**
	 * 获取上一条数据
	 * @param yellowListId
	 * @return
	 */
	public YellowList getListPrevious(int yellowListId ){
		JDBC jdbc = null;
		YellowList yellowList = new YellowList();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM yellow_list WHERE ID = (SELECT MIN(ID) As ID FROM yellow_list WHERE ID > "+ yellowListId +"  ORDER BY ID LIMIT 1);";
			jdbc.noParamsQuery();
	   		if(jdbc.rs.next()){
	   			yellowList.setId(jdbc.rs.getInt("ID"));
	   			yellowList.setTitle(jdbc.rs.getString("TITLE"));
	   			yellowList.setType(jdbc.rs.getInt("TYPE"));
	   			yellowList.setImgNum(jdbc.rs.getInt("IMG_NUM"));
	   			yellowList.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			yellowList.setPath(jdbc.rs.getString("PATH"));
	   			yellowList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			yellowList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			yellowList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			yellowList.setCreatTime(jdbc.rs.getDate("CREATE_TIME"));
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return yellowList;
		}			
	}
	
	/**
	 * 根据listId获取图片
	 * @param yellowListID
	 * @return
	 */
	public List<YellowImg> getImg(int yellowListID) {
		JDBC jdbc = null;
		ArrayList<YellowImg> yellowImgs = new ArrayList<>();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM yellow_img WHERE YELLOW_LIST_ID = " + yellowListID + ";";
			jdbc.noParamsQuery();
	   		while(jdbc.rs.next()){
	   			YellowImg yellowImg = new YellowImg();
	   			yellowImg.setId(jdbc.rs.getInt("ID"));
	   			yellowImg.setYellowListId(jdbc.rs.getInt("YELLOW_LIST_ID"));
	   			yellowImg.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			yellowImg.setPath(jdbc.rs.getString("PATH"));
	   			yellowImgs.add(yellowImg);
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return yellowImgs;
		}			
	}
	
	/**
	 * 获取数量
	 * @return
	 */
	public int getNum(){
		JDBC jdbc = null;
		int num = 0;
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "select count(*) AS all_count from yellow_list;";
			jdbc.noParamsQuery();
	   		if(jdbc.rs.next()){
	   			num = jdbc.rs.getInt(1);
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return num;
		}			
		
	}
}









