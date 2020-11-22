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

import br.edu.uni.si.myactivities.conn.DatabaseHelper;
import br.edu.uni.si.myactivities.dao.AtividadeDAO;
import br.edu.uni.si.myactivities.dao.PessoaDAO;
import br.edu.uni.si.myactivities.model.Pessoa;

public class LoginActivity extends AppCompatActivity {

    private SQLiteDatabase mConection;
    private DatabaseHelper mDataHelper;
    private PessoaDAO pessoaDAO;
    private ImageButton ibVoltar;
    private EditText ettLogin;
    private EditText ettPassword;;
    private Button btLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createConection();

        ibVoltar = (ImageButton) findViewById(R.id.ibVoltar);
        ettLogin = (EditText) findViewById(R.id.ettLogin);
        ettPassword = (EditText) findViewById(R.id.ettPassword);
        btLogar = (Button) findViewById(R.id.btLogar);

        ibVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibVoltar(v);
            }
        });
        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btLogin(v);
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
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    public void btLogin(View v){
        this.pessoaDAO =  new PessoaDAO(mConection);

        String login = ettLogin.getText().toString();
        String senha = ettPassword.getText().toString();

        Boolean exist = this.pessoaDAO.getLogar(login,senha);

        Pessoa pessoa = this.pessoaDAO.getIdByEmail(login);

        if(ettLogin.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Campo Login vazio",Toast.LENGTH_LONG).show();
            ettLogin.requestFocus();
            return;
        }
        if(ettPassword.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Campo Senha vazio",Toast.LENGTH_LONG).show();
            ettPassword.requestFocus();
            return;
        }

        if(exist == false){
            Toast.makeText(getApplicationContext(),"Usuario ou Senha invalida",Toast.LENGTH_LONG).show();
            ettLogin.requestFocus();
            return;
        }

        Intent intent = new Intent(this,MenuActivity.class);
        intent.putExtra("pessoaId",pessoa.getId());
        startActivity(intent);
    }
}