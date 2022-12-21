<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="flip">
	<div class="polaroid">
		<div class="front">
			<div class="top">
				<div class="photo">
					<img onerror="this.style.display='none'" src="/resources/feed/${photo}" />
				</div>
			</div>
			<div class="date">${publishDates.get(feedId)}</div>
			<div class="reaction">👍 ${positiveReacts.get(feedId)}&nbsp;&nbsp;👎 ${negativeReacts.get(feedId)}</div>
		</div>
		<div class="back">
			<div class="top">
				<div>
					${publishDates.get(feedId)}
					<ul>
						<c:forEach var="food" items="${foods.get(feedId)}">
							<li>${food.getFname()} ${food.getKcal()}kcal</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			Meal:Log
		</div>
	</div>
</div>