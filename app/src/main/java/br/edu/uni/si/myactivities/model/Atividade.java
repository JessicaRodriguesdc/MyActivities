package br.edu.uni.si.myactivities.model;

import java.util.Date;
import java.util.Objects;

public class Atividade {

    private String nome;
    private String descricao;
    private Date dataInicial;
    private Date dataFinal;

    public Atividade() {
    }

    public Atividade(String nome, String descricao, Date dataInicial, Date dataFinal) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
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

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }


    @Override
    public String toString() {
        return "Atividade{" +
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
        return Objects.equals(nome, atividade.nome) &&
                Objects.equals(descricao, atividade.descricao) &&
                Objects.equals(dataInicial, atividade.dataInicial) &&
                Objects.equals(dataFinal, atividade.dataFinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal);
    }
}
