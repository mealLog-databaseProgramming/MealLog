var body = document.querySelector('body');

function groupView_init() {
	var hashtags = document.querySelectorAll('#groupView #hashtag');
	hashtags.forEach((input) => {
		var values = input.value.split(', ', 3);
		input.value = values;
		
		var tagify = new Tagify(input);
	 	tagify.setReadonly(true);
	});
	
	hashtags = document.querySelectorAll('#joinedGroupView #hashtag');
	hashtags.forEach((input) => {
//		var values = input.value.split(', ', 3);
//		input.value = values;
		
		var tagify = new Tagify(input);
	 	tagify.setReadonly(true);
	});
	
	hashtags = document.querySelectorAll('.myGroup_edit #hashtag');
	hashtags.forEach((input) => {
		var tagify = new Tagify(input);
	 	tagify.setReadonly(false);
	});
	
	var profiles = document.querySelectorAll("#member img");
	profiles.forEach((img) => {
		if(img.width > img.height) img.style.height = "45px";
        else img.style.width = "45px";
	});
}
//
function moveSrc(e) {
	location.href = `/mypage?uid=${e.querySelector("#userId").value}`;
}

function group_edit(e) {
	var myGroup = e.parentNode.parentNode;
	
	myGroup.querySelector(".myGroupView").style.display = "none";
	myGroup.querySelector(".myGroup_edit").style.display = "flex";
	console.log(myGroup);
}