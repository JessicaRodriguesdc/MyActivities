package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Date;

public class AddActivity extends AppCompatActivity {

    private ImageButton ibVoltar;
    private EditText ettNomeAtividade;
    private EditText ettDescricaoAtividade;
    private EditText etdDataInicio;
    private EditText etdDataTermino;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ibVoltar = (ImageButton) findViewById(R.id.ibVoltar);
        ettNomeAtividade = (EditText) findViewById(R.id.ettNomeAtividade);
        ettDescricaoAtividade = (EditText) findViewById(R.id.ettDescricaoAtividade);
        etdDataInicio = (EditText) findViewById(R.id.etdDataInicio);
        etdDataTermino = (EditText) findViewById(R.id.etdDataTermino);
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
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }

    public void btLimpar(View v){
        ettNomeAtividade.setText("");
        ettDescricaoAtividade.setText("");
        etdDataInicio.setText("");
        etdDataTermino.setText("");
        ettNomeAtividade.requestFocus();
    }
}