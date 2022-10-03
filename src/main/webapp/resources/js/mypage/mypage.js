
var body = document.querySelector('body');
body.setAttribute('onLoad', 'init_mypage()');

function init_mypage() {
	init();
	var keywords = document.querySelectorAll('.wrap .stat .info .detail span');
	
	for(var i = 0; i < keywords.length; i++) {
		keywords[i].setAttribute('onClick', 'keywords_select(this)');
	}
}

function keywords_select(e) {
	var before = document.querySelector('.wrap .stat .info .detail .select');
	
	if(e != before) {
		before.className = 'nonsel';
	
		e.className = 'select';
		
		chart_set();
	}
}