<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script defer type="text/javascript" src="/resources/js/mypage/mypage.js"></script>
<link rel="stylesheet" href="/resources/css/mypage/mypage.css"/>
<link rel="stylesheet" href="/resources/css/mypage/polaroid.css"/>

<jsp:include page="modal/weightStat_update.jsp"/>

<div class='Content'>
<div class="mypage">
	<c:if test="${edit eq true}">
		<jsp:include page="profile/profile_edit.jsp"/>
	</c:if>
	<c:if test="${edit eq false}">
		<jsp:include page="profile/profile.jsp"/>
	</c:if>
	<hr/>
	<jsp:include page="stat/stat.jsp"/>
	<div class='seeAlso' onclick="location.href = '#feeds';">
		▼ 식단 기록 모아 보기
	</div>
	<div id='feeds' class="polra">
		<c:forEach begin="1" end="40" varStatus="loop">
			<jsp:include page="polaroid.jsp"/>
		</c:forEach>
	</div>
</div>
</div>