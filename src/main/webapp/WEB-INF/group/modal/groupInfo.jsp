<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="resources/css/group/modal/groupInfo.css"/>

<div id="groupInfo">
<form action="/joingroup" method="post" onsubmit="return false">
	<input type="hidden" name="clubId"></input>
	<div class="title">
		<iconify-icon icon="mdi:account-group"></iconify-icon>
		<h2>그룹 정보</h2>
	</div>
	<div class="info-group">
		<div class="info-left">
			<div class="name">
				<h3>그룹 이름</h3>
				<span></span>
			</div>
			<div class="member">
				<iconify-icon icon="mingcute:group-line"></iconify-icon>
				<h3>그룹원 인원</h3>
				<span></span>
			</div>
			<div class="hashtagInput">
				<h3>해시태그</h3>
				<input id="hashtag"></input>
			</div>
		</div>
		<div class="info-right">
			<div class="goal">
				<h3>그룹 목표</h3>
				<span></span>
			</div>
			<div class="introduce">
				<h3>그룹 소개</h3>
				<span></span>
			</div>
		</div>
	</div>
	<div class="buttons">
		<hr>
		<input type="submit" value="가입"></input>
		<input id="cancel" type="button" value="취소"></input>
	</div>
</form>
</div>