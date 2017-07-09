package com.syrs.web.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
import com.syrs.web.DAO.SearchDAO;
import com.syrs.web.Model.MainImgShowModel;
import com.syrs.web.Model.NewsContentModel;
import com.syrs.web.Model.NewsListModel;
import com.syrs.web.Model.SecondImgAryModel;

@Service
public class ShootService {
	@Resource
	SearchDAO searchDAO;
	private final static String mysqlIp = "106.14.220.94:3306/My_DB?useUnicode=true&characterEncoding=utf-8&useSSL=false&autoReconnect=true&failOverReadOnly=false&maxReconnects=10";

//	public String backUrl(int id) {
//		String url = null;
//		String sqlStr = "SELECT * FROM manhua_list WHERE id=" + id;
//
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//
//		url = searchDAO.search(sqlStr, conn);
//		return url;
//	}
//
//	// 主页混合显示的图片列表
//	public List<MainImgShowModel> backMainAllImgList() {
//		String sql = "SELECT TITLE,ID,CREATE_TIME,PATH,IMG_NAME "
//				+ "FROM yellow_list ORDER BY CREATE_TIME DESC LIMIT 8;";
////		String sql1 = "SELECT TITLE,ID,CREATE_TIME,PATH,IMG_NAME "
////				+ "FROM funny_list ORDER BY CREATE_TIME DESC LIMIT 8";
//		String sql1 = "SELECT TITLE,ID,CREATE_TIME,PATH,IMG_NAME,NUM "
//				+ "FROM manhua_list ORDER BY CREATE_TIME DESC LIMIT 8;";
//		String sql2 = "SELECT TITLE,ID,CREATE_TIME,PATH,IMG_NAME "
//				+ "FROM face_list ORDER BY CREATE_TIME DESC LIMIT 8;";
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		List<MainImgShowModel> list = searchDAO.searchImgModelAry(sql, conn, false);
//		List<MainImgShowModel> list1 = searchDAO.searchImgModelAry(sql1, conn, false);
//		List<MainImgShowModel> list2 = searchDAO.searchImgModelAry(sql2, conn, false);
//		list.addAll(list1);
//		list.addAll(list2);
//		return list;
//	}
//
//	// 根据表名返回副主页的图片列表
//	public List<MainImgShowModel> backMainImgList(String tableName, boolean isManHua, Integer section, Integer count) {
//		String sqlStr = null;
//		if (isManHua) {
//			//sqlStr = "SELECT TITLE,ID,CREATE_TIME,PATH,IMG_NAME,NUM " + "FROM " + tableName + " ORDER BY CREATE_TIME DESC;";
//			sqlStr = "SELECT TITLE,ID,CREATE_TIME,PATH,IMG_NAME,NUM FROM " + tableName + " ORDER BY ID DESC LIMIT " + (section * 12) + "," + count + ";";
//		} else {
//			sqlStr = "SELECT TITLE,ID,CREATE_TIME,PATH,IMG_NAME FROM " + tableName + " ORDER BY ID DESC LIMIT " + (section * 12) + "," + count + ";";
//			//sqlStr = "SELECT TITLE,ID,CREATE_TIME,PATH,IMG_NAME " + "FROM " + tableName + " ORDER BY CREATE_TIME DESC;";
//		}
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.searchImgModelAry(sqlStr, conn, isManHua);
//	}
//
//	public Integer allNumber(String tableName) {
//		String sql = "select count(*) AS all_count from " + tableName;
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.allNumber(sql, conn);
//	}
//	
//	// 返回浏览写真图片的图集
//	public List<SecondImgAryModel> backSecondImgList(String yellowListID) {
//		String sqlStr = "SELECT * FROM yellow_img WHERE YELLOW_LIST_ID=" + yellowListID;
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.secondPageImageAry(sqlStr, conn);
//	}
//
//	// 返回下一个不会空的图集id
//	public String backIndexNumber(String yellowListID, String tableName) {
//		String sqlString = "SELECT MAX(ID) AS id FROM " + tableName + " WHERE ID < "
//				+ Integer.valueOf(yellowListID) + " ORDER BY ID;";
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.backNextID(sqlString, conn);
//	}
//
//	// 返回搞笑图片的图集
//	public List<SecondImgAryModel> backFunnyImgList(String funnyListID) {
//		String sql = "SELECT ID,CONCAT(PATH,IMG_NAME) AS PATH " + "FROM funny_list WHERE ID=" + funnyListID + ";";
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.secondPageFunImageAry(sql, conn);
//	}
//
//	// 返回表情图片的图集
//	public List<SecondImgAryModel> backFaceImgList(String faceListID) {
//		String sqlStr = "SELECT * FROM face_img WHERE FACE_LIST_ID=" + faceListID;
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.secondPageFaceImageAry(sqlStr, conn);
//	}
//
//	// 返回漫画图片的图集
//	public List<SecondImgAryModel> backManHuaImgList(String faceListID, String words) {
//		String sqlStr = "SELECT * FROM manhua_img WHERE MANHUA_LIST_ID=" + faceListID + " AND NUM=" + words + ";";
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.secondPageManHuaImageAry(sqlStr, conn);
//	}
//
//	// 返回标题
//	public String backTitle(String yellowListID, String tableName) {
//		String sqlStr = "SELECT concat(title,keytitle) AS TITLE FROM " + tableName + " WHERE ID=" + yellowListID + ";";
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.backTitle(sqlStr, conn);
//	}
//
//	// 推荐图库
//	public List<MainImgShowModel> backRecommendImg() {
//
//		String sqlStr = "SELECT TITLE,ID,CREATE_TIME,PATH,IMG_NAME " + "FROM yellow_list ORDER BY CREATE_TIME LIMIT 6;";
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.searchImgModelAry(sqlStr, conn, false);
//	}
//
//	// 返回相关的作品
//	public List<MainImgShowModel> backAboutImg() {
//		String sqlStr = "SELECT TITLE,ID,CREATE_TIME,PATH,IMG_NAME " + "FROM yellow_list ORDER BY rand() LIMIT 4;";
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.searchImgModelAry(sqlStr, conn, false);
//	}
//	
//	public Integer backNumberOfCartoons(String id) {
//		String sqlStr = "SELECT NUM FROM manhua_list WHERE ID = " + id;
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.allCartoon(sqlStr, conn);
//	}
//	
//	// 返回新闻列表
//	public List<NewsListModel> backNewsList(Integer section, Integer count) {  //num表示第几页
//		String sqlString = "SELECT * FROM news_list ORDER BY ID DESC LIMIT " + (section * 12) + "," + count + ";";
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.allNews(sqlString, conn);
//	}
//	
//	// 返回新闻表的条数
//	public Integer backNewsCount() {
//		String sql = "select count(*) AS news_count from news_list;";
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.allNewsCount(sql, conn);
//	}
//	//随机返回新闻数
//	public List<NewsListModel> randTitleList(Integer count) {
//		String sql = "SELECT * FROM news_list ORDER BY RAND() LIMIT " + count;
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.randNews(sql, conn);
//	}
//	
//	//根据news_id去新闻content取对应数据
//	public List<NewsContentModel> newsContent(String id) {
//		String sql = "SELECT * FROM news_content WHERE NEWS_LIST_ID = " + id + ";";
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.newsContent(sql, conn);
//	}
//	
//	//根据news_id取新闻图片
//	public List<NewsContentModel> newsImg(String id) {
//		String sql = "SELECT * FROM news_img WHERE NEWS_LIST_ID = " + id + ";";
//		Connection conn = searchDAO.getConnection("jdbc:mysql://" + mysqlIp, "root", "web123");
//		return searchDAO.newsImg(sql, conn);
//	}
}
