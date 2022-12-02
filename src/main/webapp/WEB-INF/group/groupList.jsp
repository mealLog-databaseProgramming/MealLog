<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script defer type="text/javascript" src="/resources/js/group/groupEvents.js"></script> 
<script defer type="text/javascript" src="/resources/js/group/groupView.js"></script> 

<link rel="stylesheet" href="resources/css/group/groupList.css"/>
<link rel="stylesheet" href="resources/css/group/groupView.css"/>


<div class='Content'>
	<div class="groupHeader">
		<input type="text" placeholder="원하는 그룹을 찾아보세요" class="groupSearch">
		<iconify-icon class="searchIcon" icon="mingcute:search-line"></iconify-icon>
		<div id="newGroup_button">새그룹 만들기</div>
	</div>
	<span class="line"></span>
	<div class="groupList_f">
		<c:forEach begin="1" end="10" varStatus="loop">
			<jsp:include page="groupView.jsp">
				<jsp:param name="clubId" value="${loop.count}"/>
				<jsp:param name="cName" value="작심 3달"/>
				<jsp:param name="goal" value="식단 초보의 3달 도전기"/>
				<jsp:param name="info" value="식단 초보입니다.\n3개월 동안 식단 봐주면서 건강해지실 분들 찾아요."/>
				<jsp:param name="current_member" value="3"/>
				<jsp:param name="max_member" value="10"/>
				<jsp:param name="tags" value="['식단', '단기', '다이어트']"/>
			</jsp:include>
		</c:forEach>
	</div>
</div>

<jsp:include page="modal/groupInfo.jsp"></jsp:include>
<jsp:include page="modal/groupCreate.jsp"></jsp:include>
<jsp:include page="modal/groupUpdate.jsp"></jsp:include>