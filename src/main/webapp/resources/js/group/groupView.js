var body = document.querySelector('body');

function groupUpdate_set(clubId, cName, goal, info, max_member, tags) {
	var popup = document.querySelector('#groupUpdate');
	popup.style.display = "block";
	document.documentElement.scrollTop = 0; // 임시
	
	body.style.overflowY = "hidden";
	
	var clubIdInput = document.querySelector('#groupUpdate input[name="clubId"]');
	clubIdInput.setAttribute('value',clubId);
	
	var cNameInput = document.querySelector('#groupUpdate .nameInput input');
	cNameInput.setAttribute('value', cName);
	
	var goalInput = document.querySelector('#groupUpdate .goalInput input');
	goalInput.setAttribute('value', goal);
	
	var infoInput = document.querySelector('#groupUpdate .infoInput textarea');
	infoInput.innerText = info;
	
	var max_memberInput = document.querySelector(`#groupUpdate .memberInput option[value="${max_member}"]`);
	max_memberInput.setAttribute('selected', true);
	
	var tagInput = document.querySelector('#groupUpdate #hashtag');

	var tagify = new Tagify(tagInput);

	tagify.on('add', function() {
	  console.log(tagify.value); 
	});	
	tagify.addTags(tags);
}