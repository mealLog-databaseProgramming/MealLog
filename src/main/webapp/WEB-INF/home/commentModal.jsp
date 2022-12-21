<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="model.dto.ReplyDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
//feedId가 필요함.
	//long feedId = Long.parseLong(request.getParameter("feedId"));
	//String replyList = request.getParameter("replyList");
%>
<div class="modal fade" id="commentModal" tabindex="-1">
		  <div class="modal-dialog modal-dialog-scrollable">
		    <div class="modal-content">
		      <div class="modal-header">
		      	<h5 class="modal-title">모든 댓글 보기</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body commentModalBody">
		      	<!-- insertReplies -->
		      </div>
		      <div class="modal-footer">
		      </div>
		    </div>
		  </div>
		</div>
	<script type="text/javascript" src="resources/js/home/home.js"></script>
</body>
</html>