package br.edu.uni.si.myactivities.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.edu.uni.si.myactivities.model.Pessoa;

public class PessoaDAO {
    SQLiteDatabase mConection;

    public PessoaDAO (SQLiteDatabase mConection){
        this.mConection = mConection;
    }

    public void insert(Pessoa pessoa){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nome",pessoa.getNome());
        contentValues.put("Email",pessoa.getEmail());
        contentValues.put("Senha",pessoa.getSenha());
        mConection.insertOrThrow("Pessoa",null, contentValues);
    }

    public Boolean getEmailPessoa(String email){
        String[] params = new String[1];
        params[0] = String.valueOf(email);
        Cursor result = mConection.rawQuery(ScriptDLL.getEmailPessoa(),params);
        if(result.getCount()>0){
            return true;
        }
        return false;
    }

    public Boolean getLogar(String email ,String senha){
        String[] params = new String[2];
        params[0] = String.valueOf(email);
        params[1] = String.valueOf(senha);
        Cursor result = mConection.rawQuery(ScriptDLL.logar(),params);
        if(result.getCount()>0){
            return true;
        }
        return false;
    }

}
