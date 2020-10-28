package com.pim.criptocoin.agencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pim.criptocoin.R;
import com.pim.criptocoin.service.HttpServiceExterno;

import org.json.JSONArray;
import org.json.JSONObject;

public class MonitoramentoActivity extends AppCompatActivity {

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoramento);

        bundle = getIntent().getExtras();

        try {
            JSONObject jBtc = new JSONObject(new HttpServiceExterno("https://www.mercadobitcoin.net/api/btc/ticker/").execute().get());
            JSONObject jTickerBtc = new JSONObject(jBtc.getString("ticker"));
            JSONObject jEth = new JSONObject(new HttpServiceExterno("https://www.mercadobitcoin.net/api/eth/ticker/").execute().get());
            JSONObject jTickerEth = new JSONObject(jEth.getString("ticker"));
            JSONObject jLtc = new JSONObject(new HttpServiceExterno("https://www.mercadobitcoin.net/api/ltc/ticker/").execute().get());
            JSONObject jTickerLtc = new JSONObject(jLtc.getString("ticker"));
            TextView volumeBtc = findViewById(R.id.textVolumeBtc);
            TextView valorBtc = findViewById(R.id.textValorBtc);
            TextView volumeEth = findViewById(R.id.textVolumeEth);
            TextView valorEth = findViewById(R.id.textValorEth);
            TextView volumeLtc = findViewById(R.id.textVolumeLtc);
            TextView valorLtc = findViewById(R.id.textValorLtc);
            volumeBtc.setText(jTickerBtc.getString("vol"));
            valorBtc.setText(jTickerBtc.getString("buy"));
            volumeEth.setText(jTickerEth.getString("vol"));
            valorEth.setText(jTickerEth.getString("buy"));
            volumeLtc.setText(jTickerLtc.getString("vol"));
            valorLtc.setText(jTickerLtc.getString("buy"));

        }catch (Exception e){
            Log.e("Exception",e.getMessage());
        }
        setBottomNavigation(getApplicationContext());
    }

    public void setBottomNavigation(final Context contexto){

        final Context contextoApp = contexto;

        LinearLayout llBottomCliente = findViewById(R.id.llbtnClientes);
        LinearLayout llBottomTransacoes = findViewById(R.id.llbtnTransacoes);
        LinearLayout llBottomRelatorios = findViewById(R.id.llbtnRelatorios);
        LinearLayout llBottomIndicacoes = findViewById(R.id.llbtnIndicacoes);

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

        llBottomIndicacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp,IndicacoesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Id",bundle.getInt("Id"));
                contextoApp.startActivity(intent);
            }
        });

    }
}