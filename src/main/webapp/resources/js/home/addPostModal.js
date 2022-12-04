const foodContainer = document.querySelector('.modalFoodContainer');

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

	console.log(food, foodContainer);
	foodContainer.insertAdjacentHTML('afterbegin', food);
}

displayFoodList();
