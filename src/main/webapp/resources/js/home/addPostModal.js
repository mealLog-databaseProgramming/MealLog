const foodContainer = document.querySelector('.modalFoodContainer');
const fileName = document.getElementById('fileName');
const foodList = document.querySelector('#foodList');

function deleteFood(){
	console.log(event.target.parentNode)
	event.target.parentNode.remove();
}

function displayFoodList(){
	if (foodName == undefined) {
		return;
	}
	const food = `
	<div class="food">
		${foodName}
		<img src="resources/img/x.svg" onclick="deleteFood()">
	</div>`

	//console.log(food, foodContainer);
	foodContainer.insertAdjacentHTML('afterbegin', food);
	
	//request.setParameter("test", "adfs");
}

function setFoods() {
	var list = new Array();
	$("input[name=selectFood]").each(function(index, item) {
		list.push($(item).val());
	});
	$("#foodList").val(list);
	console.log(foodList);
}

file.onchange = () => {
	let path = event.target.value;
	console.log(path);
	const splitPath = path.split("\\");
	
	fileName.value = splitPath[splitPath.length - 1];
	console.log(splitPath);
};

function formSubmit() {
	var fileName = document.getElementById( 'fileName' ).value;
	var foodList = document.getElementsByClassName('selectFood');
	    
    if (fileName == "") {
    	alert('사진을 추가해주세요.');
    	return false;
    }
    if (foodList.length <= 0) {
		alert('음식을 1개 이상 추가해주세요.');
		return false;
	}
}

displayFoodList();
