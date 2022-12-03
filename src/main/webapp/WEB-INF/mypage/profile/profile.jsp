<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/resources/css/mypage/profile/profile.css"/>

<style>
	.profile {
		transform: translate(0, 30px);
	}
</style>

<div id="profile" class="profile">
	<div class="img">
		<c:if test="${profile ne null}">
			<img class="profileImg" src="${profile}"></img>
		</c:if>
	</div>
	<div class="info">
		<div class="name">${uname}</div>
		<c:if test="${userId eq param.uid}">
			<div class="edit">✏ 수정하기</div>
		</c:if>
		<div class="introduce">
			<c:if test="${introduce eq null}">
				<span style="color: rgba(0, 0, 0, .5)">자기소개 글이 아직 없습니다.</span>
			</c:if>
			${introduce}
		</div>
		<div class="tag">🥗 식단 기록 | 53</div>
		<div class="tag">👍 긍정 반응 | 3</div>
	</div>
</div>