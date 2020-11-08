package br.edu.uni.si.myactivities.dao;

public class ScriptDLL {

    public static String getCreateTablePessoa(){
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE Pessoa (");
        sql.append(" ID INTEGER PRIMARY KEY");
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
        sql.append(" ID INTEGER PRIMARY KEY");
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

    public static String getAtividades(){
        StringBuilder sql = new StringBuilder();
        sql.append("Select ID, Nome, Descricao, DataInicial, DataFinal, PessoaId");
        sql.append(" from Atividade as a");
        sql.append(" INNER JOIN Pessoa as p on p.id = a.PessoaId");
        return sql.toString();
    }

    public static String getAtividade(){
        StringBuilder sql = new StringBuilder();
        sql.append("Select ID, Nome, Descricao, DataInicial, DataFinal, PessoaId");
        sql.append(" from Atividade as a");
        sql.append(" INNER JOIN Pessoa as p on p.id = a.PessoaId");
        sql.append(" where ID = ?");
        return sql.toString();
    }

}
