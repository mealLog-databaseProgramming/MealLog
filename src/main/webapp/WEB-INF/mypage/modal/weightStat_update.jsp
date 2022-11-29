<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <%@ page import="java.util.*" %> --%>

<%-- <% 
	ArrayList<String> dateList = new ArrayList<>();
	ArrayList<Float> weightList = new ArrayList<>();
	
	for(int i = 0; i < 10; i++) {
		dateList.add("2022년 11월 28일");
		weightList.add(60.0f);
	}
	
	request.setAttribute("date_list", dateList);
	request.setAttribute("weight_list", weightList);
%>--%>

<script defer type="text/javascript" src="/resources/js/mypage/modal/weightStat_update.js"></script>
<link rel="stylesheet" href="/resources/css/mypage/modal/weightStat_update.css"/>

<div id="modal" class="modal-overlay">
	<div class="modal_window">
		<iconify-icon class="cancel" icon="emojione-v1:heavy-multiplication-x"></iconify-icon>
		<div class="title">
			<iconify-icon icon="healthicons:weight"></iconify-icon>
			<h2>몸무게 기록 수정</h2>
		</div>
		<div class="stat_list">
			<c:forEach begin="1" end="8" varStatus="loop">
				<div class="record">
					<div class="date">2022년 11월 28일</div>
					<div class="weight">60kg</div>
					<iconify-icon icon="ph:x-circle-bold"></iconify-icon>
				</div>
			</c:forEach>
		</div>
		<form id="weightStat_update" action="" method="post">
			<input type="date" name="date"></input>
			<input type="number" name="weight"></input>
			<h3>kg</h3>
			<input type="hidden" name="type" value="add"></input>
			<input type="submit" value="추가"></input>
		</form>
	</div>
</div>