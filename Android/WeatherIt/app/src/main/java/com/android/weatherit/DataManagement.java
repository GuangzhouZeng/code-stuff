/**
 * Created by guangzhou on 11/23/2015.
 */

package com.android.weatherit;

import android.content.Context;
import android.util.Log;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class DataManagement {
    //singleton parttern
    private final static DataManagement INSTANCE=new DataManagement();
    private DataManagement(){}
    public static DataManagement getINSTANCE(){
        return INSTANCE;
    }

    //raw data, getter and setter
    private static String returnJsonString;

    public static String getResult() {
        return returnJsonString;
    }

    public static void setResult(String returnJsonString) {
        DataManagement.returnJsonString = returnJsonString;
    }

    //user's input
    private static String street;
    private static String city;
    private static String state;
    private static String degree;


    //below are convert functions, convert raw data into information can be used directly
    private static String LOG_TAG="DataManagement";
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
    static public String convertIconToUrl(Context context, String sumIcon){
        String res="http://cs-server.usc.edu:45678/hw/hw8/images/";
        switch(sumIcon){
            case "clear-day":sumIcon="clear";break;
            case "clear-night":sumIcon="clear_night";break;
            case "partly-cloudy-day":sumIcon="cloud_day";break;
            case "partly-cloudy-night":sumIcon="cloud_night";break;
        }
        res=res+sumIcon+".png";
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
        double temp=Double.parseDouble(precIn);
        if(temp>=0&&temp<0.002){
            res="None";
        }else if(temp>=0.002&&temp<0.017){
            res="Very Light";
        }else if(temp>=0.017&&temp<0.1){
            res="Light";
        }else if(temp>=0.01&&temp<0.4){
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
        DateFormat formatter=new SimpleDateFormat("hh:mm a");

        formatter.setTimeZone(TimeZone.getTimeZone(timezone));
        String res=formatter.format(date);
        return res;
    }
    static public String convertTimeToDate(String time, String timezone){
        long timestamp=Long.parseLong(time);
        Date date=new Date(timestamp*1000);
        Log.d(LOG_TAG, "timestamp:" + String.valueOf(timestamp));

        DateFormat formatterDay=new SimpleDateFormat("E");
        formatterDay.setTimeZone(TimeZone.getTimeZone(timezone));
        String day=formatterDay.format(date);

        DateFormat formatterMonth=new SimpleDateFormat("M");
        formatterMonth.setTimeZone(TimeZone.getTimeZone(timezone));
        String month=formatterMonth.format(date);
        switch(month){
            case "1": month="Jan";break;
            case "2": month="Feb";break;
            case "3": month="Mar";break;
            case "4": month="Apr";break;
            case "5": month="May";break;
            case "6": month="Jun";break;
            case "7": month="Jul";break;
            case "8": month="Aug";break;
            case "9": month="Sep";break;
            case "10": month="Oct";break;
            case "11": month="Nov";break;
            case "12": month="Dec";break;
        }

        DateFormat formatterDate=new SimpleDateFormat("dd");
        formatterDate.setTimeZone(TimeZone.getTimeZone(timezone));
        String dateDay=formatterDate.format(date);

        String res=day+", "+month+" "+dateDay;
        return res;
    }

    public static String getStreet() {
        return street;
    }

    public static void setStreet(String street) {
        DataManagement.street = street;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        DataManagement.city = city;
    }

    public static String getState() {
        return state;
    }

    public static void setState(String state) {
        DataManagement.state = state;
    }

    public static String getDegree() {
        return degree;
    }

    public static void setDegree(String degree) {
        DataManagement.degree = degree;
    }
}
