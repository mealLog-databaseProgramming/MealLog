var modal = document.getElementById('simpleModal');
 var modal2 = document.getElementById('simpleModal2');
  
 var groupInfo = document.getElementById('groupInfo');
 var newGroup = document.getElementById('makeNewGroup');
 
 var closeBtn = document.getElementsByClassName('closeBtn')[0];
  var closeBtn2 = document.getElementsByClassName('closeBtn2')[0];
  
 var joinGroup = document.getElementById('joinGroup');
  
 var createGroup = document.getElementById('createGroup');
  
 groupInfo.addEventListener('click', openModal);
 newGroup.addEventListener('click', openModal2);
 //클로즈 버튼
 closeBtn.addEventListener('click', closeModal);
 closeBtn2.addEventListener('click', closeModal2);
//창 바깥 클릭시 창 닫힘
 window.addEventListener('click', clickOutside);
//그룹 가입 버튼 누르면
 joinGroup.addEventListener('click', joinedGroup);
 //전송시 팝업 삭제 
createGroup.addEventListener("submit", newGroupCreated);
 
 function openModal(){ modal.style.display = 'block'; } 
 function openModal2(){ modal2.style.display = 'block'; } 

 function closeModal(){ modal.style.display = 'none'; }
 function closeModal2(){ modal2.style.display = 'none'; }


 function clickOutside(e){
	if(e.target == modal || e.target == modal2){
		modal.style.display = 'none';
		modal2.style.display = 'none';
	}
}

function joinedGroup(){ joinGroup.value="이미 가입된 그룹입니다"; }
//새그룹 생성시 팝업창 닫기
function newGroupCreated(){
	if(document.newGroup.groupName.value!="" && document.newGroup.groupGoalInfo.value!="" && document.newGroup.groupInfo.value!="" ){
		console.log("새그룹이 생성되었습니다");
		modal2.style.display = 'none';
	}
}
//해시태그 함수
function inputValueChange(){
	var hashtagList = '';
	var groupHashtag = document.getElementById("groupHashtag");
		 hashtagList += groupHashtag.innerHTML + ' ';
    var hashtag = document.getElementById('hashtag').value;
 		
 		groupHashtag.innerHTML = hashtagList + "#" + hashtag;
		document.getElementById('hashtag').value = null;
    }
