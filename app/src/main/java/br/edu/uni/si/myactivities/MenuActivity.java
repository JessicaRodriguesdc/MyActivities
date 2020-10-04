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
    private ImageView ivLista;
    private ImageView ivAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ibLogout = (ImageButton) findViewById(R.id.ibLogout);

        ibLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibLogout(v);
            }
        });

        ivLista = (ImageView) findViewById(R.id.ivLista);

        ivLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivLista(v);
            }
        });

        ivAdd = (ImageView) findViewById(R.id.ivAdd);

        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivAdd(v);
            }
        });
    }

    public void ibLogout(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void ivLista(View v){
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }

    public void ivAdd(View v){
        Intent intent = new Intent(this,AddActivity.class);
        startActivity(intent);
    }
}