//move(num,tag,time)
//num is we want to show.
//tag should not be changed
//time is duration of the animation
$(document).ready(function(){
    $("#number_change").mouseenter(function(){
		move(2001,1,900);  
		move(100,2,700);
		move(1600000,3,1000);
		move(300,4,800);
    });
});
function numberWithCommas(x) { //comma
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
function numberWithoutCommas(x){
	return x.replace(/,/g,"");
}
function numberWithPercentage(x) {
	return x.toString()+"%";
}

//input: the value current is
function move(value,mode,time){
	var s; 
	switch(mode){
		case 1:s=$("#data1").text();s=numberWithoutCommas(s);break
		case 2:s=$("#data2").text();s=s.replace("%","");break;
		case 3:s=$("#data3").text();s=numberWithoutCommas(s);break;
		case 4:s=$("#data4").text();s=numberWithoutCommas(s);break;
	}
	s=parseInt(s);
	var endPoint=value;//end point
	if(s<parseInt(endPoint)){
	//var fontSize=10; //from small to large
	var outTime=0;  // time cost
	var interTime=30;
	
	var timer = setInterval(function(){
		outTime+=interTime;
		//fontSize=fontSize+0.9;
		if(outTime<time){
			switch(mode){
				case 1: $("#data1").text(numberWithCommas(parseInt(endPoint/time*outTime)));break;
				case 2: $("#data2").text(numberWithPercentage(parseInt(endPoint/time*outTime)));break;
				case 3: $("#data3").text(numberWithCommas(parseInt(endPoint/time*outTime)));break;
				case 4: $("#data4").text(numberWithCommas(parseInt(endPoint/time*outTime)));break;
			}
			//$(".data_num").css({"font-size": "0"+fontSize+"px"});
			//$("#data1").text(numberWithCommas(parseInt(endPoint/time*outTime)));
		}else{
			switch(mode){
				case 1: $("#data1").text(numberWithCommas(endPoint));break;
				case 2: $("#data2").text(numberWithPercentage(endPoint));break;
				case 3: $("#data3").text(numberWithCommas(endPoint));break;
				case 4: $("#data4").text(numberWithCommas(endPoint));break;				
			}
			//$("#data1").text(numberWithCommas(endPoint));
		}
		},interTime);
	}
}