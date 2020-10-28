package com.pim.criptocoin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.pim.criptocoin.R;
import com.pim.criptocoin.model.Carteira;
import com.pim.criptocoin.model.Indicacoes;

import java.util.ArrayList;

public class IndicacoesAdapter extends ArrayAdapter<Indicacoes> {
    private ArrayList<Indicacoes> listaIndicacoes;

    public IndicacoesAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Indicacoes> listaIndicacoes) {
        super(context, resource, listaIndicacoes);
        this.listaIndicacoes = listaIndicacoes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int carteiraIndex = position;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_indicacoes_cliente,parent,false);
        }

        TextView data = convertView.findViewById(R.id.textDataIndicacao);
        TextView criptomoeda = convertView.findViewById(R.id.textCriptomoedaIndicacao);
        TextView observacao = convertView.findViewById(R.id.textObservacaoIndicacao);

        criptomoeda.setText(listaIndicacoes.get(carteiraIndex).getCriptomoeda());
        data.setText(listaIndicacoes.get(carteiraIndex).getData_Indicacao());
        observacao.setText(listaIndicacoes.get(carteiraIndex).getMotivo());

        return convertView;
    }
}
