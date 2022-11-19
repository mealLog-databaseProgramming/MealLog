const $modal_body = document.querySelector('.modal-body');
const $modal_body_childs = $modal_body.childNodes;
const $modal_foodContainer = $modal_body_childs[5];

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