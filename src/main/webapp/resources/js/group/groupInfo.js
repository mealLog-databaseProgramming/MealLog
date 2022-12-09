function groupInfo_init() {
	var popup = document.querySelector('#groupInfo');
	
	var cancel = document.querySelector('#groupInfo #cancel');
	cancel.onclick = () => {
		var tagInput = document.querySelector('#groupInfo #hashtag');
		
		popup.style.display = "none";
		body.style.overflowY = "auto";
		
		var tagify = new Tagify(tagInput);
		tagify.setReadonly(false);
		tagify.removeAllTags();
		
		var form = document.querySelector('#groupInfo form');
		var submit = document.querySelector('#groupInfo input[type="submit"]');
		submit.onclick = () => form.submit();
	};
}

function groupInfo_set(e) {	
	var clubIdInput = document.querySelector('#groupInfo input[name="clubId"]');
	clubIdInput.setAttribute('value', e.querySelector("#clubId").value);
	
	var cNameInput = document.querySelector('#groupInfo .name span');
	cNameInput.innerText = e.querySelector("#cName").innerText;
	
	var goalInput = document.querySelector('#groupInfo .goal span');
	goalInput.innerText = e.querySelector("#goal").innerText;
	
	var infoInput = document.querySelector('#groupInfo .introduce span');
	infoInput.innerText =  e.querySelector("#info").value;
	
	var max_memberInput = document.querySelector(`#groupInfo .member span`);
	max_memberInput.innerText = e.querySelector("#member").innerText;
	
	var tagInput = document.querySelector('#groupInfo #hashtag');
	tagInput.value = e.querySelector("#hashtag").value;
	
	var tagify = new Tagify(tagInput);
	tagify.setReadonly(true);
	
	var popup = document.querySelector('#groupInfo');
	popup.style.display = "block";
	document.documentElement.scrollTop = 0; // 임시
	
	body.style.overflowY = "hidden";	
}