<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="myGroup">
	<div id="joinedGroupView" class="myGroupView">
		<input type="button" value="수정"></input>
		<div>
			<div class="title">
				<iconify-icon icon="mdi:account-group"></iconify-icon>
				${clubData.getCname()}
			</div>
			<div>
				<label>그룹 목표</label>
				<div>${clubData.getGoal()}</div>
			</div>
			<div>
				<label>그룹 소개</label>
				<div class="info">${clubData.getInfo()}</div>
			</div>
			<input id="hashtag" value="${hashtags.get(Long.valueOf(clubData.getClubId()))}"></input>
		</div>
		<div>
			<div class="groupMember">
				<label>그룹원 명단</label>
				<div class="memberList">
					<c:forEach var="user" items="${members.get(Long.valueOf(clubData.getClubId()))}">
						<c:set var="userData" value="${user}" scope="request"/>
						<jsp:include page="member.jsp"/>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
	<form id="joinedGroupView" class="myGroup_edit">
		<input type="submit" value="수정"></input>
		<div>
			<div class="title">
				<iconify-icon icon="mdi:account-group"></iconify-icon>
				${clubData.getCname()}
			</div>
			<div>
				<label>그룹 목표</label>
				<div>${clubData.getGoal()}</div>
			</div>
			<div>
				<label>그룹 소개</label>
				<div class="info">${clubData.getInfo()}</div>
			</div>
			<input id="hashtag" value="${hashtags.get(Long.valueOf(clubData.getClubId()))}"></input>
		</div>
		<div>
			<div class="groupMember">
				<label>그룹원 명단</label>
				<div class="memberList">
					<c:forEach var="user" items="${members.get(Long.valueOf(clubData.getClubId()))}">
						<c:set var="userData" value="${user}" scope="request"/>
						<jsp:include page="member.jsp"/>
					</c:forEach>
				</div>
			</div>
		</div>
	</form>
</div>