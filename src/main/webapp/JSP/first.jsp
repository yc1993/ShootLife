<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title }</title>
<style type="text/css">
#imgBody{
	width:300px;
	height:200px;
}

</style>
</head>
<body>

<p>${header["user-agent"]}</p>

pageContext.request.queryString:<c:out value="${param.age }"></c:out><br/>

<%-- <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://101.200.40.71:3307/test"
	user="root" password="web123"/>
<sql:query var="result" dataSource="${snapshot }">
	SELECT TITLE FROM yellow_list WHERE ID=1;
</sql:query>
<c:forEach items="${result.rows }" var="row">
	<c:out value="${row.title }"></c:out>
</c:forEach> --%>

<%-- <c:redirect url="/second.do">
	<c:param name="index" value="2"></c:param>
	<c:param name="page" value="hz"></c:param>
</c:redirect> --%>

<c:out value="ok" escapeXml="false"></c:out>&ltc:out&gt。<br/>
session的值：<c:out value="${user.username }"></c:out><br/>

request的值：<c:out value="${user1.password }"></c:out><br/>
<c:set target="${user}" property="username" value="hello" scope="session" var="u" ></c:set>

<c:set target="${student }" property="age" value="13" scope="session" var="studentAge"></c:set>

student的age：<c:out value="${studentAge }"></c:out>

新的session的值：<c:out value="${user.username}"></c:out><br />
<c:set var="person" scope="session" value="${2*100 }"></c:set>
<c:out value="${person }"></c:out>
<div id="imgBody">
	<img alt="图片1" src="${image1 }">
	
</div>
<div>
	<button onclick="tz()" >提交</button>
</div>

<c:forEach var="i" begin="1" end="5">
	Item<c:out value="${i }"></c:out>
</c:forEach>

<c:forTokens items="hello,world,my,deal" delims="," var="content" varStatus="status">
	<c:if test="${status.last }">
		总共<c:out value="${status.count }"></c:out>段<br/>
	</c:if>
	当前迭代从1开始的计数：<c:out value="${status.count }"></c:out><br/>
	当前迭代从0开始的迭代索引：<c:out value="${status.index }"></c:out><br/>
	当前项1：<c:out value="${content }"></c:out><br/>
	当前项2：<c:out value="${status.current }"></c:out><br/>
</c:forTokens>

<script type="text/javascript">
function tz() {
	console.log("卧槽");
	window.location.href = "second.do";
}
</script>
</body>
</html>