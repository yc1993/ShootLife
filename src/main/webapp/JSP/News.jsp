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
<title>热点新闻</title>

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
	background: url(image/gototop.png)
		no-repeat;
}

.backToTop:hover {
	background: url(image/gototop.png)
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
	padding-top: 20px;
}
.col-sm-3{
	border: 1px solid #d6d6d6;
	margin-top: 10px;
	margin-left: 15px;
	width: 270px;
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
	<div id="main_nav">
		<div class="tk_row">
			<div id="tk_nav">
				<c:forEach items="${targetList }" var="targetModel" varStatus="status">
					<c:choose>
						<c:when test="${status.index == 0 }">
							<a href="main.do" target="_self" id="${targetModel.getId() }" class="${targetModel.getClazz() }">${targetModel.getTarget() }</a>
						</c:when>
						<c:otherwise>
							<a href="main.do?target=${status.index }" target="_self" id="${targetModel.getId() }" class="${targetModel.getClazz() }">${targetModel.getTarget() }</a>
						</c:otherwise>	
					</c:choose>
				</c:forEach>
				<a href="news.do" target="_self" id="newsMenu" class="f88">热点新闻</a>
			</div>
		</div>
	</div>
	
	<!--最新作品-->
	<div class="container">
		<div class="row">
			<!-- 主新闻 -->
			<div class="col-sm-7 col-md-offset-1">
				<div class="row">
					<c:forEach items="${newsList}" var="news">
						<div class="content" style="display: block;height: 180px;">
						<div class="col-sm-4">
							<a href="readNews.do?id=${news.getId()}&createTime=${news.getCreateTime()}&title=${news.getTitle()}" target="_self">
								<img alt="image" src="${MyIP}${news.getImgPath()}" style="height: 120px;width: 170px;">
							</a>
						</div>
						<div class="col-sm-8">
							<a href="readNews.do?id=${news.getId()}&createTime=${news.getCreateTime()}&title=${news.getTitle()}" target="_self">
								<h4 style="color: black;">${news.getTitle()}<br><br><small><fmt:formatDate value="${news.getCreateTime()}" pattern="yyyy-MM-dd HH:mm:ss"/></small></h4>
							</a>
						</div>
					</div>
					
					</c:forEach>
				</div>
			<!-- 页码 -->
			<div class="pager">
				<label class="a1">共${newsCount}条</label>
				<!-- 上一页 -->
				<c:forEach items="${pagerModels }" var="pagerModel" varStatus="status">
					<c:if test="${pagerModel.url eq 'null'}">
						<c:if test="${param['section'] > 1 }">
							<a href="news.do?section=${param['section']-1}" class="a1">上一页</a>
						</c:if>
						<c:if test="${param['section'] <=1 || param['section'] == null }">
							<a href="news.do" class="a1">上一页</a>
						</c:if>
					</c:if>
				</c:forEach>
				<!-- section不需要出现省略的情况 -->
				<c:if test="${newsCount < 132}">
					<!-- 页码 -->
					<c:forEach items="${pagerModels }" var="pagerModel" varStatus="status">
						<c:if test="${pagerModel.url eq 'null' }">
							<span>${pagerModel.showContent}</span>
						</c:if>
						<c:if test="${pagerModel.url != 'null' }">
							<a href="${pagerModel.url }">${pagerModel.showContent}</a>
						</c:if>
					</c:forEach>
				</c:if>

				<!-- section页面出现省略等的情况 -->
				<c:if test="${newsCount >=132 }">
					<!-- 页码 -->
					<c:forEach items="${pagerModels }" var="pagerModel" varStatus="status">
						<c:if test="${pagerModel.url eq 'null' }">
							<c:choose>
								<c:when test="${pagerModel.url eq 'null' && status.count <= 6 }">
									<c:forEach items="${pagerModels }" var="pModel" varStatus="pStatus">
										<c:if test="${pModel.url eq 'null' }">
											<span>${pModel.showContent}</span>
										</c:if>
										<c:if test="${pModel.url != 'null' && pStatus.count + 1 != pagerModels.size() }">
											<a href="${pModel.url }">${pModel.showContent}</a>
										</c:if>
										<c:if test="${pStatus.count + 1 == pagerModels.size() }">
											..
										</c:if>
									</c:forEach>
								</c:when>
								<c:when test="${pagerModel.url eq 'null' && pagerModels.size() - status.count <= 5}">
									<c:forEach items="${pagerModels }" var="pModel" varStatus="pStatus">
										<c:if test="${pModel.url eq 'null' }">
											<span>${pModel.showContent}</span>
										</c:if>
										<c:if test="${pModel.url != 'null' && pStatus.count != 2 }">
											<a href="${pModel.url }">${pModel.showContent}</a>
										</c:if>
										<c:if test="${pStatus.count  == 2 }">
											..
										</c:if>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach items="${pagerModels }" var="pModel" varStatus="pStatus">
										<c:choose>
											<c:when test="${pStatus.count == 2 }">
												..
											</c:when>
											<c:when test="${pStatus.count + 1 == pagerModels.size() }">
												..
											</c:when>
											<c:otherwise>
												<c:if test="${pModel.url eq 'null' }">
													<span>${pModel.showContent}</span>
												</c:if>
												<c:if test="${pModel.url != 'null' }">
													<a href="${pModel.url }">${pModel.showContent}</a>
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</c:if>
					</c:forEach>
				</c:if>
				<!-- 下一页 -->
				<c:forEach items="${pagerModels }" var="pagerModel" varStatus="status">
					<c:if test="${pagerModel.url eq 'null'}">
						<c:if test="${pagerModels.size() - param['section'] <= 1 }">
							<a href="news.do?section=${param['section']}" class="a1">下一页</a>
						</c:if>
						<c:if test="${pagerModels.size() - param['section'] > 1}">
							<a href="news.do?section=${param['section'] + 1}" class="a1">下一页</a>
						</c:if>
					</c:if>
				</c:forEach>
			</div> 
			</div>
			<div class="col-sm-3">
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
	<div class="dw_globle">
		<div class="sy_brand s_tjpp tk_link">
			<div class="s_syjd_top">
				<h2 style="margin-top:10px;">友情链接</h2>
			</div>
			<div class="grand">
				<div class="website">
					·<a href="main.do?target=1" target="_self">化妆造型</a>
					·<a href="main.do?target=1" target="_self">婚纱摄影</a>
					·<a href="main.do?target=1" target="_self">写真摄影</a>

					·<a href="main.do?target=1" target="_self">明星图片</a> ·<a
						href="main.do?target=1" target="_self">高清壁纸图片</a> 
					·<a href="main.do?target=3" target="_self">搞笑图片</a>
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
					<a href="main.do" target="_self" title="柚柚网">柚柚网</a>
					<span>|</span>  
					<script src="https://s95.cnzz.com/z_stat.php?id=1261349182&web_id=1261349182" language="JavaScript"></script>
				</div>
			</div>

		</div>
	</div>
</body>
</html>