<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="applicable-device" content="pc" />
<title>${title}</title>
<meta name="keywords" content="搞笑,表情,写真,美女,柚柚妹,柚柚网" />
<meta name="description" content="搞笑,表情,写真,美女,柚柚妹,柚柚网,消遣空余时间，游戏后的调剂品" />

<c:set var="MyIP" value="http://youyougirl.com"></c:set>

<link rel="stylesheet" type="text/css" href="CSS/global.css">
<link rel="stylesheet" type="text/css" href="CSS/content.css">
<link rel="stylesheet" type="text/css" href="CSS/reset.css">
<link rel="stylesheet" type="text/css" href="CSS/default_blue.css">
<link rel="stylesheet" type="text/css" href="CSS/photo.css">
<link rel="stylesheet" type="text/css" href="CSS/all.css">
<link href="CSS/footer.css" rel="stylesheet" type="text/css" />

<style>
iframe {
	margin-top: 6px;
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
	background: url(${MyIP}/tmp/image/gototop.png)
		no-repeat;
}

.backToTop:hover {
	background: url(${MyIP}/tmp/image/gototop.png)
		no-repeat -35px 0px;
}

.pager {
	display:block;
	width: 960px;
	margin: 0 auto;
	
}
.pager .pagerContent {
	text-align:center;
	display:inline-block;
	width:35px;
	margin:auto;
	border:1px solid #000;
}
</style>

</head>
<body>

	<div class="tk_row" id="tk_header">
		<div class="logo">
			<a href="main.do"> <img
				src="${MyIP }/tmp/image/logo.png"
				alt="logo" />
			</a>
		</div>
		<!-- 广告 -->
	</div>

	<div class="tk_row">
		<!--页面logo-->
		<div id="imageWrapper_title">
			<div class="path" style="margin-left:0px">
				<a href="main.do">首页</a> &gt; 作品展示&gt;第${param['words']}话
			</div>
		</div>
	</div>
	<!-- 广告位 -->
	
	<div class="tk_row" id="tc_title" style="padding-top:0px">
		<h1 style="line-height: 50px;">${title }</h1>
	</div>
	<!--页面主体-->
	<div class="tk_row" id="imageWrapper">
		<!--页面照片-->
		<div id="tc_photo">
			<div class="inner">
				<div class="pv t8">
					<div class="big-pic">
						<div id="big-pic">
							<c:forEach items="${list }" var="imgPath" varStatus="status">
								<c:if test="${sessionScope.number eq status.index }">
									<img alt="${title }" title="${title }" src="${imgPath }">
								</c:if>
							</c:forEach>
						</div>
						<div class="photo_prev">
							<c:choose>
								<c:when test="${sessionScope.number <=1}">
									<a id="photoPrev" title="&lt;上一页" class="btn_pphoto"
										target="_self" hidefocus="true"
										href="cartoon.do?target=${param['target'] }&index=${param['index'] }&words=${param['words']}"
										onclick="showpic('pre');"></a>
								</c:when>
								<c:otherwise>
									<a id="photoPrev" title="&lt;上一页" class="btn_pphoto"
										target="_self" hidefocus="true"
										href="cartoon.do?target=${param['target'] }&index=${param['index'] }&words=${param['words']}&page=${sessionScope.number - 1}"
										onclick="showpic('pre');"></a>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="photo_next">
							<c:choose>
								<c:when test="${(sessionScope.number + 1 )== list.size() }">
									<a id="photoNext" title="下一页&gt;" class="btn_nphoto"
										target="_self" hidefocus="true"
										href="cartoon.do?target=${param['target']}&index=${param['index'] - 1}&words=1"
										onclick="showpic('next')"></a>
								</c:when>
								<c:otherwise>
									<a id="photoNext" title="下一页&gt;" class="btn_nphoto"
										target="_self" hidefocus="true"
										href="cartoon.do?target=${param['target'] }&index=${param['index'] }&words=${param['words']}&page=${sessionScope.number + 1}"
										onclick="showpic('next')"></a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="hr_10"></div>
	</div>
	<!--lazy loading-->
	<ul class="cont picbig" id="pictureurls" style="display:none;">
		<c:forEach items="${list }" var="imgPath">
			<li rel="${imgPath }" alt="${title }">
		</c:forEach>
	</ul>
	<!--切换按钮-->
	<div class="tk_row">
		<div id="tc_photo">
			<div class="pp">
				<a href="cartoon.do?target=${param['target'] }&index=${param['index'] }&words=${param['words']}" class="start"><img alt="首页" src="${MyIP }/tmp/image/start.png"></a>
				<c:choose>
					<c:when test="${sessionScope.number <=1}">
						<a href="cartoon.do?target=${param['target'] }&index=${param['index'] }&words=${param['words']}" class="up"><img alt="上页" src="${MyIP }/tmp/image/up.png"></a>
					</c:when>
					<c:otherwise>
						<a
							href="cartoon.do?target=${param['target'] }&index=${param['index'] }&words=${param['words']}&page=${sessionScope.number - 1}"
							class="up"><img alt="上页" src="${MyIP }/tmp/image/up.png"></a>
					</c:otherwise>
				</c:choose>
				<span class="count" id="picnum">第<c:out
						value="${sessionScope.number + 1 }"></c:out>页 | 共<c:out
						value="${list.size() }"></c:out>页
				</span>
				<c:choose>
					<c:when test="${(sessionScope.number + 1 )== list.size() }">
						<a
							href="cartoon.do?target=${param['target'] }&index=${param['index'] - 1}&words=1"
							class="down"><img alt="下页" src="${MyIP }/tmp/image/down.png"></a>
					</c:when>
					<c:otherwise>
						<a
							href="cartoon.do?target=${param['target'] }&index=${param['index'] }&words=${param['words']}&page=${sessionScope.number + 1}"
							class="down"><img alt="下页" src="${MyIP }/tmp/image/down.png"></a>
					</c:otherwise>
				</c:choose>
				<c:if test="${list.size() eq (sessionScope.number + 1) }">
					<a
						href="cartoon.do?target=${param['target']}&index=${param['index'] - 1}&words=1"
						class="end"><img alt="末页" src="${MyIP }/tmp/image/end.png"></a>
				</c:if>
				<c:if test="${list.size() != (sessionScope.number + 1) }">

					<a
						href="cartoon.do?target=${param['target'] }&index=${param['index'] }&words=${param['words']}&page=${list.size()-1}"
						class="end"><img alt="末页" src="${MyIP }/tmp/image/end.png"></a>
				</c:if>
			</div>
		</div>
	</div>
	<!--点赞部分-->
	<div class="tk_row">
		<div class="col_7">
			<a href="javascript:void()"
				onmouseover="document.getElementById('zan').style.background='url(${MyIP}/tmp/image/zan2.jpg) no-repeat';"
				onmouseout="document.getElementById('zan').style.background='url(${MyIP}/tmp/image/zan1.jpg) no-repeat';">
				<span class="click_status" id='zan'></span> <span class="click_text">赞&nbsp;&nbsp;<span
					class="number">1</span></span>
			</a> <span class="show_status"></span> <span class="click_text">浏览&nbsp;&nbsp;<span
				id="hits">1</span></span>
		</div>
		<div class="hr_10"></div>
	</div>
	<!-- 选择第几话的部分 -->
	<div class="pager">
		<!-- section不需要出现省略的情况 -->
		<c:if test="${cartoonList.size() > 1}">
			<c:forEach items="${cartoonList }" var="pagerModel" varStatus="status">
				<c:if test="${param['words'] eq status.count }">
					<span class="pagerContent">${pagerModel.showContent}</span>
				</c:if>
				<c:if test="${param['words'] != status.count }">
					<a class="pagerContent" href="${pagerModel.url }">${pagerModel.showContent}</a>
				</c:if>
			</c:forEach>
		</c:if>
	</div>
	<!--相关作品-->
	<div class="tk_row" id="tk_share">

		<div class="tk_baidu">
			<div id="bdshare" class="bdsharebuttonbox">
				<a href="#" class="bds_more" data-cmd="more"></a><a href="#"
					class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a href="#"
					class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#"
					class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>
				<iframe allowTransparency="true" frameborder="0" scrolling="no"
					src="http://huaban.com/share/button?style=icon&size=large&media=&description=&url="
					width="32" height="32"></iframe>
			</div>
			<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"32"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
		</div>

		<br>
		<!--相关作品-->
		<dl class="xgzp">
			<dt>
				<span class="title">相关作品</span>
			</dt>
			<c:forEach items="${aboutList }" var="aboutModel" varStatus="status">
				<c:if test="${status.count != 4 }">
					<dd>
						<a href="secondPage.do?target=1&index=${aboutModel.getId()}">
							<img
							src="${MyIP }${aboutModel.getPath()}${aboutModel.getImgName() }"
							alt="${aboutModel.getTitle() }" title="${aboutModel.getTitle() }">
						</a>
						<div class="mask"></div>
						<div class="content">
							<p>
								<a href="secondPage.do?target=1&index=${aboutModel.getId()}">${aboutModel.getTitle() }</a>
							</p>
							<p>${aboutModel.getTitle() }</p>
						</div>
					</dd>
				</c:if>
				<c:if test="${status.count == 4 }">
					<dd class="rightlimit">
						<a href="secondPage.do?target=1&index=${aboutModel.getId()}">
							<img
							src="${MyIP }${aboutModel.getPath()}${aboutModel.getImgName() }"
							alt="${aboutModel.getTitle() }" title="${aboutModel.getTitle() }">
						</a>
						<div class="mask"></div>
						<div class="content">
							<p>
								<a href="secondPage.do?target=1&index=${aboutModel.getId()}">${aboutModel.getTitle() }</a>
							</p>
							<p>${aboutModel.getTitle() }</p>
						</div>
					</dd>
				</c:if>
			</c:forEach>
		</dl>
	</div>
	<!-- 横页广告2 -->

	<!-- 右下角浮窗 -->

	<!-- 对联广告 -->

	<!--页面底部-->
	<div class="hr_10"></div>


	<div id="load_pic" style="display:none;"
		rel="${MyIP }/image/loading_d.gif"></div>
	
	<!-- 监听键盘方向键的左右按钮。-->
	<!-- <script src="http://libs.baidu.com/jquery/1.9.0/jquery.min.js"></script> -->
	
	<script type="text/javascript"
		src="JS/jquery.sgallery.js"></script>

	<script type="text/javascript"
		src="JS/show_picture.js"></script>
	
	<script language="JavaScript">
		if(document.getElementById('hits') != null){
			document.getElementById('hits').innerHTML='8419';
			}
	</script>

	<!--blue-->

	<script>
		$(document).ready(function() {
			$(".load_zk").mousemove(function() {
				$("#tc_title").find("div").css("display", "block");
			}).mouseout(function() {
				$("#tc_title").find("div").css("display", "none");
			});
		});
	</script>

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
	
	<script>
		(function() {
			var $backToTopTxt = "",
				$backToTopEle = $('<div class="backToTop"></div>').appendTo($("body"))
					.text($backToTopTxt).attr("title", $backToTopTxt).click(function() {
					$("html, body").animate({
						scrollTop : 0
					}, 120);
				}),
				$backToTopFun = function() {
					var st = $(document).scrollTop(),
						winh = $(window).height();
					(st > 0) ? $backToTopEle.show() : $backToTopEle.hide();
	
					if (!window.XMLHttpRequest) {
						$backToTopEle.css("top", st + winh - 166);
					}
				};
			$(window).bind("scroll", $backToTopFun);
			$(function() {
				$backToTopFun();
			});
		})();
	</script>		
</body>
</html>