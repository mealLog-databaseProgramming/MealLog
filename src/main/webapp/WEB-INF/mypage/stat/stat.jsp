<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-adapter-date-fns/dist/chartjs-adapter-date-fns.bundle.min.js"></script>

<link rel="stylesheet" href="/resources/css/mypage/stat.css"/>

<div class="stat">
	<div class="s_box">
		<div class="s_header">
			섭취 영양소 비율
		</div>
		<jsp:include page="nutri_chart.jsp"/>
	</div>
	<div class="s_box">
		<div class="s_header">
			체중 변화
			<div class="edit"><iconify-icon icon="ri:edit-2-fill"></iconify-icon> 기록하기</div>
		</div>
		<jsp:include page="weight_chart.jsp"/>
	</div>
</div>