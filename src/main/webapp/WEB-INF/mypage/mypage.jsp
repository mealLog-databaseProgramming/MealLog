<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script defer type="text/javascript" src="/resources/js/mypage/mypage.js"></script>
<link rel="stylesheet" href="/resources/css/mypage/mypage.css"/>
<link rel="stylesheet" href="/resources/css/mypage/polaroid.css"/>

<c:if test="${message ne null}">
	<script defer>
		alert("<%=request.getAttribute("message")%>");
	</script>
</c:if>
<jsp:include page="modal/weightStat_update.jsp"/>
<div class='Content'>
<div class="mypage">
	<jsp:include page="profile/profile.jsp"/>
	<c:if test="${userId eq param.uid}">
		<jsp:include page="profile/profile_edit.jsp"/>
	</c:if>
	<hr/>
	<c:if test="${userId eq param.uid}">
		<jsp:include page="stat/stat.jsp"/>
		<div class='seeAlso' onclick="location.href = '#feeds';">
			▼ 식단 기록 모아 보기
		</div>
	</c:if>
	<div id='feeds' class="polra">
		<c:forEach var="feed" items="${feedList}">
			<c:set var="feedId" value="${feed.getFeedId()}" scope="request"/>
			<c:set var="photo" value="${feed.getPhoto()}" scope="request"/>
			<jsp:include page="polaroid.jsp"/>
		</c:forEach>
	</div>
</div>
</div>