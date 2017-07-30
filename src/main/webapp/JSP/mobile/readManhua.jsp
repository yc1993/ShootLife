<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>${title}</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" type="text/css" href="dist/css/mui.css"/>
	<script type="text/javascript" src="JS/jquery-3.2.1.min.js"></script>
	<style>
		.tableCell {
			background: #333;
		}
		.nextOrPrev {
			text-align: center;
		}
		.mui-btn {
			margin-left: 10%;
			margin-right: 10%;
		}
		#selectPage {
			padding: 0 8px;
		}
		.pagerContent {
			border: solid 1px #ccc;
			display: inline-block;
			margin-bottom: 2px;
			width: 20%;
			margin-left:auto;
			margin-right: auto; 
		}
	</style>
</head>
<body>
    <!-- 主界面不动、菜单移动 -->
    <!-- 侧滑导航根容器 -->
    <div class="mui-off-canvas-wrap mui-draggable mui-slide-in">
      <!-- 菜单容器 -->
      <c:import url="menu.jsp"></c:import>
      <!-- 主页面容器 -->
      <div class="mui-inner-wrap">
        <!-- 主页面标题 -->
        <header class="mui-bar mui-bar-nav">
          <a class="mui-icon mui-action-menu mui-icon-bars mui-pull-left" href="#offCanvasSide"></a>
          <h1 class="mui-title">${title}</h1>
        </header>
        
        <div class="mui-content mui-scroll-wrapper">
          <div class="mui-scroll">
            <!-- 主界面具体展示内容 -->
            <h4  style="padding-left: 8px;display: inline-block;">第${param.words}话-第${param.page}页</h4><span style="color: #333; font-size: 10px;">(共${list.size()}页)</span>
            <c:forEach items="${list }" var="imgPath" varStatus="status">
				<c:if test="${param.page eq (status.index + 1) }">
					<div class="mui-card">
						<!--内容区-->
						<div class="mui-card-content"><img src="${imgPath}" width="100%" title="${title }" alt="${title }"></div>
						<!--页脚，放置补充信息或支持的操作-->
						
					</div>
				</c:if>
			</c:forEach>
			<!--上下页-->
			<div class="nextOrPrev">
				<button type="button" class="mui-btn" onclick="prevPage()">上一页</button>
				<button type="button" class="mui-btn" onclick="nextPage()">下一页</button>
			</div>
			<br />
			<div id="selectPage">
				<c:forEach items="${cartoonList}" var="pagerModel" varStatus="status">
					<c:if test="${param['words'] eq status.count }">
						<span class="pagerContent">${pagerModel.showContent}</span>
					</c:if>
					<c:if test="${param['words'] != status.count }">
						<a id="page${status.index}" class="pagerContent" href="${pagerModel.url }">${pagerModel.showContent}</a>
					</c:if>
				</c:forEach>
			</div>
			<br/>
			<!--推荐新闻-->
			<ul class="mui-table-view">
			    <c:forEach items="${randNewsList}" var="news" varStatus="status">
    		    	<li class="mui-table-view-cell mui-media">
	    		        <a id="news${status.index}" href="mobileRNews.do?title=${news.title}&index=${news.id}&createTime=${news.createTime}">
	    		            <img class="mui-media-object mui-pull-left" src="${MyIP}${news.imgPath}">
	    		            <div class="mui-media-body">
	    		                <p class="mui-ellipsis">${news.title}</p>
	    		            </div>
	    		        </a>
	    		    </li>
    		    </c:forEach>
			</ul>
			
          </div>
        </div>  
        <div class="mui-off-canvas-backdrop"></div>
      </div>
    </div>
    <script src="dist/js/mui.js" type="text/javascript" charset="utf-8"></script>
    <script src="JS/common.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
    mui.init()
    $(function(){
		mui('.mui-scroll-wrapper').scroll({
			scrollY: true, //是否竖向滚动
			scrollX: false, //是否横向滚动
			startX: 0, //初始化时滚动至x
			startY: 0, //初始化时滚动至y
			indicators: true, //是否显示滚动条
			deceleration:0.0006, //阻尼系数,系数越小滑动越灵敏
			bounce: true //是否启用回弹
		});
	});
    for (var int = 0; int < 3; int++) {
		addEvent("news" + int, $("#news" + int).attr("href"));
	}
    for (var int = 0; int < parseInt("${cartoonList.size()}"); int++) {
    	if ("${param.words}" == (int + 1)) {
    		continue;
		}
		addEvent("page" + int, $("#page" + int).attr("href"))
		
	}
    var prevPage = function() {
    	var page = getQueryString("page");
    	if (1 == page) {
			return;	
    	}
		window.location = "mobileRManhua.do?index=" + getQueryString("index") + "&page=" + (parseInt(page) - 1) + "&words=${param.words}";
    };
    var nextPage = function() {
    	var page = getQueryString("page");
    	if (parseInt("${list.size()}") == parseInt(page)) {
    		alert("已经是当前话最后页");
    		return;
    	}else {
			window.location = "mobileRManhua.do?index=" + getQueryString("index") + "&page=" + (parseInt(page) + 1 + "&words=${param.words}");
    	}

    };
    </script>
</body>
</html>
