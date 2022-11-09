/*home.jsp의 차트 */  
var data = {
	axis: 'y',
	datasets:[
		{
			//탄수화물
			data:[42],
			backgroundColor:'#81B44F',
		},
		{
			//단백질
			data:[40],
			backgroundColor:'#9CD069',
		},
		{
			//지방
			data:[12],
			backgroundColor:'#C2EC98',
		},
		{
			//칼로리
			data:[82],
			backgroundColor:'#CACACA',
		}
	],
};

var options = {
	scales: {
    	xAxes: [{
            stacked: true,
            display:false
        }],
        yAxes: [{
            stacked: true,
            display:false
        }]
    },
    plugins:{
		datalabels: {
			display:false
		},
		legend:{
			display:false
		}
	}
};
        
var ctx = document.getElementById('foodChart');
var foodChart = new Chart(ctx, {
	type:'horizontalBar',
	data:data,
	options:options
});

document.getElementById("foodChart").style.width="100%";
document.getElementById("foodChart").style.height="100px";	