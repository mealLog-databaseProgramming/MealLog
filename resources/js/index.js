function init() {
	var lis = document.querySelectorAll('.Nav li');

	for(var i = 0; i < lis.length; i++) {
		lis[i].setAttribute('onClick', 'lis_select(this)');
	}
}

function lis_select(e) {
	var before = document.querySelector('.Nav .select');
	before.className = '';
	
	e.className = 'select';
}