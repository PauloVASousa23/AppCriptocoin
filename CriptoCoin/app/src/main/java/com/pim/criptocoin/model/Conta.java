package com.pim.criptocoin.model;

public class Conta {
    private int Id;
    private String Conta_Numero;
    private String Conta_Agencia;
    private String Banco;
    private float saldo;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getConta_Numero() {
        return Conta_Numero;
    }

    public void setConta_Numero(String conta_Numero) {
        Conta_Numero = conta_Numero;
    }

    public String getConta_Agencia() {
        return Conta_Agencia;
    }

    public void setConta_Agencia(String conta_Agencia) {
        Conta_Agencia = conta_Agencia;
    }

    public String getBanco() {
        return Banco;
    }

    public void setBanco(String banco) {
        Banco = banco;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
