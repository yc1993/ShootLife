package com.syrs.web.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.syrs.web.Model.MainImgShowModel;
import com.syrs.web.Model.NewsContentModel;
import com.syrs.web.Model.NewsListModel;
import com.syrs.web.Model.PagerModel;
import com.syrs.web.Model.SecondImgAryModel;
import com.syrs.web.Model.TargetModel;
import com.syrs.web.Model.User;
import com.syrs.web.Service.ShootService;

/**
 * URL中的param的参数意义
 * target表示副标签的，主页没有target标签，写真target=1，搞笑target=2，表情target=3
 * index表示第一个JSP页面中图集的序号。
 * page表示第二个JSP页面的一个图集的序号，第一张没有page属性，第二张为page=1
 * section表示第一个JSP页面的副主页的页数。
 */

@Controller
public class ImageController {
	
	@Resource
	ShootService shootService;
	
	@Resource
	User user;
	
	private static final String IP = "http://youyougirl.com";
	
	//测试用
	@RequestMapping("index")
	public String firts(HttpServletRequest request,HttpServletResponse response,HttpSession session, ModelMap map){
//		ModelAndView mav = new ModelAndView("JSP/first.jsp");
//		mav.getModelMap().put("title", "第一个标题");
//		mav.getModelMap().put("image1", "http://youyougirl.com/1.jpg");
//	
//		user.setUsername("乔sb");
//		user.setPassword("12333");
//		
//		session.setAttribute("user", user);
//		
//		User user1 = new User();
//		user1.setUsername("yyyyyy");
//		user1.setPassword("333333");
//		
//		request.setAttribute("user1", user1);
		
		
		System.out.println(request.getAttribute("count"));
		System.out.println();
		if (request.getAttribute("count") != null) {
			
			return "JSP/first.jsp";
		}else {
			request.setAttribute("count", 2);
			return "redirect:index.do";
		}
		
		
	}
	
	//测试用
	@RequestMapping("second")
	public ModelAndView tiaozhuan(HttpSession session){
		ModelAndView mav = new ModelAndView("JSP/first.jsp");
		mav.getModelMap().put("title", "第二个标题");
		mav.getModelMap().put("image1", "http://youyougirl.com/2.jpg");
		
		return mav;
	}
	
	@RequestMapping("main")
	public ModelAndView mainPage(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("JSP/Main.jsp");
		
		
		TargetModel tm = new TargetModel();
		TargetModel tm1 = new TargetModel();
		TargetModel tm2 = new TargetModel();
		TargetModel tm3 = new TargetModel();
		tm.setId("menu_0");
		tm.setTarget("图库首页");
		
		tm1.setId("menu_66");
		tm1.setTarget("写真摄影");
		tm2.setId("menu_67");
		tm2.setTarget("每日一漫");
		tm3.setId("menu_68");
		tm3.setTarget("表情世界");
		
		String tableName = null;
		boolean isManHua = false;
		String path = null;
		if (request.getParameter("target") == null) {
			tm.setClazz("f88");
			tm1.setClazz("");
			tm2.setClazz("");
			tm3.setClazz("");
			mav.getModelMap().put("mainTitle", "柚柚网");
			path = "secondPage.do";
			
			//返回混合的页面
			ArrayList<MainImgShowModel> imgList = (ArrayList<MainImgShowModel>) shootService.backMainAllImgList();
			mav.getModelMap().put("modelList", imgList);
			
			List<NewsListModel> newsList = shootService.backNewsList(0, 4);
			
			List<NewsListModel> randNewsList = shootService.randTitleList(4);
			mav.getModelMap().put("newsList", newsList);
			mav.getModelMap().put("randNewsList", randNewsList);
			
		}else {
			
			switch (request.getParameter("target")) {
			case "1":
			{
				tm.setClazz("");
				tm1.setClazz("f88");
				tm2.setClazz("");
				tm3.setClazz("");
				mav.getModelMap().put("mainTitle", "写真摄影");
				tableName = "yellow_list";	//写真表名
				isManHua = false;
				path = "secondPage.do";
			}
			break;
			case "2":
			{
				tm.setClazz("");
				tm1.setClazz("");
				tm2.setClazz("f88");
				tm3.setClazz("");
				mav.getModelMap().put("mainTitle", "每日一漫");
				tableName = "manhua_list";	//漫画表名
				isManHua = true;
				path = "cartoon.do";
			}
			break;
			case "3":
			{
				tm.setClazz("");
				tm1.setClazz("");
				tm2.setClazz("");
				tm3.setClazz("f88");
				mav.getModelMap().put("mainTitle", "表情世界");
				tableName = "face_list";	//标签表名
				isManHua = false;
				path = "secondPage.do";
			}
			default:
				
				break;
			}
			
			ArrayList<MainImgShowModel> imgList = (ArrayList<MainImgShowModel>) shootService.backMainImgList(tableName, isManHua);

			mav.getModelMap().put("modelList", imgList);
			
			//当前页的索引
			int num = (request.getParameter("section") == null)?0:Integer.parseInt(request.getParameter("section"));
			List<PagerModel> pagerModels = new ArrayList<PagerModel>();

			for (int i = 0; i < ((imgList.size() % 12 == 0?(imgList.size() / 12):(imgList.size() / 12 + 1))); i++) {
				PagerModel pModel = new PagerModel();
				
				//是section=0的时候
				if (num == i) {
					pModel.setUrl("null");
					
				}else if (num < i) {
					pModel.setUrl("main.do?target="+request.getParameter("target")+"&section="+ String.valueOf(i));
				}else if (num > i) {
					if (i == 0) {
						pModel.setUrl("main.do?target="+request.getParameter("target"));
					}else {
						pModel.setUrl("main.do?target="+request.getParameter("target")+"&section="+ String.valueOf(i));
					}
				}
				pModel.setShowContent(String.valueOf(i+1));
				pagerModels.add(pModel);

			}
			mav.getModelMap().put("pagerModels", pagerModels);
			
		}
		
		mav.getModelMap().put("nextPage", path);
		//标签内容
		List<TargetModel> targetList = new ArrayList<TargetModel>();
		targetList.add(tm);
		targetList.add(tm1);
		targetList.add(tm2);
		targetList.add(tm3);
		mav.getModelMap().put("targetList", targetList);	
		
		
		mav.getModelMap().put("MyIP", IP);
		
		//推荐内容
		ArrayList<MainImgShowModel> recommendList = (ArrayList<MainImgShowModel>) shootService.backRecommendImg();
		mav.getModelMap().put("recommendList",recommendList);
		
		return mav;
	}
	
	@RequestMapping("secondPage")
	public String secondPage(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap modelMap){
		
		// 判断点击的是哪个标签
		ArrayList<SecondImgAryModel> imgList = new ArrayList<>();
		List<String> list = new ArrayList<String>();
		String tableName = null;
		switch (request.getParameter("target")) {
		case "1": {
			imgList = (ArrayList<SecondImgAryModel>) shootService.backSecondImgList(request.getParameter("index"));
			tableName = "yellow_list";
		}
			break;
		case "2": {
			imgList = (ArrayList<SecondImgAryModel>) shootService.backManHuaImgList(request.getParameter("index"),"1");
			tableName = "manhua_list";
			
		}
			break;
		case "3": {
			imgList = (ArrayList<SecondImgAryModel>) shootService.backFaceImgList(request.getParameter("index"));
			tableName = "face_list";
		}
			break;

		default:
			break;
		}
		if (imgList.size() == 0) {
			String index = shootService.backIndexNumber(request.getParameter("index"),tableName);
			return "redirect:secondPage.do?target=" + request.getParameter("target") + "&index=" + index;
		}
		

		for (SecondImgAryModel secondImgAryModel : imgList) {
			list.add(IP + secondImgAryModel.getImagePath());
		}
		
		modelMap.put("list",list);
		request.setAttribute("count", list.size());
		
		//session中的number记录查看当前图集是第几页
		if (request.getParameter("page") == null || session.getAttribute("number") == request.getParameter("page") || session.getAttribute("number") == null) {
			session.setAttribute("number", "0");
		}else {
			session.setAttribute("number", request.getParameter("page"));
		}
		
		modelMap.put("secondPage", "secondPage.do");
		//随机返回四条数据
		ArrayList<MainImgShowModel> aboutList = (ArrayList<MainImgShowModel>) shootService.backAboutImg();
		modelMap.put("aboutList", aboutList);
		
		//返回标题
		String title = shootService.backTitle(request.getParameter("index"), tableName);
		modelMap.put("title", title);
		return "JSP/Second.jsp";
	}
	
	@RequestMapping("cartoon")
	public String cartoonPage(HttpServletRequest request, ModelMap modelMap, HttpSession session) {
		//先判断是否为连载漫画
		Integer count = shootService.backNumberOfCartoons(request.getParameter("index"));
		List<PagerModel> cartoonList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			PagerModel pm = new PagerModel();
			pm.setUrl("cartoon.do?target=" + request.getParameter("target") + "&index=" + request.getParameter("index") + "&words=" + (i+1));
			pm.setShowContent("第" + (i+1) + "话");
			cartoonList.add(pm);
		}
		modelMap.put("cartoonList", cartoonList);
		
		ArrayList<SecondImgAryModel> imgList = new ArrayList<>();
		List<String> list = new ArrayList<String>();
		imgList = (ArrayList<SecondImgAryModel>) shootService.backManHuaImgList(request.getParameter("index"), request.getParameter("words"));
		String tableName = "manhua_list";
		if (imgList.size() == 0) {	//如果下一图集是空，则返回下一图集的index
			String index = shootService.backIndexNumber(request.getParameter("index"),tableName);
			return "redirect:cartoon.do?target=" + request.getParameter("target") + "&index=" + index + "&words=1";
		}

		for (SecondImgAryModel secondImgAryModel : imgList) {
			list.add(IP + secondImgAryModel.getImagePath());
		}
		modelMap.put("list",list);
	    String title = shootService.backTitle(request.getParameter("index"), tableName);
		modelMap.put("title", title);
		
		//session中的number记录查看当前图集是第几页
		if (request.getParameter("page") == null || session.getAttribute("number") == request.getParameter("page") || session.getAttribute("number") == null) {
			session.setAttribute("number", "0");
		}else {
			session.setAttribute("number", request.getParameter("page"));
		}
		
		return "JSP/Cartoon.jsp";
	}
	
	@RequestMapping("news")
	public String news(HttpServletRequest request, ModelMap map){
		TargetModel tm = new TargetModel();
		TargetModel tm1 = new TargetModel();
		TargetModel tm2 = new TargetModel();
		TargetModel tm3 = new TargetModel();
		tm.setId("menu_0");
		tm.setTarget("图库首页");
		tm1.setId("menu_66");
		tm1.setTarget("写真摄影");
		tm2.setId("menu_67");
		tm2.setTarget("每日一漫");
		tm3.setId("menu_68");
		tm3.setTarget("表情世界");
		//标签内容
		List<TargetModel> targetList = new ArrayList<TargetModel>();
		targetList.add(tm);
		targetList.add(tm1);
		targetList.add(tm2);
		targetList.add(tm3);
	
		//返回新闻内容
		String sectionStr = request.getParameter("section");

		int nowSection = (sectionStr == null)?0:Integer.parseInt(sectionStr);
		List<NewsListModel> newsList = shootService.backNewsList(nowSection, 12);
		
		//随机新闻（右边显示）
		List<NewsListModel> randNewsTitle = shootService.randTitleList(3);
		
		//新闻条数
		Integer newsCount = shootService.backNewsCount();
		//当前页的索引
		List<PagerModel> pagerModels = new ArrayList<PagerModel>();
		
		for (int i = 0; i < ((newsCount % 12 == 0?(newsCount / 12):(newsCount / 12 + 1))); i++) {
			PagerModel pModel = new PagerModel();
			
			//是section=0的时候
			if (nowSection == i) {
				pModel.setUrl("null");
				
			}else if (nowSection < i) {
				pModel.setUrl("news.do?section="+ String.valueOf(i));
			}else if (nowSection > i) {
				if (i == 0) {
					pModel.setUrl("news.do");
				}else {
					pModel.setUrl("news.do?&section="+ String.valueOf(i));
				}
			}
			pModel.setShowContent(String.valueOf(i+1));
			pagerModels.add(pModel);

		}
		map.put("pagerModels", pagerModels);
		map.put("randNewsTitle", randNewsTitle);
		map.put("newsCount", newsCount);
		map.put("newsList", newsList);
		map.put("targetList", targetList);
		map.put("MyIP", IP);
		return "JSP/News.jsp";
	}
	
	@RequestMapping("readNews")
	public String readNews(HttpServletRequest request, ModelMap map) {
		String newsTitle = request.getParameter("title");
		String createTime = request.getParameter("createTime");
		createTime = createTime.substring(0, 19);
		String id = request.getParameter("id");
		//随机新闻（右边显示）
		List<NewsListModel> randNewsTitle = shootService.randTitleList(3);
		
		List<NewsContentModel> newsContentList = shootService.newsContent(id);
		List<NewsContentModel> newsImgList = shootService.newsImg(id);
		Map<Integer, NewsContentModel> newsMap = new HashMap<>();
		for (NewsContentModel newsContent : newsContentList) {
			newsMap.put(newsContent.getNum(), newsContent);
		}
		for (NewsContentModel newsImg : newsImgList) {
			newsMap.put(newsImg.getNum(), newsImg);
		}
		
		map.put("randNewsTitle", randNewsTitle);
		map.put("newsMap", newsMap);
		map.put("newsTitle", newsTitle);
		map.put("createTime", createTime);
		map.put("MyIP", IP);
		return "JSP/ReadNews.jsp";
	}
}


