<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="controller.UserSessionUtils" %>
<%@ page import="model.service.UserManager" %>
<%@ page import="model.dto.UserDTO" %>
<%
	long userId = UserSessionUtils.getLoginUserId(request.getSession());
	UserManager userManager = UserManager.getInstance();
	UserDTO user = userManager.findUser(userId);
	
	request.setAttribute("header_uname", user.getUname());
	if(user.getProfile() != null) request.setAttribute("header_profile", user.getProfile());
%>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="/resources/js/kakaoLogin.js"></script>
<script>
	function logout() {
		console.log("sgg");
		kakaoLogout();
		location.href='/logout';
	}
</script>
<div class='Header'>
	<div class='title' onclick="location.href='/'">
		<div class='yolk'></div>
		<iconify-icon icon="fluent:food-egg-24-regular"></iconify-icon>
		Meal:<span>Log</span>
	</div>
	<div class='greet'>
		<div id="profile" onclick="location.href='/mypage'">
			<img src="/resources/profile/${header_profile}" onError="this.style.visibility='hidden'">
		</div>
		${header_uname}님, 식사 맛있게 하셨나요? 식단을 그룹원들에게 공유해보세요
		<div class='logout' onclick="logout()">
			<iconify-icon icon="icon-park:logout"></iconify-icon>
			로그아웃
		</div>
	</div>
</div>