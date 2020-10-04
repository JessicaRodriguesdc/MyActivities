package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    private ImageView ivVoltar;
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

        ivVoltar = (ImageView) findViewById(R.id.ivVoltar);

        ivVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivVoltar(v);
            }
        });
    }

    public void ivVoltar(View v){
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }
}