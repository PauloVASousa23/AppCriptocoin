package com.pim.criptocoin.model;

public class Permissao {
    private int Id;
    private String PermissaoUsuario;
    private String Descricao;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPermissaoUsuario() {
        return PermissaoUsuario;
    }

    public void setPermissaoUsuario(String permissaoUsuario) {
        PermissaoUsuario = permissaoUsuario;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}
