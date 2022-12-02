<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="resources/css/group/modal/groupUpdate.css"/>

<div id="groupUpdate">
<form action="" method="post" onsubmit="return false">
	<div class="title">
		<iconify-icon icon="mdi:account-group"></iconify-icon>
		<h2>그룹 편집</h2>
	</div>
	<div class="groupInputs">
		<div class="groupInputs-left">
			<input type="hidden" name="clubId"></input>
			<div class="nameInput">
				<h3>그룹 이름</h3>
				<input type="text" name="cName" placeholder="그룹 이름을 입력하세요"></input>
			</div>
			<div class="memberInput">
				<iconify-icon icon="mingcute:group-line"></iconify-icon>
				<h3>그룹원 인원 제한</h3>
				<select name="max_member">
					<c:forEach begin="1" end="20" varStatus="loop">
						<option value="${loop.count}">${loop.count}</option>
					</c:forEach>
				</select>
				명
			</div>
			<div class="hashtagInput">
				<h3>해시태그</h3>
				<input id="hashtag" placeholder="엔터로 태그를 입력하세요"></input>
			</div>
		</div>
		<div class="groupInputs-right">
			<div class="goalInput">
				<h3>그룹 목표</h3>
				<input type="text" name="name" placeholder="목표를 입력하세요"></input>
			</div>
			<div class="infoInput">
				<h3>그룹 소개</h3>
				<textarea name="name" placeholder="소개글을 입력하세요"></textarea>
			</div>
		</div>
	</div>
	<div class="members">
		<!-- 추가 예정 -->
		<hr>
	</div>
	<div class="buttons">
		
		<input type="submit" value="생성"></input>
		<input id="cancel" type="button" value="취소"></input>
	</div>
</form>
</div>