<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/resources/css/main/signup.css"/>

<div class="Content">
	<div id="move_login" onclick="location.href='/login'">${ "< 로그인" }</div>
	<div class="signup" align="center">
		<div class="title">회원 가입</div>
		<form action="/kakao_signup" id="signup_form" method="post">
			<div class="input">
				<label>아이디</label>
				<input type="password" name="loginId" value="${loginId}" readonly></input>
			</div>
			<div class="input">
				<label>비밀번호</label>
				<input type="password" name="password" value="${password}" readonly></input>
			</div>
			<div class="input">
				<label>비밀번호 확인</label>
				<input type="password" name="confirm_password" value="${password}" readonly></input>
			</div>
			<div class="input">
				<label>이메일</label>
				<input type="email" name="emailAddress" value="${emailAddress}" readonly></input>
			</div>
			<hr/>
			<div class="input">
				<label>닉네임</label>
				<input type="text" name="name" placeholder="입력" required></input>
			</div>
			<div class="input">
				<label>성별</label>
				<select name="gender" size="2">
					<c:if test="${gender eq 1}">
						<option value="1" selected>여성</option>
						<option value="2">남성</option>
					</c:if>
					<c:if test="${gender eq 2}">
						<option value="1">여성</option>
						<option value="2" selected>남성</option>
					</c:if>
					<c:if test="${gender eq null}">
						<option value="1">여성</option>
						<option value="2">남성</option>
					</c:if>
				</select>
			</div>
			<div class="input">
				<label>나이</label>
				<input type="number" min='0' max="100" name="age"  placeholder="입력" required></input>
			</div>
			<div class="input">
				<label>키/몸무게</label>
				<input type="number" min='0' max="300" name="height"  placeholder="입력" required></input>cm
				<input type="number" min='0' max="300" name="weight"  placeholder="입력" required></input>kg
			</div>
			<div class="input">
				<label>활동량</label>
				<select name="activeRank" size="4" required>
					<option value="1">거의 활동하지 않음</option>
					<option value="2">조금씩 활동함</option>
					<option value="3">규칙적으로 활동함</option>
					<option value="4">활발하게 활동함</option>
				</select>
			</div>
			<input id="submit" type="submit" value="회원 가입"></input>
		</form>
	</div>
</div>
 