<?php
$ret="fail";



$geoapi="AIzaSyABos6Mp8acxGZ8pbE6j-ZRrWuMhyBflrA";
$focapi="2c7b9245a34a438b2464e95088a5797b";


if($_SERVER["REQUEST_METHOD"]=="GET"){
	$str=$_REQUEST["street"];
	$cit=$_REQUEST["city"];
	$sta=$_REQUEST["state"];
	$deg=$_REQUEST["degree"];
	
	//$ret="street: $str  City: $cit  State: $sta  Degree:$deg";
	
	//should do some validation here
	
	
	$unit=$deg=="Fahrenheit"?"us":"si";
	
	//construct geoURL to request from google
	$geoURL="https://maps.googleapis.com/maps/api/geocode/xml?address=$str,$cit,$sta&key=$geoapi";
    $geoURL=urlencode($geoURL);
	//echo 'geoURL='.$geoURL."<br>";
	
	//get lat and lng here
	$geoxml=simplexml_load_file($geoURL) or die("Error: Cannot create object");
    $lat= $geoxml->result->geometry->location->lat;
    $lng= $geoxml->result->geometry->location->lng;
	
	//construct forURL to request from forecast.io
	$focURL="https://api.forecast.io/forecast/$focapi/$lat,$lng?units=$unit&exclude=flags";

    $focCont=file_get_contents($focURL);
	$focJson=json_decode($focCont);
	$ret=$focJson;
		
}

echo json_encode($ret);
?>