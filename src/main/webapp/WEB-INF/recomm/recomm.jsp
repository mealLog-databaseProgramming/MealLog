<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/recomm.css"/>
</head>
<body>
<div class="contents">
	<div class="topDiv">
		<div class="graphContainer col-9">
		<div class="graphTitle">전유영 님<br><span>단백질</span>이 부족하네요</div>
			<div class="zt-skill-bar"><div data-width="75" style="">kcal<span>75%</span></div></div>
			<div class="zt-skill-bar"><div data-width="100" style="">탄수화물<span>100%</span></div></div>
			<div class="zt-skill-bar"><div data-width="30" style=";">단백질<span>30%</span></div></div>
			<div class="zt-skill-bar"><div data-width="45" style=";">지방<span>45%</span></div></div>
		</div>
		
		<div></div>
		
		<div class="recommContainer">
			<span>오늘의 추천메뉴</span>
			<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-arrow-counterclockwise" viewBox="0 0 16 16">
			  	<path fill-rule="evenodd" d="M8 3a5 5 0 1 1-4.546 2.914.5.5 0 0 0-.908-.417A6 6 0 1 0 8 2v1z"/>
			  	<path d="M8 4.466V.534a.25.25 0 0 0-.41-.192L5.23 2.308a.25.25 0 0 0 0 .384l2.36 1.966A.25.25 0 0 0 8 4.466z"/>
			</svg>
			<div class="recommCard">
		        <div class="item front"><img src="resources/favicon/favicon-96x96.png"></div>
		        <div class="item back">
		        	<div class="itemText">
			        	<p class="title">돼지고기 김치찌개</p>
			        	<p class="content">칼로리 : 520kcal</p>
						<p class="content">탄수화물 : 55g</p>
						<p class="content">단백질 : 60g</p>
						<p class="content">지방 : 60g</p>
					</div>
		        </div>
		  	</div>
		</div>
	</div>
	
	<p class="cardTitle">오늘의 음식기록</p>
	<div class="cardContainer">
		 <div class="card">
			<img src="resources/img/salad.jpg" class="card-img"  alt="...">
		  	<div class="card-body">
		    	<div class="card-text">닭가슴살 샐러드<br><div class="kcal">261kcal</div></div>
		  	</div>
		</div>
		<div class="card">
			<img src="resources/img/salad.jpg" class="card-img"  alt="...">
		  	<div class="card-body">
		    	<div class="card-text">닭가슴살 샐러드<div class="kcal">261kcal</div></div>
		  	</div>
		</div>
		<div class="card">
			<img src="resources/img/salad.jpg" class="card-img"  alt="...">
		  	<div class="card-body">
		    	<div class="card-text">닭가슴살 샐러드<br><div class="kcal">261kcal</div></div>
		  	</div>
		</div>
		<div class="card">
			<img src="resources/img/salad.jpg" class="card-img"  alt="...">
		  	<div class="card-body">
		    	<div class="card-text">닭가슴살 샐러드<br><div class="kcal">261kcal</div></div>
		  	</div>
		</div>
		<div class="card">
			<img src="resources/img/salad.jpg" class="card-img"  alt="...">
		  	<div class="card-body">
		    	<div class="card-text">닭가슴살 샐러드<br><div class="kcal">261kcal</div></div>
		  	</div>
		</div>

	</div>
</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="resources/js/recomm.js"></script>
</body>
</html>