<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="model.dao.FeedDAO"%>
<%@page import="model.dto.FeedDTO"%>
<%@page import="model.dto.FoodDTO"%>
<%@page import="model.dto.ReplyDTO"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="resources/css/recomm/recomm.css"/>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@700&display=swap" rel="stylesheet">
	<style> @import url('https://fonts.googleapis.com/css2?family=Caveat:wght@700&display=swap'); </style>
</head>
<body>
<div class="Content">
<% 
	//EER
	Object userId = request.getAttribute("userId"); //꼭 Object형으로 받기
	Object EER = request.getAttribute("EER");
	
	//영양소 합
	float kcalSum = (float)request.getAttribute("kcalSum");
	float carbSum = (float)request.getAttribute("carbSum");
	float proteinSum = (float)request.getAttribute("proteinSum");
	float fatSum = (float)request.getAttribute("fatSum");
	
	//당일 피드
	List<Map> list = (List<Map>)request.getAttribute("list");
	
	//유저이름
	String uname = (String)request.getAttribute("uname");
%>
	<div class="topDiv">
		<div class="graphContainer">
			<div class="graphComment">
			</div>
			<input type="hidden" value="<%=uname %>" name="uname">
			<input type="hidden" value="<%=EER %>" name="EER">
			<input type="hidden" value="<%=kcalSum %>" name="kcalSum">
			<input type="hidden" value="<%=carbSum %>" name="carbSum">
			<input type="hidden" value="<%=proteinSum %>" name="proteinSum">
			<input type="hidden" value="<%=fatSum %>" name="fatSum">
			
			<canvas id="graph" width="600" height="200"></canvas> 
		</div>

		<!-- 공백div -->
		<div></div>
		
		<div class="recommContainer">
			<span class="recommTitle">오늘의 추천메뉴</span>
			<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-arrow-counterclockwise" viewBox="0 0 16 16" onclick="setRecomm()">
			  	<path fill-rule="evenodd" d="M8 3a5 5 0 1 1-4.546 2.914.5.5 0 0 0-.908-.417A6 6 0 1 0 8 2v1z"/>
			  	<path d="M8 4.466V.534a.25.25 0 0 0-.41-.192L5.23 2.308a.25.25 0 0 0 0 .384l2.36 1.966A.25.25 0 0 0 8 4.466z"/>
			</svg>
			<div class="recommCard">
		        <div class="item front"><img src="resources/favicon/favicon-96x96.png"></div>
		        <div class="item back">
		        	<div class="itemText">
			        	<p class="foodTitle"></p>
			        	<p class="kcal"></p>
						<p class="carb"></p>
						<p class="protein"></p>
						<p class="fat"></p>
					</div>
		        </div>
		  	</div>
		</div>
	</div>
	
	<p class="cardTitle">오늘의 음식기록</p>
	<div class="cardContainer">
	<%for (int i = 0; i < list.size(); i++) {%>
		<%
			FeedDTO feed = (FeedDTO)list.get(i).get("feed");
			List<FoodDTO> foodList = (List<FoodDTO>)list.get(i).get("food"); 
		%>
		<div class="flip">  
		  <div class="card">
		    <!-- 앞면 -->
		    <div class="front">
		    	<div class="top">
		    		<div class="photo">
		    			<img src="/resources/feed/<%=feed.getPhoto()%>" class="card-img"  alt="...">
			  		</div>
			  	</div>
			  	<div class="date">
			    	<%=feed.getPublishDate()%>
			  	</div>
		    </div>
		    <!-- 뒷면 -->
		    <div class="back">
		    	<div class="backContainer">
			    	<ul>
			    		<%for (int j = 0; j < foodList.size(); j++) {%>
			    			<li><%=foodList.get(j).getFname()%>, <%=foodList.get(j).getKcal()%>kcal</li>
			    		<%} %>
			    	</ul>
		    	</div>
		    </div>
		  </div>
		</div>
	<% }%>
	</div>
</div>
	

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="resources/js/recomm/recomm.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
	<script src="resources/js/recomm/chart.js"></script>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

	<script src="resources/js/recomm/foodData.js" type="module"></script>
</body>
</html>