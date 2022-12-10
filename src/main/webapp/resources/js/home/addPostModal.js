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

	//console.log(food, foodContainer);
	foodContainer.insertAdjacentHTML('afterbegin', food);
	
	//request.setParameter("test", "adfs");
}

function setFoods() {
	var list = new Array();
	$("input[name=food]").each(function(index, item) {
		list.push($(item).val());
	});
	$("#foodList").val(list);
	const foodList = document.querySelector('#foodList');
	console.log(foodList);
}

$('#exampleFormControlTextarea1').keyup(function (e) {
	let content = $(this).val();
    
    // 글자수 세기
    if (content.length == 0 || content == '') {
    	$('.textCount').text('0자');
    } else {
    	$('.textCount').text(content.length + '자');
    }
    
    // 글자수 제한
    if (content.length > 100) {
    	// 100자 부터는 타이핑 되지 않도록
        $(this).val($(this).val().substring(0, 100));
        // 100자 넘으면 알림창 뜨도록
        alert('100자까지 입력 가능합니다.');
    };
});

displayFoodList();

//localStorage파싱해서 어떻게 넘기기?
