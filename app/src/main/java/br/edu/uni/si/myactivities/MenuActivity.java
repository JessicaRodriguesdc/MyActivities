package br.edu.uni.si.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    private ImageView ivLogout;
    private ImageView ivLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ivLogout = (ImageView) findViewById(R.id.ivLogout);

        ivLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivLogout(v);
            }
        });

        ivLista = (ImageView) findViewById(R.id.ivLista);

        ivLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivLista(v);
            }
        });
    }

    public void ivLogout(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void ivLista(View v){
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }
}