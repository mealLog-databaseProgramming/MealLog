const data = {
    '1/1/2020': 60,
    '1/2/2020': 66,
    '1/3/2020': 65,
    '1/5/2020': 78,
    '1/6/2020': 74,
    '1/9/2020': 72,
    '12/9/2020': 60,
    '14/5/2020': 65,
    '15/6/2020': 58,
};

function weightChartDraw(data) {
    const weightData = generateWeightChartData(data);
    let ctx = document.getElementById('weight-chart').getContext('2d');
    
    window.weightChart = new Chart(ctx, {
        type: 'line',
        data: weightData,
        options: {
            responsive: false,
			legend: {
                display: false
            },
            scales: {
                x: {
                  type: 'time',
                  displayFormats: {
                        quarter: 'MM/DD'
                    }
                }
            }
        }
    });
};

function generateWeightChartData(data) {
    const weightData = { 
        labels: [],
        datasets: [{
            data: [],
            borderColor: 'rgb(75, 192, 192)',
			tension: 0,
			fill: false,
        }] 
    };

	console.log(weightData.datasets[0]);
	for (let key in data) {
		weightData.labels.push(key);
		weightData.datasets[0].data.push(data[key]);
	}
	

	
    return weightData;
}

weightChartDraw(data);
