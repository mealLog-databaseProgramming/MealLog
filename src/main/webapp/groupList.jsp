<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/groupList.css"/>
</head>
<body>
<div class="groupHeader">
	<input type="text" placeholder="원하는 그룹을 찾아보세요" class="groupSearch">
	<img src="resources/img/searchIcon.png" class="searchImage"alt="searchIcon">
	
	<div id="makeNewGroup" class="newGroup" >새그룹 만들기</div>
</div>

<div class="groupList_f">
	<div id="groupInfo" class="groupList">
			<div class="groupTitle">작심 3달</div><p>
			<span class="groupText">그룹 목표</span><p>
			<div class="">식단 초보의 3달 도전기</div><p>
			<div class="groupHashtag">#식단 #단기 #다이어트</div>
			
			<span class="Line"></span>
	
			<span class="groupNum">인원</span>
			<img src="resources/img/groupIcon.png" class="groupImage"alt="GroupIcon">
			<div class="groupCount">3/10</div>
	</div>


		<div class="groupList">
			<span class="Line"></span>
		</div>
	
		<div class="groupList">
			<span class="Line"></span>
		</div>
	
		<div class="groupList">
			<span class="Line"></span>
		</div>
</div>

<!-- 그룹 상세보기 팝업창 -->
<div id="simpleModal" class="modal" >
		<div class="modal-content">
			<div class="modal-header">
				<span class="closeBtn">&times;</span>
			</div>
			<p>
				<div class="modal-body">
					<div class="groupTitle">작심 3달</div>
					<span class="groupText">그룹 목표</span>
					<div class="">식단 초보의 3달 도전기</div>
					<span class="groupText">그룹 소개</span>
					<div class="groupInfo" >
					같이 건강해지실 아무나 환영합니다<p>
					[그룹 규칙]<p>
					1. 하루 세끼 챙겨먹기<p>
					2. 식단은 사진과 함께 작성<p>
					3. 다른 사람 식단에 적극적인 피드백!<p>
					</div>
					<div class="groupHashtag">#식단 #단기 #다이어트</div>
					
					<span class="Line"></span>
				
						<span class="groupNum">인원</span>
						<img src="resources/img/groupIcon.png" class="groupImage"alt="GroupIcon">
						<div class="groupCount">3/10</div>
					
						<span class="groupLeader">그룹장</span>
						<img src="resources/img/testpicture.png" class="profilePicture"alt="GroupIcon"/>
						<div class="userName">tting</div> 
				</div>	
			<div class="modal-footer">
				<hr>
				<input type="button" id="joinGroup" class="button" value="가입하기"></input>
			</div>
		</div>
</div>

<!-- 새 그룹 만들기 팝업창 -->
<form name="newGroup" action="" method="get" onsubmit="return false">
<div id="simpleModal2" class="modal" >
		<div class="modal-content">
			<div class="modal-header">
				<span class="closeBtn2">&times;</span>
			</div>

			<div class="modal-body">
				<div><input type="text" name="groupName" class="groupTitle"  
					style="width:280px;height:50px;" placeholder="그룹명을 입력하세요" required></div>
					
				<span class="groupText">그룹 목표</span>
				<div><input type="text" name="groupGoalInfo" class="newGroup_Inputbox1" 
					style="width:280px;height:20px;" placeholder="예시) 밀가루 끊기 30일 챌린지" required></div>
						
				<span class="groupText" >그룹 소개</span>
				<div><textarea name="groupInfo" cols="38" rows="8" class="newGroup_Inputbox2" 
					  placeholder="그룹을 소개해 보세요
						 
예시) 같이 건강해지실 아무나 환영합니다
[그룹 규칙]
1. 하루 세끼 챙겨먹기
2. 식단은 사진과 함께 작성
3. 다른 사람 식단에 적극적인 피드백!"
						 required></textarea></div>
						
				<input type="text" name="hashtag" id="hashtag" onchange="inputValueChange()" 
						style="width:280px;height:20px;" placeholder="해시태그를 입력해 보세요" class="newGroup_Inputbox1">
				<div class="groupHashtag" id="groupHashtag" ></div>
					
				<span class="Line"></span>
				
				<span class="groupNum">인원</span>
				<img src="resources/img/groupIcon.png" class="groupImage"alt="GroupIcon">
				<div class="groupCount">
					<select name="groupMemberNum">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select></div>
					
				<span class="groupLeader">그룹장</span>
				<img src="resources/img/testpicture.png" class="profilePicture"alt="GroupIcon"/>
				<div class="userName">tting</div>
					 
			</div>	
			<div class="modal-footer">
				<hr>
				<input type="submit" id="createGroup" class="button" value="새그룹 만들기" onClick="newGroupCreated()"/>
			</div>
		</div>
	</div>
</form>
<script defer src="groupEvents.js"></script>
</body>
</html>