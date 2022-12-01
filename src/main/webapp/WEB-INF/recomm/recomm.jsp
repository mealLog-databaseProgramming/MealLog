<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!--<link rel="preconnect" href="https://fonts.googleapis.com"> 
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
	<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">-->
		
	<link rel="stylesheet" href="resources/css/recomm/recomm.css"/>
</head>
<body>
<div class="Content">
<% 
	Object userId = request.getAttribute("userId"); //꼭 Object형으로 받기
	Object EER = request.getAttribute("EER");
%>
	<div class="topDiv">
		<div class="graphContainer">
			<div class="graphComment">
				사용자 님, <%=userId%>
				<br>
				단백질이 부족하네요, EER은 <%=EER %>
			</div>
			<canvas id="graph" width="600" height="200"></canvas>
		</div>
		
		
		
		<!-- 공백div -->
		<div></div>
		
		<div class="recommContainer">
			<input type="text"><input type="button" value="ok" id="submitBtn">
			<span class="recommTitle">오늘의 추천메뉴</span>
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
		<div class="flip">  
		  <div class="card">
		    <!-- 앞면 -->
		    <div class="front">
		    	<img src="resources/img/salad.jpg" class="card-img"  alt="...">
			  	<div class="date">
			    	2022-12-12 pm 6:50
			  	</div>
		    </div>
		    <!-- 뒷면 -->
		    <div class="back">
		    	<div class="backContainer">
			    	<ul>
			    		<li>닭가슴살 샐러드 261kcal</li>
			    	</ul>
		    	</div>
		    </div>
		  </div>
		</div>
		<div class="flip">  
		  <div class="card">
		    <!-- 앞면 -->
		    <div class="front">
		    	<img src="resources/img/salad.jpg" class="card-img"  alt="...">
			  	<div class="date">
			    	2022-12-12 pm 6:50
			  	</div>
		    </div>
		    <!-- 뒷면 -->
		    <div class="back">
		    	<div class="backContainer">
			    	<ul>
			    		<li>닭가슴살 샐러드 261kcal</li>
			    	</ul>
		    	</div>
		    </div>
		  </div>
		</div>
		<div class="flip">  
		  <div class="card">
		    <!-- 앞면 -->
		    <div class="front">
		    	<img src="resources/img/salad.jpg" class="card-img"  alt="...">
			  	<div class="date">
			    	2022-12-12 pm 6:50
			  	</div>
		    </div>
		    <!-- 뒷면 -->
		    <div class="back">
		    	<div class="backContainer">
			    	<ul>
			    		<li>닭가슴살 샐러드 261kcal</li>
			    	</ul>
		    	</div>
		    </div>
		  </div>
		</div>
		<div class="flip">  
		  <div class="card">
		    <!-- 앞면 -->
		    <div class="front">
		    	<img src="resources/img/salad.jpg" class="card-img"  alt="...">
			  	<div class="date">
			    	2022-12-12 pm 6:50
			  	</div>
		    </div>
		    <!-- 뒷면 -->
		    <div class="back">
		    	<div class="backContainer">
			    	<ul>
			    		<li>닭가슴살 샐러드 261kcal</li>
			    	</ul>
		    	</div>
		    </div>
		  </div>
		</div>
		<div class="flip">  
		  <div class="card">
		    <!-- 앞면 -->
		    <div class="front">
		    	<img src="resources/img/salad.jpg" class="card-img"  alt="...">
			  	<div class="date">
			    	2022-12-12 pm 6:50
			  	</div>
		    </div>
		    <!-- 뒷면 -->
		    <div class="back">
		    	<div class="backContainer">
			    	<ul>
			    		<li>닭가슴살 샐러드 261kcal</li>
			    	</ul>
		    	</div>
		    </div>
		  </div>
		</div>
	</div>
</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="resources/js/recomm/recomm.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
	<script src="resources/js/recomm/chart.js"></script>
</body>
</html>