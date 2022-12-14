<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="member" onclick="moveSrc(this)">
	<input id="userId" type="hidden" value="${userData.getUserId()}">
	<div id="profile">
		<img src="/resources/profile/${userData.getProfile()}" onError="this.style.visibility='hidden'">
	</div>
	${userData.getUname()}
</div>
