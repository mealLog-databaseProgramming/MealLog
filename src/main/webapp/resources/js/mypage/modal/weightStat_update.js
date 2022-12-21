
function weightStat_update_modal() {	
	var cancel = document.querySelector('#modal .cancel');
	cancel.onclick = () => {
		var answer = confirm("여기서 취소하면 수정 사항은 적용되지 않습니다. 취소하시겠습니까?");
		if(answer) location.href = "/mypage";
	}
	
	/* record 삭제 display */
	record_create_display();
	record_delete_display();
	
	var submit = document.querySelector('#weightStat_update input[type="submit"]');
	submit.onclick = () => {
		var answer = confirm("지금까지의 수정사항을 적용합니다.");
		if(answer) {
			var form = document.querySelector('#weightStat_update');
			form.submit();
		}
	};
}

function record_create_display() {
	document.querySelector('#weightStat_update').reset();
	
	var dateInput = document.querySelector('#weightStat_update input[name="date"]');
	dateInput.removeAttribute('readonly');
	
	var weightInput = document.querySelector('#weightStat_update input[name="weight"]');
	weightInput.setAttribute('value', '');
	
	var records = document.querySelectorAll('#modal .record');
	
	records.forEach((item) => {
		item.style.background = "#FFFFFF";
		
		item.onclick = (e) => {
			var record = e.target;
			if(record.tagName != "ICONIFY-ICON") {
				while(record.className != "record") {
					var record = record.parentNode;
				}

				record_update_display(record);
			}
		};
	});
	
	var button = document.querySelector('#weightStat_update input[type="button"]');
	button.setAttribute('value', '추가');
	
	button.onclick = () => {
		var form = document.querySelector('#weightStat_update');
		
		var date = form.querySelector('input[name="date"]').value;
		var weight = form.querySelector('input[name="weight"]').value;
		if(weight % 1 === 0) weight = weight + ".0";
		
		var record = getRecordByDate(date);
		if(record != null) {
			record.querySelector('.weight').innerText = weight+"kg";
			
			record_update(date, weight);
		} else {
			record = document.createRange().createContextualFragment(`
				<div class="record">
					<div class="date">${date}</div>
					<div class="weight">${weight}kg</div>
					<iconify-icon icon="ph:x-circle-bold"></iconify-icon>
				</div>`);
			var front = getFrontRecordByDate(date);
			if(front == null) {
				document.querySelector('.stat_list').prepend(record);
			} else {
				front.after(record);
			}
			
			record_create(date, weight);
			
			record_delete_display();
			record_create_display();
		}
	};
}
function getFrontRecordByDate(_date) {
	var records = document.querySelectorAll('#modal .record');
	
	var front = null;
	records.forEach((e) => {
		var d = e.querySelector('.date').innerText;
		if(d < _date) front = e;
	});
	return front;	
}

function record_update_display(record) {
	document.querySelector('#weightStat_update').reset();
	
	var records = document.querySelectorAll('#modal .record');
	records.forEach((item) => item.onclick = null);
	
	record.style.background = "rgba(146, 210, 123, 0.45)";
	
	record.onclick = () => {
		record_create_display();
	}
	
	var dateInput = document.querySelector('#weightStat_update input[name="date"]');
	dateInput.value = record.querySelector('.date').innerText;
	dateInput.setAttribute('readonly', true);
	
	var weightInput = document.querySelector('#weightStat_update input[name="weight"]');
	weightInput.setAttribute('value', record.querySelector('.weight').innerText.replace('kg', ''));
	
	var button = document.querySelector('#weightStat_update input[type="button"]');
	button.setAttribute('value', '변경');
	
	button.onclick = () => {
		var form = document.querySelector('#weightStat_update');
		
		var date = form.querySelector('input[name="date"]').value;
		var weight = form.querySelector('input[name="weight"]').value;
		
		if(weight % 1 === 0) weight = weight + ".0";
		record.querySelector('.weight').innerText = weight+"kg";
		
		record_update(date, weight);
		
		form.reset();
		record_create_display();
	};
}
function record_delete_display() {
	var records = document.querySelectorAll('#modal .record');
	records.forEach((item) => {
		item.onmouseover = (e) => {
			var deleteIcon = e.target.querySelector('iconify-icon');
			deleteIcon.style.opacity = "1";
		};
		item.onmouseleave = (e) => {
			var deleteIcon = e.target.querySelector('iconify-icon');
			deleteIcon.style.opacity = "0";
		};
		var deleteIcon = item.querySelector('iconify-icon');
		deleteIcon.onclick = (e) => {
			if(e.target.tagName === "ICONIFY-ICON") {
				var record = e.target.parentNode;
				
				var date = record.querySelector('.date').innerText;
				
				record_delete(date);
				record.remove();
			}
		};
	});	
}

function record_create(_date, _weight) {
	var hidden = document.querySelector('#weightStat_update .hidden');
	
	hidden.innerHTML = `${hidden.innerHTML}
	<input type="hidden" name="statList" value="${_date+'/'+_weight}"></input>`;
}
function record_update(_date, _weight) {
	var tag = getInputTagByDate(_date);
	
	tag.value = `${_date}/${_weight}`;
}
function record_delete(_date) {
	var tag = getInputTagByDate(_date);
	if(tag === null) return;
	
	tag.remove();
}

function getInputTagByDate(_date) {
	var tags = document.querySelectorAll('#weightStat_update .hidden input');
	
	var tag = null;
	tags.forEach((e) => {
		var d = e.value.split('/').shift();
		if(d === _date) {
			tag = e;
			return;
		}
	});
	return tag;
}
function getRecordByDate(_date) {
	var records = document.querySelectorAll('#modal .record');
	
	var rec = null;
	
	records.forEach((e) => {
		var d = e.querySelector('.date').innerText;
		console.log(e);
		if(d == _date) {
			rec = e;
			return;
		}
	});
	return rec;
}