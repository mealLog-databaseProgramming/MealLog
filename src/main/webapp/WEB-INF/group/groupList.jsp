<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script defer type="text/javascript" src="/resources/js/group/groupEvents.js"></script> 
<script defer type="text/javascript" src="/resources/js/group/groupView.js"></script>
<script defer type="text/javascript" src="/resources/js/group/groupCreate.js"></script>  
<script defer type="text/javascript" src="/resources/js/group/groupInfo.js"></script> 

<link rel="stylesheet" href="resources/css/group/groupList.css"/>
<link rel="stylesheet" href="resources/css/group/view/groupView.css"/>
<link rel="stylesheet" href="resources/css/group/view/joinedGroupView.css"/>
<link rel="stylesheet" href="resources/css/group/view/myGroupView.css"/>

<div class='Content'>
	<div class="groupHeader">
		<input type="text" placeholder="원하는 그룹을 찾아보세요" class="groupSearch">
		<iconify-icon class="searchIcon" icon="mingcute:search-line"></iconify-icon>
		<div id="newGroup_button">새그룹 만들기</div>
	</div>
	<span class="line"></span>
	<div class="groupList_f">
		<c:forEach var="club" items="${myClubList}">
			<c:set var="clubData" value="${club}" scope="request"/>
			<jsp:include page="view/myGroupView.jsp"/>
		</c:forEach>
		<c:forEach var="club" items="${joinedClubList}">
			<c:set var="clubData" value="${club}" scope="request"/>
			<jsp:include page="view/joinedGroupView.jsp"/>
		</c:forEach>
		<c:forEach var="club" items="${clubList}">
			<c:set var="clubData" value="${club}" scope="request"/>
			<jsp:include page="view/groupView.jsp"/>
		</c:forEach>
	</div>
</div>

<jsp:include page="modal/groupInfo.jsp"></jsp:include>
<jsp:include page="modal/groupCreate.jsp"></jsp:include>