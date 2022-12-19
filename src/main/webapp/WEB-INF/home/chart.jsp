<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.Math"%>
<%@page import="model.dao.FeedDAO"%>
<%@page import="model.dto.FeedDTO"%>
<%@page import="model.dto.FoodDTO"%>
<%@page import="model.dto.ReplyDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" href="resources/css/home/chart.css"/>
</head>
<body>
<%
    float kcalSum = Float.parseFloat(request.getParameter("kcalSum"));
	float carbSum = Float.parseFloat(request.getParameter("carbSum"));
	float proteinSum = Float.parseFloat(request.getParameter("proteinSum"));
	float fatSum = Float.parseFloat(request.getParameter("fatSum"));
%>
	<div class="stats_graph_box">   
	<%
		int kcal = Math.round(kcalSum);
		int carb = Math.round(carbSum) * 4;
		int protein = Math.round(proteinSum) * 4;
		int fat = Math.round(fatSum) * 9;
		
		int total = kcal + carb + protein + fat;
		
		double kcalPer = 0.0;
		double carbPer = 0.0;
		double proteinPer = 0.0;
		double fatPer = 0.0;
		if (total != 0) {
			kcalPer = Math.round(kcal / (float)total * 100);
			carbPer = Math.round(carb / (float)total * 100);
			proteinPer = Math.round(protein / (float)total * 100);
			fatPer = Math.round(fat / (float)total * 100);
		}
	%>     
    <%=kcalPer %>
    <%=carbPer %>  
    <%=proteinPer %>  
    <%=fatPer %> 
    <%=total %>                  
	<div class="graph">
	  <!-- 비율에 따라 width 값 조정 -->
	  <div class="bar carb" style="width:<%=carbPer %>%;">
	    <dl class="desc">
	      <dt>탄수화물</dt>
	    </dl>
	  </div>
	  <div class="bar protein" style="width:<%=proteinPer %>%">
	    <dl class="desc">
	      <dt>단백질</dt>
	    </dl>
	  </div>
	  <div class="bar fat" style="width:<%=fatPer %>%">
	    <dl class="desc">
	      <dt>지방</dt>
	    </dl>
	  </div>
	  <div class="bar kcal" style="width:<%=kcalPer %>%">
	    <dl class="desc">
	      <dt>kcal</dt>
	    </dl>
	  </div>
  </div>
</div>
</body>
</html>