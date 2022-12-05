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

function groupInfo_set(clubId, cName, goal, info, current_mamber, max_member, tags) {
	var popup = document.querySelector('#groupInfo');
	popup.style.display = "block";
	document.documentElement.scrollTop = 0; // 임시
	
	body.style.overflowY = "hidden";
	
	var clubIdInput = document.querySelector('#groupInfo input[name="clubId"]');
	clubIdInput.setAttribute('value',clubId);
	
	var cNameInput = document.querySelector('#groupInfo .name span');
	cNameInput.innerText = cName;
	
	var goalInput = document.querySelector('#groupInfo .goal span');
	goalInput.innerText = goal;
	
	var infoInput = document.querySelector('#groupInfo .introduce span');
	infoInput.innerText = info;
	
	var max_memberInput = document.querySelector(`#groupInfo .member span`);
	max_memberInput.innerText = `${current_mamber} / ${max_member}`;
	
	var tagInput = document.querySelector('#groupInfo #hashtag');

	var tagify = new Tagify(tagInput);
	tagify.addTags(tags);
	tagify.setReadonly(true);
}