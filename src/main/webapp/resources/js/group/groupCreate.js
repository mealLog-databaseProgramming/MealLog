function groupCreate_init() {
	var popup = document.querySelector('#groupCreate');
	
	var popup_button = document.querySelector('#newGroup_button');
	popup_button.onclick = () => {
		popup.style.display = "block";
		body.style.overflowY = "hidden";
	};
	
	var cancel = document.querySelector('#groupCreate #cancel');
	cancel.onclick = () => {
		popup.style.display = "none";
		body.style.overflowY = "auto";
	};
	
	var form = document.querySelector('#groupCreate form');
	var submit = document.querySelector('#groupCreate input[type="submit"]');
	submit.onclick = () => {
		console.log(form);
		form.submit();
	};
	
		
	var tagInput = document.querySelector('#groupCreate #hashtag');
	
	var tagify = new Tagify(tagInput);
}