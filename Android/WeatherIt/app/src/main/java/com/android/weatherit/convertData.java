/**
 * Created by guangzhou on 11/23/2015.
 */

package com.android.weatherit;

import android.content.Context;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class convertData {
    private static String LOG_TAG="convertData";
    static public int convertIcon(Context context, String sumIcon){
        int res;
        switch(sumIcon){
            case "clear-day":sumIcon="clear";break;
            case "clear-night":sumIcon="clear_night";break;
            case "partly-cloudy-day":sumIcon="cloud_day";break;
            case "partly-cloudy-night":sumIcon="cloud_night";break;
        }
        res=context.getResources().getIdentifier(sumIcon,"drawable",context.getPackageName());
        return res;
    }
    static public String convertTemp(String temp, String degree){
        int i=(int)Double.parseDouble(temp);
        if(degree.equals("Fahrenheit")){
            temp=Integer.toString(i)+"\u2109";
        }else{
            temp=String.valueOf(i)+"\u2103";
        }
        return temp;
    }
    static public String convertSummary(String summary, String city, String state){
        String res=summary+" in "+city+", "+state;
        return res;
    }

    static public String convertMinMax(String minT, String maxT){
        int minTint=(int)Double.parseDouble(minT);
        int maxTint=(int)Double.parseDouble(maxT);
        String res="L: "+minTint+"\u00B0 | H: "+maxTint+"\u00B0";
        return res;
    }

    static public String convertPrecipitation(String precIn){
        String res;
        if(Double.parseDouble(precIn)>=0&&Double.parseDouble(precIn)<0.002){
            res="None";
        }else if(Double.parseDouble(precIn)>=0.002&&Double.parseDouble(precIn)<0.017){
            res="Very Light";
        }else if(Double.parseDouble(precIn)>=0.017&&Double.parseDouble(precIn)<0.1){
            res="Light";
        }else if(Double.parseDouble(precIn)>=0.01&&Double.parseDouble(precIn)<0.4){
            res="Moderate";
        }else{
            res="heavy";
        }
        return res;
    }

    static public String convertChanceOfRain(String precPr){
        String res;
        double temp=Double.parseDouble(precPr);
        temp=temp*100;
        temp=Math.round(temp);
        res=String.valueOf(temp)+"%";
        return res;
    }

    static public String convertWindSpeed(String windSpeed, String degree){
        String res;
        double ws=Double.parseDouble(windSpeed);
        if(degree.equals("Fahrenheit")){
            res=String.valueOf(ws)+"km/h";
        }else{
            res=String.valueOf(ws)+"m/s";
        }
        return res;
    }

    static public String convertDewPoint(String dp, String degree){
        String res;
        int temp=(int)Double.parseDouble(dp);
        if(degree.equals("Fahrenheit")){
            res=String.valueOf(temp)+"\u2109";
        }else{
            res=String.valueOf(temp)+"\u2103";
        }
        return res;
    }

    static public String convertHumidity(String humidity){
        String res;
        Log.d(LOG_TAG, "humidity:"+humidity);
        double temp=Double.parseDouble(humidity);
        temp=temp*100;
        temp=Math.round(temp);
        res=String.valueOf(temp)+"%";
        return res;
    }

    static public String convertVisibility(String visibility, String degree){
        String res;
        if(degree.equals("Fahrenheit")){
            res=visibility+" mi";
        }else{
            res=visibility+" km";
        }
        return res;
    }

    static public String convertTime(String time, String timezone){
        long timestamp=Long.parseLong(time);
        Date date=new Date(timestamp*1000);
        Log.d(LOG_TAG, "timestamp:"+String.valueOf(timestamp));
        DateFormat formatter=new SimpleDateFormat("h:mm a");

        formatter.setTimeZone(TimeZone.getTimeZone(timezone));
        String res=formatter.format(date);
        return res;

    }

}
