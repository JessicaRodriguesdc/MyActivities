package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class ViewWeatherActivity extends AppCompatActivity {

    private ImageButton ibVoltar;
    private TextView result;
    private final String BASE_URL = "https://api.hgbrasil.com/weather?woeid=455830";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_weather);

        ibVoltar = (ImageButton) findViewById(R.id.ibVoltar);
        ibVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibVoltar(v);
            }
        });

        result = findViewById(R.id.result);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerDay);
        String[] dias = new String[] {
                "Dom","Seg","Ter","Qua","Qui","Sex","Sáb"
        };

// API as vzs puxa os dias em inglês
//        String[] dias = new String[] {
//                "Sun","Mon","Tue","Wed","Thu","Fri","Sat"
//        };

        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,dias);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i,
                                       long l) {
                Log.d("Weather", "" + adapterView.getItemAtPosition(i));
                search(BASE_URL,adapterView.getItemAtPosition(i).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d("Weather", "Nothing selected");
            }
        });
    }

    public void ibVoltar(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void  search(String url, final String dia){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("Weather", "JSON: " + response.toString());
                try{
                    JSONObject obj = new JSONObject(response.toString());
                    JSONObject objResults = obj.getJSONObject("results");
                    JSONArray forecast = objResults.getJSONArray("forecast");

                    String weatherData;
                    String weekday;
                    String description;
                    String condition;
                    String max;
                    String min;

                    String resultText;

                    for(int i=0; i<forecast.length(); i++){

                        weatherData = forecast.getJSONObject(i).getString("date");
                        weekday = forecast.getJSONObject(i).getString("weekday");
                        description = forecast.getJSONObject(i).getString("description");
                        condition = forecast.getJSONObject(i).getString("condition");
                        max = forecast.getJSONObject(i).getString("max");
                        min = forecast.getJSONObject(i).getString("min");

                        if(weekday.equals(dia)){
                            resultText = "Dia : "+weekday+
                                        "\nData : "+weatherData +
                                        "\nDescrição : "+description +
                                        "\nCondição : "+condition +
                                        "\nMáximo : "+max +
                                        "\nMínimo : "+min ;

                            result.setText(resultText);

                        }
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject response) {
                Log.d("Weather", "Request fail! Status code: " + statusCode);
            }
        });
    }
}

