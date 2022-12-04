<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		<form id="weightStat_update" action="/statupdate" method="post">
			<input type="date" name="date"></input>
			<input type="number" name="weight"></input>
			<h3>kg</h3>
			<input type="hidden" name="type" value="add"></input>
			<input type="button" value="추가"></input>
			<input type="submit" value="적용"></input>
			
			<div class="hidden">
				<c:forEach items="${statList}" var="stat">
					<input type="hidden" name="statList" value="${stat.getDate()}/${stat.getWeight()}"></input>
				</c:forEach>
			</div>
		</form>
	</div>
</div>