package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    private ImageButton ibVoltar;
    private String[] listaAtvdd = {"Fazer testes de Rede",
            "Verificar chamadas do suporte",
            "Concluir AP1´s",
            "Concluir projetos",
            "Fazer tarefas de casa",
            "Assistir Anime",
            "Desenhar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_list_atvdd,listaAtvdd);

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

    public void ibVoltar(View v){
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }
}