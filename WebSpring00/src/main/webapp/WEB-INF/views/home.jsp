<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/js_css/style.css" type="text/css"/>
	<script src="<%=request.getContextPath()%>/js_css/script.js"></script>
</head>

<body>
<a href="/myapp/aLink?name=흰둥이&age=2">클릭1</a>
<a href="/myapp/aLink2?name=짱구&age=5">클릭2</a>
<a href="/myapp/aLink3?username=짱아&age=1">클릭3</a>
<a href="/myapp/aLink4?username=신짱&age=5">클릭4</a></br>
<a href="/myapp/formData">클릭하세요 폼으로 이동</a>



<img src="<%=request.getContextPath()%>/img/06.jfif"/>
</body>
</html>
