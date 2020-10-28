package com.pim.criptocoin.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.pim.criptocoin.Interfaces.RetrofitSetCarteira;
import com.pim.criptocoin.Interfaces.RetrofitSetConta;
import com.pim.criptocoin.Interfaces.RetrofitSetPerfil;
import com.pim.criptocoin.Interfaces.RetrofitSetPerfilResult;
import com.pim.criptocoin.Interfaces.RetrofitSetPermissao;
import com.pim.criptocoin.admin.AdminActivity;
import com.pim.criptocoin.agencia.AgenciaActivity;
import com.pim.criptocoin.agencia.CadastrarClienteActivity;
import com.pim.criptocoin.cliente.ClienteActivity;
import com.pim.criptocoin.model.Carteira;
import com.pim.criptocoin.model.Conta;
import com.pim.criptocoin.model.Indicacoes;
import com.pim.criptocoin.Interfaces.RetrofitSetIndicacao;
import com.pim.criptocoin.model.Perfil;
import com.pim.criptocoin.model.Permissao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostService {

    Context contexto;

    public void enviaRequestIndicacao(Indicacoes indicacoes, final Context contexto){
        this.contexto = contexto;
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://criptocoinapi.azurewebsites.net/criptocoin/setIndicacao/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        RetrofitSetIndicacao indicacao = retrofit.create(RetrofitSetIndicacao.class);
        Call<Indicacoes> indicacoesCall = indicacao.setIndicacao(indicacoes);

        indicacoesCall.enqueue(new Callback<Indicacoes>() {
            @Override
            public void onResponse(Call<Indicacoes> call, Response<Indicacoes> response) {
                Toast.makeText(contexto,"Deu certo",Toast.LENGTH_LONG);
            }

            @Override
            public void onFailure(Call<Indicacoes> call, Throwable t) {
                //Toast.makeText(contexto,"Deu errado!",Toast.LENGTH_LONG);
            }
        });
    }

    public void enviaRequestCarteira(Carteira carteira, final Context contexto){
        this.contexto = contexto;
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://criptocoinapi.azurewebsites.net/criptocoin/setCarteira/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        RetrofitSetCarteira retrofitCarteira = retrofit.create(RetrofitSetCarteira.class);
        Call<Carteira> carteiraCall = retrofitCarteira.setCarteira(carteira);

        carteiraCall.enqueue(new Callback<Carteira>() {
            @Override
            public void onResponse(Call<Carteira> call, Response<Carteira> response) {

            }

            @Override
            public void onFailure(Call<Carteira> call, Throwable t) {

            }
        });
    }

    public void enviaRequestConta(Conta conta, final Context contexto){
        this.contexto = contexto;
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://criptocoinapi.azurewebsites.net/criptocoin/setContas/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        RetrofitSetConta retrofitConta = retrofit.create(RetrofitSetConta.class);
        Call<Conta> contaCall = retrofitConta.setConta(conta);

        contaCall.enqueue(new Callback<Conta>() {
            @Override
            public void onResponse(Call<Conta> call, Response<Conta> response) {

            }

            @Override
            public void onFailure(Call<Conta> call, Throwable t) {

            }
        });
    }

    public void enviaRequestPermissao(Permissao permissao, final Context contexto){
        this.contexto = contexto;
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://criptocoinapi.azurewebsites.net/criptocoin/setPermissao/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        RetrofitSetPermissao retrofitPermissao = retrofit.create(RetrofitSetPermissao.class);
        Call<Permissao> permissaoCall = retrofitPermissao.setPermissao(permissao);

        permissaoCall.enqueue(new Callback<Permissao>() {
            @Override
            public void onResponse(Call<Permissao> call, Response<Permissao> response) {

            }

            @Override
            public void onFailure(Call<Permissao> call, Throwable t) {

            }
        });
    }

    public void enviaRequestPerfil(Perfil perfil, final Context contexto){
        this.contexto = contexto;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://criptocoinapi.azurewebsites.net/criptocoin/setPerfil/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitSetPerfilResult retrofitSetPerfil = retrofit.create(RetrofitSetPerfilResult.class);
        Call<Boolean> perfilCall = retrofitSetPerfil.setPerfil(perfil);

        perfilCall.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(response.body()){
                    Toast.makeText(contexto,"Cadastrado com sucesso! ",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(contexto,"Erro ao cadastrar! ",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(contexto,"Erro ao enviar requisição!" + t.getMessage(),Toast.LENGTH_LONG).show();
                Log.e("Err",t.getMessage());
            }
        });

        /*perfilCall.enqueue(new Callback<Perfil>() {
            @Override
            public void onResponse(Call<Perfil> call, Response<Perfil> response) {
                Toast.makeText(contexto,"Cadastrado com sucesso!",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Perfil> call, Throwable t) {
                Toast.makeText(contexto,"Erro ao enviar requisição!" + t.getMessage(),Toast.LENGTH_LONG).show();
                Log.e("Err",t.getMessage());
                //Toast.makeText(contexto,"Cadastrado com sucesso!",Toast.LENGTH_LONG).show();
            }
        });

         */
    }

    public void enviaRequestAtualizarPerfil(Perfil perfil, final Context contexto){
        this.contexto = contexto;
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://criptocoinapi.azurewebsites.net/criptocoin/updatePerfil/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        RetrofitSetPerfil retrofitSetPerfil = retrofit.create(RetrofitSetPerfil.class);
        Call<Perfil> perfilCall = retrofitSetPerfil.setPerfil(perfil);

        perfilCall.enqueue(new Callback<Perfil>() {
            @Override
            public void onResponse(Call<Perfil> call, Response<Perfil> response) {
                Toast.makeText(contexto,"Atualizado com sucesso!",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Perfil> call, Throwable t) {
                //Toast.makeText(contexto,"Erro ao enviar requisição!" + t.getMessage(),Toast.LENGTH_LONG).show();
                Toast.makeText(contexto,"Atualizado com sucesso!",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void enviaRequestAutenticarPerfil(Perfil perfil, final Context contexto){
        this.contexto = contexto;
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://criptocoinapi.azurewebsites.net/criptocoin/autenticarPerfil/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        RetrofitSetPerfil retrofitSetPerfil = retrofit.create(RetrofitSetPerfil.class);
        Call<Perfil> perfilCall = retrofitSetPerfil.setPerfil(perfil);

        perfilCall.enqueue(new Callback<Perfil>() {
            @Override
            public void onResponse(Call<Perfil> call, Response<Perfil> response) {
                switch (response.body().getPermissao()){
                    //Não encontrado
                    case 0:
                        Toast.makeText(contexto,"Usuário ou senha incorreta!",Toast.LENGTH_LONG).show();
                        break;
                    //Cliente
                    case 1:
                        Intent intentCliente = new Intent(contexto, ClienteActivity.class);
                        intentCliente.putExtra("Id",response.body().getId()+"");
                        intentCliente.putExtra("Nome",response.body().getNome());
                        intentCliente.putExtra("Rg",response.body().getRg());
                        intentCliente.putExtra("Cpf",response.body().getCpf());
                        intentCliente.putExtra("Email",response.body().getEmail());
                        intentCliente.putExtra("Telefone",response.body().getTelefone());
                        intentCliente.putExtra("Cep",response.body().getCep());
                        intentCliente.putExtra("Bairro",response.body().getBairro());
                        intentCliente.putExtra("Cidade",response.body().getCidade());
                        intentCliente.putExtra("Endereco",response.body().getEndereco());
                        intentCliente.putExtra("Senha",response.body().getSenha());
                        intentCliente.putExtra("Agencia",response.body().getAgencia());
                        intentCliente.putExtra("Permissao",response.body().getPermissao());
                        intentCliente.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        contexto.startActivity(intentCliente);
                        break;
                    //Agencia
                    case 2:
                        Intent intentAgencia = new Intent(contexto, AgenciaActivity.class);
                        Log.e("ID",response.body().getId()+"");
                        intentAgencia.putExtra("Id",response.body().getId());
                        intentAgencia.putExtra("Nome",response.body().getNome());
                        intentAgencia.putExtra("Rg",response.body().getRg());
                        intentAgencia.putExtra("Cpf",response.body().getCpf());
                        intentAgencia.putExtra("Email",response.body().getEmail());
                        intentAgencia.putExtra("Cep",response.body().getCep());
                        intentAgencia.putExtra("Bairro",response.body().getBairro());
                        intentAgencia.putExtra("Cidade",response.body().getCidade());
                        intentAgencia.putExtra("Endereco",response.body().getEndereco());
                        intentAgencia.putExtra("Senha",response.body().getSenha());
                        intentAgencia.putExtra("Agencia",response.body().getAgencia());
                        intentAgencia.putExtra("Permissao",response.body().getPermissao());
                        intentAgencia.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        contexto.startActivity(intentAgencia);
                        break;
                    //Admin
                    case 3:
                        Intent intentAdmin = new Intent(contexto, AdminActivity.class);
                        intentAdmin.putExtra("Id",response.body().getId());
                        intentAdmin.putExtra("Nome",response.body().getNome());
                        intentAdmin.putExtra("Rg",response.body().getRg());
                        intentAdmin.putExtra("Cpf",response.body().getCpf());
                        intentAdmin.putExtra("Email",response.body().getEmail());
                        intentAdmin.putExtra("Cep",response.body().getCep());
                        intentAdmin.putExtra("Bairro",response.body().getBairro());
                        intentAdmin.putExtra("Cidade",response.body().getCidade());
                        intentAdmin.putExtra("Endereco",response.body().getEndereco());
                        intentAdmin.putExtra("Senha",response.body().getSenha());
                        intentAdmin.putExtra("Agencia",response.body().getAgencia());
                        intentAdmin.putExtra("Permissao",response.body().getPermissao());
                        intentAdmin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        contexto.startActivity(intentAdmin);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onFailure(Call<Perfil> call, Throwable t) {
                Log.e("RESPONSE",t.getMessage().toLowerCase());
                Toast.makeText(contexto,"Usuário ou senha incorreta!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
