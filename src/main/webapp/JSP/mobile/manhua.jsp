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
    <title>深夜漫画</title>
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
      <c:import url="menu.jsp"></c:import>
      <!-- 主页面容器 -->
      <div class="mui-inner-wrap">
        <!-- 主页面标题 -->
        <header class="mui-bar mui-bar-nav">
          <a class="mui-icon mui-action-menu mui-icon-bars mui-pull-left" href="#offCanvasSide"></a>
          <h1 class="mui-title">深夜漫画</h1>
        </header>
        
        <div class="mui-content mui-scroll-wrapper">
          <div class="mui-scroll">
            <!-- 主界面具体展示内容 -->
            
            <c:forEach items="${manhuaList}" var="manhua" varStatus="status">
    			<div class="mui-card">
	    			<a id="detail${status.index}" href="mobileRManhua.do?index=${manhua.id}&page=1">
						<!--页眉，放置标题-->
						<!-- <div class="mui-card-header">页眉</div> -->
						<!--内容区-->
						<div class="mui-card-content" style="width: 100%; padding-bottom: 131%; height: 0;position: relative; overflow: hidden;"><img src="${MyIP}${manhua.path}${manhua.imgName}" style="width: 100%; height: 100%;position: absolute;"></div>
						<!--页脚，放置补充信息或支持的操作-->
						<div class="mui-card-footer">${manhua.title}</div>
					</a>
				</div>
    		</c:forEach>
            
			<!--上下页-->
			<div class="nextOrPrev">
				<button type="button" class="mui-btn" onclick="prevPage()">上一页</button>
				<button type="button" class="mui-btn" onclick="nextPage()">下一页</button>
			</div>
			<br />
			<!--随机新闻-->
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
 
    for (var int = 0; int < parseInt("${photoList.size()}"); int++) {
		addEvent("detail" + int, $("#detail" + int).attr("href"));
	}
    for (var int = 0; int < 4; int++) {
		addEvent("news" + int, $("#news" + int).attr("href"));
	}
    var prevPage = function() {
    	var section = getQueryString("section");
    	if (1 == section) {
    		alert("已经是第一页了!");
			return;	
    	}
		window.location = "mobileManhua.do?section=" + (parseInt(section) - 1);
    };
    var nextPage = function() {
    	var section = getQueryString("section");
    	
    	if (Math.ceil("${allNum}" / 12) == section) {
			alert("已经是最后一页了!");
    		return;
    	}
		window.location = "mobileManhua.do?section=" + (parseInt(section) + 1);
    };

    
    </script>
</body>
</html>
