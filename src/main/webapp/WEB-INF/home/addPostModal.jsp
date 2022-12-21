<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="model.dto.FeedDTO"%>
<%@page import="model.dto.FoodDTO"%>
<%@page import="model.dto.ReplyDTO"%>
<%@page import="java.util.ArrayList"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="modal fade" id="addPostModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<form id="feed_create"  action="/newfeed" method="post" onsubmit="return formSubmit();" class="feed" enctype="multipart/form-data">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
				      <div class="modal-body">
				      	<div class="modal-wrap">
					      	<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="rgba(0,0,0,.75)" class="bi bi-person-circle" viewBox="0 0 16 16">
							  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
							  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
							</svg>
							<div class="modal-content-wrap">
								<div class="modalFoodContainer">
								</div>
								<div id = "test_cnt" class="textLengthWrap">(0 / 100)
								</div>
								<!-- div class="modalMessage">오늘의 식사를 기록하세요.</div-->
								<!-- content --> 
								<textarea placeholder="오늘의 식사를 기록하세요." maxlength="100" name="content" class="form-control" id="exampleFormControlTextarea1" rows="5" required></textarea>
								<script>
								$(document).ready(function() {
									$('#exampleFormControlTextarea1').on('keyup', function() {
										$('#test_cnt').html("("+$(this).val().length+" / 100)");
															 
										if($(this).val().length > 100) {
											$(this).val($(this).val().substring(0, 100));
											$('#test_cnt').html("(100 / 100)");
										}
									});
								});
								</script>
								<div class="fileContainer">
									<label for="file" class="btn-upload">
										<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="rgba(0,0,0,.75)" class="bi bi-image" viewBox="0 0 16 16">
									<path d="M6.002 5.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
									<path d="M2.002 1a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2h-12zm12 1a1 1 0 0 1 1 1v6.5l-3.777-1.947a.5.5 0 0 0-.577.093l-3.71 3.71-2.66-1.772a.5.5 0 0 0-.63.062L1.002 12V3a1 1 0 0 1 1-1h12z"/>
										</svg>
										사진 추가
									</label>
									<!-- file -->
									<input type="file" accept=".jpg, .png, .jpeg" name="file" id="file">
									<input type="text" id="fileName"  name="fileName" readonly>
									
									<!-- hidden data -->
									<div class="foodInfo">
										<!-- <input type="hidden" name="food" value="김치찌개/80/10/10/10"> -->
										<input type="hidden" name="food[]" id="foodList" value="">
									</div>
									<input type="hidden" name="userId">
									
									<div class="addFoodBtn">
										<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="rgba(0,0,0,.75)" class="bi bi-plus-circle" viewBox="0 0 16 16" data-bs-toggle="modal" data-bs-target="#addFoodModal">
											<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
											<path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
										</svg>
									<span data-bs-toggle="modal" data-bs-target="#addFoodModal">음식 추가</span>
									</div>
								</div>
							</div>
						</div>
				      </div>
				      <div class="modal-footer">
				        <input type="submit" class="btn btn-primary" value="등록" onclick="setFoods()">
				      </div>
				    </div>
			    </form>
			</div>
		</div>
	 
<!-- <div class="modal fade" id="addPostModal" tabindex="-1" aria-labelledby="addPostModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <form id="feed_create" action="/newfeed" class="feed" method="post" enctype="multipart/form-data">
      	<input type="file" name="file">
      	<textarea name="content" id="exampleFormControlTextarea1" rows="5" required></textarea>
      	<input type="submit" value="등록">
      </form>
    </div>
  </div>
</div>	 -->
	<script type="text/javascript" src="resources/js/home/addPostModal.js"></script>	
</body>
</html>