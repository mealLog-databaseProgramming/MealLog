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