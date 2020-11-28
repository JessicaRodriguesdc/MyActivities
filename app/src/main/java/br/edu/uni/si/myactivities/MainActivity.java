package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btLogar;
    private Button btCadastrar;
    private TextView tvWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLogar = (Button) findViewById(R.id.btLogar);
        btCadastrar = (Button) findViewById(R.id.btCadastrar);

        tvWeather = (TextView) findViewById(R.id.tvWeather);

        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btLogar(v);
            }
        });
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btCadastrar(v);
            }
        });

        tvWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weather(v);
            }
        });
    }

    public void btLogar(View v){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void btCadastrar(View v){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    public void weather(View v){
        Intent intent = new Intent(this,ViewWeatherActivity.class);
        startActivity(intent);
    }
}