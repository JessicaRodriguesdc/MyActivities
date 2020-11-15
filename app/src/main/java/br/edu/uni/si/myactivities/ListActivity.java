package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
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
    private List<String> list;
    private ImageButton ibVoltar;
//    private String[] listaAtvdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        createConection();
        list = getList();
//        listaAtividadeFake();

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_list_atvdd,list);


        ListView listView = (ListView)findViewById(R.id.lvLista);
        listView.setAdapter(adapter);

        ibVoltar = (ImageButton) findViewById(R.id.ibVoltar);

        ibVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibVoltar(v);
            }
        });
    }

    private void createConection(){
        try{
            mDataHelper = new DatabaseHelper(this.getApplicationContext());
            mConection = mDataHelper.getWritableDatabase();
//            Toast.makeText(this, "Banco criado com sucesso", Toast.LENGTH_SHORT).show();
        }catch(SQLException e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }

    public void ibVoltar(View v){
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }


//    private void listaAtividadeFake(){
//        Atividade atd1 = new Atividade("Fazer testes de Rede", "Atividade de rede", "01 - 9 - 2020", "01 - 10 - 2020");
//        Atividade atd2 = new Atividade("Verificar chamadas do suporte", "Atidade da Empresa", "02 - 9 - 2020", "02 - 10 - 2020");
//        Atividade atd3 = new Atividade("Concluir AP1´s", "Provas","02 - 9 - 2020", "02 - 10 - 2020");
//        Atividade atd4 = new Atividade("Concluir projetos", "Projetos Pessoais", "03 - 9 - 2020", "03 - 10 - 2020");
//        Atividade atd5 = new Atividade("Fazer tarefas de casa", "Atividade de casa", "04 - 9 - 2020", "04 - 10 - 2020");
//        Atividade atd6 = new Atividade("Assistir Anime", "Lazer", "05 - 9 - 2020", "05 - 10 - 2020");
//        Atividade atd7 = new Atividade("Desenhar", "Lazer", "06 - 9 - 2020", "06 - 10 - 2020");
//
//        {
//            String[] atividades = {
//                    "Atividade: "+atd1.getNome()+" | Descrição: "+atd1.getNome(),
//                    "Atividade: "+atd2.getNome()+" | Descrição: "+atd2.getNome(),
//                    "Atividade: "+atd3.getNome()+" | Descrição: "+atd3.getNome(),
//                    "Atividade: "+atd4.getNome()+" | Descrição: "+atd4.getNome(),
//                    "Atividade: "+atd5.getNome()+" | Descrição: "+atd5.getNome(),
//                    "Atividade: "+atd6.getNome()+" | Descrição: "+atd6.getNome(),
//                    "Atividade: "+atd7.getNome()+" | Descrição: "+atd7.getNome()
//            };
//            listaAtvdd = atividades;
//        }
//    }


    private List<String> getList() {
        this.atividadeDAO = new AtividadeDAO(mConection);
        List<String> atv = new ArrayList<>();
        List<Atividade> list = atividadeDAO.listAtividades();

        for(Atividade atividade : list) {
            String at= "Id: " + atividade.getId()
                    + " | Nome: " + atividade.getNome()
                    + " | Descrição:" + atividade.getDescricao()
                    + " | Data Inicial: " + atividade.getDataInicial()
                    + " | Data Final:" + atividade.getDataFinal();
            atv.add(at);
        }
        return atv;
    }
}