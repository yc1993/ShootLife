package com.syrs.web.Controller;

import java.sql.Timestamp;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.syrs.web.DAO.FaceListDao;
import com.syrs.web.DAO.ManhuaListDao;
import com.syrs.web.DAO.NewsListDao;
import com.syrs.web.DAO.YellowListDao;
import com.syrs.web.Model.MainImgShowModel;
import com.syrs.web.Model.PagerModel;
import com.syrs.web.Model.TargetModel;
import com.syrs.web.Model.User;
import com.syrs.web.Service.NewShootService;
import com.syrs.web.Service.ShootService;
import com.syrs.web.entity.FaceImg;
import com.syrs.web.entity.FaceList;
import com.syrs.web.entity.ManhuaImg;
import com.syrs.web.entity.ManhuaList;
import com.syrs.web.entity.NewsList;
import com.syrs.web.entity.NewsListImgAndContent;
import com.syrs.web.entity.YellowImg;
import com.syrs.web.entity.YellowList;
import com.syrs.web.util.JdbcDataSource;

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
	NewShootService newShootService;
	
	@Resource
	NewsListDao newsListDao;
	
	@Resource
	YellowListDao yellowListDao;
	
	@Resource
	ManhuaListDao manhuaListDao;
	
	@Resource
	FaceListDao faceListDao;
	
	@Resource
	User user;
	
	private static final String IP = "http://www.youyougirl.com";
	private static final int lENGTH = 12;
	
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
		int i;
		i  = 10 ;
		
		
		
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
//			ArrayList<MainImgShowModel> imgList = (ArrayList<MainImgShowModel>) shootService.backMainAllImgList();
			ArrayList<MainImgShowModel> imgList = (ArrayList<MainImgShowModel>) newShootService.backMainAllImgList();
			mav.getModelMap().put("modelList", imgList);
			
//			List<NewsListModel> newsList = shootService.backNewsList(0, 11);			
//			List<NewsListModel> randNewsList = shootService.randTitleList(4);
			List<NewsList> newsList = newsListDao.getList(0, 11);
			List<NewsList> randNewsList = newsListDao.getListRand(4);
			mav.getModelMap().put("newsList", newsList);
			mav.getModelMap().put("randNewsList", randNewsList);
			
		}else {
			Integer allNum = 0;
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
				allNum = yellowListDao.getNum();
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
				allNum = manhuaListDao.getNum();
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
				allNum = faceListDao.getNum();
				path = "secondPage.do";
			}
			default:
				
				break;
			}
			
			
			//当前页的索引
			int num = (request.getParameter("section") == null)?0:Integer.parseInt(request.getParameter("section"));
//			ArrayList<MainImgShowModel> imgList = (ArrayList<MainImgShowModel>) shootService.backMainImgList(tableName, isManHua, num, 12);
			ArrayList<MainImgShowModel> imgList = (ArrayList<MainImgShowModel>) newShootService.backMainImgList(tableName, num, lENGTH);
			mav.getModelMap().put("modelList", imgList);
			
//			Integer allNum = shootService.allNumber(tableName);
			mav.getModelMap().put("allNum", allNum);
			List<PagerModel> pagerModels = new ArrayList<PagerModel>();

			for (int i = 0; i < ((allNum % lENGTH == 0?(allNum / lENGTH):(allNum / lENGTH + 1))); i++) {
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
//		ArrayList<MainImgShowModel> recommendList = (ArrayList<MainImgShowModel>) shootService.backRecommendImg();
		ArrayList<MainImgShowModel> recommendList = (ArrayList<MainImgShowModel>) newShootService.yellowList2MainImgShowModel(yellowListDao.getListRand(6));
		mav.getModelMap().put("recommendList",recommendList);
		
		return mav;
	}
	
	@RequestMapping("secondPage")
	public String secondPage(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap modelMap){
		
		// 判断点击的是哪个标签
//		ArrayList<SecondImgAryModel> imgList = new ArrayList<>();
		List<String> list = new ArrayList<String>();
//		String tableName = null;
		String title = null;
		switch (request.getParameter("target")) {
		case "1": {
//			imgList = (ArrayList<SecondImgAryModel>) shootService.backSecondImgList(request.getParameter("index"));	
			List<YellowImg> yellowImgs = yellowListDao.getImg(Integer.parseInt(request.getParameter("index")));
			for (YellowImg yellowImg : yellowImgs) {
				list.add(IP + yellowImg.getPath());
			}
			YellowList yellowList = yellowListDao.getList(Integer.parseInt(request.getParameter("index")));
			title = yellowList.getTitle();
//			tableName = "yellow_list";
		}
			break;
		case "2": {
//			imgList = (ArrayList<SecondImgAryModel>) shootService.backManHuaImgList(request.getParameter("index"),"1");
			List<ManhuaImg> manhuaImgs = manhuaListDao.getListImg(1, Integer.parseInt(request.getParameter("index")));
			for (ManhuaImg manhuaImg : manhuaImgs) {
				list.add(IP + manhuaImg.getPath());
			}
			ManhuaList manhuaList = manhuaListDao.getList(Integer.parseInt(request.getParameter("index")));
			title = manhuaList.getTitle();
//			tableName = "manhua_list";
			
		}
			break;
		case "3": {
//			imgList = (ArrayList<SecondImgAryModel>) shootService.backFaceImgList(request.getParameter("index"));
			List<FaceImg> faceImgs = faceListDao.getImg(Integer.parseInt(request.getParameter("index")));
			for (FaceImg faceImg : faceImgs) {
				list.add(IP + faceImg.getPath());
			}
			FaceList faceList = faceListDao.getList(Integer.parseInt(request.getParameter("index")));
			title = faceList.getTitle();
//			tableName = "face_list";
		}
			break;

		default:
			break;
		}
//		if (imgList.size() == 0) {
//			String index = shootService.backIndexNumber(request.getParameter("index"),tableName);
//			return "redirect:secondPage.do?target=" + request.getParameter("target") + "&index=" + index;
//		}
		
//
//		for (SecondImgAryModel secondImgAryModel : imgList) {
//			list.add(IP + secondImgAryModel.getImagePath());
//		}
		
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
//		ArrayList<MainImgShowModel> aboutList = (ArrayList<MainImgShowModel>) shootService.backAboutImg();
		ArrayList<MainImgShowModel> aboutList = (ArrayList<MainImgShowModel>) newShootService.yellowList2MainImgShowModel(yellowListDao.getListRand(4));
		modelMap.put("aboutList", aboutList);
		
		//返回标题
//		String title = shootService.backTitle(request.getParameter("index"), tableName);
		
		modelMap.put("title", title);
		return "JSP/Second.jsp";
	}
	
	@RequestMapping("cartoon")
	public String cartoonPage(HttpServletRequest request, ModelMap modelMap, HttpSession session) {
		//先判断是否为连载漫画
//		Integer count = shootService.backNumberOfCartoons(request.getParameter("index"));
		ManhuaList manhuaList = manhuaListDao.getList(Integer.parseInt(request.getParameter("index")));
		List<PagerModel> cartoonList = new ArrayList<>();
		for (int i = 0; i < manhuaList.getNum(); i++) {
			PagerModel pm = new PagerModel();
			pm.setUrl("cartoon.do?target=" + request.getParameter("target") + "&index=" + request.getParameter("index") + "&words=" + (i+1));
			pm.setShowContent("第" + (i+1) + "话");
			cartoonList.add(pm);
		}
		modelMap.put("cartoonList", cartoonList);
		
//		ArrayList<SecondImgAryModel> imgList = new ArrayList<>();
		ArrayList<ManhuaImg> manhuaImgs = new ArrayList<>();
		List<String> urlList = new ArrayList<String>();
//		imgList = (ArrayList<SecondImgAryModel>) shootService.backManHuaImgList(request.getParameter("index"), request.getParameter("words"));
		manhuaImgs = (ArrayList<ManhuaImg>) manhuaListDao.getListImg( Integer.parseInt(request.getParameter("words")), Integer.parseInt(request.getParameter("index")));
//		String tableName = "manhua_list";
//		if (manhuaImgs.size() == 0) {	//如果下一图集是空，则返回下一图集的index
//			String index = shootService.backIndexNumber(request.getParameter("index"),tableName);
//			return "redirect:cartoon.do?target=" + request.getParameter("target") + "&index=" + index + "&words=1";
//		}

		for (ManhuaImg manhuaImg : manhuaImgs) {
			urlList.add(IP + manhuaImg.getPath());
		}
		modelMap.put("list", urlList);
//	    String title = shootService.backTitle(request.getParameter("index"), tableName);
		modelMap.put("title", manhuaList.getTitle());
		
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
//		List<NewsListModel> newsList = shootService.backNewsList(nowSection, 12);
		List<NewsList> newsList = newsListDao.getList(nowSection, 12);

		//随机新闻（右边显示）
//		List<NewsListModel> randNewsTitle = shootService.randTitleList(10);
		List<NewsList> randNewsTitle = newsListDao.getListRand(10);
		
		//新闻条数
//		Integer newsCount = shootService.backNewsCount();
		Integer newsCount = newsListDao.getNum();
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
//		String id = request.getParameter("id");
		//随机新闻（右边显示）
//		List<NewsListModel> randNewsTitle = shootService.randTitleList(10);
		List<NewsList> randNewsTitle = newsListDao.getListRand(10);
		
//		List<NewsContentModel> newsContentList = shootService.newsContent(id);
//		List<NewsContentModel> newsImgList = shootService.newsImg(id);
		List<NewsListImgAndContent> newsContentList = newsListDao.getLisContent(Integer.parseInt(request.getParameter("id")));
		List<NewsListImgAndContent> newsImgList = newsListDao.getLisImg(Integer.parseInt(request.getParameter("id")));
		Map<Integer, NewsListImgAndContent> newsMap = new HashMap<>();
		for (NewsListImgAndContent newsContent : newsContentList) {
			newsMap.put(newsContent.getNum(), newsContent);
		}
		for (NewsListImgAndContent newsImg : newsImgList) {
			newsMap.put(newsImg.getNum(), newsImg);
		}
		
		map.put("randNewsTitle", randNewsTitle);
		map.put("newsMap", newsMap);
		map.put("newsTitle", newsTitle);
		map.put("createTime", createTime);
		map.put("MyIP", IP);
		return "JSP/ReadNews.jsp";
	}
	
	@RequestMapping(value="push", method=RequestMethod.GET)
	public String push(ModelMap map, HttpServletRequest request, String icon){
		return "JSP/push.jsp";
	}
	
	@RequestMapping(value="push", method=RequestMethod.POST)
	public String push(HttpSession session ,ModelMap map, HttpServletRequest request,String title, String iconUrl, String[] content, String[] url){
		if (content != null && content.length > 0) {
			for (String string : content) {
				System.out.println("content:" + string);
			}
		}
		if (url != null && url.length > 0) {
			for (String string : url) {
				System.out.println("url:" + string);
			}
		}
		return "redirect:push.do";
	}
	
	@RequestMapping(value="mobileMain", method=RequestMethod.GET)
	public String mobileMain(HttpSession session ,ModelMap map, HttpServletRequest request){
		
		//主页写真
		List<MainImgShowModel> photoList = newShootService.mobileMainData(0, 8);
		map.put("photoList", photoList);
		
		//新闻
		List<NewsList> newsList = newsListDao.getList(0, 4);
		map.put("newsList", newsList);
		map.put("MyIP", IP);
		return "JSP/mobile/main.jsp";
	}
	
	@RequestMapping(value="mobilePhoto", method=RequestMethod.GET)
	public String mobilePhoto(HttpSession session ,ModelMap map, HttpServletRequest request, Integer section){
		//主页写真
		List<MainImgShowModel> photoList = newShootService.mobileMainData(section - 1, 12);
		map.put("photoList", photoList);
		map.put("MyIP", IP);
		map.put("allNum", yellowListDao.getNum());
		List<NewsList> randNewsList = newsListDao.getListRand(4);
		map.put("randNewsList", randNewsList);
		return "JSP/mobile/photo.jsp";
	}

	@RequestMapping(value="mobileNews", method=RequestMethod.GET)
	public String mobileNews(HttpSession session ,ModelMap map, HttpServletRequest request, Integer section){
		List<NewsList> newsList = newsListDao.getList(section - 1, 12);
		map.put("newsList", newsList);
		map.put("MyIP", IP);
		map.put("allNum", newsListDao.getNum());
		return "JSP/mobile/news.jsp";
	}
	
	@RequestMapping(value="mobileRP", method=RequestMethod.GET)
	public String mobileReadPhoto(HttpSession session ,ModelMap map, HttpServletRequest request){
		List<String> list = new ArrayList<String>();
		List<YellowImg> yellowImgs = yellowListDao.getImg(Integer.parseInt(request.getParameter("index")));
		for (YellowImg yellowImg : yellowImgs) {
			list.add(IP + yellowImg.getPath());
		}
		YellowList yellowList = yellowListDao.getList(Integer.parseInt(request.getParameter("index")));
		String title = yellowList.getTitle();
		
		map.put("title", title);
		map.put("list", list);
		List<NewsList> randNewsList = newsListDao.getListRand(3);
		map.put("randNewsList", randNewsList);
		map.put("MyIP", IP);
		return "JSP/mobile/readPhoto.jsp";
	}
	

	@RequestMapping(value="mobileRNews", method=RequestMethod.GET)
	public String mobileReadNews(HttpSession session ,ModelMap map, HttpServletRequest request, String title, Integer index, String createTime){
		map.put("title", title);
		List<NewsListImgAndContent> newsContentList = newsListDao.getLisContent(index);
		List<NewsListImgAndContent> newsImgList = newsListDao.getLisImg(index);
		List<NewsList> randNewsList = newsListDao.getListRand(4);
		map.put("randNewsList", randNewsList);
		Map<Integer, NewsListImgAndContent> newsMap = new HashMap<>();
		for (NewsListImgAndContent newsContent : newsContentList) {
			newsMap.put(newsContent.getNum(), newsContent);
		}
		for (NewsListImgAndContent newsImg : newsImgList) {
			newsMap.put(newsImg.getNum(), newsImg);
		}
		map.put("newsMap", newsMap);
		map.put("MyIP", IP);
		map.put("createTime", createTime);
		
		int count = newsListDao.getNum();
		map.put("count", count);
		return "JSP/mobile/readNews.jsp";
	}
	
	public static void main(String args[]){
		 try {
			JdbcDataSource.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }
}



