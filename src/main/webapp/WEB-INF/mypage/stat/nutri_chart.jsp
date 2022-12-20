<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
	.nutri-chart-div {
		display: flex;
		justify-content: center;
		margin-top: 50px; margin-bottom: 50px;
	}
	.nutri-legend-div {
		margin: 20px;
	}
    .nutri-legend-div ul li {
        margin: 10px 0;
        color: #666;
        font-size: 18px;
        list-style:none;
    }
    .nutri-legend-div ul li span {
        display: inline-block;
        width: 20px;
        height: 20px;
        border-radius: 50%;
        margin-right: 5px;
        vertical-align: middle;
    }
</style>

<div class="nutri-chart-div">
	 <canvas id="nutri-chart" width="350px" height="350px"></canvas>
	 <div id='nutri-legend-div' class="nutri-legend-div"></div>
</div>
<script> 
	const nutriData = <%= request.getAttribute("nutriData") %>;
	
	if(nutriData[0] === 0) {
		nutriData[0] = 50;
		nutriData[1] = 30;
		nutriData[2] = 20;
		document.querySelector('.nutri-chart-div').style.opacity = '0.5';
	}
</script>
<script defer type="text/javascript" src="/resources/js/mypage/chart/nutri_chart.js"></script> 