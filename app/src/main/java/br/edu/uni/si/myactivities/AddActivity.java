package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
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

import br.edu.uni.si.myactivities.conn.DatabaseHelper;
import br.edu.uni.si.myactivities.dao.AtividadeDAO;
import br.edu.uni.si.myactivities.model.Atividade;
import br.edu.uni.si.myactivities.model.Pessoa;

public class AddActivity extends AppCompatActivity {

    private SQLiteDatabase mConection;
    private DatabaseHelper mDataHelper;
    private AtividadeDAO atividadeDAO;
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
        createConection();

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
                try {
                    btSalvar(v);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void createConection(){
        try{
            mDataHelper = new DatabaseHelper(this.getApplicationContext());
            mConection = mDataHelper.getWritableDatabase();
            Toast.makeText(this, "Banco criado com sucesso", Toast.LENGTH_SHORT).show();
        }catch(SQLException e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
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

    public void btSalvar(View v) throws ParseException {
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
        this.atividadeDAO =  new AtividadeDAO(mConection);
        this.atividade.setNome(ettNomeAtividade.getText().toString());
        this.atividade.setDescricao(ettDescricaoAtividade.getText().toString());
        this.atividade.setDataInicial(etdDataInicio.getText().toString());
        this.atividade.setDataFinal(etdDataTermino.getText().toString());
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        this.atividade.setPessoa(pessoa);

        this.atividadeDAO.insert(atividade);

        String dataI = etdDataInicio.getText().toString();
        Date dataI_formatada = new Date();
        String dataF = etdDataTermino.getText().toString();
        Date dataF_formatada = new Date();

        try {
            DateFormat formatterI = new SimpleDateFormat("dd/MM/yyyy");
            dataI_formatada = (Date)formatterI.parse(dataI);
        } catch (ParseException e) {
            e.printStackTrace();
        }

         try{
             DateFormat formatterF = new SimpleDateFormat("dd/MM/yyyy");
             dataF_formatada = (Date)formatterF.parse(dataF);
         }catch (ParseException e) {
            e.printStackTrace();
         }


        if(!atividade.toString().isEmpty()){
            if(dataI_formatada.getTime() > dataF_formatada.getTime()){
                Toast.makeText(getApplicationContext(),"Data inicial não pode ser maior que a final",Toast.LENGTH_LONG).show();
                return;
            }
            else{
                Toast.makeText(getApplicationContext(),"Atividade registrada com sucesso!",Toast.LENGTH_LONG).show();
                ibVoltar(v);
            }
        }

    }
}