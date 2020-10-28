package com.pim.criptocoin.cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pim.criptocoin.R;
import com.pim.criptocoin.model.Carteira;
import com.pim.criptocoin.service.HttpServiceExterno;
import com.pim.criptocoin.service.PostService;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MovimentarContaActivity extends AppCompatActivity {

    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimentar_conta);

        setBottomNavigation(getApplicationContext());
        bundle = getIntent().getExtras();

        final Bundle bundle = getIntent().getExtras();

        final EditText inputValorBtc = findViewById(R.id.inputValorBtc);
        final EditText inputValorEth = findViewById(R.id.inputValorEth);
        final EditText inputValorLtc = findViewById(R.id.inputValorLtc);
        TextView btnComprarBtc = findViewById(R.id.btnComprarBtc);
        TextView btnVenderBtc = findViewById(R.id.btnVenderBtc);
        TextView btnComprarEth = findViewById(R.id.btnComprarEth);
        TextView btnVenderEth = findViewById(R.id.btnVenderEth);
        TextView btnComprarLtc = findViewById(R.id.btnComprarLtc);
        TextView btnVenderLtc = findViewById(R.id.btnVenderLtc);

        btnComprarBtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Brazil"));
                cal.setTime(data);
                Carteira c = new Carteira();
                c.setValor(Float.parseFloat(inputValorBtc.getText().toString()));
                c.setOperacao("Compra");
                c.setPerfil(Integer.parseInt(bundle.getString("Id")));
                c.setData(cal.get(Calendar.DAY_OF_MONTH)+"/"+(Integer.parseInt(cal.get(Calendar.MONTH)+"")+1)+"/"+cal.get(Calendar.YEAR));
                c.setCriptomoeda("Bitcoin");

                PostService postService = new PostService();
                postService.enviaRequestCarteira(c,getApplicationContext());
            }
        });

        btnVenderBtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Brazil"));
                cal.setTime(data);
                Carteira c = new Carteira();
                c.setValor(Float.parseFloat(inputValorBtc.getText().toString()));
                c.setOperacao("Venda");
                c.setPerfil(Integer.parseInt(bundle.getString("Id")));
                c.setData(cal.get(Calendar.DAY_OF_MONTH)+"/"+(Integer.parseInt(cal.get(Calendar.MONTH)+"")+1)+"/"+cal.get(Calendar.YEAR));
                c.setCriptomoeda("Bitcoin");

                PostService postService = new PostService();
                postService.enviaRequestCarteira(c,getApplicationContext());
            }
        });

        btnComprarEth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Brazil"));
                cal.setTime(data);
                Carteira c = new Carteira();
                c.setValor(Float.parseFloat(inputValorEth.getText().toString()));
                c.setOperacao("Compra");
                c.setPerfil(Integer.parseInt(bundle.getString("Id")));
                c.setData(cal.get(Calendar.DAY_OF_MONTH)+"/"+(Integer.parseInt(cal.get(Calendar.MONTH)+"")+1)+"/"+cal.get(Calendar.YEAR));
                c.setCriptomoeda("Ethereum");

                PostService postService = new PostService();
                postService.enviaRequestCarteira(c,getApplicationContext());
            }
        });

        btnVenderEth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Brazil"));
                cal.setTime(data);
                Carteira c = new Carteira();
                c.setValor(Float.parseFloat(inputValorEth.getText().toString()));
                c.setOperacao("Venda");
                c.setPerfil(Integer.parseInt(bundle.getString("Id")));
                c.setData(cal.get(Calendar.DAY_OF_MONTH)+"/"+(Integer.parseInt(cal.get(Calendar.MONTH)+"")+1)+"/"+cal.get(Calendar.YEAR));
                c.setCriptomoeda("Ethereum");

                PostService postService = new PostService();
                postService.enviaRequestCarteira(c,getApplicationContext());
            }
        });

        btnComprarLtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Brazil"));
                cal.setTime(data);
                Carteira c = new Carteira();
                c.setValor(Float.parseFloat(inputValorLtc.getText().toString()));
                c.setOperacao("Compra");
                c.setPerfil(Integer.parseInt(bundle.getString("Id")));
                c.setData(cal.get(Calendar.DAY_OF_MONTH)+"/"+(Integer.parseInt(cal.get(Calendar.MONTH)+"")+1)+"/"+cal.get(Calendar.YEAR));
                c.setCriptomoeda("Litecoin");

                PostService postService = new PostService();
                postService.enviaRequestCarteira(c,getApplicationContext());
            }
        });

        btnVenderLtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Brazil"));
                cal.setTime(data);
                Carteira c = new Carteira();
                c.setValor(Float.parseFloat(inputValorLtc.getText().toString()));
                c.setOperacao("Venda");
                c.setPerfil(Integer.parseInt(bundle.getString("Id")));
                c.setData(cal.get(Calendar.DAY_OF_MONTH)+"/"+(Integer.parseInt(cal.get(Calendar.MONTH)+"")+1)+"/"+cal.get(Calendar.YEAR));
                c.setCriptomoeda("Litecoin");

                PostService postService = new PostService();
                postService.enviaRequestCarteira(c,getApplicationContext());
            }
        });

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

        LinearLayout llBottomRelatorios = findViewById(R.id.llbtnRelatorios);
        LinearLayout llBottomMonitoramento = findViewById(R.id.llbtnMonitoramento);
        LinearLayout llBottomIndicacoes = findViewById(R.id.llbtnIndicacoes);

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