var sliderYear = document.getElementById('slider_year');
var sliderPrice = document.getElementById('slider_price');
var sliderMileage = document.getElementById('slider_mileage');

//year slider
noUiSlider.create(sliderYear,{
	connect: true,
	start: [2000,2015],
	step: 1,
	range: {
		'min': [ 2000 ],
		'max': [ 2015 ]
	}
});
sliderYear.noUiSlider.on('update',function(){
	document.getElementById('year_minval').innerHTML=parseInt(sliderYear.noUiSlider.get()[0]);
	document.getElementById('year_maxval').innerHTML=parseInt(sliderYear.noUiSlider.get()[1]);
});

//price slider
noUiSlider.create(sliderPrice,{
	connect: true,
	start: [4000,60000],
	step: 1000,
	range: {
		'min': [4000],
		'max': [60000]
	},
	format: wNumb({
		decimals: 0,
		thousand: ',',
		prefix: '$'
	})
});
sliderPrice.noUiSlider.on('update',function(){
	document.getElementById('price_minval').innerHTML=sliderPrice.noUiSlider.get()[0];
	document.getElementById('price_maxval').innerHTML=sliderPrice.noUiSlider.get()[1];
});

//mileage slider
noUiSlider.create(sliderMileage,{
	connect:true,
	start: [0,30000],
	step: 1000,
	range: {
		'min': [0],
		'max': [30000]
	},
	format: wNumb({
		decimals: 0,
		thousand: ',',
	})
});
sliderMileage.noUiSlider.on('update',function(){
	document.getElementById('mileage_minval').innerHTML=sliderMileage.noUiSlider.get()[0];
	document.getElementById('mileage_maxval').innerHTML=sliderMileage.noUiSlider.get()[1];	
});