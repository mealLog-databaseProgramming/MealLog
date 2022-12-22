function init() {
	var lis = document.querySelectorAll('.Nav li');
	
	for(var i = 0; i < lis.length; i++) {
		lis[i].setAttribute('onClick', `lis_select(${i})`);
	}
	
	var url = window.location.pathname;
	var selected = -1;
	if(url == "/") selected = 0;
	else if(url == "/recomm") selected = 1;
	else if(url == "/group") selected = 2;
	else if(url == "/mypage") selected = 3;
	
	lis[selected].className = 'select';
	
	
	var content = document.querySelector('.Content').getBoundingClientRect();
	var header = document.querySelector('.Header')
	window.addEventListener('scroll', function() {
		if(window.pageYOffset < 50)
			header.style.boxShadow = 'none';
		else
			header.style.boxShadow = '0px 2px 5px rgba(0, 0, 0, 0.25)';
	});
	
	var img = document.querySelector(".Header .greet #profile img");
	if(img.width > img.height) img.style.height = "100%";
    else img.style.width = "100%";

	document.querySelector("#loading").style.display = "none";
	
	window.onbeforeunload = (event) => {
		event.preventDefault();
		document.querySelector("#loading").style.display = "flex";
	};
}

function lis_select(i) {
	if(i === 0) location.href = '/';
	else if(i === 1) location.href = '/recomm';
	else if(i === 2) location.href = '/group';
	else if(i === 3) location.href = '/mypage';
}