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
	String replyList = request.getParameter("replyList");
%>
<div class="modal fade" id="commentModal" tabindex="-1">
		  <div class="modal-dialog modal-dialog-scrollable">
		    <div class="modal-content">
		      <div class="modal-header">
		      	<h5 class="modal-title">모든 댓글 보기</h5>
		      	<%=replyList %>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">

				<div class="commentContainer">
					<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="rgba(0,0,0,.75)" class="bi bi-person-circle" viewBox="0 0 16 16">
						<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
						<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
					</svg>
					<div class="commentText">
						<span class="commentWriter">류승연</span>
						<span class="commentTime">12초전</span>
						<div class="comment">나도 먹고싶다</div>
					</div>
				</div>
				
		      </div>
		      <div class="modal-footer">
		      </div>
		    </div>
		  </div>
		</div>
</body>
</html>