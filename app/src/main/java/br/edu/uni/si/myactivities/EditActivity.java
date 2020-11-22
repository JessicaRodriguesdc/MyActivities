package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.uni.si.myactivities.conn.DatabaseHelper;
import br.edu.uni.si.myactivities.dao.AtividadeDAO;
import br.edu.uni.si.myactivities.model.Atividade;

public class EditActivity extends AppCompatActivity {

    private SQLiteDatabase mConection;
    private DatabaseHelper mDataHelper;
    private AtividadeDAO atividadeDAO;
    private Atividade atividade;
    private TextView ettNomeAtividade;
    private TextView ettDescricaoAtividade;
    private TextView etdDataInicio;
    private TextView etdDataTermino;
    private Button btEditar;
    private ImageButton ibVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        createConection();

        this.atividade = buscarAtividade();

        ibVoltar = (ImageButton) findViewById(R.id.ibVoltar);
        ettNomeAtividade = (TextView) findViewById(R.id.ettNomeAtividade);
        ettNomeAtividade.setText(atividade.getNome());

        ettDescricaoAtividade = (TextView) findViewById(R.id.ettDescricaoAtividade);
        ettDescricaoAtividade.setText(atividade.getDescricao());

        etdDataInicio = (TextView) findViewById(R.id.etdDataInicio);
        etdDataInicio.setText(atividade.getDataInicial());

        etdDataTermino = (TextView) findViewById(R.id.etdDataTermino);
        etdDataTermino.setText(atividade.getDataFinal());

        btEditar = (Button) findViewById(R.id.btEditar);

        ibVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibVoltar(v);
            }
        });
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btEditar(v);
            }
        });

    }

    private void createConection() {
        try {
            mDataHelper = new DatabaseHelper(this.getApplicationContext());
            mConection = mDataHelper.getWritableDatabase();
        } catch (SQLException e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void ibVoltar(View v) {
        Intent intentId = getIntent();
        int idPessoa = (int) intentId.getSerializableExtra("pessoaId");
        int atividadeId = (int) intentId.getSerializableExtra("id");

        Intent intent = new Intent(this,ViewActivity.class);
        intent.putExtra("pessoaId",idPessoa);
        intent.putExtra("id",atividadeId);
        startActivity(intent);
    }

    public Atividade buscarAtividade(){
        Intent intent = getIntent();
        int atividadeIdEdit = (int) intent.getSerializableExtra("id");

        this.atividadeDAO =  new AtividadeDAO(mConection);
        Atividade atividade = this.atividadeDAO.getAtividade(atividadeIdEdit);
        return atividade;
    }

    public void btEditar(View v) {
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

        this.atividadeDAO =  new AtividadeDAO(mConection);
        this.atividade.setNome(ettNomeAtividade.getText().toString());
        this.atividade.setDescricao(ettDescricaoAtividade.getText().toString());
        this.atividade.setDataInicial(etdDataInicio.getText().toString());
        this.atividade.setDataFinal(etdDataTermino.getText().toString());

        this.atividadeDAO.alter(atividade);

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
                Toast.makeText(getApplicationContext(),"Atividade "+atividade.getNome()
                        +" alterada com sucesso!",Toast.LENGTH_LONG).show();
                ibVoltar(v);
            }
        }

    }
}