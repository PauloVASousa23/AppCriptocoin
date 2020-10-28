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
import com.pim.criptocoin.adapters.TransacoesAdapter;
import com.pim.criptocoin.model.Carteira;
import com.pim.criptocoin.model.Perfil;
import com.pim.criptocoin.service.HttpService;

import org.json.JSONArray;

import java.util.ArrayList;

public class RelatorioClienteActivity extends AppCompatActivity {

    private ArrayList<Carteira> listaCarteiras;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_cliente2);

        setBottomNavigation(getApplicationContext());
        listaCarteiras = new ArrayList<>();
        bundle = getIntent().getExtras();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONArray jArray = new JSONArray(new HttpService("getCarteira", Integer.parseInt(bundle.getString("Id"))).execute().get());
                    Carteira[] carteiras = new Carteira[jArray.length()];
                    for(int i=0;i<jArray.length();i++){
                        Carteira carteira = new Gson().fromJson(jArray.getJSONObject(i).toString(), Carteira.class);
                        Perfil perfil = new Gson().fromJson((new HttpService("getPerfil", carteira.getPerfil()).execute().get()), Perfil.class);
                        carteira.setNome(perfil.getNome());
                        listaCarteiras.add(carteira);
                    }
                }catch (Exception e){
                    Log.e("ERRO:",e.toString());
                    e.printStackTrace();
                }

                TransacoesAdapter adapterList = new TransacoesAdapter(getApplicationContext(),R.layout.listitem_transacoes_agencia, listaCarteiras);
                ListView listView = findViewById(R.id.listView_transacoes);
                listView.setAdapter(adapterList);

                findViewById(R.id.Imageloading).setVisibility(View.GONE);
            }
        }, 1000);
    }

    public void setBottomNavigation(final Context contexto){

        final Context contextoApp = contexto;

        LinearLayout llBottomConta = findViewById(R.id.llbtnConta);
        LinearLayout llBottomMonitoramento = findViewById(R.id.llbtnMonitoramento);
        LinearLayout llBottomIndicacoes = findViewById(R.id.llbtnIndicacoes);

        llBottomConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp, MovimentarContaActivity.class);
                intent.putExtra("Id", bundle.getString("Id"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contextoApp.startActivity(intent);
            }
        });

        llBottomIndicacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp, IndicacoesClienteActivity.class);
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