package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.DecimalFormat;

import br.edu.uni.si.myactivities.model.Pessoa;

public class RegisterActivity extends AppCompatActivity {

    private ImageButton ibVoltar;
    private EditText ettNome;
    private EditText ettEmail;
    private EditText ettPassword;
    private Button btLimpar;
    private Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ibVoltar = (ImageButton) findViewById(R.id.ibVoltar);
        ettNome = (EditText) findViewById(R.id.ettNome);
        ettEmail = (EditText) findViewById(R.id.ettEmail);
        ettPassword = (EditText) findViewById(R.id.ettPassword);
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
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void btLimpar(View v){
        ettNome.setText("");
        ettEmail.setText("");
        ettPassword.setText("");
        ettNome.requestFocus();
    }

    public void btSalvar(View v){
        if(ettNome.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Campo Nome vazio",Toast.LENGTH_LONG).show();
            ettNome.requestFocus();
            return;
        }
        if(ettEmail.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Campo Email vazio",Toast.LENGTH_LONG).show();
            ettEmail.requestFocus();
            return;
        }
        if(ettPassword.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Campo Senha vazio",Toast.LENGTH_LONG).show();
            ettPassword.requestFocus();
            return;
        }

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(ettNome.getText().toString());
        pessoa.setEmail(ettEmail.getText().toString());
        pessoa.setSenha(ettPassword.getText().toString());

        if(!pessoa.toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Cadastro feito com sucesso! Bem vindo(a) "+pessoa.getNome(),Toast.LENGTH_LONG).show();
            ibVoltar(v);
        }

    }

}