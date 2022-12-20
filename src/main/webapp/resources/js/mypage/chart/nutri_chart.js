
const nutriChartData = {
    labels: ['탄수화물', '지방', '단백질'],
    datasets: [{
        data: nutriData,
        backgroundColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)']
    }] 
};

let nutriChartDraw = function () {
    let ctx = document.getElementById('nutri-chart').getContext('2d');
    
    window.nutriChart = new Chart(ctx, {
        type: 'doughnut',
        data: nutriChartData,
        options: {
            responsive: false,
            legend: {
                display: false
            },
            legendCallback: customLegend
        }
    });
};

let customLegend = function (chart) {
    let ul = document.createElement('ul');
    let color = chart.data.datasets[0].backgroundColor;

    chart.data.labels.forEach(function (label, index) {
        ul.innerHTML += `<li><span style="background-color: ${color[index]};"></span> ${label}</li>`;
    });

    return ul.outerHTML;
};


nutriChartDraw();
document.getElementById('nutri-legend-div').innerHTML = window.nutriChart.generateLegend();
