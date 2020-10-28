package com.pim.criptocoin.alert;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pim.criptocoin.R;

public class Alerta {
    public void abreAlerta(final Context contexto, String id, String nome, String rg, String cpf, String cidade, String agencia){

        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View viewAlert = inflater.inflate(R.layout.custom_alert_card_info,null);
        TextView idTextView = (TextView) viewAlert.findViewById(R.id.alertCardId);
        TextView nomeTextView = (TextView) viewAlert.findViewById(R.id.alertCardClienteNome);
        TextView rgTextView = (TextView) viewAlert.findViewById(R.id.alertCardRg);
        TextView cpfTextView = (TextView) viewAlert.findViewById(R.id.alertCardCpf);
        TextView cidadeTextView = (TextView) viewAlert.findViewById(R.id.alertCardCidade);
        TextView agenciaTextView = (TextView) viewAlert.findViewById(R.id.alertCardAgencia);
        Button btnFechar = (Button) viewAlert.findViewById(R.id.alertCardClienteFechar);
        idTextView.setText(id);
        nomeTextView.setText(nome);
        rgTextView.setText(rg);
        cpfTextView.setText(cpf);
        cidadeTextView.setText(cidade);
        agenciaTextView.setText(agencia);
        builder.setView(viewAlert);
        final AlertDialog alerta = builder.create();
        alerta.show();

        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerta.cancel();
            }
        });
        /*builder.setMessage("Mensagem de alerta");
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alerta = builder.create();
        alerta.show();*/
    }
}
