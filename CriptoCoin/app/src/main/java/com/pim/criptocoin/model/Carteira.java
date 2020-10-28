package com.pim.criptocoin.model;

import java.util.Date;

public class Carteira {
    private int Id;
    private int Perfil;
    private String Criptomoeda;
    private float Valor;
    private String Data;
    private String Operacao;
    private String Nome;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPerfil() {
        return Perfil;
    }

    public void setPerfil(int perfil) {
        Perfil = perfil;
    }

    public String getCriptomoeda() {
        return Criptomoeda;
    }

    public void setCriptomoeda(String criptomoeda) {
        Criptomoeda = criptomoeda;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float valor) {
        Valor = valor;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getOperacao() {
        return Operacao;
    }

    public void setOperacao(String operacao) {
        Operacao = operacao;
    }
}
