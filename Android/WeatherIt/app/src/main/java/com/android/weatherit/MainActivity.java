package com.android.weatherit;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MainActivity extends Activity {

    private String awsPhpUrl="http://weatherit-env.elasticbeanstalk.com/index.php";
    private String streetVal;
    private String cityVal;
    private String stateVal;
    private String degreeVal;

    private static String LOG_TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //spinner
        Spinner stateSpinner=(Spinner) findViewById(R.id.spinnerState);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.state_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(adapter);

        Button searchBtn = (Button) findViewById(R.id.btnSearch);
        Button clearBtn = (Button) findViewById(R.id.btnClear);

        final EditText streetET = (EditText) findViewById(R.id.editStrId);
        final EditText cityET = (EditText) findViewById(R.id.editCityId);
        final Spinner stateSp = (Spinner) findViewById(R.id.spinnerState);
        final RadioGroup degreeRG=(RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton degreeBtn=(RadioButton) findViewById(degreeRG.getCheckedRadioButtonId());



        searchBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        streetVal=streetET.getText().toString();
                        cityVal=cityET.getText().toString();
                        stateVal=stateSp.getSelectedItem().toString();
                        degreeVal=degreeBtn.getText().toString();

                        TextView warningTV = (TextView) findViewById(R.id.strWarning);
                        if(streetVal.length()==0){
                            warningTV.setText("Please enter a Street Address");
                        }else if(cityVal.length()==0){
                            warningTV.setText("Please enter a City Address ");
                        }else if(stateVal.equals("Select")){
                            warningTV.setText("Please enter a State Address ");
                        }else {
                           // http://weatherit-env.elasticbeanstalk.com/index.php?street
                            try {
                                streetVal= URLEncoder.encode(streetVal,"utf-8");
                                cityVal=URLEncoder.encode(cityVal,"utf-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                            awsPhpUrl+="?street="+streetVal+"&city="+cityVal+"&state="+stateVal+"&degree="+degreeVal;
                            warningTV.setText("");
                            Log.d(LOG_TAG, streetVal);
                            Log.d(LOG_TAG, cityVal);
                            Log.d(LOG_TAG, stateVal);
                            Log.d(LOG_TAG, degreeVal);
                            Log.d(LOG_TAG,awsPhpUrl);

                            //request json here
                            new LoadJson().execute(awsPhpUrl);
                        }
                    }
                }
        );

        clearBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        streetET.setText("");
                        cityET.setText("");
                        stateSp.setSelection(0);
                        RadioButton fahrenheitRB= (RadioButton) findViewById(R.id.radioFahrenheit);
                        fahrenheitRB.setChecked(true);
                    }
                }
        );
    }


    private class LoadJson extends AsyncTask<String, String, String>{

        private ProgressDialog progressDialog;
        String jsonString;

        @Override
        protected void onPreExecute(){
            Log.d(LOG_TAG,"in PreExecute");
            progressDialog=progressDialog.show(MainActivity.this,"","Loading...",true,true);
            if(!isNetworkAvailable()){
                Log.d(LOG_TAG,"in PreExecute if");
                Toast.makeText(MainActivity.this,"No Internet Available",Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected String doInBackground(String... url) {
            try {
                Log.d(LOG_TAG,"url in backgroud:"+url[0]);
                jsonString = getJsonFromServer(url[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (isCancelled()) return null;
            Log.d(LOG_TAG, "in doInBackground2");
            return jsonString;
        }

        @Override
        protected void onPostExecute(String result){
            progressDialog.dismiss();
            Log.d(LOG_TAG, "in onPostExecute");
            Log.d(LOG_TAG, "result:" + result);
            if(result==null||result.equals("")){
                Log.d(LOG_TAG,"result in if:"+result);
                Toast.makeText(MainActivity.this,"Please try again latter",Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("jsonResult", result);
                startActivity(intent);
            }
        }

        private boolean isNetworkAvailable() {
            Log.d(LOG_TAG,"in isNetworkAvailable");
            /*ConnectivityManager connectivityManager1
                    = (ConnectivityManager) getSystemService(MainActivity.this.CONNECTIVITY_SERVICE);*/
            //NetworkInfo activeNetworkInfo = connectivityManager1.getActiveNetworkInfo();
           // return activeNetworkInfo != null && activeNetworkInfo.isConnected();

            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo!=null && activeNetworkInfo.isConnected();
        }

        private String getJsonFromServer(String url) throws IOException {
            Log.d(LOG_TAG,"url in getJsonFromServer:"+url);
            BufferedReader inputStream=null;
            URL awsUrl=new URL(url);
            URLConnection connection=awsUrl.openConnection();

            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);

            inputStream=new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String result="";
            String temp;
            while((temp=inputStream.readLine())!=null){
                result+=temp;
                Log.d(LOG_TAG,"temp:"+temp);
            }

            Log.d(LOG_TAG,"result:"+result);
            return result;
        }
    }

    public void aboutClickHandler(View view) {
        Intent intent = new Intent(this,AboutActivity.class);
        startActivity(intent);
    }

    public void forecastIoClickHandler(View view) {
        Uri forecastIo = Uri.parse("http://forecast.io/");
        Intent intent = new Intent(Intent.ACTION_VIEW,forecastIo);
        startActivity(intent);
    }
}
