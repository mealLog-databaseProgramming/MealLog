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
		var tagify = new Tagify(input);
	 	tagify.setReadonly(true);
		console.log(input.value);
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

function group_edit(e, clubId, memberDatas) {
	var myGroup = e.parentNode.parentNode;
	
	myGroup.querySelector(".myGroupView").style.display = "none";
	myGroup.querySelector(".myGroup_edit").style.display = "flex";
	
	const input = document.querySelector(`#memberList_${clubId}`);
	
	const tagify = new Tagify( input, {
			templates : {
				tag : function(tagData){
		            try{
		                return `<tag title='${tagData.name}' spellcheck="false">
			                        <x title='remove tag' class='tagify__tag__removeBtn'></x>
									<div class="profile">
			                            <img src='${tagData.profile}' onerror="this.style.visibility='hidden'">
									</div>
			                        <span class='tagify__tag-text'>${tagData.name}</span>
			                    </tag>`;
		            }
		            catch(err){}
		        },
			},
			 hooks: {
	       		beforeRemoveTag : function( tags ) {
		            return new Promise((resolve, reject) => {
		                confirm(tags[0].data.value + "님을 그룹에서 탈퇴시킵니다.")
		                    ? resolve()
		                    : reject()
		            })
		        },
			},
		}
	);
	tagify.addTags(memberDatas);
	
	console.log(tagify.value);
	
	var profiles = document.querySelectorAll(".myGroup_edit .groupMember tag .profile img");
	profiles.forEach((img) => {
		if(img.width > img.height) img.style.height = "45px";
        else img.style.width = "45px";
	});
}