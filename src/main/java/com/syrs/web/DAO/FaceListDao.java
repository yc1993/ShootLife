package com.syrs.web.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.syrs.web.entity.FaceImg;
import com.syrs.web.entity.FaceList;
import com.syrs.web.util.JDBC;

@Component
public class FaceListDao {
	/**
	 * 按时间降序获取List
	 * @param index		页码（从0开始）
	 * @param lenth		数量
	 * @return
	 */
	public List<FaceList> getList(int index, int lenth){
		JDBC jdbc = null;
		ArrayList<FaceList> faceLists = new ArrayList<>();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM face_list ORDER BY CREATE_TIME DESC LIMIT " + index*lenth + ", " + lenth + ";";
			jdbc.noParamsQuery();
	   		while(jdbc.rs.next()){
				FaceList faceList = new FaceList();
	   			faceList.setId(jdbc.rs.getInt("ID"));
	   			faceList.setTitle(jdbc.rs.getString("TITLE"));
	   			faceList.setType(jdbc.rs.getInt("TYPE"));
	   			faceList.setImgNum(jdbc.rs.getInt("IMG_NUM"));
	   			faceList.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			faceList.setPath(jdbc.rs.getString("PATH"));
	   			faceList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			faceList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			faceList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			faceList.setCreatTime(jdbc.rs.getDate("CREATE_TIME"));
	   			faceLists.add(faceList);
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return faceLists;
		}			
	}
	
	/**
	 * 根据Id获取list
	 * @param listId
	 * @return
	 */
	public FaceList getList(Integer listId){
		JDBC jdbc = null;
		FaceList faceList = new FaceList();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM face_list where ID = " + listId +";";
			jdbc.noParamsQuery();
	   		if(jdbc.rs.next()){
	   			faceList.setId(jdbc.rs.getInt("ID"));
	   			faceList.setTitle(jdbc.rs.getString("TITLE"));
	   			faceList.setType(jdbc.rs.getInt("TYPE"));
	   			faceList.setImgNum(jdbc.rs.getInt("IMG_NUM"));
	   			faceList.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			faceList.setPath(jdbc.rs.getString("PATH"));
	   			faceList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			faceList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			faceList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			faceList.setCreatTime(jdbc.rs.getDate("CREATE_TIME"));
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return faceList;
		}			
	}
	
	/**
	 * 随机获取一定数量的List
	 * @param num
	 * @return
	 */
	public List<FaceList> getListRand(int num ){
		JDBC jdbc = null;
		ArrayList<FaceList> faceLists = new ArrayList<>();
		try {
			jdbc = new JDBC();
			FaceList faceList = new FaceList();
	   		jdbc.sql = "SELECT * FROM face_list ORDER BY rand() LIMIT " + num + ";";
			jdbc.noParamsQuery();
	   		while(jdbc.rs.next()){
	   			faceList.setId(jdbc.rs.getInt("ID"));
	   			faceList.setTitle(jdbc.rs.getString("TITLE"));
	   			faceList.setType(jdbc.rs.getInt("TYPE"));
	   			faceList.setImgNum(jdbc.rs.getInt("IMG_NUM"));
	   			faceList.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			faceList.setPath(jdbc.rs.getString("PATH"));
	   			faceList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			faceList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			faceList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			faceList.setCreatTime(jdbc.rs.getDate("CREATE_TIME"));
	   			faceLists.add(faceList);
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return faceLists;
		}			
	}
	
	/**
	 * 获取下一条记录
	 * @param faceListId
	 * @return
	 */
	public FaceList getListNext(int faceListId ){
		JDBC jdbc = null;
		FaceList faceList = new FaceList();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM face_list WHERE ID = (SELECT MAX(ID) As ID FROM face_list WHERE ID < "+ faceListId +"  ORDER BY ID LIMIT 1);";
			jdbc.noParamsQuery();
	   		if(jdbc.rs.next()){
	   			faceList.setId(jdbc.rs.getInt("ID"));
	   			faceList.setTitle(jdbc.rs.getString("TITLE"));
	   			faceList.setType(jdbc.rs.getInt("TYPE"));
	   			faceList.setImgNum(jdbc.rs.getInt("IMG_NUM"));
	   			faceList.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			faceList.setPath(jdbc.rs.getString("PATH"));
	   			faceList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			faceList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			faceList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			faceList.setCreatTime(jdbc.rs.getDate("CREATE_TIME"));
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return faceList;
		}			
	}
	
	/**
	 * 获取上一条数据
	 * @param faceListId
	 * @return
	 */
	public FaceList getListPrevious(int faceListId ){
		JDBC jdbc = null;
		FaceList faceList = new FaceList();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM face_list WHERE ID = (SELECT MIN(ID) As ID FROM face_list WHERE ID > "+ faceListId +"  ORDER BY ID LIMIT 1);";
			jdbc.noParamsQuery();
	   		if(jdbc.rs.next()){
	   			faceList.setId(jdbc.rs.getInt("ID"));
	   			faceList.setTitle(jdbc.rs.getString("TITLE"));
	   			faceList.setType(jdbc.rs.getInt("TYPE"));
	   			faceList.setImgNum(jdbc.rs.getInt("IMG_NUM"));
	   			faceList.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			faceList.setPath(jdbc.rs.getString("PATH"));
	   			faceList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			faceList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			faceList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			faceList.setCreatTime(jdbc.rs.getDate("CREATE_TIME"));
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return faceList;
		}			
	}
	
	/**
	 * 根据listId获取图片
	 * @param faceListID
	 * @return
	 */
	public List<FaceImg> getImg(int faceListID) {
		JDBC jdbc = null;
		ArrayList<FaceImg> faceImgs = new ArrayList<>();
		try {
			jdbc = new JDBC();
			FaceImg faceImg = new FaceImg();
	   		jdbc.sql = "SELECT * FROM face_img WHERE FACE_LIST_ID = " + faceListID + ";";
			jdbc.noParamsQuery();
	   		while(jdbc.rs.next()){
	   			faceImg.setId(jdbc.rs.getInt("ID"));
	   			faceImg.setFaceListId(jdbc.rs.getInt("FACE_LIST_ID"));
	   			faceImg.setImgName(jdbc.rs.getString("IMG_NAME"));
	   			faceImg.setPath(jdbc.rs.getString("PATH"));
	   			faceImgs.add(faceImg);
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return faceImgs;
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
	   		jdbc.sql = "select count(*) AS all_count from face_list;";
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
