package com.example.sistema_medeiros.model;

import androidx.annotation.NonNull;

import java.util.Date;

public class Funcionario {

    private Integer id;
    private String nome;
    private String email;
    private Date dataNasc;
    private String tipoAcesso;
    private String login;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(String nome, String email, Date dataNasc, String tipoAcesso, String login, String senha) {
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
        this.tipoAcesso = tipoAcesso;
        this.login = login;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTipoAcesso() {
        return tipoAcesso;
    }

    public void setTipoAcesso(String tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    @NonNull
    @Override
    public String toString() {
        return this.nome+"  -  "+this.tipoAcesso;
    }
}
