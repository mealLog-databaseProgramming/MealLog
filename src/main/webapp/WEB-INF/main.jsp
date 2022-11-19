<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Meal:Log</title>
		<jsp:include page="setting.jsp"/>
		<link rel="stylesheet" href="/resources/css/main.css"/>
	</head>
	<body>
		<div class="Content">
			<c:if test="${page ne null}">
				<jsp:include page="main/${page}" />
			</c:if>
		</div>
	</body>
</html>