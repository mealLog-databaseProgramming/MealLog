<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Meal:Log</title>
		<jsp:include page="setting.jsp"/>
		<link rel="stylesheet" href="/resources/css/main/main.css"/>
		
		<c:if test="${message ne null}">
			<script defer>
				alert("<%=request.getAttribute("message")%>");
			</script>
		</c:if>
	</head>
	<body>
		<div class="Content">
			<c:if test="${page ne null}">
				<jsp:include page="main/${page}" />
			</c:if>
		</div>
	</body>
</html>

