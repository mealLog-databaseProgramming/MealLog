<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Meal:Log</title>
	<jsp:include page="setting.jsp"/>
	
	<link rel="stylesheet" href="resources/css/index.css"/>
	<script type="text/javascript" src="resources/js/index.js"></script> 
</head>

<body onload='init()'>
	<jsp:include page="header.jsp"/>
	<div class='Nav'>
		<ul>
			<li class='nonsel'>피드</li>
			<li class='nonsel'>식단 추천</li>
			<li class='nonsel'>그룹 매칭</li>
			<li class='nonsel'>마이페이지</li>
		</ul>
	</div>
	<c:if test="${page ne null}">
		<jsp:include page="${page}" />
	</c:if>
	
</body>
</html>


