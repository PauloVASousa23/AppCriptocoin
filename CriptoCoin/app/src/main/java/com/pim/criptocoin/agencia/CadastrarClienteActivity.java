package com.pim.criptocoin.agencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.pim.criptocoin.R;
import com.pim.criptocoin.model.Perfil;
import com.pim.criptocoin.service.PostService;

public class CadastrarClienteActivity extends AppCompatActivity {

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cliente);

        setBottomNavigation(getApplicationContext());
        bundle = getIntent().getExtras();

        final EditText inputNome = findViewById(R.id.inputNome_Cadastrar_Cliente);
        final EditText inputRg = findViewById(R.id.inputRg_Cadastrar_Cliente);
        final EditText inputCpf = findViewById(R.id.inputCpf_Cadastrar_Cliente);
        final EditText inputEmail = findViewById(R.id.inputEmail_Cadastrar_Cliente);
        final EditText inputTelefone = findViewById(R.id.inputTelefone_Cadastrar_Cliente);
        final EditText inputCep = findViewById(R.id.inputCep_Cadastrar_Cliente);
        final EditText inputEstado = findViewById(R.id.inputEstado_Cadastrar_Cliente);
        final EditText inputCidade = findViewById(R.id.inputCidade_Cadastrar_Cliente);
        final EditText inputLogradouro = findViewById(R.id.inputLogradouro_Cadastrar_Cliente);
        Button btnLimpar = findViewById(R.id.btnLimpar_Cadastrar_Cliente);
        Button btnCadastrar = findViewById(R.id.btnCadastrar_Cadastrar_Cliente);
        bundle = getIntent().getExtras();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(
                        inputNome.getText().toString().length() < 5 ||
                        inputRg.getText().toString().length() < 5 ||
                        inputCpf.getText().toString().length() < 5 ||
                        inputEmail.getText().toString().length() < 5 ||
                        inputTelefone.getText().toString().length() < 5 ||
                        inputCep.getText().toString().length() < 5 ||
                        inputEstado.getText().toString().length() < 5 ||
                        inputCidade.getText().toString().length() < 5 ||
                        inputLogradouro.getText().toString().length() < 5
                ){
                    Toast.makeText(CadastrarClienteActivity.this,"Algum(s) campo(s) esta vazio!",Toast.LENGTH_LONG).show();
                }else{
                    Perfil perfil = new Perfil();
                    perfil.setId(1);
                    perfil.setAgencia(bundle.getInt("Id"));
                    perfil.setBairro(inputEstado.getText().toString());
                    perfil.setCidade(inputCidade.getText().toString());
                    perfil.setCep(inputCep.getText().toString());
                    perfil.setCpf(inputCpf.getText().toString());
                    perfil.setEmail(inputEmail.getText().toString());
                    perfil.setTelefone(inputTelefone.getText().toString());
                    perfil.setEndereco(inputLogradouro.getText().toString());
                    perfil.setRg(inputRg.getText().toString());
                    perfil.setNome(inputNome.getText().toString());
                    perfil.setPermissao(1);
                    perfil.setSenha(inputCpf.getText().toString().replace(".","").replace(".","").replace(".","").replace(".","").replace(".","").replace(".","").replace(".","").substring(0,6));

                    PostService postService = new PostService();
                    postService.enviaRequestPerfil(perfil,getApplicationContext());
                }
            }
        });
    }

    public void setBottomNavigation(final Context contexto){

        final Context contextoApp = contexto;

        LinearLayout llBottomTransacoes = findViewById(R.id.llbtnTransacoes);
        LinearLayout llBottomRelatorios = findViewById(R.id.llbtnRelatorios);
        LinearLayout llBottomIndicacoes = findViewById(R.id.llbtnIndicacoes);
        LinearLayout llBottomMonitoramento = findViewById(R.id.llbtnMonitoramento);

        llBottomTransacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp, TransacoesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Id",bundle.getInt("Id"));
                contextoApp.startActivity(intent);
            }
        });

        llBottomRelatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp,RelatoriosActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Id",bundle.getInt("Id"));
                contextoApp.startActivity(intent);
            }
        });

        llBottomIndicacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp,IndicacoesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Id",bundle.getInt("Id"));
                contextoApp.startActivity(intent);
            }
        });

        llBottomMonitoramento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp,MonitoramentoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Id",bundle.getInt("Id"));
                contextoApp.startActivity(intent);
            }
        });

    }
}