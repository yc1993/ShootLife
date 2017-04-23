<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="JS/jquery-3.2.1.min.js"></script>

</head>
<body>
<form action="push.do" method="post" accept-charset="UTF-8">
	<label for="title">title</label><input type="text" id="title" name="title" class="title"/><br>
	<label for="icon_url">icon_url</label><input type="text" id="iconUrl" name="iconUrl" /><br>
	<label for="content">content</label><textarea rows="3" cols="40" class="content" name="content" ></textarea><br id="contentBr">
	<button type="button" onclick="addContent()">增加content</button><br>
	<label for="url">url</label><input type="text" class="url" name="url"><br id="urlBr">
	<button type="button" onclick="addUrl()">增加url</button><br>
	<button type="submit">提交</button>
</form>

</body>
<script type="text/javascript">
	function addContent(){
		$("#contentBr").before("<textarea rows=\"3\" cols=\"40\" class=\"content\" name=\"content\"></textarea>");
	}
	function addUrl() {
		$("#urlBr").before("<input type=\"text\" class=\"url\" name=\"url\">");
	}
</script>
</html>