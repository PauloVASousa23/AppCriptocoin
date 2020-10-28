package com.pim.criptocoin.agencia;

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
import com.pim.criptocoin.adapters.ConsultarClientePerfilAdapter;
import com.pim.criptocoin.adapters.RelatoriosAdapter;
import com.pim.criptocoin.model.Perfil;
import com.pim.criptocoin.service.HttpService;

import org.json.JSONArray;

import java.util.ArrayList;

public class RelatoriosActivity extends AppCompatActivity {

    Perfil[] perfil;
    public ArrayList<Perfil> clientesList;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorios);

        setBottomNavigation(getApplicationContext());
        bundle = getIntent().getExtras();

        clientesList = new ArrayList<>();

        //populaArray(matriculas,nome,cpf,cidade);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONArray jArray = new JSONArray(new HttpService("getPerfisAgencia", bundle.getInt("Id")).execute().get());
                    perfil = new Perfil[jArray.length()];
                    for(int i=0;i<jArray.length();i++){
                        Perfil p = new Gson().fromJson(jArray.getJSONObject(i).toString(), Perfil.class);
                        clientesList.add(p);
                    }
                }catch (Exception e){
                    Log.e("ERRO:",e.toString());
                    e.printStackTrace();
                }

                RelatoriosAdapter adapterList = new RelatoriosAdapter(getApplicationContext(),R.layout.listitem_relatorios_agencia, clientesList);
                ListView listView = findViewById(R.id.listView_relatorios);
                listView.setAdapter(adapterList);
                findViewById(R.id.Imageloading).setVisibility(View.GONE);
            }
        }, 1000);

    }

    public void setBottomNavigation(final Context contexto){

        final Context contextoApp = contexto;

        LinearLayout llBottomCliente = findViewById(R.id.llbtnClientes);
        LinearLayout llBottomTransacoes = findViewById(R.id.llbtnTransacoes);
        LinearLayout llBottomIndicacoes = findViewById(R.id.llbtnIndicacoes);
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