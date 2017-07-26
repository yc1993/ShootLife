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
	</style>
</head>
<body>
    <!-- 主界面不动、菜单移动 -->
    <!-- 侧滑导航根容器 -->
    <div class="mui-off-canvas-wrap mui-draggable mui-slide-in">
      <!-- 菜单容器 -->
      <aside class="mui-off-canvas-left" id="offCanvasSide">
        <div class="mui-scroll-wrapper">
          <div class="mui-scroll">
            <!-- 菜单具体展示内容 -->
            <ul class="mui-table-view">
			    <li class="mui-table-view-cell">
			        <a id="shouye" class="tableCell" href="mobileMain.do" target="_self" style="color: #FFFFFF;">首页</a>
			    </li>
			    <li class="mui-table-view-cell">
			        <a id="xiezhen" class="tableCell" href="mobilePhoto.do?section=1" target="_self" style="color: #FFFFFF;">写真</a>
			    </li>
			    <li class="mui-table-view-cell">
			        <a id="xinwen" class="tableCell" href="mobileNews.do?section=1" target="_self" style="color: #FFFFFF;">新闻</a>
			    </li>
			</ul>
          </div>
        </div>
      </aside>
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
            
            <c:forEach items="${list }" var="imgPath" varStatus="status">
				<c:if test="${param.page eq status.index }">
					<div class="mui-card">
						<!--内容区-->
						<div class="mui-card-content"><img src="${imgPath}" width="100%" title="${title }" alt="${title }"></div>
						<!--页脚，放置补充信息或支持的操作-->
						<div class="mui-card-footer">${title}</div>
					</div>
				</c:if>
			</c:forEach>
			<!--上下页-->
			<div class="nextOrPrev">
				<button type="button" class="mui-btn">上一页</button>
				<button type="button" class="mui-btn">下一页</button>
			</div>
			<br />
			<!--推荐新闻-->
			<ul class="mui-table-view">
			    <li class="mui-table-view-cell mui-media">
			        <a href="javascript:;">
			            <img class="mui-media-object mui-pull-left" src="http://placehold.it/40x30">
			            <div class="mui-media-body">
			                幸福
			                <p class="mui-ellipsis">能和心爱的人一起睡觉，是件幸福的事情；可是，打呼噜怎么办？</p>
			            </div>
			        </a>
			    </li>
			    <li class="mui-table-view-cell mui-media">
			        <a href="javascript:;">
			            <img class="mui-media-object mui-pull-left" src="http://placehold.it/40x30">
			            <div class="mui-media-body">
			                木屋
			                <p class="mui-ellipsis">想要这样一间小木屋，夏天挫冰吃瓜，冬天围炉取暖.</p>
			            </div>
			        </a>
			    </li>
			    <li class="mui-table-view-cell mui-media">
			        <a href="javascript:;">
			            <img class="mui-media-object mui-pull-left" src="http://placehold.it/40x30">
			            <div class="mui-media-body">
			                CBD
			                <p class="mui-ellipsis">烤炉模式的城，到黄昏，如同打翻的调色盘一般.</p>
			            </div>
			        </a>
			    </li>
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
    
    addEvent("shouye", "mobileMain.do?section=1");
    addEvent("xinwen", "mobileNews.do?section=1");
    addEvent("shouye", "mobileMain.do");
    </script>
</body>
</html>
