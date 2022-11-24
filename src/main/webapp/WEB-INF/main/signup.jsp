<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/resources/css/main/signup.css"/>

<div id="move_login" onclick="location.href='/login'">${ "< 로그인" }</div>
<div class="signup" align="center">
	<div class="title">회원 가입</div>
	<form id="signup_form" method="post">
		<div class="input">
			<div class="label">아이디</div>
			<input class="text_input" type="text" name="id" placeholder="입력하세요"></input>
		</div>
		<div class="input">
			<div class="label">비밀번호</div>
			<input class="text_input" type="password" name="password" placeholder="입력하세요"></input>
		</div>
		<div class="input">
			<div class="label">비밀번호 확인</div>
			<input class="text_input" type="password" name="password_confirm" placeholder="입력하세요"></input>
		</div>
		<hr/>
		<div class="input">
			<div class="label">닉네임</div>
			<input class="text_input" type="text" name="nickname" placeholder="입력하세요"></input>
		</div>
		<div class="input">
			<div class="label">성별</div>
			<input type="radio" name="gender" value="female"></input>
			<input type="radio" name="gender" value="male"></input>
		</div>
		<div class="input">
			<div class="label">몸무게</div>
			<input type="text" name="weight"  placeholder="입력하세요"></input>
		</div>
		<div class="input">
			<div class="label">활동량</div>
			<input type="radio" name="activeRank" value="1"></input>
			<input type="radio" name="activeRank" value="2"></input>
			<input type="radio" name="activeRank" value="3"></input>
			<input type="radio" name="activeRank" value="4"></input>
		</div>
		<input id="submit" type="submit" value="회원 가입"></input>
	</form>
</div>
