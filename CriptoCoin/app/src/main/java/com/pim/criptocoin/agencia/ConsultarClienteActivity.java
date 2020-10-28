package com.pim.criptocoin.agencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.pim.criptocoin.R;
import com.pim.criptocoin.adapters.ConsultarClientePerfilAdapter;
import com.pim.criptocoin.model.Perfil;
import com.pim.criptocoin.service.HttpService;

import org.json.JSONArray;

import java.util.ArrayList;

public class ConsultarClienteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String filtroTipo;
    EditText filtroValor;
    TableRow[] row = new TableRow[10];
    final TextView[] textViewId = new TextView[10];
    final TextView[] textViewNome = new TextView[10];
    final TextView[] textViewCpf = new TextView[10];
    Perfil[] perfil;
    Bundle bundle;

    public ArrayList<Perfil> clientesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_cliente);

        //Glide.with(getApplicationContext()).load(R.mipmap.icone_loading).asGif().into((ImageView) findViewById(R.id.Imageloading));

        setBottomNavigation(getApplicationContext());
        bundle = getIntent().getExtras();

        //Log.e("ID",Integer.parseInt(bundle.getString("Id"))+"");

        Spinner spinnerFiltro = (Spinner) findViewById(R.id.spinnerFiltro_consultar_cliente_agencia);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerIdCpfNome, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFiltro.setAdapter(adapter);

        spinnerFiltro.setOnItemSelectedListener(this);

        //defineCliqueLinha();

        Button btnFiltrar = findViewById(R.id.btnFiltrarConsultarCliente);

        /*btnFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TableLayout table = findViewById(R.id.tblConsultarCliente);
                for(int i=0;i<10;i++){
                    switch (filtroTipo){
                        case "Id":
                            if(!textViewId[i].getText().toString().contains(filtroValor.getText().toString())){
                                table.removeView(row[i]);
                            }
                            break;
                        case "Cpf":
                            break;
                        case "Nome":
                            if(!textViewNome[i].getText().toString().contains(filtroValor.getText().toString())){
                                table.removeView(row[i]);
                            }
                            break;
                    }
                }
            }
        });
        */

        Button btnCadastrar = findViewById(R.id.btnCadastrar_Novo_Cliente_Agencia);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConsultarClienteActivity.this,CadastrarClienteActivity.class);
                intent.putExtra("Id", bundle.getInt("Id"));
                ConsultarClienteActivity.this.startActivity(intent);
            }
        });

        clientesList = new ArrayList<>();

        //populaArray(matriculas,nome,cpf,cidade);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONArray jArray = new JSONArray(new HttpService("getPerfisAgencia",bundle.getInt("Id")).execute().get());
                    perfil = new Perfil[jArray.length()];
                    for(int i=0;i<jArray.length();i++){
                        Perfil p = new Gson().fromJson(jArray.getJSONObject(i).toString(), Perfil.class);
                        clientesList.add(p);
                    }
                }catch (Exception e){
                    Log.e("ERRO:",e.toString());
                    e.printStackTrace();
                }

                ConsultarClientePerfilAdapter adapterList = new ConsultarClientePerfilAdapter(getApplicationContext(),R.layout.listitem_consultar, clientesList);
                ListView listView = findViewById(R.id.listView_consultar_clientes);
                listView.setAdapter(adapterList);
                findViewById(R.id.Imageloading).setVisibility(View.GONE);
            }
        }, 1000);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        filtroValor = (EditText) findViewById(R.id.inputFilter_consultar_cliente_agencia);
        filtroValor.setHint(parent.getItemAtPosition(position).toString());
        filtroTipo = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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