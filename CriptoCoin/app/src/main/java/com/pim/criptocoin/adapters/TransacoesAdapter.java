package com.pim.criptocoin.adapters;

import android.content.Context;
import android.util.Log;
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

import java.util.ArrayList;
import java.util.List;

public class TransacoesAdapter extends ArrayAdapter<Carteira> {
    private ArrayList<Carteira> listaCarteira;

    public TransacoesAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Carteira> listaCarteira) {
        super(context, resource, listaCarteira);
        this.listaCarteira = listaCarteira;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int carteiraIndex = position;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_transacoes_agencia,parent,false);
        }

        TextView criptomoeda = convertView.findViewById(R.id.list_item_transacoes_criptomoeda);
        TextView nome = convertView.findViewById(R.id.list_item_transacoes_nome);
        TextView valor = convertView.findViewById(R.id.list_item_transacoes_valor);
        TextView data = convertView.findViewById(R.id.list_item_transacoes_data);
        LinearLayout card = convertView.findViewById(R.id.list_item_transacoes_card);
        if(listaCarteira.get(carteiraIndex).getOperacao().equals("Compra")){
            card.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.custom_semi_rounded_verde));
        }

        criptomoeda.setText(listaCarteira.get(carteiraIndex).getCriptomoeda());
        nome.setText(listaCarteira.get(carteiraIndex).getNome()+"");
        valor.setText("R$ "+listaCarteira.get(carteiraIndex).getValor()+"");
        data.setText(listaCarteira.get(carteiraIndex).getData());

        return convertView;
    }
}
