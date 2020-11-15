package br.edu.uni.si.myactivities.model;

import java.util.Objects;

public class Atividade {

    private int id;
    private String nome;
    private String descricao;
    private String dataInicial;
    private String dataFinal;
    private Pessoa pessoa;


    public Atividade() {
    }

    public Atividade(int id, String nome, String descricao, String dataInicial, String dataFinal,Pessoa pessoa) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicial=" + dataInicial + '\'' +
                ", dataFinal=" + dataFinal + '\'' +
                ", pessoa=" + pessoa + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return  Objects.equals(id, atividade.id) &&
                Objects.equals(nome, atividade.nome) &&
                Objects.equals(descricao, atividade.descricao) &&
                Objects.equals(dataInicial, atividade.dataInicial) &&
                Objects.equals(dataFinal, atividade.dataFinal) &&
                Objects.equals(pessoa, atividade.pessoa);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nome, descricao, dataInicial, dataFinal,pessoa);
    }
}
