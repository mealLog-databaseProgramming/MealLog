<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/resources/css/mypage/profile.css"/>

<style>
	#profile_edit input[type="file"] {
		position: absolute;
	    width: 0;
	    height: 0;
	    padding: 0;
	    overflow: hidden;
	    border: 0;
	}
	#profile_edit .img {
		display: flex;
	    align-items: center;
	    justify-content: center;
	    overflow: hidden;
	    
	    transform: translate(0, 25px);
	}
	#profile_edit .preview {
		position: absolute;
	}
	#profile_edit .img label {
		position: absolute;
		font-size: 60px;
		color: white;
	}
	
	#profile_edit input[type="text"], #profile_edit textarea {
		background: rgba(0, 0, 0, .05);
		border-radius: 10px;
		border: none;
		box-shadow: inset 1px 1px 5px rgba(0, 0, 0, 0.25);
		
		
		margin: 10px;
	}
	
	#profile_edit input[type="submit"] {
		width: 100px; height: 30px;
		background: #81B44F;
		box-shadow: 0px 4px 3px rgba(0, 0, 0, 0.25);
		border-radius: 10px;
/* 		margin: 10px; */
		
		border: none;
		
		font-size: 14px;
		font-weight: 400;
		line-height: 30px;
		color: white;
	}
	#profile_edit input[type="submit"]:active {
		transform: translate(0, 5px);
		box-shadow: none;
	}
	
	#profile_edit input[type="text"] {
		width: 200px; height: 34px;
		font-size: 24px;
		font-weight: 400;
		
		padding: 10px;
		margin-right: 150px;
	}
	#profile_edit textarea {
		width: 480px; height: 80px;
		padding: 10px;
		font-size: 18px;
	}
</style>



<form id="profile_edit" class="profile" method="post">
	<div class="img">
		<img class="preview"/>
		<label for="file"><iconify-icon icon="mdi:image-edit-outline"></iconify-icon></label>
		<input type="file" id="file" accept="image/*"></input>
	</div>
	<div class="info">
		<input type="text" class="name" placeholder="이름을 입력하세요"></input>
		<input type="submit" class="edit" value="✏ 수정완료"></input>
<!-- 		<input type="button" class=""></input> -->
		<textarea placeholder="본인을 소개해주세요"></textarea>
		<div class="tag">🥗 식단 기록 | 53</div>
		<div class="tag">👍 긍정 반응 | 3</div>
	</div>
</form>

<script defer>
	function readImage(input) {
		console.log(input);
		if(input.files && input.files[0]) {
			const reader = new FileReader();
			
			console.log(input.files[0]);
			
			reader.onload = (e) => {
				console.log("load!!");
	            const previewImage = document.querySelector(".preview");
	            previewImage.src = e.target.result;
	            
	            if(previewImage.width > previewImage.height) previewImage.style.height = "200px";
	            else previewImage.style.width = "200px";
	        }
			reader.readAsDataURL(input.files[0]);
		}
	}
	
	var fileInput = document.querySelector('#file');
	fileInput.onchange = (e) => {
		readImage(e.target);
	}
	
	
</script>