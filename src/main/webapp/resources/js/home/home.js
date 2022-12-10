const thumbs_up = document.querySelectorAll('.bi-hand-thumbs-up');
const thumbs_up_fill = document.querySelectorAll('.bi-hand-thumbs-up-fill');
const thumbs_down = document.querySelectorAll('.bi-hand-thumbs-down');
const thumbs_down_fill = document.querySelectorAll('.bi-hand-thumbs-down-fill');

const $modal_body = document.querySelector('.modal-body');
const $modal_body_childs = $modal_body.childNodes;
const $modal_foodContainer = $modal_body_childs[5];

//좋아요 버튼
for(let i = 0; i< thumbs_up.length; i++) {
	thumbs_up[i].addEventListener('click', function(e){
		thumbs_up[i].style.display="none";
		thumbs_up_fill[i].style.display="inline";
	});
}

//싫어요 버튼 
for(let i = 0; i< thumbs_down.length; i++) {
	thumbs_down[i].addEventListener('click', function(e){
		thumbs_down[i].style.display="none";
		thumbs_down_fill[i].style.display="inline";
	});
}

//좋아요 버튼 취소
for(let i = 0; i< thumbs_up_fill.length; i++) {
	thumbs_up_fill[i].addEventListener('click', function(e){
		thumbs_up_fill[i].style.display="none";
		thumbs_up[i].style.display="inline";
	});
}

//싫어요 버튼 취소
for(let i = 0; i< thumbs_down_fill.length; i++) {
	thumbs_down_fill[i].addEventListener('click', function(e){
		thumbs_down_fill[i].style.display="none";
		thumbs_down[i].style.display="inline";
	});
}

function reactDown(){
	$thumbs_down.style.display = "none";
	$thumbs_down_fill.style.display = "inline";
}

//댓글 업로드 함수 테스트
function commentUpload(){
	alert('upload comment');
}

function addFood() {
	var inputFood = prompt("임시, 음식 이름 입력");
	const foodElement = `<div class="food" onclick="deleteFood()">${inputFood}</div>`
	$modal_foodContainer.insertAdjacentHTML('beforeend', foodElement);
	
}

$(document).ready(function() {
	$('#exampleFormControlTextarea1').on('keyup', function() {
		$('#test_cnt').html("("+$(this).val().length+" / 100)");
							 
		if($(this).val().length > 100) {
			$(this).val($(this).val().substring(0, 100));
			$('#test_cnt').html("(100 / 100)");
		}
	});
});

