package br.edu.uni.si.myactivities.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.edu.uni.si.myactivities.model.Atividade;
import br.edu.uni.si.myactivities.model.Pessoa;

public class AtividadeDAO {

    SQLiteDatabase mConection;

    public AtividadeDAO (SQLiteDatabase mConection){
        this.mConection = mConection;
    }

    public void insert(Atividade atividade){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nome",atividade.getNome());
        contentValues.put("Descricao",atividade.getDescricao());
        contentValues.put("DataInicial",atividade.getDataInicial());
        contentValues.put("DataFinal",atividade.getDataFinal());
        contentValues.put("PessoaId",atividade.getPessoa().getId());
        mConection.insertOrThrow("Atividade",null, contentValues);
    }
    public void remove(int id){
        String[] params = new String[1];
        params[0] = String.valueOf(id);
        mConection.delete("Atividade","ID = ?",params);
    }
    public void alter(Atividade atividade,int pessoaId){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nome",atividade.getNome());
        contentValues.put("Descricao",atividade.getDescricao());
        contentValues.put("DataInicial",atividade.getDataInicial());
        contentValues.put("DataFinal",atividade.getDataFinal());
        contentValues.put("PessoaId",pessoaId);
        String[] params = new String[1];
        params[0] = String.valueOf(atividade.getId());
        mConection.update("Atividade",contentValues,"ID = ?",params);

    }

    public List<Atividade> listAtividades(){
        List<Atividade> atividades = new ArrayList<>();
        Cursor result = mConection.rawQuery(ScriptDLL.getAtividades(),null);
        if(result.getCount()>0){
            result.moveToFirst();
            do{
                Atividade atividade = new Atividade();
                Pessoa pessoa = new Pessoa();
                atividade.setId(result.getInt(result.getColumnIndexOrThrow("ID")));
                atividade.setNome(result.getString(result.getColumnIndexOrThrow("Nome")));
                atividade.setDescricao(result.getString(result.getColumnIndexOrThrow("Descricao")));
                atividade.setDataInicial(result.getString(result.getColumnIndexOrThrow("DataInicial")));
                atividade.setDataFinal(result.getString(result.getColumnIndexOrThrow("DataFinal")));
                int idPessoa = (result.getInt(result.getColumnIndexOrThrow("PessoaId")));
                pessoa.setId(idPessoa);
                atividade.setPessoa(pessoa);
                atividades.add(atividade);
            }while(result.moveToNext());
        }
        return atividades;
    }

    public Atividade getAtividade(int id){
        Atividade atividade = new Atividade();
        Pessoa pessoa = new Pessoa();
        String[] params = new String[1];
        params[0] = String.valueOf(id);
        Cursor result = mConection.rawQuery(ScriptDLL.getAtividade(),params);
        if(result.getCount()>0){
            result.moveToFirst();
            atividade.setId(result.getInt(result.getColumnIndexOrThrow("ID")));
            atividade.setNome(result.getString(result.getColumnIndexOrThrow("Nome")));
            atividade.setDescricao(result.getString(result.getColumnIndexOrThrow("Descricao")));
            atividade.setDataInicial(result.getString(result.getColumnIndexOrThrow("DataInicial")));
            atividade.setDataFinal(result.getString(result.getColumnIndexOrThrow("DataFinal")));
            int idPessoa = (result.getInt(result.getColumnIndexOrThrow("PessoaId")));
            pessoa.setId(idPessoa);
            atividade.setPessoa(pessoa);
            return atividade;
        }
        return null;
    }
}
