<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Meal:Log</title>
	<jsp:include page="/setting.jsp"/>
	
	<link rel="stylesheet" href="/resources/css/index.css"/>
	<script type="text/javascript" src="/resources/js/index.js"></script> 
</head>
<body onload='init()'>
	<div class='Header'>
		<div class='title'>
			<div class='yolk'></div>
			<iconify-icon icon="fluent:food-egg-24-regular"></iconify-icon>
			Meal:<span>Log</span>
		</div>
		<div class='greet'>
			<iconify-icon icon="healthicons:ui-user-profile"></iconify-icon>
			박솜솜님, 식사 맛있게 하셨나요? 식단을 그룹원들에게 공유해보세요
			<div class='logout'>
				<iconify-icon icon="icon-park:logout"></iconify-icon>
				로그아웃
			</div>
		</div>
		
	</div>
	<div class='Nav'>
		<ul>
			<li class='nonsel'>피드</li>
			<li class='nonsel'>식단 추천</li>
			<li class='nonsel'>그룹 매칭</li>
			<li class='select'>마이페이지</li>
		</ul>
	</div>
	<div class='Content'>
		<jsp:include page="/WEB-INF/mypage/mypage.jsp"/> <!-- 알갱이 만든걸 여기 경로 넣어서 적용 -->
	</div>
</body>
</html>


