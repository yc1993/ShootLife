<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="applicable-device" content="pc">
<title>${mainTitle }</title>
<meta name="keywords" content="搞笑,表情,写真,美女,漫画,柚柚网" />
<meta name="description" content="搞笑,表情,写真,美女,漫画,柚柚网,消遣空余时间，游戏后的调剂品" />

<link rel="stylesheet" type="text/css" href="CSS/global.css" />

<!-- <link rel="stylesheet" type="text/css" href="../CSS/global.css">  -->

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

.Column{
	font-size:21px;
	font-color:orange;
	padding-bottom: 10px;
}
.lable1{
	color:RGB(224,71,109);
}
.lable2{
	font-size:14px;
	color:#cccccc;
}
#ycDiv0,#ycDiv1,#ycDiv2, #ycDiv3 {
	margin-top:20px;
	margin-bottom:10px;
	font-weight:bold;
}
.col-sm-6 {
	border: 1px dotted gray;
	padding:5px;
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
</style>

<!-- <script>
    if (document.referrer.match(eval('/mtu.heiguang.com/i'))) {
        
    } else {
        

        var ua = ['iphone', 'android', 'phone', 'mobile', 'wap', 'netfront', 'java', 'opera mobi', 'opera mini', 'ucweb', 'windows ce', 'symbian', 'series', 'webos', 'sony', 'blackberry', 'dopod', 'nokia', 'samsung', 'palmsource', 'xda', 'pieplus', 'meizu', 'midp', 'cldc', 'motorola', 'foma', 'docomo', 'up.browser', 'up.link', 'blazer', 'helio', 'hosin', 'huawei', 'novarra', 'coolpad', 'webos', 'techfaith', 'palmsource', 'alcatel', 'amoi', 'ktouch', 'nexian', 'ericsson', 'philips', 'sagem', 'wellcom', 'bunjalloo', 'maui', 'smartphone', 'iemobile', 'spice', 'bird', 'zte-', 'longcos', 'pantech', 'gionee', 'portalmmm', 'jig browser', 'hiptop', 'benq', 'haier', '^lct', '320x320', '240x320', '176x220', 'windows phone', 'cect', 'compal', 'ctl', 'lg', 'nec', 'tcl', 'alcatel', 'ericsson', 'bird', 'daxian', 'dbtel', 'eastcom', 'pantech', 'dopod', 'philips', 'haier', 'konka', 'kejian', 'lenovo', 'benq', 'mot', 'soutec', 'nokia', 'sagem', 'sgh', 'sed', 'capitel', 'panasonic', 'sonyericsson', 'sharp', 'amoi', 'panda', 'zte'];
        var reg = ua.join('|');
        reg = '/' + reg + '/i';
        
        var x = location.href;
        x = x.replace('www.heiguang.com/photo', 'mtu.heiguang.com');
        x = x.replace('index.html', '');
        
        if((navigator.userAgent.match(eval(reg)))) {
            window.location.href = x;
        }
        
    }
    </script> --> 

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
				<%-- <a href="" target="_self" id="menu_0" class="${a }">图库首页</a> 
				<a href="main.do" target="_self" id="menu_66" class="f88">写真摄影</a> 
				<a href="" target="_self" id="menu_67">搞笑GIF</a>
				<a href="" target="_self" id="menu_68">表情世界</a> --%>
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
				<a href="news.do" target="_self" id="newsMenu" class="">热点新闻</a>
				
			</div>
		</div>
	</div>
	<!--最新作品-->
	<div class="container">
	
	<div class="row">
	<div class="tk_row">
		<dl class="imagesWrapper">
		
			<c:if test="${param.target == null }">
				<c:forEach items="${modelList }" var="model" varStatus="status">
					<c:choose>
						<c:when test="${status.index < 8 }">
							<c:if test="${status.index == 0 }">
	
								<div id="ycDiv1" class="Column"><label class="lable1">写真摄影</label><label class="lable2">/PHOTO</label></div>
							</c:if>
							<c:if test="${status.count % 4 == 0 }">
								<dd class="rightlimit">
									<a href="${nextPage }?target=1&index=${model.getId()}" target="_self">
										<img alt="${model.getTitle() }"
										src="${MyIP }${model.getPath()}${model.getImgName() }"
										title="${model.getTitle() }" />
									</a>
									<div id="abc" class="mask"></div>
									<div class="content">
										<a href="${nextPage }?target=1&index=${model.getId()}"
											target="_self">${model.getTitle() }</a> <span>${model.getCreateTime()}</span>
									</div>
								</dd>
							</c:if>
							<c:if test="${status.count % 4 !=0 }">
								<dd>
									<a href="${nextPage }?target=1&index=${model.getId()}" target="_self">
										<img alt="${model.getTitle() }"
										src="${MyIP }${model.getPath()}${model.getImgName() }"
										title="${model.getTitle() }" />
									</a>
									<div id="abc" class="mask"></div>
									<div class="content">
										<a href="${nextPage }?target=1&index=${model.getId()}"
											target="_self">${model.getTitle() }</a> <span>${model.getCreateTime()}</span>
									</div>
								</dd>
							</c:if>
							<c:if test="${status.index == 7 }">
																<!-- 新闻 -->
	<div id="ycDiv0" class="Column">
		<label class="lable1">热门新闻</label><label class="lable2">/NEWS</label>
	</div>
	<div class="row" >
		
		<div class="col-sm-6">
			<div class="row">
				<c:forEach items="${randNewsList}" var="randNews">
					<div class="col-sm-5" style="margin-right: 30px;margin-bottom: 30px;">
						<a href="readNews.do?id=${randNews.getId()}&createTime=${randNews.getCreateTime()}&title=${randNews.getTitle()}">
							<img alt="图片" src="${MyIP}${randNews.imgPath}" style="height: 150px;width: 200px;">
						</a>
						<div style="width: 100%;position: absolute;height: 45px;bottom: 0px;z-index: 3;left: 0px;color: #fff;background-color: #333;opacity:0.7;">${randNews.title}</div>
					</div>
				</c:forEach>
				
			</div>
		</div>
		<div class="col-sm-6">
			<c:forEach items="${newsList}" var="news">
				<a href="readNews.do?id=${news.getId()}&createTime=${news.getCreateTime()}&title=${news.getTitle()}"><p class="news">•&nbsp;${news.title}</p></a>
			</c:forEach>
		</div>
	</div>
								<div id="ycDiv2" class="Column"><label class="lable1">每日一漫</label><label class="lable2">/CARTOON</label></div>
							</c:if>
						</c:when>
						<c:when test="${status.index < 16 }">
							<c:if test="${status.count % 4 == 0 }">
								<dd class="rightlimit">
									<a href="cartoon.do?target=2&index=${model.getId()}&words=1" target="_self">
										<img alt="${model.getTitle() }"
										src="${MyIP }${model.getPath()}${model.getImgName() }"
										title="${model.getTitle() }" />
									</a>
									<div id="abc" class="specialMask" style="bottom:0px;"></div>
									<div class="special" style="bottom:0px;">
										<a href="cartoon.do?target=2&index=${model.getId()}&words=1"
											target="_self" style="color:#fff;">${model.getTitle() }</a><br> <span>${model.getCreateTime()}</span>
									</div>
								</dd>
							</c:if>
							<c:if test="${status.count % 4 !=0 }">
								<dd>
									<a href="cartoon.do?target=2&index=${model.getId()}&words=1" target="_self">
										<img alt="${model.getTitle() }"
										src="${MyIP }${model.getPath()}${model.getImgName() }"
										title="${model.getTitle() }" />
									</a>
									<div id="abc" class="specialMask" style="bottom:0px;"></div>
									<div class="special" style="bottom:0px;">
										<a href="cartoon.do?target=2&index=${model.getId()}&words=1"
											target="_self" style="color:#fff">${model.getTitle() }</a><br> <span>${model.getCreateTime()}</span>
									</div>
								</dd>
							</c:if>
							<c:if test="${status.index == 15 }">
								<div id="ycDiv3" class="Column"><label class="lable1">表情世界</label><label class="lable2">/EXPRESSION</label></div>
							</c:if>
						</c:when>
						<c:otherwise>
							<c:if test="${status.count % 4 == 0 }">
								<dd class="rightlimit">
									<a href="${nextPage }?target=3&index=${model.getId()}" target="_self">
										<img alt="${model.getTitle() }"
										src="${MyIP }${model.getPath()}${model.getImgName() }"
										title="${model.getTitle() }" />
									</a>
									<div id="abc" class="mask"></div>
									<div class="content">
										<a href="${nextPage }?target=3&index=${model.getId()}"
											target="_self">${model.getTitle() }</a> <span>${model.getCreateTime()}</span>
									</div>
								</dd>
							</c:if>
							<c:if test="${status.count % 4 !=0 }">
								<dd>
									<a href="${nextPage }?target=3&index=${model.getId()}" target="_self">
										<img alt="${model.getTitle() }"
										src="${MyIP }${model.getPath()}${model.getImgName() }"
										title="${model.getTitle() }" />
									</a>
									<div id="abc" class="mask"></div>
									<div class="content">
										<a href="${nextPage }?target=3&index=${model.getId()}"
											target="_self">${model.getTitle() }</a> <span>${model.getCreateTime()}</span>
									</div>
								</dd>
							</c:if>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if> 
			<!-- 根据target不是空的操作 -->
			<c:if test="${param.target != null }">
				<c:forEach items="${modelList }" var="model" varStatus="status" >
					<c:if test="${status.count % 4 !=0 }">
						<dd>
							<a
								href="${nextPage }?target=${param.target }&index=${model.getId()}&words=1"
								target="_self"> <img alt="${model.getTitle() }"
								src="${MyIP }${model.getPath()}${model.getImgName() }"
								title="${model.getTitle() }" />
							</a>
							<div <c:if test="${param.target != 2}">class="mask"</c:if> <c:if test="${param.target == 2}">class="specialMask" style="bottom:0px;"</c:if>></div>
							<div <c:if test="${param.target != 2}">class="content"</c:if> <c:if test="${param.target == 2}">class="special" style="bottom:0px;"</c:if>>
								<a <c:if test="${param.target == 2}">style="color:#fff"</c:if>
									href="${nextPage }?target=${param.target }&index=${model.getId()}&words=1"
									target="_self">${model.getTitle() }</a><c:if test="${param.target == 2}"><br></c:if> <span>${model.getCreateTime()}</span>
							</div>
						</dd>
					</c:if>
					<c:if test="${status.count % 4 == 0 }">
						<dd class="rightlimit">
							<a
								href="${nextPage }?target=${param.target }&index=${model.getId()}&words=1"
								target="_self"> <img alt="${model.getTitle() }"
								src="${MyIP }${model.getPath()}${model.getImgName() }"
								title="${model.getTitle() }" />
							</a>
							<div id="abc" <c:if test="${param.target != 2}">class="mask"</c:if> <c:if test="${param.target == 2}">class="specialMask" style="bottom:0px;"</c:if>></div>
							<div <c:if test="${param.target != 2}">class="content"</c:if> <c:if test="${param.target == 2}">class="special" style="bottom:0px;"</c:if>>
								<a <c:if test="${param.target == 2}">style="color:#fff"</c:if>
									href="${nextPage }?target=${param.target }&index=${model.getId()}&words=1"
									target="_self">${model.getTitle() }</a><c:if test="${param.target == 2}"><br></c:if> <span>${model.getCreateTime()}</span>
							</div>
						</dd>
					</c:if>
				</c:forEach>
				
				<dd class="pager">
					<a class="a1"><c:out value="${allNum }" />条</a>
					<!-- 上一页 -->
					<c:forEach items="${pagerModels }" var="pagerModel" varStatus="status">
						<c:if test="${pagerModel.url eq 'null'}">
							<c:if test="${param['section'] > 1 }">
								<a href="main.do?target=${param['target'] }&section=${param['section']-1}"class="a1">上一页</a>
							</c:if>
							<c:if test="${param['section'] <=1 || param['section'] == null }">
								<a href="main.do?target=${param['target'] }" class="a1">上一页</a>
							</c:if>
						</c:if>
					</c:forEach>
					<!-- section不需要出现省略的情况 -->
					<c:if test="${allNum < 132}">
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
					<c:if test="${allNum >=132 }">
						<!-- 页码 -->
						<c:forEach items="${pagerModels }" var="pagerModel" varStatus="status">
							<c:if test="${pagerModel.url eq 'null' }" >
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
					<c:forEach items="${pagerModels }" var="pagerModel"
						varStatus="status">
						<c:if test="${pagerModel.url eq 'null'}">
							<c:if test="${pagerModels.size() - param['section'] <= 1 }">
								<a href="main.do?target=${param['target'] }&section=${param['section']}" class="a1">下一页</a>
							</c:if>
							<c:if test="${pagerModels.size() - param['section'] > 1}">
								<a href="main.do?target=${param['target'] }&section=${param['section'] + 1}" class="a1">下一页</a>
							</c:if>
						</c:if>
					</c:forEach>
				</dd>
			</c:if> 
			
		</dl>
	</div>
	</div>
	</div>
	<!-- 广告位 -->
	
	<!---博客达人-->
	<div class="tk_row">
		<div class="col_24" id="blog" style="height:270px">
			<h2 class="tj_title" style="margin-bottom:10px;">
				<span class="tj_title_left"> <img
					src="image/photo_tktj.png"
					alt="图库推荐" />
				</span>
				<!-- <a class="tj_title_right" href="http://wpa.qq.com/msgrd?v=3&amp;uin=1760434080&amp;site=qq&amp;menu=yes" target="_self" rel="nofollow" style="width:95px">
                <img src="http://www.heiguang.com/statics/201404/img/photo_wytg.png" alt="我要投稿" >
            </a> -->
			</h2>

			<c:forEach items="${recommendList }" var="model" varStatus="status">
				<c:if test="${status.count % 6 != 0 }">
				<div class="tj_list">
					<div class="tj_list_border">
						<a
							href="secondPage.do?target=1&index=${model.getId()}"
							target="_self" title="${model.getTitle() }" rel="nofollow"> <img
							src="${MyIP }${model.getPath()}${model.getImgName() }" alt="${model.getTitle() }">
						</a>
					</div>
					<div class="tj_list_info">
						<span class="pink">
							</span> 
							<span class="zise">${model.getTitle() }</span>
					</div>
				</div>
				</c:if>
				<c:if test="${status.count % 6 == 0 }">
				<div class="tj_list" style="margin-right:0px">
					<div class="tj_list_border">
						<a
							href="secondPage.do?target=1&index=${model.getId()}"
							target="_self" title="${model.getTitle() }" rel="nofollow"> <img
							src="${MyIP }${model.getPath()}${model.getImgName() }" alt="${model.getTitle() }">
						</a>
					</div>
					<div class="tj_list_info">
						<span class="pink">
							</span> 
							<span class="zise">${model.getTitle() }</span>
					</div>
				</div>
				</c:if>		
			</c:forEach>
			<div class="clear"></div>
			<div class="hr_10"></div>
		</div>
	</div>
	<!-- 横幅广告2 -->
	
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
					<span>|</span><script src="https://s95.cnzz.com/z_stat.php?id=1261349182&web_id=1261349182" language="JavaScript"></script>
				</div>
			</div>

		</div>
	</div>
	<!-- 右下角浮窗 -->
	
	<!-- 对联广告 -->

	<!--js文件-->
	<script src="http://libs.baidu.com/jquery/1.9.0/jquery.min.js"></script>
	<script type="text/javascript"
		src="JS/common.tukuscroll.js"></script>

	<!--heiguang.com baidu analytics BEGIN-->
	<script>
var _hmt = _hmt || [];
_hmt.push(["_setUserId", "{{xid}}"]);
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?b402e0a7169c75a55900fb37559d05b0";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>

	<!--heiguang.com baidu analytics END-->
	<!--www.heiguang.com analytics BEGIN-->
	<script type="text/javascript">
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fa0e2f5480dc36f754aa28437a28fc063' type='text/javascript'%3E%3C/script%3E"));
</script>


	<script>
(function() {
    var $backToTopTxt = "", $backToTopEle = $('<div class="backToTop"></div>').appendTo($("body"))
        .text($backToTopTxt).attr("title", $backToTopTxt).click(function() {
            $("html, body").animate({ scrollTop: 0 }, 120);
    }), $backToTopFun = function() {
        var st = $(document).scrollTop(), winh = $(window).height();
        (st > 0)? $backToTopEle.show(): $backToTopEle.hide();    
        //IE6�µĶ�λ
        if (!window.XMLHttpRequest) {
            $backToTopEle.css("top", st + winh - 166);    
        }
    };
    $(window).bind("scroll", $backToTopFun);
    $(function() { $backToTopFun(); });
})();
</script>


	<script>
(function(){
    var bp = document.createElement('script');
    bp.src = '//push.zhanzhang.baidu.com/push.js';
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(bp, s);
})();
</script>

</body>
</html>
