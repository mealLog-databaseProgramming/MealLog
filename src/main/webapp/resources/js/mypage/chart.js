
function chart_set() {
	var chart = new Chart(document.getElementById("line-chart"), {
	  type: 'line',
	  data: {
	    labels: ['\'22.01','\'22.02','\'22.03','\'22.04','\'22.05','\'22.06','\'22.07','\'22.08','\'22.09','\'22.10'],
	    datasets: [
			{ 
		        data: [Math.random(0,20),Math.random(0,20),Math.random(0,20),Math.random(0,20),Math.random(0,20),Math.random(0,20),Math.random(0,20),Math.random(0,20),Math.random(0,20), Math.random(0,20)],
				label: '',
		        borderColor: "#547A1D",
		        fill: false,
				tension: 0
	      	}
	    ]
	  },
	  options: {
	    title: {
	      display: false,
	      text: 'World population per region (in millions)'
	    },
		//plugins:{
		   legend: {
		     display: false
		   },
	  }
		//}
	});
	
	document.getElementById("line-chart").style.width="600px";
	document.getElementById("line-chart").style.height="350px";	
}

chart_set();