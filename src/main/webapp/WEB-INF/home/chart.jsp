<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
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
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" href="resources/css/home/chart.css"/>
</head>
<body>
<%
    String kcalSum = request.getParameter("kcalSum");
	String carbSum = request.getParameter("carbSum");
	String proteinSum = request.getParameter("proteinSum");
	String fatSum = request.getParameter("fatSum");
%>
	<div class="stats_graph_box">   
	<%=kcalSum %>     
	<%=carbSum %> 
	<%=proteinSum %> 
	<%=fatSum %>                        
	<div class="graph">
	  <!-- 비율에 따라 width 값 조정 -->
	  <div class="bar carb" style="width:30%;">
	    <dl class="desc">
	      <dt>탄수화물</dt>
	    </dl>
	  </div>
	  <div class="bar protein" style="width:40%">
	    <dl class="desc">
	      <dt>단백질</dt>
	    </dl>
	  </div>
	  <div class="bar fat" style="width:10%">
	    <dl class="desc">
	      <dt>지방</dt>
	    </dl>
	  </div>
	  <div class="bar kcal" style="width:20%">
	    <dl class="desc">
	      <dt>kcal</dt>
	    </dl>
	  </div>
  </div>
</div>
</body>
</html>