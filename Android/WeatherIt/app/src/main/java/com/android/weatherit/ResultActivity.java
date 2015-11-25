package com.android.weatherit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ResultActivity extends Activity {

    private String cityVal;
    private String stateVal;
    private String degreeVal;
    private String result;

    private String lon;
    private String lat;
    private String timezone;
    private String sumIcon;
    private String summary;
    private String temper;
    private String precIn;
    private String precPr;
    private String windSpeed;
    private String dewPoint;
    private String humidity;
    private String visibility;
    private String minT;
    private String maxT;
    private String sunrise;
    private String sunset;

    private String LOG_TAG="ResultActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        DataManagement data= DataManagement.getINSTANCE();
        Log.d(LOG_TAG,"testHere: "+data.getResult());
        try {//extract data here
            extractData();
            testData();  //test here
        } catch (JSONException e) {
            e.printStackTrace();
        }

        displayCurrent();

        Button moreDetailsBtn = (Button) findViewById(R.id.btnMore);
        Button viewMapBtn = (Button) findViewById(R.id.btnMap);
        ImageButton facebookImgBtn = (ImageButton) findViewById(R.id.imgBtnFacebook);

        moreDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, DetailsActivity.class);
                //intent.putExtra("jsonResult",result);
                startActivity(intent);
            }
        });

    }

    private void displayCurrent() {
        ImageView ivIcon= (ImageView) findViewById(R.id.imgViewIcon);
        TextView tvSumm= (TextView) findViewById(R.id.textViewSummary);
        TextView tvTemp= (TextView) findViewById(R.id.textViewTemp);
        TextView tvMinMax= (TextView) findViewById(R.id.textViewMinTMaxT);

        TextView tvPrec= (TextView) findViewById(R.id.textViewPrecipitationVal);
        TextView tvChan= (TextView) findViewById(R.id.textViewChanceOfRainVal);
        TextView tvWind= (TextView) findViewById(R.id.textViewWindSpeedVal);
        TextView tvDewP= (TextView) findViewById(R.id.textViewDewPointVal);
        TextView tvHumi= (TextView) findViewById(R.id.textViewHumidityVal);
        TextView tvVisi= (TextView) findViewById(R.id.textViewVisibilityVal);
        TextView tvSunr= (TextView) findViewById(R.id.textViewSunriseVal);
        TextView tvSuns= (TextView) findViewById(R.id.textViewSunsetVal);


        ivIcon.setImageResource(DataManagement.convertIcon(this, sumIcon));
        tvSumm.setText(DataManagement.convertSummary(summary, cityVal, stateVal));
        tvTemp.setText(DataManagement.convertTemp(temper, degreeVal));
        tvMinMax.setText(DataManagement.convertMinMax(minT, maxT));

        tvPrec.setText(DataManagement.convertPrecipitation(precIn));
        tvChan.setText(DataManagement.convertChanceOfRain(precPr));
        tvWind.setText(DataManagement.convertWindSpeed(windSpeed, degreeVal));
        tvDewP.setText(DataManagement.convertDewPoint(dewPoint, degreeVal));
        tvHumi.setText(DataManagement.convertHumidity(humidity));
        tvVisi.setText(DataManagement.convertVisibility(visibility, degreeVal));
        tvSunr.setText(DataManagement.convertTime(sunrise, timezone));
        tvSuns.setText(DataManagement.convertTime(sunset, timezone));
    }

    protected void extractData() throws JSONException {
        //extract data from MainActivity
        Intent intent=getIntent();
        result= DataManagement.getResult();
        //result=intent.getStringExtra("jsonResult");
        //cityVal=intent.getStringExtra("cityVal");
        stateVal=intent.getStringExtra("stateVal");
        degreeVal=intent.getStringExtra("degreeVal");


        //extract data from json current
        JSONObject jsonObject = new JSONObject(result);
        lon=jsonObject.getString("longitude");
        lat=jsonObject.getString("latitude");
        timezone=jsonObject.getString("timezone");
        sumIcon=jsonObject.getJSONObject("currently").getString("icon");
        summary=jsonObject.getJSONObject("currently").getString("summary");
        temper=jsonObject.getJSONObject("currently").getString("temperature");
        precIn=jsonObject.getJSONObject("currently").getString("precipIntensity");
        precPr=jsonObject.getJSONObject("currently").getString("precipProbability");
        windSpeed=jsonObject.getJSONObject("currently").getString("windSpeed");
        dewPoint=jsonObject.getJSONObject("currently").getString("dewPoint");
        humidity=jsonObject.getJSONObject("currently").getString("humidity");
        visibility=jsonObject.getJSONObject("currently").getString("visibility");

        //extract data from json daily
        JSONObject joDaily=jsonObject.getJSONObject("daily");
        JSONArray jaData=joDaily.getJSONArray("data");
        minT=jaData.getJSONObject(0).getString("temperatureMin");
        maxT=jaData.getJSONObject(0).getString("temperatureMax");
        sunrise=jaData.getJSONObject(0).getString("sunriseTime");
        sunset=jaData.getJSONObject(0).getString("sunsetTime");

        //get cityVal
        cityVal=timezone.replace("America/", "");
        cityVal=cityVal.replace("_", " ");

    }

    private void testData() {
        Log.d(LOG_TAG,cityVal);
        Log.d(LOG_TAG,stateVal);
        Log.d(LOG_TAG,degreeVal);
        Log.d(LOG_TAG,lon);
        Log.d(LOG_TAG,lat);
        Log.d(LOG_TAG,timezone);
        Log.d(LOG_TAG,sumIcon);
        Log.d(LOG_TAG,summary);
        Log.d(LOG_TAG,temper);
        Log.d(LOG_TAG,precIn);
        Log.d(LOG_TAG,precPr);
        Log.d(LOG_TAG,windSpeed);
        Log.d(LOG_TAG,dewPoint);
        Log.d(LOG_TAG,humidity);
        Log.d(LOG_TAG,visibility);
        Log.d(LOG_TAG,minT);
        Log.d(LOG_TAG,maxT);
        Log.d(LOG_TAG,sunrise);
        Log.d(LOG_TAG,sunset);
    }

}
