const chart = document.getElementById('graph');

const stat = new Chart(chart, {
    type: 'horizontalBar',
    data: {
        labels: ['kcal', '탄수화물', '단백질', '지방'],
        datasets: [{
			axis: 'y',
            label: '하루 섭취량',
            data: [kcalPer, nutriPer[0], nutriPer[1], nutriPer[2]],
            backgroundColor: '#A7E074',
            borderColor: '#A7E074',
            borderWidth: 0,
		   
		    borderSkipped: false,
        }]
    },
    options: {
		responsive: true,
		indexAxis: 'y',
		legend: {
		     display: false
		},
		scales : {
			xAxes : [ {
				ticks : {
					beginAtZero : true, // 0부터 시작하게 합니다.
					max: 100,
				}
			} ]
		},
		barRadius: 4,
    }
});

document.getElementById("graph").style.width="800px";
document.getElementById("graph").style.height="300px";	

