<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/resources/css/main/login.css"/>

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="/resources/js/kakaoLogin.js"></script>

<div class="Content">
	<div id="move_signup" onclick="location.href='/signup'">회원 가입 ></div>
	<div class="Login" align="center">
		<div class="title">
			<div class='meallog_icon'>
				<div class='yolk'></div>
				<iconify-icon icon="fluent:food-egg-24-regular"></iconify-icon>
			</div>
			<span>Meal:</span>Log
		</div>
		<form id="login_form" method="post">
			<input type="text" name="loginId" placeholder="아이디를 입력하세요" required></input>
			<input type="password" name="password" placeholder="비밀번호를 입력하세요" required></input>
			<input id="submit" type="submit" value="로그인"></input>
			<img id="kakao_login" 
				onclick="kakaoLogin()"
				src="https://developers.kakao.com/tool/resource/static/img/button/login/full/ko/kakao_login_large_wide.png"/>
		</form>
	</div>
</div>
