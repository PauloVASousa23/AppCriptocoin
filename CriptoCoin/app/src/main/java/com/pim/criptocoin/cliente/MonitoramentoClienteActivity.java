package com.pim.criptocoin.cliente;

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

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MonitoramentoClienteActivity extends AppCompatActivity {
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoramento_cliente);

        setBottomNavigation(getApplicationContext());
        bundle = getIntent().getExtras();

        TextView data = findViewById(R.id.textDataAtualizada);
        Date date = new Date();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        cal.setTime(date);
        data.setText(cal.get(Calendar.DAY_OF_MONTH)+"/"+(Integer.parseInt(cal.get(Calendar.MONTH)+"")+1)+"/"+cal.get(Calendar.YEAR) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":" +cal.get(Calendar.MINUTE));

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

            DecimalFormat df2 = new DecimalFormat("#.##");
            volumeBtc.setText(""+ df2.format(Double.parseDouble(jTickerBtc.getString("vol"))));
            valorBtc.setText("R$ "+ df2.format(Double.parseDouble(jTickerBtc.getString("buy"))));
            volumeEth.setText(""+ df2.format(Double.parseDouble(jTickerEth.getString("vol"))));
            valorEth.setText("R$ "+ df2.format(Double.parseDouble(jTickerEth.getString("buy"))));
            volumeLtc.setText(""+ df2.format(Double.parseDouble(jTickerLtc.getString("vol"))));
            valorLtc.setText("R$ "+ df2.format(Double.parseDouble(jTickerLtc.getString("buy"))));

        }catch (Exception e){
            Log.e("Exception",e.getMessage());
        }
    }
    public void setBottomNavigation(final Context contexto){

        final Context contextoApp = contexto;

        LinearLayout llBottomConta = findViewById(R.id.llbtnConta);
        LinearLayout llBottomRelatorios = findViewById(R.id.llbtnRelatorios);
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

    }
}