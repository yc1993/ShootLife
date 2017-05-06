<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="搞笑,表情,写真,美女,漫画,柚柚网" />
<meta name="description" content="搞笑,表情,写真,美女,漫画,柚柚网,消遣空余时间，游戏后的调剂品" />
<title>${newsTitle}</title>

<link rel="stylesheet" type="text/css" href="CSS/global.css" />
<link rel="stylesheet" href="CSS/photo.css" />
<link rel="stylesheet" href="CSS/all.css" />
<link href="CSS/footer.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="CSS/list.css" />
<link rel="stylesheet" href="CSS/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script type="text/javascript" src="CSS/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="JS/picture.js"></script>
<script type="text/javascript" src="JS/jquery-3.2.1.min.js"></script>

<style>
img {
	display: block;
    margin-left: auto;
    margin-right: auto;
}
.backToTop {
	display: none;
	z-index: 2000;
	width: 33px;
	height: 33px;
	line-height: 1.2;
	padding: 5px 0;
	background-color: #000;
	color: #fff;
	font-size: 12px;
	text-align: center;
	position: fixed;
	_position: absolute;
	right: 10px;
	bottom: 10px;
	_bottom: "auto";
	cursor: pointer;
	opacity: .6;
	filter: Alpha(opacity = 60);
	background: url(${MyIP }/tmp/image/gototop.png)
		no-repeat;
}

.backToTop:hover {
	background: url(${MyIP }/tmp/image/gototop.png)
		no-repeat -35px 0px;
}
.specialMask{    
	position: absolute;
    bottom: 0px;
    left: 0px;
    width: 234px;
    height: 50px;
    background-color: #000;
    opacity: 0.5;
    filter: alpha(opacity=50);
    z-index: 2;}
.special{position:absolute;bottom:0px;left:0px;width:234px;height:50px;z-index:3;color:#fff;}
.col-sm-7{
	border: 1px solid #d6d6d6;
	margin-top: 10px;
}
.col-sm-3{
	border: 1px solid #d6d6d6;
	margin-top: 10px;
}
.container {
	margin-bottom: 20px;
}
.topOtherNews {
	margin-top: 10px;
}
</style>

</head>
<body>
	<div class="tk_row" id="tk_header">
		<!--logo图标，以及以及跳转 -->
		<div class="logo" >
			<a href="main.do"> <img
				src="image/logo.png"
				alt="logo" />
			</a>
		</div>
		<!-- 广告 -->
	</div>
	
	<!--图库导航-->
	<div class="tk_row" style="width: 975px;">
		<!--页面logo-->
		<div id="imageWrapper_title">
			<div class="path" style="margin-left:0px">
				<a href="news.do" style="color: black;">首页</a> &gt; 作品展示
			</div>
		</div>
	</div>
	
	<!--最新作品-->
	<div class="container">
		<div class="row">
			<!-- 主新闻 -->
			<div class="col-sm-7 col-xs-12 col-md-offset-1">
				<div class="mainontent">
					<h3 align="center">${newsTitle}<br><br><small>${createTime}</small></h3>
					<c:forEach items="${newsMap}" var="news" varStatus="status">
						<c:if test="${news.value.path == null}">
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${news.value.content}</p>
						</c:if>
						<c:if test="${news.value.path != null}">
							<img alt="图片" src="${MyIP}${news.value.path}">
						</c:if>
					</c:forEach>
				</div>
			</div>
			<div class="col-sm-3 col-xs-12">
				<c:forEach items="${randNewsTitle}" var="news" varStatus="status">
					<c:if test="${status.index == 0}">
						<a href="readNews.do?id=${news.getId()}&createTime=${news.getCreateTime()}&title=${news.getTitle()}"><p class="topOtherNews">1、${news.title}</p></a>
					</c:if>
					<c:if test="${status.index != 0}">
						<a href="readNews.do?id=${news.getId()}&createTime=${news.getCreateTime()}&title=${news.getTitle()}"><p class="otherNews">${status.index + 1}、${news.title}</p></a>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>

	<!--友情连接-->
	<div class="dw_globle" style="width: 977px;">
		<div class="sy_brand s_tjpp tk_link">
			<div class="s_syjd_top">
				<h2 style="margin-top:10px;">友情链接</h2>
			</div>
			<div class="grand">
				<div class="website">
					·<a href="main.do?target=1" target="_blank">化妆造型</a>
					·<a href="main.do?target=1" target="_blank">婚纱摄影</a>
					·<a href="main.do?target=1" target="_blank">写真摄影</a>

					·<a href="main.do?target=1" target="_blank">明星图片</a> ·<a
						href="main.do?target=1" target="_blank">高清壁纸图片</a> 
					·<a href="main.do?target=3" target="_blank">搞笑图片</a>
					<a
						href="http://wpa.qq.com/msgrd?v=3&amp;uin=1392892351&amp;site=qq&amp;menu=yes"
						target="_blank" rel="nofollow">申请友链点击qq:1392892351</a>
				</div>
			</div>
		</div>
	</div>
	
	<!---页面底部-->
	<div class="hr_10"></div>
	<div class="footer">
		<div class="f_top">
			<div class="tp">
				<div class="nav">
					<a href="main.do" target="_blank" title="柚柚网">柚柚网</a>
					<span>|</span>  
					<script src="https://s95.cnzz.com/z_stat.php?id=1261349182&web_id=1261349182" language="JavaScript"></script>
				</div>
			</div>

		</div>
	</div>
</body>
</html>