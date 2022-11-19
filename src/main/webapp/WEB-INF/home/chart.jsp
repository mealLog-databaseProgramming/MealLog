<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" href="resources/css/home/chart.css"/>
</head>
<body>
	<div class="stats_graph_box">                               
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
  <!-- 위치시킬 값에 따라 left 값 조정 -->
  <!-- <dl class="fixed_data" style="left:75%;">
    <div class="item">
      <dt>data data</dt>
      <dd><em>21</em>개</dd>
    </div>
    <div class="item">
      <dt>data data data</dt>
      <dd><em>190</em>개</dd>
    </div>
  </dl> -->
</div>
</body>
</html>