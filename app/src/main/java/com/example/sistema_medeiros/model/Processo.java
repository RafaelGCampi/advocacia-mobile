package com.example.sistema_medeiros.model;

import androidx.annotation.NonNull;

public class Processo {
    private Integer id;
    private String nome;
    private String tipoProcesso;
    private String situacao;
    private String observacao;
    public Processo(){

    }

    public Processo(String nome, String tipoProcesso, String situacao, String observacao) {
        this.nome = nome;
        this.tipoProcesso = tipoProcesso;
        this.situacao = situacao;
        this.observacao = observacao;
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

    public String getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(String tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    @NonNull
    @Override
    public String toString() {
        return this.nome+"  -  "+this.tipoProcesso;
    }
}

