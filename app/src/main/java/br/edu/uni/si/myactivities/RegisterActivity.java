package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class RegisterActivity extends AppCompatActivity {

    private ImageButton ibVoltar;
    private EditText ettNome;
    private EditText ettEmail;
    private EditText ettPassword;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ibVoltar = (ImageButton) findViewById(R.id.ibVoltar);
        ettNome = (EditText) findViewById(R.id.ettNome);
        ettEmail = (EditText) findViewById(R.id.ettEmail);
        ettPassword = (EditText) findViewById(R.id.ettPassword);
        btLimpar = (Button) findViewById(R.id.btLimpar);

        ibVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibVoltar(v);
            }
        });
        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btLimpar(v);
            }
        });
    }

    public void ibVoltar(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void btLimpar(View v){
        ettNome.setText("");
        ettEmail.setText("");
        ettPassword.setText("");
        ettNome.requestFocus();
    }
}