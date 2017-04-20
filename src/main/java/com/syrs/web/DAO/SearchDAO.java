package com.syrs.web.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.syrs.web.Model.MainImgShowModel;
import com.syrs.web.Model.NewsContentModel;
import com.syrs.web.Model.NewsListModel;
import com.syrs.web.Model.SecondImgAryModel;

@Component
public class SearchDAO {

	// 查询的数据库语句，数据库的用户名和密码
	public Connection getConnection(String mysqlURL, String username, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			if (password != null) {
				conn = (Connection) DriverManager.getConnection(mysqlURL, username, password);
			} else {
				if (username == null || "".equals(username)) {
					conn = (Connection) DriverManager.getConnection(mysqlURL);
				} else {

					System.out.println("存在用户名的时候，密码不能为null");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 测试来返回图片路径
	public String search(String sql, Connection conn) {
		String path = null;
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {

				path = set.getString("PATH");
			}

			set.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	// 主页图片展示
	public List<MainImgShowModel> searchImgModelAry(String sql, Connection conn, boolean isManHua) {
		List<MainImgShowModel> modelList = new ArrayList<>();

		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			modelList.clear();
			while (set.next()) {

				MainImgShowModel mainImgShowModel = new MainImgShowModel();
				mainImgShowModel.setCreateTime(set.getDate("CREATE_TIME"));
				mainImgShowModel.setId(set.getInt("ID"));
				// mainImgShowModel.setImgNum(set.getInt(columnLabel));
				mainImgShowModel.setPath(set.getString("PATH"));
				mainImgShowModel.setTitle(set.getString("TITLE"));
				if (isManHua) { // 判断是否为漫画
					mainImgShowModel.setManhuaNum(set.getInt("NUM"));
				}
				mainImgShowModel.setImgName(set.getString("IMG_NAME"));
				modelList.add(mainImgShowModel);

			}
			set.close();
			statement.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelList;
	}

	// 返回浏览图片页面的图集
	public List<SecondImgAryModel> secondPageImageAry(String sql, Connection conn) {
		List<SecondImgAryModel> aryList = new ArrayList<>();
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				SecondImgAryModel siam = new SecondImgAryModel();
				siam.setId(set.getInt("ID"));
				siam.setImagePath(set.getString("PATH"));
				siam.setYellowListId(set.getString("YELLOW_LIST_ID"));
				aryList.add(siam);
			}
			set.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aryList;
	}

	// 返回不为空的listID
	public String backNextID(String sql, Connection conn) {
		String yellowListId = null;
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				yellowListId = set.getString("id");
			}
			set.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return yellowListId;
	}

	// 返回搞笑图片页面的图集
	public List<SecondImgAryModel> secondPageFunImageAry(String sql, Connection conn) {
		List<SecondImgAryModel> aryList = new ArrayList<>();
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				SecondImgAryModel siam = new SecondImgAryModel();
				siam.setId(set.getInt("ID"));
				siam.setImagePath(set.getString("PATH"));
				aryList.add(siam);
			}
			set.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aryList;
	}

	// 返回漫画图片页面的图集
	public List<SecondImgAryModel> secondPageManHuaImageAry(String sql, Connection conn) {
		List<SecondImgAryModel> aryList = new ArrayList<>();
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				SecondImgAryModel siam = new SecondImgAryModel();
				siam.setId(set.getInt("ID"));
				siam.setImagePath(set.getString("PATH"));
				siam.setYellowListId(set.getString("MANHUA_LIST_ID"));
				aryList.add(siam);
			}
			set.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aryList;
	}

	// 返回表情图片页面的图集
	public List<SecondImgAryModel> secondPageFaceImageAry(String sql, Connection conn) {
		List<SecondImgAryModel> aryList = new ArrayList<>();
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				SecondImgAryModel siam = new SecondImgAryModel();
				siam.setId(set.getInt("ID"));
				siam.setImagePath(set.getString("PATH"));
				siam.setYellowListId(set.getString("FACE_LIST_ID"));
				aryList.add(siam);
			}
			set.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aryList;
	}

	public String backTitle(String sql, Connection conn) {
		String title = null;
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				title = set.getString("TITLE");
			}
			set.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return title;
	}
	
	//返回漫画章节数
	public Integer allCartoon(String sql, Connection conn) {
		Integer count = 0;
		Statement statement;
		try {
			statement = (Statement) conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				count = set.getInt("NUM");
			}
			set.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//返回新闻列表
	public List<NewsListModel> allNews(String sql, Connection conn) {
		Statement statement;
		List<NewsListModel> arrayList = new ArrayList<NewsListModel>();
		try {
			statement = (Statement) conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				NewsListModel nlm = new NewsListModel();
				nlm.setId(set.getInt("ID"));
				nlm.setCreateTime(set.getTimestamp("CREATE_TIME"));
				nlm.setImgPath(set.getString("IMG_PATH"));
				nlm.setTitle(set.getString("TITLE"));
				nlm.setNum(set.getInt("NUM"));
				arrayList.add(nlm);
			}
			set.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayList;
	}
	
	//返回新闻的条数
	public Integer allNewsCount(String sql, Connection conn) {
		Statement statement;
		Integer count = 0;
		try {
			statement = (Statement) conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				count = set.getInt("news_count");
			}
			set.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//随机返回的新闻
	public List<NewsListModel> randNews(String sql, Connection conn) {
		Statement statement;
		List<NewsListModel> titleList = new ArrayList<>();
		try {
			statement = (Statement) conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				NewsListModel nlm = new NewsListModel();
				nlm.setId(set.getInt("ID"));
				nlm.setCreateTime(set.getTimestamp("CREATE_TIME"));
				nlm.setImgPath(set.getString("IMG_PATH"));
				nlm.setTitle(set.getString("TITLE"));
				nlm.setNum(set.getInt("NUM"));
				titleList.add(nlm);
			}
			set.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return titleList;
	}
	
	//根据新闻id返回content
	public List<NewsContentModel> newsContent(String sql, Connection conn) {
		Statement statement;
		List<NewsContentModel> newsContentList = new ArrayList<>();
		try {
			statement = (Statement) conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				NewsContentModel ncm = new NewsContentModel();
				ncm.setContent(set.getString("CONTENT"));
				ncm.setNum(set.getInt("NUM"));
				newsContentList.add(ncm);
			}
			set.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newsContentList;
	}
	
	//根据新闻id返回图片
	public List<NewsContentModel> newsImg(String sql, Connection conn) {
		Statement statement;
		List<NewsContentModel> newsContentList = new ArrayList<>();
		try {
			statement = (Statement) conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				NewsContentModel ncm = new NewsContentModel();
				ncm.setPath(set.getString("PATH"));
				ncm.setNum(set.getInt("NUM"));
				newsContentList.add(ncm);
			}
			set.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newsContentList;
	}
}
