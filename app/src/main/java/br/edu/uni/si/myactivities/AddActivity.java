package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.uni.si.myactivities.model.Atividade;

public class AddActivity extends AppCompatActivity {

    private Atividade atividade;
    private ImageButton ibVoltar;
    private EditText ettNomeAtividade;
    private EditText ettDescricaoAtividade;
    private EditText etdDataInicio;
    private EditText etdDataTermino;
    private Button btLimpar;
    private Button btSalvar;

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
        btSalvar = (Button) findViewById(R.id.btSalvar);

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
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btSalvar(v);
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

    public void btSalvar(View v){
        if(ettNomeAtividade.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Campo Nome vazio",Toast.LENGTH_LONG).show();
            ettNomeAtividade.requestFocus();
            return;
        }
        if(ettDescricaoAtividade.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Campo Descrição vazio",Toast.LENGTH_LONG).show();
            ettDescricaoAtividade.requestFocus();
            return;
        }
        if(etdDataInicio.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Campo Data Inicial vazio",Toast.LENGTH_LONG).show();
            etdDataInicio.requestFocus();
            return;
        }
        if(etdDataTermino.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Campo Data Final vazio",Toast.LENGTH_LONG).show();
            etdDataTermino.requestFocus();
            return;
        }



        this.atividade = new Atividade();
        this.atividade.setNome(ettNomeAtividade.getText().toString());
        this.atividade.setDescricao(ettDescricaoAtividade.getText().toString());

        String dataI = etdDataInicio.getText().toString();
        String dataF = etdDataTermino.getText().toString();

        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dataI_formatada = (Date)formatter.parse(dataI);
            this.atividade.setDataInicial(dataI_formatada);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dataF_formatada = (Date)formatter.parse(dataF);
            this.atividade.setDataFinal(dataF_formatada);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        if(!atividade.toString().isEmpty()){
            if(atividade.getDataFinal().getTime() < atividade.getDataInicial().getTime()){
                Toast.makeText(getApplicationContext(),"Data inicial não pode ser menor que a final",Toast.LENGTH_LONG).show();
                return;
            }
            else{
                Toast.makeText(getApplicationContext(),"Atividade registrada com sucesso!",Toast.LENGTH_LONG).show();
                ibVoltar(v);
            }
        }

    }
}