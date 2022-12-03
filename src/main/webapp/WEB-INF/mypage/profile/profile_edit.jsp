<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/resources/css/mypage/profile/profile.css"/>
<link rel="stylesheet" href="/resources/css/mypage/profile/profile_edit.css"/>

<form id="profile_edit" class="profile" method="post">
	<div class="img">
		<img class="preview"/>
		<label for="file"><iconify-icon icon="mdi:image-edit-outline"></iconify-icon></label>
		<input type="file" id="file" accept="image/*"></input>
	</div>
	<div class="info">
		<input type="text" class="name" placeholder="이름을 입력하세요"></input>
		<input type="submit" class="edit" value="✏ 수정 완료"></input>
		<input type="button" class="cancel" value="수정 취소"></input>
		<textarea placeholder="본인을 소개해주세요"></textarea>
		<div class="tag">🥗 식단 기록 | 53</div>
		<div class="tag">👍 긍정 반응 | 3</div>
	</div>
</form>

<script defer type="text/javascript" src="/resources/js/mypage/profile/profile_edit.js"></script>
