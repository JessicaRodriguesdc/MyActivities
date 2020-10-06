package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {

    private ImageButton ibVoltar;
    private Button btLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ibVoltar = (ImageButton) findViewById(R.id.ibVoltar);
        btLogar = (Button) findViewById(R.id.btLogar);

        ibVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibVoltar(v);
            }
        });
        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btLogin(v);
            }
        });

    }

    public void ibVoltar(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    public void btLogin(View v){
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }
}