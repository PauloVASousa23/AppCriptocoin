package com.pim.criptocoin.agencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.pim.criptocoin.R;
import com.pim.criptocoin.adapters.TransacoesAdapter;
import com.pim.criptocoin.model.Carteira;
import com.pim.criptocoin.model.Indicacoes;
import com.pim.criptocoin.model.Perfil;
import com.pim.criptocoin.service.PostService;

public class AgenciaActivity extends AppCompatActivity {

    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agencia);

        setBottomNavigation(AgenciaActivity.this);
        bundle = getIntent().getExtras();
        Log.e("ID",bundle.getInt("Id")+"");

        LinearLayout llConsultarCliente = findViewById(R.id.btnClientes_agencia_principal);
        LinearLayout llTransacoes = findViewById(R.id.btnTransacoes_agencia_principal);
        LinearLayout llRelatorios = findViewById(R.id.btnRelatorios_agencia_principal);
        LinearLayout llIndicacoes = findViewById(R.id.btnIndicacoes_agencia_principal);
        LinearLayout llMonitoramento = findViewById(R.id.btnMonitoramento_agencia_principal);

        llConsultarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgenciaActivity.this,ConsultarClienteActivity.class);
                intent.putExtra("Id",bundle.getInt("Id"));
                AgenciaActivity.this.startActivity(intent);
            }
        });

        llTransacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgenciaActivity.this,TransacoesActivity.class);
                intent.putExtra("Id",bundle.getInt("Id"));
                AgenciaActivity.this.startActivity(intent);
            }
        });

        llRelatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgenciaActivity.this,RelatoriosActivity.class);
                intent.putExtra("Id",bundle.getInt("Id"));
                AgenciaActivity.this.startActivity(intent);
            }
        });

        llIndicacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgenciaActivity.this,IndicacoesActivity.class);
                intent.putExtra("Id",bundle.getInt("Id"));
                AgenciaActivity.this.startActivity(intent);
            }
        });

        llMonitoramento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgenciaActivity.this,MonitoramentoActivity.class);
                intent.putExtra("Id",bundle.getInt("Id"));
                AgenciaActivity.this.startActivity(intent);
            }
        });
    }

    public void setBottomNavigation(final Context contexto){

        final Context contextoApp = contexto;

        LinearLayout llBottomCliente = findViewById(R.id.llbtnClientes);
        LinearLayout llBottomTransacoes = findViewById(R.id.llbtnTransacoes);
        LinearLayout llBottomRelatorios = findViewById(R.id.llbtnRelatorios);
        LinearLayout llBottomIndicacoes = findViewById(R.id.llbtnIndicacoes);
        LinearLayout llBottomMonitoramento = findViewById(R.id.llbtnMonitoramento);

        llBottomCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp,ConsultarClienteActivity.class);
                intent.putExtra("Id",bundle.getInt("Id"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contextoApp.startActivity(intent);
            }
        });

        llBottomTransacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp, TransacoesActivity.class);
                intent.putExtra("Id",bundle.getInt("Id"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contextoApp.startActivity(intent);
            }
        });

        llBottomRelatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp,RelatoriosActivity.class);
                intent.putExtra("Id",bundle.getInt("Id"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contextoApp.startActivity(intent);
            }
        });

        llBottomIndicacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp,IndicacoesActivity.class);
                intent.putExtra("Id",bundle.getInt("Id"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contextoApp.startActivity(intent);
            }
        });

        llBottomMonitoramento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp,MonitoramentoActivity.class);
                intent.putExtra("Id",bundle.getInt("Id"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contextoApp.startActivity(intent);
            }
        });

    }
}