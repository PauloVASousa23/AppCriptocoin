package com.pim.criptocoin.model;

public class Perfil {
    private int Id;
    private String Nome;
    private String Senha;
    private String Email;
    private String Telefone;
    private String Rg;
    private String Cpf;
    private String Cep;
    private String Cidade;
    private String Bairro;
    private String Endereco;
    //private int Conta;
    private int Agencia;
    private int Permissao;
    private float Saldo;

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float saldo) {
        Saldo = saldo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String rg) {
        Rg = rg;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    /*
    public int getConta() {
        return Conta;
    }

    public void setConta(int conta) {
        Conta = conta;
    }
    */

    public int getAgencia() {
        return Agencia;
    }

    public void setAgencia(int agencia) {
        Agencia = agencia;
    }

    public int getPermissao() {
        return Permissao;
    }

    public void setPermissao(int permissao) {
        Permissao = permissao;
    }
}
