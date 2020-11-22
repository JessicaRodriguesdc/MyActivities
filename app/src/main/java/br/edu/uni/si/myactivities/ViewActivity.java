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

import br.edu.uni.si.myactivities.conn.DatabaseHelper;
import br.edu.uni.si.myactivities.dao.AtividadeDAO;
import br.edu.uni.si.myactivities.model.Atividade;

public class ViewActivity extends AppCompatActivity {

    private SQLiteDatabase mConection;
    private DatabaseHelper mDataHelper;
    private AtividadeDAO atividadeDAO;
    private Atividade atividade;
    private int atividadeId;
    private TextView tvAtividade;
    private TextView tvDescricao;
    private TextView tvDataInicio;
    private TextView tvDataTermino;
    private Button btExcluir;
    private Button btEditar;
    private ImageButton ibVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        createConection();

        Intent intent = getIntent();
        atividadeId = (int) intent.getSerializableExtra("id");
        this.atividade = buscarAtividade(atividadeId);

        tvAtividade = (TextView) findViewById(R.id.tvAtividade);
        tvAtividade.setText(atividade.getNome());

        tvDescricao = (TextView) findViewById(R.id.tvDescricao);
        tvDescricao.setText(atividade.getDescricao());

        tvDataInicio = (TextView) findViewById(R.id.tvDataInicio);
        tvDataInicio.setText(atividade.getDataInicial());

        tvDataTermino = (TextView) findViewById(R.id.tvDataTermino);
        tvDataTermino.setText(atividade.getDataFinal());

        ibVoltar = (ImageButton) findViewById(R.id.ibVoltar);

        ibVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibVoltar(v);
            }
        });

        btExcluir = (Button) findViewById(R.id.btExcluir);

        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btExcluir(v,atividade.getId());
            }
        });

        btEditar = (Button) findViewById(R.id.btEditar);

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btEditar(v,atividade.getId());
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
        Intent intent = new Intent(this,ListActivity.class);
        intent.putExtra("pessoaId",atividade.getPessoa().getId());
        startActivity(intent);
    }

    public void btExcluir(View v, int id) {
        this.atividadeDAO =  new AtividadeDAO(mConection);
        this.atividadeDAO.remove(id);
        Toast.makeText(getApplicationContext(),"Atividade: "+this.atividade.getNome()+" excluida com sucesso",
                Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,ListActivity.class);
        intent.putExtra("pessoaId",atividade.getPessoa().getId());
        startActivity(intent);
    }


    public void btEditar(View v, int id) {
        Intent intent = new Intent(this,EditActivity.class);
        intent.putExtra("id",id);
        intent.putExtra("pessoaId",atividadeId);
        startActivity(intent);
    }

    public Atividade buscarAtividade(int id){
        this.atividadeDAO =  new AtividadeDAO(mConection);
        Atividade atividade = this.atividadeDAO.getAtividade(id);
        return atividade;
    }
}