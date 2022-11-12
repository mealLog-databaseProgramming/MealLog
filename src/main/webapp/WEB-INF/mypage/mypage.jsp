<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="/resources/js/mypage/mypage.js"></script>

<link rel="stylesheet" href="/resources/css/mypage/mypage.css"/>
<link rel="stylesheet" href="/resources/css/mypage/profile.css"/>
<link rel="stylesheet" href="/resources/css/mypage/stat.css"/>
<link rel="stylesheet" href="/resources/css/mypage/polaroid.css"/>

<div class="mypage">
	<jsp:include page="profile.jsp"/>
	<hr/>
	<jsp:include page="stat.jsp"/>
	<div class='seeAlso' onclick="location.href = '#feeds';">
		▼ 식단 기록 모아 보기
	</div>
	<div id='feeds' class="polra">
		<c:forEach begin="1" end="40" varStatus="loop">
			<jsp:include page="polaroid.jsp"/>
		</c:forEach>
	</div>
	
</div>