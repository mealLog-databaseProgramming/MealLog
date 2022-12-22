<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="memberDatas" value="[ "/>
<c:forEach var="user" items="${members.get(Long.valueOf(clubData.getClubId()))}">
	<c:set var="memberDatas" value="${memberDatas} { value: ${user.getUserId()}, name: '${user.getUname()}', profile: '/resources/profile/${user.getProfile()}' },"/>
</c:forEach>
<c:set var="memberDatas" value="${memberDatas} ]"/>

<div id="myGroup">
	<div id="joinedGroupView" class="myGroupView">
		<input type="button" value="수정" onclick="group_edit(this, ${clubData.getClubId()}, ${memberDatas})"></input>
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
	
	<form id="joinedGroupView" class="myGroup_edit" style="display: none;" action="/groupUpdate" method="post">
		<input type="hidden" name="clubId" value="${clubData.getClubId()}">
		<input type="submit" value="적용"></input>
		<input type="button" value="삭제" onclick="group_delete(this)"></input>
		<input type="button" value="취소" onclick="location.href=''"></input>
		<div>
			<div class="title">
				<iconify-icon icon="mdi:account-group"></iconify-icon>
				<input type="text" name="cname" value="${clubData.getCname()}"/>
			</div>
			<div>
				<label>그룹 목표</label>
				<input type="text" name="goal" value="${clubData.getGoal()}"/>
			</div>
			<div>
				<label>그룹 소개</label>
				<textarea name="info" >${clubData.getInfo()}</textarea>
			</div>
			<div>
				<label>해시태그</label>
				<input id="hashtag" name="hname" value="${hashtags.get(Long.valueOf(clubData.getClubId()))}"></input>
			</div>
		</div>
		<div>
			<div class="groupMember">
				<label>그룹원 명단</label>
				<input id="memberList_${clubData.getClubId()}"></input>	
			</div>
		</div>
	</form>
</div>