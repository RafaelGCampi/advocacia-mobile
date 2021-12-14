package com.example.sistema_medeiros.model;

import androidx.annotation.NonNull;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String genero;
    private String dataNasc;
    private String endereco;
    private String profissao;
    private String estadoCivil;
    private String escolaridade;

    public Cliente(){
    }

    public Cliente( String nome, String cpf, String genero, String dataNasc, String endereco, String profissao, String estadoCivil, String escolaridade) {
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.profissao = profissao;
        this.estadoCivil = estadoCivil;
        this.escolaridade = escolaridade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    @NonNull
    @Override
    public String toString() {
        return this.nome+"  -  "+this.cpf;
    }
}
