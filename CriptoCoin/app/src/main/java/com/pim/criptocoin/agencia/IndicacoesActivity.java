package com.pim.criptocoin.agencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.pim.criptocoin.R;
import com.pim.criptocoin.model.Indicacoes;
import com.pim.criptocoin.service.PostService;

public class IndicacoesActivity extends AppCompatActivity {

    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicacoes);

        setBottomNavigation(getApplicationContext());
        bundle = getIntent().getExtras();

        final EditText inputData = findViewById(R.id.inputData_cadastrar_indicacao);
        final EditText inputCriptomoeda = findViewById(R.id.inputCriptomoeda_cadastrar_indicacao);
        final EditText inputObservacao = findViewById(R.id.inputObservacao_cadastrar_indicacao);
        Button btnLimpar = findViewById(R.id.btnLimpar_cadastrar_indicacao);
        Button btnCadastra = findViewById(R.id.btnCadastrar_cadastrar_indicacao);

        btnCadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(
                    inputCriptomoeda.getText().toString().length() < 2 ||
                    inputObservacao.getText().toString().length() < 2 ||
                    inputData.getText().toString().length() < 2
                ){
                    Toast.makeText(getApplicationContext(),"Há campo(s) vazio(s)!",Toast.LENGTH_LONG).show();
                }else{
                    Indicacoes indicacao = new Indicacoes();
                    indicacao.setPerfil_Agencia(bundle.getInt("Id"));
                    indicacao.setCriptomoeda(inputCriptomoeda.getText().toString());
                    indicacao.setMotivo(inputObservacao.getText().toString());
                    indicacao.setData_Indicacao(inputData.getText().toString());

                    PostService postService = new PostService();
                    postService.enviaRequestIndicacao(indicacao,getApplicationContext());

                }
            }
        });

    }

    public void setBottomNavigation(final Context contexto){

        final Context contextoApp = contexto;

        LinearLayout llBottomCliente = findViewById(R.id.llbtnClientes);
        LinearLayout llBottomTransacoes = findViewById(R.id.llbtnTransacoes);
        LinearLayout llBottomRelatorios = findViewById(R.id.llbtnRelatorios);
        LinearLayout llBottomMonitoramento = findViewById(R.id.llbtnMonitoramento);

        llBottomCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp,ConsultarClienteActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Id",bundle.getInt("Id"));
                contextoApp.startActivity(intent);
            }
        });

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