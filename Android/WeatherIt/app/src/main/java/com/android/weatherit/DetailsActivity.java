package com.android.weatherit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
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

/**
 * Created by guangzhou on 11/23/2015.
 */
public class DetailsActivity extends Activity{
    private boolean is24Hours=true; //true: 24 hours, flase: 7days
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        displayDetail();
    }

    private void displayDetail() {
        final RelativeLayout rl24Hours= (RelativeLayout) findViewById(R.id.layout24Hours);
        final RelativeLayout rl7Days= (RelativeLayout) findViewById(R.id.layout7Days);

        Button btn24Hours= (Button) findViewById(R.id.btn24Hours);
        Button btn7Days= (Button) findViewById(R.id.btn7Days);
        rl24Hours.setVisibility(View.VISIBLE);
        rl7Days.setVisibility(View.GONE);

        TableLayout tl24HoursContent = (TableLayout) findViewById(R.id.tableRow24Content);
        for(int i=0;i<25;i++){

            TableRow trcontent = new TableRow(this);
            TableRow.LayoutParams trlp=new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT);
            trcontent.setPadding(convertDp(10),convertDp(10),convertDp(10),convertDp(10));
            trcontent.setLayoutParams(trlp);
            if(i%2==0) {
                trcontent.setBackgroundColor(Color.parseColor("#dddddd"));
            }

            TableRow.LayoutParams param = new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT, 1.0f);

            TextView tv=new TextView(this);
            tv.setText("02:00 AM");
            tv.setGravity(Gravity.LEFT);
            tv.setPadding(0, convertDp(10), 0, 0);
            tv.setTextSize(convertDp(10));
            tv.setTypeface(null, Typeface.BOLD);
            tv.setLayoutParams(param);


            TableRow.LayoutParams param2 = new TableRow.LayoutParams(convertDp(60),
                    convertDp(60), 1.0f);
            ImageView img=new ImageView(this);
            img.setImageResource(R.drawable.rain);
            img.setPadding(convertDp(20),0,0,0);
            //param2.gravity=Gravity.LEFT;
            img.setScaleType(ImageView.ScaleType.FIT_START);
            img.setLayoutParams(param2);


            TextView tv2=new TextView(this);
            tv2.setText("67");
            tv2.setGravity(Gravity.RIGHT);
            tv2.setPadding(0, convertDp(10), 0, 0);
            tv2.setTextSize(convertDp(10));
            tv2.setTypeface(null, Typeface.BOLD);
            tv2.setLayoutParams(param);

            trcontent.addView(tv);
            trcontent.addView(img);
            trcontent.addView(tv2);
            tl24HoursContent.addView(trcontent, i);


        }


        btn24Hours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rl24Hours.setVisibility(View.VISIBLE);
                //rl7Days.setVisibility(View.GONE);
                if(!is24Hours) {
                    crossfade(rl24Hours, rl7Days);
                    is24Hours=true;
                }
            }
        });
        btn7Days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rl24Hours.setVisibility(View.GONE);
                //rl7Days.setVisibility(View.VISIBLE);
                if(is24Hours) {
                    TextView tvContent7 = (TextView) findViewById(R.id.textView4);
                    tvContent7.setText(getString(R.string.str_about));
                    crossfade(rl7Days, rl24Hours);
                    is24Hours=false;
                }
            }
        });
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
