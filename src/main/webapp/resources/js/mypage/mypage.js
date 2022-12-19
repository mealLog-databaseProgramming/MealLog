
var body = document.querySelector('body');
body.setAttribute('onLoad', 'init_mypage()');

function init_mypage() {
	init();
	profile_edit();
	weightStat_update_modal();
	
	const profileImg = document.querySelector(".mypage .profile .img .profileImg");
    if(profileImg.width > profileImg.height) profileImg.style.height = "200px";
    else profileImg.style.width = "200px";

	const previewImage = document.querySelector(".preview");
    if(previewImage.width > previewImage.height) previewImage.style.height = "200px";
    else previewImage.style.width = "200px";
}

function profile_edit() {
	var profile = document.querySelector('.mypage #profile');
	var profile_edit = document.querySelector('#profile_edit');
	var weight_update = document.querySelector('.stat .edit');
	console.log(profile);
	profile.style.display = "flex";
	profile_edit.style.display = "none";
	weight_update.style.display = "block";
	
	var profile_editButton = document.querySelector('#profile .edit');
	profile_editButton.onclick = () => {
		profile.style.display = "none";
		
		profile_edit.style.display = "flex";
		weight_update.style.display = "none";
	};
	
	var profile_cancelButton = document.querySelector('#profile_edit .cancel');
	profile_cancelButton.onclick = () => {
		var answer = confirm("여기서 취소하면 수정 사항은 적용되지 않습니다. 취소하시겠습니까?");
		if(answer) location.href = "/mypage";
	};
}