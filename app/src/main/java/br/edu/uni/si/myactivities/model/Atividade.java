package br.edu.uni.si.myactivities.model;

import java.util.Objects;

public class Atividade {

    private int id;
    private String nome;
    private String descricao;
    private String dataInicial;
    private String dataFinal;


    public Atividade() {
    }

    public Atividade(String nome, String descricao, String dataInicial, String dataFinal) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
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


    @Override
    public String toString() {
        return "Atividade{" +
                "id='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
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
                Objects.equals(dataFinal, atividade.dataFinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nome, descricao, dataInicial, dataFinal);
    }
}
