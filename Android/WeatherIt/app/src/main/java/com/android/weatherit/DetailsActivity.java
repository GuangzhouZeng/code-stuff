package com.android.weatherit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Assert;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by guangzhou on 11/23/2015.
 */
public class DetailsActivity extends Activity{
    private boolean is24Hours=true; //true: 24 hours, flase: 7days

    private String LOG_TAG="DetailsActivity";

    private String cityVal=DataManagement.getCity();
    private String stateVal=DataManagement.getState();
    private String degreeVal=DataManagement.getDegree();
    private String result=DataManagement.getResult();

    private String timePeriod;
    private String datePeriod;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        try {
            displayDetails();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void displayDetails() throws JSONException {
        TextView tvDetSumm= (TextView) findViewById(R.id.textViewDetailSymmary);
        tvDetSumm.setText("More Details for " + cityVal + ", " + stateVal);
        construct24Hours();
        construct7Days();
        tabToggle();
    }

    private void tabToggle() {
        final RelativeLayout rl24Hours= (RelativeLayout) findViewById(R.id.layout24Hours);
        final RelativeLayout rl7Days= (RelativeLayout) findViewById(R.id.layout7Days);

        Button btn24Hours= (Button) findViewById(R.id.btn24Hours);
        Button btn7Days= (Button) findViewById(R.id.btn7Days);
        rl24Hours.setVisibility(View.VISIBLE);
        rl7Days.setVisibility(View.GONE);

        btn24Hours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rl24Hours.setVisibility(View.VISIBLE);
                //rl7Days.setVisibility(View.GONE);
                if (!is24Hours) {
                    crossfade(rl24Hours, rl7Days);
                    is24Hours = true;
                }
            }
        });
        btn7Days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rl24Hours.setVisibility(View.GONE);
                //rl7Days.setVisibility(View.VISIBLE);
                if (is24Hours) {
                    //TextView tvContent7 = (TextView) findViewById(R.id.textView4);
                    //tvContent7.setText(getString(R.string.str_about));
                    crossfade(rl7Days, rl24Hours);
                    is24Hours = false;
                }
            }
        });
    }

    private void construct24Hours() throws JSONException {
        TableLayout tl24HoursContent = (TableLayout) findViewById(R.id.tableRow24Content);
        JSONObject jsonResult=new JSONObject(result);
        JSONObject jsonHourly=jsonResult.getJSONObject("hourly");
        JSONArray jsonData=jsonHourly.getJSONArray("data");
        timezone=jsonResult.getString("timezone");

        int index=0;
        //display first 24 hours
        index=displayTheHours(index,24,jsonData,tl24HoursContent);
        TextView plusBtn = new TextView(this);
        //display plus icon
        displayPlusIcon(index,plusBtn,tl24HoursContent);

        //plus icon listener
        final int finalIndex = index;
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(DetailsActivity.this,"hello world",Toast.LENGTH_LONG).show();
                Log.d(LOG_TAG, "click plus icon");

                TableLayout tl24HoursContent = (TableLayout) findViewById(R.id.tableRow24Content);
                tl24HoursContent.removeViewAt(finalIndex);  //remove the plus icon first
                try {
                    JSONObject jsonResult = new JSONObject(result);
                    JSONObject jsonHourly=jsonResult.getJSONObject("hourly");
                    JSONArray jsonData=jsonHourly.getJSONArray("data");
                    timezone=jsonResult.getString("timezone");
                    //show next 24 hours
                    displayTheHours(finalIndex, 48, jsonData,tl24HoursContent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //this is ugly, should be improved
    private void displayPlusIcon(int index, TextView plusBtn, TableLayout tl24HoursContent) {
        TableRow plusRow = new TableRow(this);
        TableRow.LayoutParams rowParams=new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        plusRow.setLayoutParams(rowParams);
        //plusRow.setPadding(convertDp(10), convertDp(10), convertDp(10), convertDp(10));

        TableRow.LayoutParams btnParams=new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT,1.0f);
        //TextView plusBtn = new TextView(this);
        //plusBtn.setBackgroundResource(R.drawable.plus);
        plusBtn.setText("+");
        plusBtn.setTextSize(60);
        plusBtn.setTypeface(null, Typeface.BOLD);
        plusBtn.setGravity(Gravity.CENTER);
        //plusBtn.setWidth(convertDp(1));
        //plusBtn.setHeight(convertDp(1));
        plusBtn.setLayoutParams(btnParams);

        TextView tvtemp1=new TextView(this);
        tvtemp1.setLayoutParams(btnParams);
        TextView tvtemp2=new TextView(this);
        tvtemp2.setLayoutParams(btnParams);

        plusRow.addView(tvtemp1);
        plusRow.addView(plusBtn);
        plusRow.addView(tvtemp2);
        tl24HoursContent.addView(plusRow,index);
        if(index%2==0) {
            plusRow.setBackgroundColor(Color.parseColor("#dddddd"));
        }
    }

    //this is ugly, should be modified
    private int displayTheHours(int index, int endIndex, JSONArray jsonData, TableLayout tl24HoursContent) throws JSONException {
        for(;index<endIndex;index++){
            timePeriod=jsonData.getJSONObject(index).getString("time");
            sumIcon=jsonData.getJSONObject(index).getString("icon");
            temper = jsonData.getJSONObject(index).getString("temperature");

            TableRow trcontent = new TableRow(this);
            TableRow.LayoutParams trlp=new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT);
            trcontent.setPadding(convertDp(10),convertDp(10),convertDp(10),convertDp(10));
            trcontent.setLayoutParams(trlp);
            if(index%2==0) {
                trcontent.setBackgroundColor(Color.parseColor("#dddddd"));
            }

            TableRow.LayoutParams param = new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT, 1.0f);

            TextView tv=new TextView(this);
            tv.setText(DataManagement.convertTime(timePeriod,timezone)); //set time
            tv.setGravity(Gravity.LEFT);
            tv.setPadding(0, convertDp(10), 0, 0);
            tv.setTextSize(convertDp(10));
            tv.setTypeface(null, Typeface.BOLD);
            tv.setLayoutParams(param);

            TableRow.LayoutParams param2 = new TableRow.LayoutParams(
                    convertDp(60),
                    convertDp(60), 1.0f);
            ImageView img=new ImageView(this);
            img.setImageResource(DataManagement.convertIcon(this,sumIcon));  //set icon
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setPadding(0, 0, convertDp(20), 0);
            //param2.gravity=Gravity.LEFT;
            img.setLayoutParams(param2);


            TextView tv2=new TextView(this);
            tv2.setText(DataManagement.convertTemp(temper,degreeVal));  //set temperature
            tv2.setGravity(Gravity.RIGHT);
            tv2.setPadding(0, convertDp(10), 0, 0);
            tv2.setTextSize(convertDp(10));
            tv2.setTypeface(null, Typeface.BOLD);
            tv2.setLayoutParams(param);

            trcontent.addView(tv);
            trcontent.addView(img);
            trcontent.addView(tv2);
            tl24HoursContent.addView(trcontent, index);
        }
        Log.d(LOG_TAG,"index="+index);
        return index;

    }

    private void construct7Days() throws JSONException {
        TableLayout tl7DaysContent = (TableLayout) findViewById(R.id.tableRow7Content);
        for(int index=1;index<=7;index++){
            JSONObject jsonObject=new JSONObject(result);
            JSONObject jsonDaily=jsonObject.getJSONObject("daily");
            JSONArray jsonData=jsonDaily.getJSONArray("data");
            minT=jsonData.getJSONObject(index).getString("temperatureMin");
            maxT=jsonData.getJSONObject(index).getString("temperatureMax");
            timePeriod=jsonData.getJSONObject(index).getString("time");
            sumIcon=jsonData.getJSONObject(index).getString("icon");

            TableRow tr7content = new TableRow(this);
            TableLayout.LayoutParams tr7contentParams=new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.WRAP_CONTENT,
                    TableLayout.LayoutParams.WRAP_CONTENT);

            tr7contentParams.setMargins(convertDp(10), convertDp(10), convertDp(10), convertDp(10));
            tr7content.setLayoutParams(tr7contentParams);

            int color_int=14548991+index*36-index*376256;
            String color_string =Integer.toHexString(color_int);
            color_string="#"+color_string;
            //Log.d(LOG_TAG, index+": "+color_string);

            //tr7content.setBackgroundColor(Color.parseColor("#dddddd")); //set color here
            tr7content.setBackgroundColor(Color.parseColor(color_string));

            RelativeLayout relativeLayout=new RelativeLayout(this);
            TableRow.LayoutParams relativeParams = new TableRow.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    convertDp(80));
            relativeLayout.setLayoutParams(relativeParams);

            TextView tv1=new TextView(this);
            tv1.setText(DataManagement.convertTimeToDate(timePeriod,timezone)); //set data here
            tv1.setTextSize(20);
            tv1.setTypeface(null, Typeface.BOLD);
            RelativeLayout.LayoutParams tv1Params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            tv1Params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            tv1Params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            tv1.setPadding(convertDp(10), convertDp(10), convertDp(10), convertDp(10));
            tv1.setLayoutParams(tv1Params);

            TextView tv2=new TextView(this);
            tv2.setText(DataManagement.convertMinMax(minT,maxT));  //set Min T and Max T here
            tv2.setTextSize(20);
            tv2.setTypeface(null, Typeface.BOLD);
            RelativeLayout.LayoutParams tv2Params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            tv2Params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            tv2Params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            tv2.setPadding(convertDp(10), convertDp(10), convertDp(10), convertDp(10));
            tv2.setLayoutParams(tv2Params);

            ImageView img=new ImageView(this);
            img.setImageResource(DataManagement.convertIcon(this,sumIcon));   //set icon here
            RelativeLayout.LayoutParams imgParams = new RelativeLayout.LayoutParams(
                    convertDp(50),
                    convertDp(50));
            imgParams.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE);
            imgParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
            imgParams.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
            imgParams.setMargins(0,convertDp(10),convertDp(40),0);
            img.setLayoutParams(imgParams);

            relativeLayout.addView(tv1);
            relativeLayout.addView(tv2);
            relativeLayout.addView(img);

            tr7content.addView(relativeLayout);
            tl7DaysContent.addView(tr7content,index-1);
        }
    }

    private int convertDp(int sizeInDp){
        float scale = getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (sizeInDp*scale + 0.5f);
        return dpAsPixels;
    }

    private void crossfade(View mContentView, final View mLoadingView) {

        // Retrieve and cache the system's default "short" animation time.
        int mShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_shortAnimTime);
        // Set the content view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        mContentView.setAlpha(0f);
        mContentView.setVisibility(View.VISIBLE);

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        mContentView.animate()
                .alpha(1f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);

        // Animate the loading view to 0% opacity. After the animation ends,
        // set its visibility to GONE as an optimization step (it won't
        // participate in layout passes, etc.)
        mLoadingView.animate()
                .alpha(0f)
                .setDuration(mShortAnimationDuration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mLoadingView.setVisibility(View.GONE);
                    }
                });
    }
}
