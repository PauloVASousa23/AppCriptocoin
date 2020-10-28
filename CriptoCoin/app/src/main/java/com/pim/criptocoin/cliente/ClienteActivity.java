package com.pim.criptocoin.cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pim.criptocoin.R;
import com.pim.criptocoin.agencia.ConsultarClienteActivity;
import com.pim.criptocoin.agencia.IndicacoesActivity;
import com.pim.criptocoin.agencia.MonitoramentoActivity;
import com.pim.criptocoin.agencia.RelatoriosActivity;
import com.pim.criptocoin.agencia.TransacoesActivity;
import com.pim.criptocoin.model.Indicacoes;
import com.pim.criptocoin.service.HttpServiceExterno;

import org.json.JSONObject;

import java.text.DecimalFormat;

public class ClienteActivity extends AppCompatActivity {

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        HorizontalScrollView horizontalScrollView = findViewById(R.id.scrollViewCriptomoedas);
        horizontalScrollView.scrollTo(horizontalScrollView.getWidth()/2,0);

        setBottomNavigation(getApplicationContext());

        Button btnMovimentarConta = findViewById(R.id.btnMovimentarConta);

        bundle = getIntent().getExtras();

        btnMovimentarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IndicacoesClienteActivity.class);
                intent.putExtra("Id", bundle.getString("Id"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);
            }
        });

        try {
            JSONObject jBtc = new JSONObject(new HttpServiceExterno("https://www.mercadobitcoin.net/api/btc/ticker/").execute().get());
            JSONObject jTickerBtc = new JSONObject(jBtc.getString("ticker"));
            JSONObject jEth = new JSONObject(new HttpServiceExterno("https://www.mercadobitcoin.net/api/eth/ticker/").execute().get());
            JSONObject jTickerEth = new JSONObject(jEth.getString("ticker"));
            JSONObject jLtc = new JSONObject(new HttpServiceExterno("https://www.mercadobitcoin.net/api/ltc/ticker/").execute().get());
            JSONObject jTickerLtc = new JSONObject(jLtc.getString("ticker"));
            TextView valorBtc = findViewById(R.id.textValorBtc);
            TextView valorEth = findViewById(R.id.textValorEth);
            TextView valorLtc = findViewById(R.id.textValorLtc);
            DecimalFormat df2 = new DecimalFormat("#.##");
            valorBtc.setText("R$ "+ df2.format(Double.parseDouble(jTickerBtc.getString("buy"))));
            valorEth.setText("R$ "+ df2.format(Double.parseDouble(jTickerEth.getString("buy"))));
            valorLtc.setText("R$ "+ df2.format(Double.parseDouble(jTickerLtc.getString("buy"))));

        }catch (Exception e){
            Log.e("Exception",e.getMessage());
        }
    }
    public void setBottomNavigation(final Context contexto){

        final Context contextoApp = contexto;

        LinearLayout llBottomConta = findViewById(R.id.llbtnConta);
        LinearLayout llBottomRelatorios = findViewById(R.id.llbtnRelatorios);
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

        llBottomRelatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextoApp, RelatorioClienteActivity.class);
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