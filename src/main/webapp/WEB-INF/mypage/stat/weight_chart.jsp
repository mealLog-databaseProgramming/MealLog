<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	.weight-chart-div { 
		display: flex;
		justify-content: center; 
 		margin-top: 50px; margin-bottom: 50px;
 		padding: 20px 50px;
 	}
</style>

<div class="weight-chart-div">
	 <canvas id="weight-chart" width="500px" height="350px"></canvas>
</div>

<script> 
	const statData = <%= request.getAttribute("statData") %>;
	const height = <%= request.getAttribute("height") %>;
</script>
<script defer type="text/javascript" src="/resources/js/mypage/chart/weight_chart.js"></script> 
