package com.syrs.web.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.syrs.web.entity.NewsList;
import com.syrs.web.entity.NewsListImgAndContent;
import com.syrs.web.entity.YellowList;
import com.syrs.web.util.JDBC;


@Component
public class NewsListDao {
	/**
	 * 按时间降序获取List
	 * @param index		页码（从0开始）
	 * @param lenth		数量
	 * @return
	 */
	public List<NewsList> getList(int index, int lenth){
		JDBC jdbc = null;
		ArrayList<NewsList> newsLists = new ArrayList<>();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM news_list ORDER BY CREATE_TIME DESC LIMIT " + index*lenth + ", " + lenth + ";";
			jdbc.noParamsQuery();
	   		while(jdbc.rs.next()){
				NewsList newsList = new NewsList();
	   			newsList.setId(jdbc.rs.getInt("ID"));
	   			newsList.setTitle(jdbc.rs.getString("TITLE"));
	   			newsList.setImgPath(jdbc.rs.getString("IMG_PATH"));
	   			newsList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			newsList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			newsList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			newsList.setCreatTime(jdbc.rs.getTimestamp("CREATE_TIME"));
	   			newsLists.add(newsList);
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return newsLists;
		}			
	}
	
	/**
	 * 随机获取一定数量的List
	 * @param num
	 * @return
	 */
	public List<NewsList> getListRand(int num ){
		JDBC jdbc = null;
		ArrayList<NewsList> newsLists = new ArrayList<>();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM news_list ORDER BY rand() LIMIT " + num + ";";
			jdbc.noParamsQuery();
	   		while(jdbc.rs.next()){
	   			NewsList newsList = new NewsList();
	   			newsList.setId(jdbc.rs.getInt("ID"));
	   			newsList.setTitle(jdbc.rs.getString("TITLE"));
	   			newsList.setImgPath(jdbc.rs.getString("IMG_PATH"));
	   			newsList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			newsList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			newsList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			newsList.setCreatTime(jdbc.rs.getTimestamp("CREATE_TIME"));
	   			newsLists.add(newsList);
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return newsLists;
		}			
	}
	
	/**
	 * 获取下一个数据
	 * @param newsListId
	 * @return
	 */
	public NewsList getListNext(int newsListId){
		JDBC jdbc = null;
		NewsList newsList = new NewsList();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM news_list WHERE ID = (SELECT MAX(ID) As ID FROM news_list WHERE ID < " + newsListId + "  ORDER BY ID LIMIT 1);";
			jdbc.noParamsQuery();
	   		if(jdbc.rs.next()){
	   			newsList.setId(jdbc.rs.getInt("ID"));
	   			newsList.setTitle(jdbc.rs.getString("TITLE"));
	   			newsList.setImgPath(jdbc.rs.getString("IMG_PATH"));
	   			newsList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			newsList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			newsList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			newsList.setCreatTime(jdbc.rs.getTimestamp("CREATE_TIME"));
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return newsList;
		}			
	}
	
	/**
	 * 获取上一条数据
	 * @param newsListId
	 * @return
	 */
	public NewsList getListPrevious(int newsListId){
		JDBC jdbc = null;
		NewsList newsList = new NewsList();
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM news_list WHERE ID = (SELECT MIN(ID) As ID FROM news_list WHERE ID > " + newsListId + "  ORDER BY ID LIMIT 1);";
			jdbc.noParamsQuery();
	   		if(jdbc.rs.next()){
	   			newsList.setId(jdbc.rs.getInt("ID"));
	   			newsList.setTitle(jdbc.rs.getString("TITLE"));
	   			newsList.setImgPath(jdbc.rs.getString("IMG_PATH"));
	   			newsList.setGoodNum(jdbc.rs.getInt("GOOD_NUM"));
	   			newsList.setBadNum(jdbc.rs.getInt("BAD_NUM"));
	   			newsList.setLookNum(jdbc.rs.getInt("LOOK_NUM"));
	   			newsList.setCreatTime(jdbc.rs.getTimestamp("CREATE_TIME"));
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return newsList;
		}			
	}
	
	
	/**
	 * 根据listId获取img
	 * @param NewsListId
	 * @return
	 */
	public List<NewsListImgAndContent> getLisImg(int newsListId){
		
		JDBC jdbc = null;
		ArrayList<NewsListImgAndContent> newsListImgAndContents =  new ArrayList<>(); 
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM news_img WHERE NEWS_LIST_ID = " + newsListId + ";";
			jdbc.noParamsQuery();
	   		while(jdbc.rs.next()){
				NewsListImgAndContent newsListImgAndContent = new NewsListImgAndContent();
	   			newsListImgAndContent.setId(jdbc.rs.getInt("ID"));
	   			newsListImgAndContent.setNewsListId(jdbc.rs.getInt("NEWS_LIST_ID"));
	   			newsListImgAndContent.setNum(jdbc.rs.getInt("NUM"));
	   			newsListImgAndContent.setPath(jdbc.rs.getString("PATH"));
	   			newsListImgAndContents.add(newsListImgAndContent);
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return newsListImgAndContents;
		}			
		
	}
	
	/**
	 * 根据listId获取Content
	 * @param NewsListId
	 * @return
	 */
	public List<NewsListImgAndContent> getLisContent(int newsListId){
		JDBC jdbc = null;
		ArrayList<NewsListImgAndContent> newsListImgAndContents =  new ArrayList<>(); 
		try {
			jdbc = new JDBC();
	   		jdbc.sql = "SELECT * FROM news_content WHERE NEWS_LIST_ID = " + newsListId + ";";
			jdbc.noParamsQuery();
	   		while(jdbc.rs.next()){
				NewsListImgAndContent newsListImgAndContent = new NewsListImgAndContent();
	   			newsListImgAndContent.setId(jdbc.rs.getInt("ID"));
	   			newsListImgAndContent.setNewsListId(jdbc.rs.getInt("NEWS_LIST_ID"));
	   			newsListImgAndContent.setNum(jdbc.rs.getInt("NUM"));
	   			newsListImgAndContent.setContent(jdbc.rs.getString("CONTENT"));
	   			newsListImgAndContents.add(newsListImgAndContent);
	   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null != jdbc){
				jdbc.close();
			}
			return newsListImgAndContents;
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
	   		jdbc.sql = "select count(*) AS all_count from news_list;";
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
