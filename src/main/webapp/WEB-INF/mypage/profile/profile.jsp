<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/resources/css/mypage/profile.css"/>

<style>
	.profile {
		transform: translate(0, 20px);
	}
</style>

<div class="profile">
	<div class="img"></div>
	<div class="info">
		<div class="name">사용자 이름</div>
		<div class="edit" onclick = "location.href='?edit=true'">✏ 수정하기</div>
		<div class="introduce">안녕하세요 저는 사용자 이름이구요.<br>저는 서로 식단 공유하면서 피드백할 분들을 찾고 있습니다.</div>
		<div class="tag">🥗 식단 기록 | 53</div>
		<div class="tag">👍 긍정 반응 | 3</div>
	</div>
</div>