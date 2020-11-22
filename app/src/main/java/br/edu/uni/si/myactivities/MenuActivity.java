package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    private ImageButton ibLogout;
    private ImageButton ibLista;
    private ImageButton ibAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ibLogout = (ImageButton) findViewById(R.id.ibLogout);
        ibLista = (ImageButton) findViewById(R.id.ibLista);
        ibAdd = (ImageButton) findViewById(R.id.ibAdd);

        ibLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibLogout(v);
            }
        });
        ibLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibLista(v);
            }
        });
        ibAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibAdd(v);
            }
        });
    }

    public void ibLogout(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void ibLista(View v){
        Intent intentId = getIntent();
        int idPessoa = (int) intentId.getSerializableExtra("pessoaId");

        Intent intent = new Intent(this,ListActivity.class);
        intent.putExtra("pessoaId",idPessoa);
        startActivity(intent);
    }

    public void ibAdd(View v){
        Intent intentId = getIntent();
        int idPessoa = (int) intentId.getSerializableExtra("pessoaId");

        Intent intent = new Intent(this,AddActivity.class);
        intent.putExtra("pessoaId",idPessoa);
        startActivity(intent);
    }
}