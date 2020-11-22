package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.uni.si.myactivities.conn.DatabaseHelper;
import br.edu.uni.si.myactivities.dao.AtividadeDAO;
import br.edu.uni.si.myactivities.model.Atividade;

public class ListActivity extends AppCompatActivity {

    private SQLiteDatabase mConection;
    private DatabaseHelper mDataHelper;
    private AtividadeDAO atividadeDAO;
    private int idPessoa;
    private ImageButton ibVoltar;
    private List<Atividade> atividades;
    private List<Atividade> atividadeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        createConection();

        Intent intent = getIntent();
        idPessoa = (int) intent.getSerializableExtra("pessoaId");
        this.atividadeDAO = new AtividadeDAO(mConection);
        this.atividades = atividadeDAO.listAtividadesIdPessoa(idPessoa);
        this.atividadeList.addAll(atividades);

        ArrayAdapter adapter = new ArrayAdapter<Atividade>(this, R.layout.activity_list_atvdd,atividadeList);

        ListView listView = (ListView) findViewById(R.id.lvLista);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Atividade: " + atividadeList.get(position).getNome(), Toast.LENGTH_SHORT).show();
            }
        });

        ibVoltar = (ImageButton) findViewById(R.id.ibVoltar);

        ibVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibVoltar(v);
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
        Intent intent = new Intent(this,MenuActivity.class);
        intent.putExtra("pessoaId",idPessoa);
        startActivity(intent);
    }

}