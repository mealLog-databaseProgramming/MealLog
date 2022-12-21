<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<div class="modal fade" id="addFoodModal" tabindex="-1">
		  <div class="modal-dialog modal-xl">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">음식 선택하기</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <input type="text" id="searchKeyword">
		        <input type="button" value="제출" onclick="setPlaceholder()">
		        <table class="table table-hover">
				  <thead class="table-light">
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">식품명</th>
				      <th scope="col">kcal</th>
				      <th scope="col">탄수화물</th>
				      <th scope="col">단백질</th>
				      <th scope="col">지방</th>
				      <th scope="col">선택하기</th>
				    </tr>
				  </thead>
				  <tbody id="rowContainer">
				  		
				    <!-- <tr>
				      <th scope="row">1</th>
				      <td>Mark</td>
				      <td>Otto</td>
				      <td>@mdo</td>
				    </tr>
				    <tr>
				      <th scope="row">2</th>
				      <td>Jacob</td>
				      <td>Thornton</td>
				      <td>@fat</td>
				    </tr>
				    <tr>
				      <th scope="row">3</th>
				      <td colspan="2">Larry the Bird</td>
				      <td>@twitter</td>
				    </tr> -->
				  </tbody>
				</table>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" data-bs-target="#addPostModal" data-bs-toggle="modal">이전으로</button>
		      </div>
		    </div>
		  </div>
		</div>
	<script type="text/javascript" src="resources/js/home/addFoodModal.js"></script>
</body>
</html>