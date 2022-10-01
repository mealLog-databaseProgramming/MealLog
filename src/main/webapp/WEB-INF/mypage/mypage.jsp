<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/resources/css/mypage/mypage.css"/>

<div class="wrap">
	<div class="profile">
		<div class="img"></div>
		<div class="info">
			<div class="name">사용자 이름</div>
			<div class="goal"><span>목표 |</span> 체지방률 10% 이하 달성!</div>
			<div class="comment">안녕하세요 저는 사용자 이름이구요.<br>저는 서로 식단 공유하면서 피드백할 분들을 찾고 있습니다.</div>
		</div>
	</div>
	<div class="stat">
		<div class="info">
			<div class="title">최근 인바디 통계</div>
			<div class="edit">인바디 기록하기</div>
			<div class="detail">
				키는 <b>180cm</b>, <span class="select">몸무게</span>는<b>60kg</b><br>
				<span class='nonsel'>골격근량</span>는<b>15kg</b><br>
				<span class='nonsel'>체지방량</span>는<b>15kg</b><br>
				<span class='nonsel'>체지방률</span>는<b>25%</b>입니다.
			</div>
		</div>
		<jsp:include page="chart.jsp"/>
		<div class="notice">
			<div>2022.09.26 am 10:29 기준</div>
			<div>키워드를 클릭하면 통계 그래프를 확인할 수 있습니다.</div>
		</div>
	</div>
	<!--  <div class="polra">
		<c:forEach begin="0" end="40" varStatus="loop">
			<jsp:include page="polaroid.jsp"/>
		</c:forEach>
	</div>-->
</div>