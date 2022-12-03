const $thumbs_up = document.querySelector('.bi-hand-thumbs-up');
const $thumbs_up_fill = document.querySelector('.bi-hand-thumbs-up-fill');
const $thumbs_down = document.querySelector('.bi-hand-thumbs-down');
const $thumbs_down_fill = document.querySelector('.bi-hand-thumbs-down-fill');

const $modal_body = document.querySelector('.modal-body');
const $modal_body_childs = $modal_body.childNodes;
const $modal_foodContainer = $modal_body_childs[5];

function reactUp(){
	$thumbs_up.style.display = "none";
	$thumbs_up_fill.style.display = "inline";
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

function deleteFood(){
	console.log(event.target.parentNode)
	event.target.parentNode.remove();
	//event target이 svg, path 2가지 나올 수 있
}

/*function showAllComment(event) {
	var feedId = event.target.id
	console.log(feedId);
}*/

