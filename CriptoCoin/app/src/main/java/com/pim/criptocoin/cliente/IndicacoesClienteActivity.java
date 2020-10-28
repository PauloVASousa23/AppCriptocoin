package com.pim.criptocoin.cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.gson.Gson;
import com.pim.criptocoin.R;
import com.pim.criptocoin.adapters.IndicacoesAdapter;
import com.pim.criptocoin.adapters.TransacoesAdapter;
import com.pim.criptocoin.model.Carteira;
import com.pim.criptocoin.model.Indicacoes;
import com.pim.criptocoin.model.Perfil;
import com.pim.criptocoin.service.HttpService;

import org.json.JSONArray;

import java.util.ArrayList;

public class IndicacoesClienteActivity extends AppCompatActivity {

    private ArrayList<Indicacoes> listaIndicacoes;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicacoes_cliente);

        setBottomNavigation(getApplicationContext());

        listaIndicacoes = new ArrayList<>();
         bundle = getIntent().getExtras();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONArray jArray = new JSONArray(new HttpService("getIndicacoes", 0).execute().get());
                    Indicacoes[] indicacoes = new Indicacoes[jArray.length()];
                    for(int i=0;i<jArray.length();i++){
                        Indicacoes indicacao = new Gson().fromJson(jArray.getJSONObject(i).toString(), Indicacoes.class);
                        listaIndicacoes.add(indicacao);
                    }
                }catch (Exception e){
                    Log.e("ERRO:",e.toString());
                    e.printStackTrace();
                }

                IndicacoesAdapter adapterList = new IndicacoesAdapter(getApplicationContext(),R.layout.listitem_indicacoes_cliente, listaIndicacoes);
                ListView listView = findViewById(R.id.listView_indicacoes_cliente);
                listView.setAdapter(adapterList);

            }
        }, 1000);
    }

    public void setBottomNavigation(final Context contexto){

        final Context contextoApp = contexto;

        LinearLayout llBottomConta = findViewById(R.id.llbtnConta);
        LinearLayout llBottomRelatorios = findViewById(R.id.llbtnRelatorios);
        LinearLayout llBottomMonitoramento = findViewById(R.id.llbtnMonitoramento);

        llBottomConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp, MovimentarContaActivity.class);
                intent.putExtra("Id", bundle.getString("Id"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contextoApp.startActivity(intent);
            }
        });

        llBottomRelatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp, RelatorioClienteActivity.class);
                intent.putExtra("Id", bundle.getString("Id"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contextoApp.startActivity(intent);
            }
        });

        llBottomMonitoramento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp, MonitoramentoClienteActivity.class);
                intent.putExtra("Id", bundle.getString("Id"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contextoApp.startActivity(intent);
            }
        });

    }
}