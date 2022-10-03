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
	<input type="text" placeholder="���ϴ� �׷��� ã�ƺ�����" class="groupSearch">
	<img src="resources/img/searchIcon.png" class="searchImage"alt="searchIcon">
	
	<div id="makeNewGroup" class="newGroup" >���׷� �����</div>
</div>

<div class="groupList_f">
	<div id="groupInfo" class="groupList">
			<div class="groupTitle">�۽� 3��</div><p>
			<span class="groupText">�׷� ��ǥ</span><p>
			<div class="">�Ĵ� �ʺ��� 3�� ������</div><p>
			<div class="groupHashtag">#�Ĵ� #�ܱ� #���̾�Ʈ</div>
			
			<span class="Line"></span>
	
			<span class="groupNum">�ο�</span>
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

<!-- �׷� �󼼺��� �˾�â -->
<div id="simpleModal" class="modal" >
		<div class="modal-content">
			<div class="modal-header">
				<span class="closeBtn">&times;</span>
			</div>
			<p>
				<div class="modal-body">
					<div class="groupTitle">�۽� 3��</div>
					<span class="groupText">�׷� ��ǥ</span>
					<div class="">�Ĵ� �ʺ��� 3�� ������</div>
					<span class="groupText">�׷� �Ұ�</span>
					<div class="groupInfo" >
					���� �ǰ������� �ƹ��� ȯ���մϴ�<p>
					[�׷� ��Ģ]<p>
					1. �Ϸ� ���� ì�ܸԱ�<p>
					2. �Ĵ��� ������ �Բ� �ۼ�<p>
					3. �ٸ� ��� �Ĵܿ� �������� �ǵ��!<p>
					</div>
					<div class="groupHashtag">#�Ĵ� #�ܱ� #���̾�Ʈ</div>
					
					<span class="Line"></span>
				
						<span class="groupNum">�ο�</span>
						<img src="resources/img/groupIcon.png" class="groupImage"alt="GroupIcon">
						<div class="groupCount">3/10</div>
					
						<span class="groupLeader">�׷���</span>
						<img src="resources/img/testpicture.png" class="profilePicture"alt="GroupIcon"/>
						<div class="userName">tting</div> 
				</div>	
			<div class="modal-footer">
				<hr>
				<input type="button" id="joinGroup" class="button" value="�����ϱ�"></input>
			</div>
		</div>
</div>

<!-- �� �׷� ����� �˾�â -->
<form name="newGroup" action="" method="get" onsubmit="return false">
<div id="simpleModal2" class="modal" >
		<div class="modal-content">
			<div class="modal-header">
				<span class="closeBtn2">&times;</span>
			</div>

			<div class="modal-body">
				<div><input type="text" name="groupName" class="groupTitle"  
					style="width:280px;height:50px;" placeholder="�׷���� �Է��ϼ���" required></div>
					
				<span class="groupText">�׷� ��ǥ</span>
				<div><input type="text" name="groupGoalInfo" class="newGroup_Inputbox1" 
					style="width:280px;height:20px;" placeholder="����) �а��� ���� 30�� ç����" required></div>
						
				<span class="groupText" >�׷� �Ұ�</span>
				<div><textarea name="groupInfo" cols="38" rows="8" class="newGroup_Inputbox2" 
					  placeholder="�׷��� �Ұ��� ������
						 
����) ���� �ǰ������� �ƹ��� ȯ���մϴ�
[�׷� ��Ģ]
1. �Ϸ� ���� ì�ܸԱ�
2. �Ĵ��� ������ �Բ� �ۼ�
3. �ٸ� ��� �Ĵܿ� �������� �ǵ��!"
						 required></textarea></div>
						
				<input type="text" name="hashtag" id="hashtag" onchange="inputValueChange()" 
						style="width:280px;height:20px;" placeholder="�ؽ��±׸� �Է��� ������" class="newGroup_Inputbox1">
				<div class="groupHashtag" id="groupHashtag" ></div>
					
				<span class="Line"></span>
				
				<span class="groupNum">�ο�</span>
				<img src="resources/img/groupIcon.png" class="groupImage"alt="GroupIcon">
				<div class="groupCount">
					<select name="groupMemberNum">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select></div>
					
				<span class="groupLeader">�׷���</span>
				<img src="resources/img/testpicture.png" class="profilePicture"alt="GroupIcon"/>
				<div class="userName">tting</div>
					 
			</div>	
			<div class="modal-footer">
				<hr>
				<input type="submit" id="createGroup" class="button" value="���׷� �����" onClick="newGroupCreated()"/>
			</div>
		</div>
	</div>
</form>
<script defer src="groupEvents.js"></script>
</body>
</html>