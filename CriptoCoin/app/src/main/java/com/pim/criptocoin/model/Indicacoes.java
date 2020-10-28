package com.pim.criptocoin.model;

import java.util.Date;

public class Indicacoes {
    private int Id;
    private String Criptomoeda;
    private String Motivo;
    private String Data_Indicacao;
    private int Perfil_Agencia;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCriptomoeda() {
        return Criptomoeda;
    }

    public void setCriptomoeda(String criptomoeda) {
        Criptomoeda = criptomoeda;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String motivo) {
        Motivo = motivo;
    }

    public String getData_Indicacao() {
        return Data_Indicacao;
    }

    public void setData_Indicacao(String data_Indicacao) {
        Data_Indicacao = data_Indicacao;
    }

    public int getPerfil_Agencia() {
        return Perfil_Agencia;
    }

    public void setPerfil_Agencia(int perfil_Agencia) {
        Perfil_Agencia = perfil_Agencia;
    }
}
