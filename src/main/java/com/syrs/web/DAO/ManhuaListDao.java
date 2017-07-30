package com.syrs.web.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sun.crypto.provider.RSACipher;
import com.syrs.web.entity.ManhuaImg;
import com.syrs.web.entity.ManhuaList;
import com.syrs.web.util.JDBC;


@Component
public class ManhuaListDao {
	
	/**
	 * 按时间降序获取List
	 * @param index		页码（从0开始）
	 * @param lenth		数量
	 * @return
	 */
	public List<ManhuaList> getList(int index, int lenth){
		JDBC jdbc = null;
		ArrayList<ManhuaList> manhuaLists = new ArrayList<>();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM manhua_list ORDER BY ID DESC LIMIT " + index*lenth + ", " + lenth + ";";
			jdbc.noParamsQuery();
	   		while(jdbc.rs.next()){
				ManhuaList manhuaList = new ManhuaList();
	   			manhuaList.setId(jdbc.rs.getInt("ID"));
	   			manhuaList.setTitle(jdbc.rs.getString("TITLE"));
	   			manhuaList.setType(jdbc.rs.getInt("TYPE"));
	   			manhuaList.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			manhuaList.setNum(jdbc.rs.getInt("NUM"));
	   			manhuaList.setPath(jdbc.rs.getString("PATH"));
	   			manhuaList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			manhuaList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			manhuaList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			manhuaList.setCreatTime(jdbc.rs.getDate("CREATE_TIME"));
	   			manhuaLists.add(manhuaList);
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return manhuaLists;
		}			
	}

	/**
	 * 根据Id获取list
	 * @param id
	 * @return
	 */
	public ManhuaList getList(Integer id){
		JDBC jdbc = null;
		ManhuaList manhuaList = new ManhuaList();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM manhua_list WHERE ID = " + id;
			jdbc.noParamsQuery();
	   		if(jdbc.rs.next()){
	   			manhuaList.setId(jdbc.rs.getInt("ID"));
	   			manhuaList.setTitle(jdbc.rs.getString("TITLE"));
	   			manhuaList.setType(jdbc.rs.getInt("TYPE"));
	   			manhuaList.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			manhuaList.setNum(jdbc.rs.getInt("NUM"));
	   			manhuaList.setPath(jdbc.rs.getString("PATH"));
	   			manhuaList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			manhuaList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			manhuaList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			manhuaList.setCreatTime(jdbc.rs.getDate("CREATE_TIME"));
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return manhuaList;
		}			
	}
	
	/**
	 * 获取下一话数据
	 * @param index				img表中的num
	 * @param manhuaListId
	 * @param num				list表中的num
	 * @return
	 */
	public ManhuaList getListNext(int index, int manhuaListId, int num){		
		JDBC jdbc = null;
		ManhuaList manhuaList = new ManhuaList();
		try {
			jdbc = new JDBC();
			if(index < num){
				jdbc.sql = "SELECT * FROM manhua_list WHERE ID = " + manhuaListId + ";";
			}
			else{
				jdbc.sql = "SELECT * FROM manhua_list WHERE ID = (SELECT MAX(ID) As ID FROM manhua_list WHERE ID < " + manhuaListId + " ORDER BY ID LIMIT 1);";
			}
			jdbc.noParamsQuery();
	   		if(jdbc.rs.next()){
	   			manhuaList.setId(jdbc.rs.getInt("ID"));
	   			manhuaList.setTitle(jdbc.rs.getString("TITLE"));
	   			manhuaList.setType(jdbc.rs.getInt("TYPE"));
	   			manhuaList.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			manhuaList.setPath(jdbc.rs.getString("PATH"));
	   			manhuaList.setNum(jdbc.rs.getInt("NUM"));
	   			manhuaList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			manhuaList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			manhuaList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			manhuaList.setCreatTime(jdbc.rs.getDate("CREATE_TIME"));
	   			if(index < num){
	   				manhuaList.setIndex(index+1);
	   			}
	   			else{
	   				manhuaList.setIndex(1);
	   			}
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return manhuaList;
		}			
	}
	
	/**
	 * 获取上一话数据
	 * @param index			img表中的num
	 * @param manhuaListId	
	 * @return
	 */
	public ManhuaList getListPrevious(int index, int manhuaListId){		
		JDBC jdbc = null;
		ManhuaList manhuaList = new ManhuaList();
		try {
			jdbc = new JDBC();
			if(index >  1){
				jdbc.sql = "SELECT * FROM manhua_list WHERE ID = " + manhuaListId + ";";
			}
			else{
				jdbc.sql = "SELECT * FROM manhua_list WHERE ID = (SELECT MIN(ID) As ID FROM manhua_list WHERE ID > " + manhuaListId + " ORDER BY ID LIMIT 1);";
			}
			jdbc.noParamsQuery();
	   		if(jdbc.rs.next()){
	   			manhuaList.setId(jdbc.rs.getInt("ID"));
	   			manhuaList.setTitle(jdbc.rs.getString("TITLE"));
	   			manhuaList.setType(jdbc.rs.getInt("TYPE"));
	   			manhuaList.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			manhuaList.setPath(jdbc.rs.getString("PATH"));
	   			manhuaList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			manhuaList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			manhuaList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			manhuaList.setCreatTime(jdbc.rs.getDate("CREATE_TIME"));
	   			if(index > 1){
	   				manhuaList.setIndex(index-1);
	   			}
	   			else{
	   				manhuaList.setIndex(1);
	   			}
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return manhuaList;
		}			
	}
	
	
	
	/**
	 * 根据ManhuaListId获取第index话数据
	 * @param index
	 * @param ManhuaListId
	 * @return
	 */
	public List<ManhuaImg> getListImg(int index, int ManhuaListId){
		JDBC jdbc = null;
		ArrayList<ManhuaImg> manhuaImgs = new ArrayList<>();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM manhua_img WHERE MANHUA_LIST_ID = " + ManhuaListId + " AND NUM = " + index + ";";
			jdbc.noParamsQuery();
	   		while(jdbc.rs.next()){
				ManhuaImg manhuaImg = new ManhuaImg();
	   			manhuaImg.setId(jdbc.rs.getInt("ID"));
	   			manhuaImg.setManhuaListId(jdbc.rs.getInt("MANHUA_LIST_ID"));
	   			manhuaImg.setNum(jdbc.rs.getInt("NUM"));
	   			manhuaImg.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			manhuaImg.setPath(jdbc.rs.getString("PATH"));
	   			manhuaImgs.add(manhuaImg);
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return manhuaImgs;
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
	   		jdbc.sql = "select count(*) AS all_count from manhua_list;";
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
