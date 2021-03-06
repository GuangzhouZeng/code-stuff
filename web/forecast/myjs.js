var street, city, state, degree;
var picVal,descVal;
var mapIsOn=0;

var tabhtml='<div>	'	
	+	'<div class="col-xs-12 col-sm-12">				'
	+	'<section id="weatherRes">'
	+	'	<ul class="nav nav-tabs" style="border-bottom-width: 0px;">'
	+	'		<li class="active"><a class="gray" data-toggle="pill" href="#menu1" >Right Now</a></li>'
	+	'		<li ><a class="gray" data-toggle="pill" href="#menu2">Next 24 Hours</a></li>'
	+	'		<li ><a class="gray" data-toggle="pill" href="#menu3">Next 7 Days</a></li>'
	+	'	</ul>'
	+	'	<div class="tab-content">'
	+	'		<div id="menu1" class="tab-pane fade in active" >	'	
	+	'		</div>'
	+	'		<div id="menu2" class="tab-pane fade">'				
	+	'		</div>'			
	+	'		<div id="menu3" class="tab-pane fade">'				
	+	'		</div>'
	+	'	</div>'
	+	'</section>'
	+	'</div>'
	+'</div>';	
function convertTempInt(temp){
	temp=(degree=="Celsius")?parseInt(temp)+" &#176 C":parseInt(temp)+" &#176 F";
	return temp;
}	
function convertTempFloat(temp){
	temp=(degree=="Celsius")?temp.toFixed(2)+" &#176 C":temp.toFixed(2)+" &#176 F";
	return temp;
}
function convertWindSpeed(temp){
	temp=(degree=="Celsius")?temp.toFixed(2)+' m/s':temp.toFixed(2)+' mph';
	return temp;
}
function convertWindSpeedInt(temp){
	temp=(degree=="Celsius")?Math.round(temp)+' m/s':Math.round(temp)+' mph';
	return temp;
}
function convertIcon(str){
	var icon;
	var folder="http://cs-server.usc.edu:45678/hw/hw8/images/"
	switch(str){
		case "clear-day": icon=folder+"clear.png";break;
		case "clear-night": icon=folder+"clear_night.png";break;
		case "partly-cloudy-day": icon=folder+"cloud_day.png";break;
		case "partly-cloudy-night": icon=folder+"cloud_night.png";break;
		default: icon=folder+str+".png";
	}
	return icon;
}
function convertprecIn(val){
	var precIn;
	if(val>=0&&val<0.02){
		precIn="None";
	}else if(val>=0.02&&val<0.017){
		precIn="Very Light";
	}else if(val>=0.017&&val<0.1){
		precIn="Light";
	}else if(val>=0.1&&val<0.4){
		precIn="Moderate";
	}else{
		precIn="Heavy";
	}
	return precIn;
}
function convertTime(date) {
	date=new Date(date*1000);
	var hours = date.getHours();
	var minutes = date.getMinutes();
	var ampm = hours >= 12 ? 'PM' : 'AM';
	hours = hours % 12;
	hours = hours ? hours : 12; // the hour '0' should be '12'
	hours = hours < 10 ? '0' + hours:hours;
	minutes = minutes < 10 ? '0'+minutes : minutes;
	var strTime = hours + ':' + minutes + ' ' + ampm;
	return strTime;
}
function convertToDay(date){
	date=new Date(date*1000).getDay();
	var day;
	switch(date){
		case 0: day="Sunday";break;
		case 1: day="Monday";break;
		case 2: day="Tuesday";break;
		case 3: day="Wednesday";break;
		case 4: day="Thursday";break;
		case 5: day="Friday";break;
		case 6: day="Saturday";break;
	}
	return day;
}
function convertToMonth(date){
	date=new Date(date*1000);
	var month=date.getMonth(date);
	switch(month){
		case 0: month="Jan";break;
		case 1: month="Feb";break;
		case 2: month="Mar";break;
		case 3: month="Apr";break;
		case 4: month="May";break;
		case 5: month="Jun";break;
		case 6: month="Jul";break;
		case 7: month="Aug";break;
		case 8: month="Sep";break;
		case 9: month="Oct";break;
		case 10: month="Nov";break;
		case 11: month="Dec";break;
	}
	return month;
}
function checkStreet(){
	if(($.trim($("#streetInput").val())).length==""){
		$("#streetWarning").text("Please enter the street address");
		return true;
	}else {
		$("#streetWarning").text("");
		return false;
	}
}
function checkCity(){
	if(($.trim($("#cityInput").val())).length==""){
		$("#cityWarning").text("Please enter a city");
		return true;
	}else{
		$("#cityWarning").text("");
		return false;
	}
}
function checkState(){
	if($("#stateInput").val()=="Select your State..."){
		$("#stateWarning").text("Please select a state")
		return true;
	}else{
		$("#stateWarning").text("");
		return false;
	}
		
}
function checkEmpty(){
	var s1=checkStreet();
	var s2=checkCity();
	var s3=checkState();
	if(s1||s2||s3)
		return true;
	else{
		$("#resSection").html(tabhtml);
		return false;
	}
}
function showMap(lon,lat){
	var lonlat = new OpenLayers.LonLat(lon,lat).transform('EPSG:4326','EPSG:3857');
    var map = new OpenLayers.Map({div:"mapLayer",
								center:lonlat});
	
	
	//map.setCenter(new OpenLayers.LonLat(-71, 42), 4);
	// Create OSM overlays
    var mapnik = new OpenLayers.Layer.OSM();
	
	var layer_cloud = new OpenLayers.Layer.XYZ(
        "clouds",
        "http://${s}.tile.openweathermap.org/map/clouds/${z}/${x}/${y}.png",
        {
            isBaseLayer: false,
            opacity: 0.7,
            sphericalMercator: true
        }
    );

    var layer_precipitation = new OpenLayers.Layer.XYZ(
        "precipitation",
        "http://${s}.tile.openweathermap.org/map/precipitation/${z}/${x}/${y}.png",
        {
            isBaseLayer: false,
            opacity: 0.7,
            sphericalMercator: true
        }
    );
	
	map.addLayers([mapnik, layer_precipitation, layer_cloud]);
	//map.addLayers([mapnik]);
	map.zoomTo(12);
	mapIsOn=1;
}
function showNow(info){
	var unit=degree=="Celsius"?"si":"en";
	
	var lon=info.longitude;
	var lat=info.latitude;
	
	var timezone=info.timezone;
	var sumIcon=info.currently.icon;
	var summary=info.currently.summary;
	var temper=info.currently.temperature;
	var minT=info.daily.data[0].temperatureMin;
	var maxT=info.daily.data[0].temperatureMax;
	var precIn=info.currently.precipIntensity;
	var precPr=info.currently.precipProbability;
	var windSpeed=info.currently.windSpeed;
	var dewPoint=info.currently.dewPoint;
	var humidity=info.currently.humidity;
	var visibility=info.currently.visibility;
	var sunrise=info.daily.data[0].sunriseTime;
	var sunset=info.daily.data[0].sunsetTime;
	
	descVal=summary+','+convertTempInt(temper); //used in facebookPost()
	console.log(descVal);
	
	sumIcon=convertIcon(sumIcon);
	summary=summary+" in "+city+", "+state;
	temper=convertTempInt(temper);
	minT=convertTempInt(minT);
	maxT=convertTempInt(maxT);
	precIn=convertprecIn(precIn);
	precPr=precPr*100+"%";
	windSpeed=convertWindSpeed(windSpeed);
	dewPoint=convertTempFloat(dewPoint);
	humidity=Math.round(humidity)+"%";
	visibility=visibility.toFixed(2)+" mi";
	sunrise=convertTime(sunrise);
	sunset=convertTime(sunset);
	
	picVal=sumIcon;//used in facebookPost()
	console.log(picVal);
	
	var nowInfoHtml='<div class="col-md-6" style="padding-left: 0px;padding-right: 0px;">'
	+'				<div class="table-responsive">'
	+'				<table class="table">'
	+'					<div id="nowHeader" class="row">'
	+'						<center>'
	+'						<div class="col-md-6">'
	+'							<img  id="nowIcon" src="'+sumIcon+'" width="100px" height="100px">'
	+'						</div>'
	+'						</center>'
	+'						<div class="col-md-6">'
	+'							<center>'
	+'							<p id="nowSum">'+summary+'</p>'
	+'							<h1 id="nowTem">'+temper+'</h1>'
	+'							<p id="nowMinMax">L:'+minT+' | H:'+maxT+'</p>'
	+'							</center>'
	+'							<div><a style="cursor:hand" onclick="facebookPost(\''+picVal+'\',\''+descVal+'\')"><img id="nowFb" src="http://cs-server.usc.edu:45678/hw/hw8/images/fb_icon.png" width="30px" height="30px"></a></div>'
	+'						</div>'
	+'					</div>'
	+'					<tr class="info"><td>Precipitation</td><td>'+precIn+'</td>'
	+'					</tr>'
	+'					<tr class="danger"><td>Chance of Rain</td><td>'+precPr+'</td>'
	+'					</tr>'
	+'					<tr class="info"><td>Wind Speed</td><td>'+windSpeed+'</td>'
	+'					</tr>'
	+'					<tr class="danger"><td>Dew Point</td><td>'+dewPoint+'</td>'
	+'					</tr>'
	+'					<tr class="info"><td>Humidity</td><td>'+humidity+'</td>'
	+'					</tr>					'
	+'					<tr class="danger"><td>Visibility</td><td>'+visibility+'</td>'
	+'					</tr>'
	+'					<tr class="info"><td>Sunrise</td><td>'+sunrise+'</td>'
	+'					</tr>'
	+'					<tr class="danger"><td>Sunset</td><td>'+sunset+'</td>'
	+'					</tr>'
	+'				</table>'
	+'				</div>'
	+'				</div>'
	+'				<div class="col-md-6" style="padding-left: 0px;padding-right: 0px;">'
	+'				<div id="mapLayer">'
	+'				</div>'
	+'				</div>';

	$("#menu1").html(nowInfoHtml);
	showMap(lon,lat);

	
	/*
	////test here
	var testinfo=timezone+" "+summary+" "+temper+" "+
		sumIcon+" "+precIn+" "+precPr+" "+windSpeed+" "+
		dewPoint+" "+humidity+" "+visibility+" "
		+sunrise+" "+sunset+" "+minT+" "+maxT;
		
	console.log(testinfo);	
	//test before
	
	
	
	var txt=timezone+"<br>"+summary+"<br>"+temper+"<br>"+
		sumIcon+"<br>"+precIn+"<br>"+precPr+"<br>"+windSpeed+"<br>"+
		dewPoint+"<br>"+humidity+"<br>"+visibility+"<br>"
		+sunrise+"<br>"+sunset+"<br>"+minT+"<br>"+maxT;
			
	//document.getElementById("nowinfo").innerHTML=txt;
	$("#menu1").html(txt);*/
}
function showNextHours(info){
	//var txt="<p><br>";
	var nextHoursHtml='	<table class="table table-responsive text-center">'
					+	'		<thead id="next24head">'
					+	'			<td class="col-sm-2 next24title">Time</th>'
					+	'			<td class="col-sm-2 next24title">Summary</th>'
					+	'			<td class="col-sm-2 next24title">Cloud Cover</th>'
					+	'			<td class="col-sm-2 next24title">Temp</th>'
					+	'			<td class="col-sm-2 next24title">View Details</th>'
					+	'		</thead>'
					+	'		<tbody id="next24body">';
	for(var i=0;i<24;i++){
		var time=info.hourly.data[i].time;
		var icon=info.hourly.data[i].icon;
		var cloud=info.hourly.data[i].cloudCover;
		var temp=info.hourly.data[i].temperature;
		var wind=info.hourly.data[i].windSpeed;
		var humidity=info.hourly.data[i].humidity;
		var visibility=info.hourly.data[i].visibility;
		var pressure=info.hourly.data[i].pressure;
		
		//////test here
		/*var testinfo=i+" "+time+" "+icon+" "+cloud+" "+
				temp+" "+wind+" "+humidity+
			" "+visibility+" "+pressure+" ";
		console.log(testinfo);*/
		//test before;

		time=convertTime(time);
		icon=convertIcon(icon);
		cloud=parseInt(cloud)+'%';
		wind=convertWindSpeedInt(wind);
		humidity=Math.round(humidity)+'%';
		visibility=visibility.toFixed(2);
		pressure=pressure+"mb";
		
		//html
		nextHoursHtml+='<tr>'
					+	'		<td >'+time+'</td>'
					+	'		<td ><img class="next24icon" src="'+icon+'"></td>'
					+	'		<td >'+cloud+'</td>'
					+	'		<td >'+temp+'</td>'
					+	'		<td >'
					+	'			<a data-toggle="collapse" href="#t'+i+'" data-parent="#accordion">'
					+	'				<span class="glyphicon glyphicon-plus">'
					+	'				</span>'
					+	'			</a>'
					+	'		</td>'
					+	'	</tr>'
					+	'	<tr>'
					+	'		<td colspan="5" style="border-bottom-width: 0px; padding-top: 0px; padding-bottom: 0px;">'
					+	'			<div id="t'+i+'" class="collapse ">'
					+	'				<table class="table  next24collapse">'
					+	'					<thead class="well">'
					+	'						<td class="next24head2">Wind</td>'
					+	'						<td class="next24head2">Humidity</td>'
					+	'						<td class="next24head2">Visibility</td>'
					+	'						<td class="next24head2">Pressure</td>'
					+	'					</thead>'
					+	'					<tbody>'
					+	'						<td>'+wind+'</td>'
					+	'						<td>'+humidity+'</td>'
					+	'						<td>'+visibility+'</td>'
					+	'						<td>'+pressure+'</td>'
					+	'					</tbody>'
					+	'				</table>'
					+	'			</div>		'	
					+	'		</td>'
					+	'	</tr>';
							
		//
		
		
		//txt+=i+" "+time+" "+icon+" "+cloud+" "+
		//		temp+" "+wind+" "+humidity+
		//	" "+visibility+" "+pressure+"<br>";
	}
	
	nextHoursHtml+='	</tbody>'
			+	'	</table>';
	
	//txt+="</p>";
	//document.getElementById("24info").innerHTML=txt;
	$("#menu2").html(nextHoursHtml);
	//$("#menu2").html(txt);
}
function showNextDays(info){
	//var txt="<p><br>";
	var nextDaysHtml='<div class="container-fluid text-center daywathersbox">'
					+'<div class="daywathers text-center">';
	for(var i=1;i<=7;i++){
		var time=info.daily.data[i].time;
		var icon=info.daily.data[i].icon;
		var minT=info.daily.data[i].temperatureMin;
		var maxT=info.daily.data[i].temperatureMax;
		var summary=info.daily.data[i].summary;
		var sunrise=info.daily.data[i].sunriseTime;
		var sunset=info.daily.data[i].sunsetTime;
		var humidity=info.daily.data[i].humidity;
		var wind=info.daily.data[i].windSpeed;
		var visibility=info.daily.data[i].visibility;
		var pressure=info.daily.data[i].pressure;
		
		var day=convertToDay(time);
		var Month=convertToMonth(time);
		var date=new Date(time).getDate();
		var monthDate=Month+" "+date;
		icon=convertIcon(icon);
		minT=Math.round(minT);
		maxT=Math.round(maxT);
		var header="Weather in "+city+" on "+monthDate;
		summary=day+": "+summary;
		sunrise=convertTime(sunrise);
		sunset=convertTime(sunset);
		humidity=Math.round(humidity)+"%";
		wind=convertWindSpeed(wind);
		pressure=pressure+"mb";
		
		
		//
		
		nextDaysHtml+='	<div>'
					+		'<div data-toggle="modal" data-target="#pop'+i+'" class="clickable">'
					+		'<div id="day'+i+'" class="well col-md-1">'
					+					'<p class="daysize">'+day+'</p>'
					+					'<p>'+monthDate+'</p>'
					+					'<img class="dayweather" src="'+icon+'" alt="sleet" width="10px" height="10px">'
					+					'<p>Min Temp</p>'
					+					'<h3>'+minT+'</h3>'
					+					'<p>Max Temp</p>'
					+					'<h3>'+maxT+'</h3>'
					+		'</div>'
					+		'</div>'
					+		'<div id="pop'+i+'" class="modal fade" role="dialog">'
					+			'<div class="modal-dialog">'
					+				'<div class="modal-content">'
					+					'<div class="modal-header">'
					+					'	<button type="button" class="close" data-dismiss="modal">&times;</button>'
					+	'					<h4>Weather in '+city+' on '+monthDate+'</h5>'
					+	'				</div>'
					+	'				<div class="modal-body">'
					+	'					<img id="popIcon" src="'+icon+'" alt="'+icon+'">'
					+	'					<h3>Friday: Mostly cloudy throughout the day.</h3>'
					+	'					<div class="row">'
					+	'						<div class="col-md-4">Sunrise Time '
					+	'							<div class="popupText">'+sunrise
					+	'							</div>'
					+	'						</div>'
					+	'						<div class="col-md-4">Sunset Time'
					+	'							<div class="popupText">'+sunset
					+	'							</div>'
					+	'						</div>'
					+	'						<div class="col-md-4">humidity'
					+	'							<div class="popupText">'
					+									humidity
					+	'							</div>'
					+	'						</div>'
					+	'						<div class="col-md-4">Wind Speed'
					+	'							<div class="popupText">'+wind
					+	'							</div>'
					+	'						</div>'
					+	'						<div class="col-md-4">Visibility'
					+	'							<div class="popupText">'+visibility+'mi'
					+	'							</div>'
					+	'						</div>'
					+	'						<div class="col-md-4">Pressure'
					+	'							<div class="popupText">'
					+									pressure
					+	'							</div>'
					+	'						</div>'
					+	'					</div>'
					+	'				</div>'
					+	'				<div class="modal-footer">'
					+	'					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>'
					+	'				</div>'
					+	'			</div>'
					+	'		</div>'
					+	'	</div>'
					+	'</div>'	

					
		
		
		//
		
		

/*
		txt+=i+" "+day+" "+monthDate+" "+icon+" "+minT+" "+
			maxT+" "+summary+" "+sunrise+" "+sunset+" "+
			humidity+" "+wind+" "+visibility+" "+pressure+"<br>";*/
			
	}
	nextDaysHtml+='</div>		'
				+'</div>';
	//txt+="</p>";
	//document.getElementById("7info").innerHTML=txt;
	$("#menu3").html(nextDaysHtml);
	
}
function loadResult(str1,str2,str3,str4){
	var url="http://weatherit-env.elasticbeanstalk.com/index.php";
	url+="?street="+str1;
	url+="&city="+str2;
	url+="&state="+str3;
	url+="&degree="+str4;
	console.log(url);
	
	var xhr;
	if(window.XMLHttpRequest){
		xhr=new XMLHttpRequest();
	}else{
		xhr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	//xhr.open("GET","returnback.json",true);
	xhr.open("GET",url,true);
	xhr.onreadystatechange=function(){
		if (xhr.readyState==4&&xhr.status==200){
			//get php content back to display properly;
			var info=JSON.parse(xhr.responseText);
			showNow(info);
			showNextHours(info);
			showNextDays(info);
			
		}
	}
	
	//xhttp.open("GET", "demo_get2.asp?fname=Henry&lname=Ford", true);
	xhr.send();
	
}

function clickSubmit(){
	if(checkEmpty()) return; //if empty input exists
	else{
		if(mapIsOn){
			$("mapLayer").html("");
		}
		street=document.getElementsByName("Street")[0].value;
		city=document.getElementsByName("City")[0].value;
		state=document.getElementsByName("State")[0].value;
		var tem=document.getElementsByName("Degree");
		degree=tem[0].checked?tem[0].value:tem[1].value;
		console.log(degree);
		loadResult(street,city,state,degree);
	}
}

function clickClear(){
	document.getElementById("streetWarning").innerHTML="";
	document.getElementById("cityWarning").innerHTML="";
	document.getElementById("stateWarning").innerHTML="";
	document.getElementsByName("Street")[0].value=""
	document.getElementsByName("City")[0].value=""
	document.getElementsByName("State")[0].value="Select your State...";
	document.getElementsByName("Degree")[0].checked=true;
	document.getElementsByName("Degree")[1].checked=false;
	$("#resSection").html("");
}

//facebook things
window.fbAsyncInit = function() {
    FB.init({
      appId      : '989492937740238',
      xfbml      : true,
      version    : 'v2.5'
    });
};

(function(d, s, id){
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) {return;}
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

function facebookPost(picVal,descVal){
	console.log(descVal);
	console.log(picVal);
	nameVal='Current Weather in '+city+', '+state;
	capVal="WEATHER INFORMATION FROM FORCAST.IO"
	FB.ui(
	{
		method: 'feed',
		name: nameVal,
		link: 'http://cs-server.usc.edu:6451/HW8/HW8.html',
		picture: picVal,
		caption: capVal,
		description: descVal,
		message: "Message here"
	},function(response){
		if(response&&response.post_id){
			alert("Posted Successfully");
		}else{
			alert("Not Posted")
		}
	});
}


