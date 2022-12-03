<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Date" %>
<%@ page import="model.dto.StatDTO" %>

<% 
	ArrayList<StatDTO> statList = new ArrayList<>();
	
	for(int i = 0; i < 10; i++) {
		StatDTO stat = new StatDTO();
		stat.setDate(java.sql.Date.valueOf("2022-12-03"));
		stat.setWeight(60f);
		
		statList.add(stat);
	}
	
	request.setAttribute("statList", statList);
%>

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
			<c:forEach items="${statList}" var="stat">
				<div class="record">
					<div class="date">${stat.getDate()}</div>
					<div class="weight">${stat.getWeight()}kg</div>
					<iconify-icon icon="ph:x-circle-bold"></iconify-icon>
				</div>
			</c:forEach>
		</div>
		<form id="weightStat_update" action="/mypage" method="post">
			<input type="date" name="date"></input>
			<input type="number" name="weight"></input>
			<h3>kg</h3>
			<input type="hidden" name="type" value="add"></input>
			<input type="button" value="추가"></input>
			<input type="submit" value="적용"></input>
			
			<div class="hidden">
			</div>
		</form>
	</div>
</div>