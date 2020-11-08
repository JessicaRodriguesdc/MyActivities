package br.edu.uni.si.myactivities.model;

import java.util.List;
import java.util.Objects;

public class Pessoa {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private List<Atividade> atividades;

    public Pessoa() {
    }

    public Pessoa(int id,String nome, String email, String senha, List<Atividade> atividades) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.atividades = atividades;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", atividades='" + atividades + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return  Objects.equals(id, pessoa.id) &&
                Objects.equals(nome, pessoa.nome) &&
                Objects.equals(email, pessoa.email) &&
                Objects.equals(senha, pessoa.senha) &&
                Objects.equals(atividades, pessoa.atividades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nome, email, senha,atividades);
    }
}
