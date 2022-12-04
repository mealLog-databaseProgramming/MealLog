function weightChartDraw(data, year, month) {
    const weightData = generateWeightChartData(data, year, month);
	
    let ctx = document.getElementById('weight-chart').getContext('2d');

	window.weightChart = new Chart(ctx, {
        type: 'line',
        data: weightData,
		showTooltips: true,
        options: {
			spanGaps: true,
			legend: {
                display: false,
            },
//			labels: {
//				display: false,
//			},
			elements: {
				point: {
					backgroundColor: 'rgb(59, 92, 10)',
					radius: 5,
					hoverRadius: 10,
				}
			},
			scales: {
				xAxes: [{
					ticks:{
						fontSize : 20,
						callback: function(val, index) {
				        	return index % 5 === 4 ? index+1 : '';
				        },
					},
				}],
				yAxes: [{
					ticks:{
						fontSize : 20,
					},
					
					max: 50,
					min: 150,
				}],
			}
        }
    });
};

function generateWeightChartData(data, year, month) {
	const weightData = { 
		labels: [],
        datasets: [{
            data: [],
            borderColor: 'rgb(59, 92, 10)',
			tension: 0,
			fill: false,
        }] 
    };

	const _data = {};
	
	for (let key in data) {
		var _date = new Date(key);
		
		if(year == _date.getFullYear() && month == _date.getMonth()) {
			_data[_date.getDate()] = data[key];
			//weightData.datasets[0].data.push({x: _date.getDate(), y: data[key]});
		}	
		else if(year < _date.getFullYear() || 
			(year === _date.getFullYear() && month < _date.getMonth())) {
			break;	
		}	
	}
	
	for(let i = 1; i <= 31; i++) {
		weightData.labels.push(i);

		if(_data[i] == undefined) weightData.datasets[0].data.push(null);
		else weightData.datasets[0].data.push( _data[i]);
	}
	console.log(weightData.datasets[0].data);
    return weightData;
}

const input = document.querySelector('input[type="month"]');
const date = new Date();
input.value = date.getFullYear()+"-"+(date.getMonth()+1);

input.onchange = () => {
	var _date = new Date(input.value);
	weightChartDraw(statData, _date.getFullYear(), _date.getMonth());
};

weightChartDraw(statData, date.getFullYear(), date.getMonth());