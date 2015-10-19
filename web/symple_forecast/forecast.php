<meta name="viewport" content="width=device-width; initial-scale=1.0" /> <!--for cellphone-->
<html>
    <head>
        <style>
            .myform{
                position:relative;
                left:-30px;
            }
            #formborder{
                border:1px solid black;
                width:425px;
            }
            #manfield{
                font-family: cursive,Calibri;
                font-size:80%;
                position:relative;
                left:-100px;
            }
            #focResult{
                border:1px solid black;
                font-size:80%;
                padding: 5px 30px 20px 70px;
                width:425px;
            }
            .summary{
                font-size:150%;
            }

            /*for cellphone*/
            @media (max-width: 1000px) { 
                .myform{
                    position:relative;
                    left:1px;
                }
                #formborder{
                    border:1px solid black;
                    width:305px;
                }
                #manfield{
                    font-family: cursive,Calibri;
                    font-size:80%;
                    position:relative;
                    left:-70px;
                }
                #focResult{
                    border:1px solid black;
                    font-size:80%;
                    padding: 5px 5px 5px 30px;    
                    width:305px;
                }
                .summary{
                    font-size:150%;
                }
            }
        </style>
        
    </head>
    <body>
<!---------------------------PHP deal with phone return back weather information---------------------------------->
<?php
$unit="";
$str=$cit=$sta=$deg="";
$forecastResult="";

$geoapi="AIzaSyABos6Mp8acxGZ8pbE6j-ZRrWuMhyBflrA";
$focapi="2c7b9245a34a438b2464e95088a5797b";

if($_SERVER["REQUEST_METHOD"]=="POST"){
    $str=$_POST["street"];
    $cit=$_POST["city"];
    $sta=$_POST["state"];
    $deg=$_POST["degree"];
    
    if($str!=""&&$cit!=""&&$sta!="Select your State..."&&$deg!=""){
        
    $unit=$deg=="Fahrenheit"?"us":"si";
    
    $geoURL="https://maps.googleapis.com/maps/api/geocode/xml?address=$str,$cit,$sta&key=$geoapi";
    //echo 'geoURL='.$geoURL."<br>";
    $geoURL=urlencode($geoURL);
    //echo 'geoURL='.$geoURL."<br>";
    

    $geoxml=simplexml_load_file($geoURL) or die("Error: Cannot create object");
    $lat= $geoxml->result->geometry->location->lat;
    $lng= $geoxml->result->geometry->location->lng;

    //print_r($geoxml);  //get back from geo
   
    $lat= $geoxml->result->geometry->location->lat;
    $lng= $geoxml->result->geometry->location->lng;
     
    $focURL="https://api.forecast.io/forecast/$focapi/$lat,$lng?units=$unit&exclude=flags";

    $focCont=file_get_contents($focURL);
    //$focCont=utf_encode($focCont);
    //var_dump(json_decode($focCont));
    $focJson=json_decode($focCont);
    //var_dump($focJson);   //get back from forecast.io
    
    $timezone=$focJson->{"timezone"};
    $summary=$focJson->{"currently"}->{"summary"};
    $temper=$focJson->{"currently"}->{"temperature"};
    $sumIcon=$focJson->{"currently"}->{"icon"};
    $precIn=$focJson->{"currently"}->{"precipIntensity"};
    $precPr=$focJson->{"currently"}->{"precipProbability"};
    $windSpeed=$focJson->{"currently"}->{"windSpeed"};
    $dewPoint=$focJson->{"currently"}->{"dewPoint"};
    $humidity=$focJson->{"currently"}->{"humidity"};
    $visibility=$focJson->{"currently"}->{"visibility"};
    $sunrise=$focJson->{"daily"}->{"data"}[0]->{"sunriseTime"};
    $sunset=$focJson->{"daily"}->{"data"}[0]->{"sunsetTime"};
    
    $temper=(int)$temper;
    $temper=$unit=='us'?$temper.='&#176 F':$temper.='&#176 C';
    switch($precIn){
        case 0.002: $precIn="Very Light";break;
        case 0.017: $precIn="Light";break;
        case 0.1:   $precIn="Moderate";break;
        case 0.4:   $precIn="Heavy";break;
        default:    $precIn="None";
    }
    $precPr=$precPr*100;
    //$windSpeed=(int)$windSpeed." mph";
    $windSpeed=$unit=='us'?(int)$windSpeed." mph":(int)$windSpeed." mps";
        
    $dewPoint=$unit=='us'?(int)$dewPoint.'&#176 F':(int)$dewPoint.'&#176 C';
    $humidity=$humidity*100;
    $visibility=$unit=='us'?(int)$visibility." mi":(int)$visibility." m";
    date_default_timezone_set($timezone);
    $sunrise=date('h:i A', $sunrise);
    $sunset=date('h:i A', $sunset);
    
    //deal with icon
    switch($sumIcon){
        case "clear-day":$sumIcon="clear";break;
        case "clear-night":$sumIcon="clear_night";break;
        case "partly-cloudy-day":$sumIcon="cloud_day";break;
        case "partly-cloudy-night":$sumIcon="cloud_night";break;
    }
    

        
    $forecastResult="
    <center >
    <table  id='focResult' >
        <tr class='summary'>
            <span ><th colspan=2 align=center>$summary</th></span>
        </tr>
        <tr class='summary'><span ><th colspan=2 align=center>$temper</th></span></tr>
        <tr><td colspan=2 align=center><img src='img/$sumIcon.png' alt='<?php echo $summary ?>' height='80%'></td></tr>
        
        <tr>
            <td>Precipitation:</td><td>$precIn</td>
        </tr>
        <tr>
            <td>Chance of Rain:</td><td>$precPr%</td>
        </tr>
        <tr>
            <td>Wind Speed:</td><td>$windSpeed</td>
        </tr>
        <tr>
            <td>Dew Point:</td><td>$dewPoint</td>
        </tr>
        <tr>
            <td>Humidity:</td><td>$humidity%</td>
        </tr>
        <tr>
            <td>Visibility:</td><td>$visibility</td>
        </tr>
        <tr>
            <td>Sunrise:</td><td>$sunrise</td>
        </tr>
        <tr>
            <td>Sunset:</td><td>$sunset</td>
        </tr>
    </table>
        </center>";
    }
    

}
?>
        
       <!------------------------------------------ html show a form------------------------------------------------>
        <center>
        <h1>Forecast Search</h1>
            
        <form id="formborder" method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>"> 
            <div class="myform">
            <table>
                <tr>
                    <td>Street Address:*</td>
                    <td><input id='inputStr' type="text" name="street" value="<?php echo $str; ?>"><br></td>
                </tr>
                <tr>
                    <td>City:*</td>
                    <td><input id="inputCit" type="text" name="city" value="<?php echo $cit; ?>"></td>
                </tr>
                <tr>
                    <td>State:*</td>
                    <td>
                        <select name="state">
                            <option <?php if($sta=="") echo "selected"?>>Select your State...</option>
                            <option <?php if($sta=="AL") echo "selected"?>>AL</option>
                            <option <?php if($sta=="AK") echo "selected"?>>AK</option>
                            <option <?php if($sta=="AZ") echo "selected"?>>AZ</option>
                            <option <?php if($sta=="AR") echo "selected"?>>AR</option>
                            <option <?php if($sta=="CA") echo "selected"?>>CA</option>
                            <option <?php if($sta=="CO") echo "selected"?>>CO</option>
                            <option <?php if($sta=="CT") echo "selected"?>>CT</option>
                            <option <?php if($sta=="DE") echo "selected"?>>DE</option>
                            <option <?php if($sta=="DC") echo "selected"?>>DC</option>
                            <option <?php if($sta=="FL") echo "selected"?>>FL</option>
                            <option <?php if($sta=="GA") echo "selected"?>>GA</option>
                            <option <?php if($sta=="HI") echo "selected"?>>HI</option>
                            <option <?php if($sta=="ID") echo "selected"?>>ID</option>
                            <option <?php if($sta=="IL") echo "selected"?>>IL</option>
                            <option <?php if($sta=="IN") echo "selected"?>>IN</option>
                            <option <?php if($sta=="IA") echo "selected"?>>IA</option>
                            <option <?php if($sta=="KS") echo "selected"?>>KS</option>
                            <option <?php if($sta=="KY") echo "selected"?>>KY</option>
                            <option <?php if($sta=="LA") echo "selected"?>>LA</option>
                            <option <?php if($sta=="ME") echo "selected"?>>ME</option>
                            <option <?php if($sta=="MD") echo "selected"?>>MD</option>
                            <option <?php if($sta=="MA") echo "selected"?>>MA</option>
                            <option <?php if($sta=="MI") echo "selected"?>>MI</option>
                            <option <?php if($sta=="MN") echo "selected"?>>MN</option>
                            <option <?php if($sta=="MS") echo "selected"?>>MS</option>
                            <option <?php if($sta=="MO") echo "selected"?>>MO</option>
                            <option <?php if($sta=="MT") echo "selected"?>>MT</option>
                            <option <?php if($sta=="NE") echo "selected"?>>NE</option>
                            <option <?php if($sta=="NV") echo "selected"?>>NV</option>
                            <option <?php if($sta=="NH") echo "selected"?>>NH</option>
                            <option <?php if($sta=="NJ") echo "selected"?>>NJ</option>
                            <option <?php if($sta=="NM") echo "selected"?>>NM</option>
                            <option <?php if($sta=="NY") echo "selected"?>>NY</option>
                            <option <?php if($sta=="NC") echo "selected"?>>NC</option>
                            <option <?php if($sta=="ND") echo "selected"?>>ND</option>
                            <option <?php if($sta=="OH") echo "selected"?>>OH</option>
                            <option <?php if($sta=="OK") echo "selected"?>>OK</option>
                            <option <?php if($sta=="OR") echo "selected"?>>OR</option>
                            <option <?php if($sta=="PA") echo "selected"?>>PA</option>
                            <option <?php if($sta=="RI") echo "selected"?>>RI</option>
                            <option <?php if($sta=="SC") echo "selected"?>>SC</option>
                            <option <?php if($sta=="SD") echo "selected"?>>SD</option>
                            <option <?php if($sta=="TN") echo "selected"?>>TN</option>
                            <option <?php if($sta=="TX") echo "selected"?>>TX</option>
                            <option <?php if($sta=="UT") echo "selected"?>>UT</option>
                            <option <?php if($sta=="VT") echo "selected"?>>VT</option>
                            <option <?php if($sta=="VA") echo "selected"?>>VA</option>
                            <option <?php if($sta=="WA") echo "selected"?>>WA</option>
                            <option <?php if($sta=="WV") echo "selected"?>>WV</option>
                            <option <?php if($sta=="WI") echo "selected"?>>WI</option>
                            <option <?php if($sta=="WY") echo "selected"?>>WY</option>
                            
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Degree:*</td>
                    <td>
                        <input type="radio" name="degree" <?php if($deg==""||$deg=="Fahrenheit") echo "checked"?> value="Fahrenheit" >Fahrenheit
                        <input type="radio" name="degree" <?php if(isset($deg)&&$deg=="Celsius") echo "checked"?> value="Celsius">Celsius
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" name="submit" onclick="inputValidation()" value="Search">
                        <input type="button" value="Clear" onclick="clickClear()">
                    </td>
                </tr>
            </table>
            </div>
                <span id="manfield">* - Mandatory fields.</span><br>
               
            <center><a href="http://forecast.io">Powered by Forecast.io</a></center>
        
        </form>
        </center>
        <div id='displayHere'>
             <?php if($forecastResult!="") echo $forecastResult;else echo "";?>  
        </div>
        
        
     <!---------------------------JavaScript validation and clear---------------------------------->
        <script>
            var street;
            var city;
            var state;
            function checkEmpty(str1,str2){
                if(str2==null||str2==""||str2=="Select your State..."){
                    alert("Please enter value for "+str1);
                    return true;
                }
            }
            function inputValidation(){
                street=document.getElementsByName("street")[0].value;
                city=document.getElementsByName("city")[0].value;
                state=document.getElementsByName("state")[0].value;
                if(checkEmpty("Street Adress",street)) return false;
                if(checkEmpty("City",city)) return false;
                if(checkEmpty("State",state)) return false;
            }
            function clickClear(){
                //alert('clickClear');
                document.getElementsByName('street')[0].value="";
                document.getElementsByName('city')[0].value="";
                document.getElementsByName('state')[0].value="Select your State...";
                document.getElementsByName('degree')[0].checked=true;
                document.getElementsByName('degree')[1].checked=false;
                document.getElementById('displayHere').innerHTML="";
            }
            
        </script>
    </body>
</html>




