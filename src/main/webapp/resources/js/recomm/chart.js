const chart = document.getElementById('graph');
const stat = new Chart(chart, {
    type: 'horizontalBar',
    data: {
        labels: ['kcal', '탄수화물', '단백질', '지방'],
        datasets: [{
			axis: 'y',
            label: '하루 섭취량',
            data: [75, 100, 30, 45],
            backgroundColor: '#A7E074',
            borderColor: '#000000',
            borderWidth: 1,
		    borderRadius: 50,
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
				}
			} ]
		}
    }
});

document.getElementById("graph").style.width="800px";
document.getElementById("graph").style.height="300px";	

