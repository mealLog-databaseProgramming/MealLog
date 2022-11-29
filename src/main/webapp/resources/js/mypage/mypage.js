
var body = document.querySelector('body');
body.setAttribute('onLoad', 'init_mypage()');

function init_mypage() {
	init();
	
	var weight_update = document.querySelector('.stat .edit');
	
	var modal = document.querySelector('#modal');
	weight_update.onclick = () => {
		modal.style.display = "block";
		body.style.overflowY = "hidden";
	}
	
	var cancel = document.querySelector('#modal .cancel');
	cancel.onclick = () => {
		modal.style.display = "none";
		body.style.overflowY = "auto";
	}
	
	var records = document.querySelectorAll('#modal .record');
	
	records.forEach((item) => {
		item.onmouseover = (e) => {
			if(e.target.className === "record") {
				var deleteIcon = e.target.querySelector('iconify-icon');
				deleteIcon.style.opacity = "1";
			}
			
		};
		item.onmouseleave = (e) => {
			if(e.target.className === "record") {
				var deleteIcon = e.target.querySelector('iconify-icon');
				deleteIcon.style.opacity = "0";
			}
		};
		
		var deleteIcon = item.querySelector('iconify-icon');
		deleteIcon.onclick = (e) => {
			if(e.target.tagName === "ICONIFY-ICON" && e.target.style.opacity === "1") {
				var record = e.target.parentNode;
				record.style.display = "none";
			}
		};
	});
}
