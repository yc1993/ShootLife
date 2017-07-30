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
    <title>Document</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" type="text/css" href="dist/css/mui.css"/>
	<script type="text/javascript" src="JS/jquery-3.2.1.min.js"></script>
	<style>
		.tableCell {
			background: #333;
		}
		.mui-card {
			width: 46%;
			margin: 2%;
			display: inline-block;
			float: left;
		}
		.mui-card-footer {
			font-size: 12px;
			padding: 0px 2px;
		}
		.mui-btn {
			margin: 5px auto 0px auto;
			width: 60%;
			display: block;
			
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
          <h1 class="mui-title">柚柚妹</h1>
        </header>
        
        <div class="mui-content mui-scroll-wrapper">
          <div class="mui-scroll">
			<!-- 主界面具体展示内容 -->
            	<ul class="mui-table-view">
			    <li class="mui-table-view-cell">
	    			<!--写真-->
		    		<h4 >美女写真</h4>
		    		<c:forEach items="${photoList}" var="photo" varStatus="status">
		    			<div class="mui-card">
			    			<a id="detail${status.index}" href="mobileRP.do?index=${photo.id}&page=1">
								<!--页眉，放置标题-->
								<!-- <div class="mui-card-header">页眉</div> -->
								<!--内容区-->
								<div class="mui-card-content"><img src="${MyIP}${photo.path}${photo.imgName}" width="100%"></div>
								<!--页脚，放置补充信息或支持的操作-->
								<div class="mui-card-footer">${photo.title}</div>
							</a>
						</div>
		    		</c:forEach>
			    </li>
			    <div>
			   		<button type="button" class="mui-btn mui-btn-danger mui-btn-outlined" onclick="showMorePhoto()">显示更多美女写真</button>
			    </div>
			     <li class="mui-table-view-cell">
			     	<h4 >深夜漫画😊</h4>
			     	<c:forEach items="${manhuaList}" var="manhua" varStatus="status">
			     		<div class="mui-card">
			     			<a id="manhua${status.index}" href="mobileRP.do?index=${photo.id}&page=1&words=1">
			     				<div class="mui-card-content"><img src="${MyIP}${manhua.path}${manhua.imgName}" width="100%"></div>
			     				<div class="mui-card-footer">${manhua.title}</div>
			     			</a>
			     		</div>
			     	</c:forEach>
			     </li>
			     <div>
			   		<button type="button" class="mui-btn mui-btn-danger mui-btn-outlined" onclick="showMoreManhua()">显示更多漫画</button>
			    </div>
			    <li class="mui-table-view-cell">
			    		<h4 >热点新闻</h4>
			    		<ul class="mui-table-view">
			    		    
			    		    <c:forEach items="${newsList}" var="news" varStatus="status">
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
			    </li>
			    <div>
			   		<button type="button" class="mui-btn mui-btn-danger mui-btn-outlined" onclick="showMoreNews()">显示更多热点新闻</button><br>
			    </div>
			</ul>  
          </div>
        </div>  
        <div class="mui-off-canvas-backdrop"></div>
      </div>
    </div>
    <script src="dist/js/mui.js" type="text/javascript" charset="utf-8"></script>
    <script src="JS/common.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
    mui.init();
    $(function(){
		mui('.mui-scroll-wrapper').scroll({
			scrollY: true, //是否竖向滚动
			scrollX: false, //是否横向滚动
			startX: 0, //初始化时滚动至x
			startY: 0, //初始化时滚动至y
			indicators: true, //是否显示滚动条
			deceleration:0.0006, //阻尼系数,系数越小滑动越灵敏
			bounce: true, //是否启用回弹
		});
		
		
	});
	for (var int = 0; int < 8; int++) {
		addEvent("detail" + int, $("#detail" + int).attr("href"));
	}
	for (var int = 0; int < 4; int++) {
		addEvent("news" + int, $("#news" + int).attr("href"));
	}
	
	var showMorePhoto = function() {
		window.location = "mobilePhoto.do?section=1";
	};
	var showMoreNews = function() {
		window.location = "mobileNews.do?section=1";
	};
	var showMoreManhua = function() {
		window.location = "mobileManhua.do?section=1";
	};
    </script>
</body>
</html>