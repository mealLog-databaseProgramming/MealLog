/**
 * 식품정보api     	32a502c6245b410b95f6
 */
const API_KEY = "32a502c6245b410b95f6"; 
const $rowContainer = document.getElementById('rowContainer');
const $foodInfo = document.querySelector('.foodInfo');
let foodName;
let rslt = [];

function searchFood() {
	const keyword = document.getElementById("searchKeyword").value;
	//alert(keyword);
	var myHeaders = new Headers();
	myHeaders.append("Cookie", "elevisor_for_j2ee_uid=ds9j5sz59bzmt");
	
	var requestOptions = {
	  method: 'GET',
	  headers: myHeaders,
	  redirect: 'follow'
	};
	
	fetch(`https://openapi.foodsafetykorea.go.kr/api/32a502c6245b410b95f6/I2790/json/1/10/DESC_KOR=${keyword}`, requestOptions)
	  .then(response => response.text())
	  .then(result => displayFood(result))
	  .catch(error => console.log('error', error));
}

function displayFood(foods) {
	object = JSON.parse(foods)
	//console.log(object);
	const foodList = object.I2790.row;
	//console.log(foodList);
	
	const rsltItem = `
		<tr>
			<th scope="row">1</th>
			<td>Mark</td>
			<td>Otto</td>
			<td>@mdo</td>
		</tr>
	`

	for (i = 0; i < foodList.length; i++) {
		console.log(foodList[i])
		const rsltItem = `
			<tr>
				<th scope="row">${i + 1}</th>
				<td>${foodList[i].DESC_KOR}</td>
				<td>
					<input type="button" value="선택" onclick="choiceFood()" data-bs-target="#addPostModal" data-bs-toggle="modal" 
					data-id="${foodList[i].DESC_KOR}/${foodList[i].NUTR_CONT1}/${foodList[i].NUTR_CONT2}/${foodList[i].NUTR_CONT3}/${foodList[i].NUTR_CONT4}">
				</td>
			</tr>
		`
		rslt[i] = rsltItem;
	}
	
	for (i = 0; i < rslt.length; i++) {
		console.log(rslt[i]);
		$rowContainer.insertAdjacentHTML('beforeend', rslt[i]);
	}
	console.log($foodInfo);
}

function choiceFood() {
	//console.log("choice");
	//foodName
	rslt = $(event.target).attr('data-id');
	//0:음식이름/1:칼로리/2:탄수/3:단백질/4:지방
	foodInfo = rslt.split("/");
	foodName = foodInfo[0];
	displayFoodList();
	
	//hidden객체 만들어주기
	const foodInput = `<input type="hidden" name="food" value="${rslt}">`
	$foodInfo.insertAdjacentHTML('beforeend', foodInput);
	
	//이전 결과값 삭제
	rslt = [];
    while (rowContainer.hasChildNodes()) {
        rowContainer.removeChild(rowContainer.firstChild);
	}
}