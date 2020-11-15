package br.edu.uni.si.myactivities.dao;

public class ScriptDLL {

    public static String getCreateTablePessoa(){
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE Pessoa (");
        sql.append(" ID INTEGER PRIMARY KEY AUTOINCREMENT");
        sql.append(" NOT NULL,");
        sql.append(" Nome TEXT (200) DEFAULT (''),");
        sql.append(" Email TEXT (200) DEFAULT (''),");
        sql.append(" Senha TEXT (200) DEFAULT ('')");
        sql.append(");");
        return sql.toString();
    }

    public static String getCreateTableAtividade(){
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE Atividade (");
        sql.append(" ID INTEGER PRIMARY KEY AUTOINCREMENT");
        sql.append(" NOT NULL,");
        sql.append(" Nome TEXT (200) DEFAULT (''),");
        sql.append(" Descricao TEXT (200) DEFAULT (''),");
        sql.append(" DataInicial TEXT (200) DEFAULT (''),");
        sql.append(" DataFinal TEXT (200) DEFAULT (''),");
        sql.append(" PessoaId INTEGER NOT NULL,");
        sql.append(" FOREIGN KEY (PessoaId)\n" +
                "       REFERENCES Pessoa (ID)");
        sql.append(");");
        return sql.toString();
    }

//    public static String getAtividades(){
//        StringBuilder sql = new StringBuilder();
//        sql.append("Select a.ID, a.Nome, a.Descricao, a.DataInicial, a.DataFinal, a.PessoaId");
//        sql.append(" from Atividade as a");
//        sql.append(" INNER JOIN Pessoa as p on  a.PessoaId = p.id");
//        return sql.toString();
//    }

    public static String getAtividades(){
        StringBuilder sql = new StringBuilder();
        sql.append("Select ID, Nome, Descricao, DataInicial, DataFinal");
        sql.append(" from Atividade");
        return sql.toString();
    }

    public static String getAtividade(){
        StringBuilder sql = new StringBuilder();
        sql.append("Select a.ID, a.Nome, a.Descricao, a.DataInicial, a.DataFinal, a.PessoaId");
        sql.append(" from Atividade as a");
        sql.append(" INNER JOIN Pessoa as p on  a.PessoaId = p.id");
        sql.append(" where ID = ?");
        return sql.toString();
    }

    public static String getIdPessoa(){
        StringBuilder sql = new StringBuilder();
        sql.append("Select ID, Nome, Email");
        sql.append(" from Pessoa as p");
        sql.append(" where ID = ?");
        return sql.toString();
    }

    public static String getEmailPessoa(){
        StringBuilder sql = new StringBuilder();
        sql.append("Select ID, Nome, Email");
        sql.append(" from Pessoa as p");
        sql.append(" where Email = ?");
        return sql.toString();
    }

    public static String logar(){
        StringBuilder sql = new StringBuilder();
        sql.append("Select ID, Email , Senha");
        sql.append(" from Pessoa as p");
        sql.append(" where Email = ? and Senha = ?");
        return sql.toString();
    }

}
