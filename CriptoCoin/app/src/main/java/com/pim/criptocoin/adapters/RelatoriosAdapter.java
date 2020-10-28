package com.pim.criptocoin.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.pim.criptocoin.R;
import com.pim.criptocoin.model.Perfil;

import java.util.ArrayList;

public class RelatoriosAdapter extends ArrayAdapter<Perfil> {
    private ArrayList<Perfil> listaPerfil;

    public RelatoriosAdapter(@NonNull Context context, int resource, ArrayList<Perfil> listaPerfil) {
        super(context, resource,listaPerfil);
        this.listaPerfil = listaPerfil;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int clienteIndex = position;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_relatorios_agencia,parent,false);
        }

        TextView matricula = convertView.findViewById(R.id.list_item_relatorio_matricula);
        TextView nome = convertView.findViewById(R.id.list_item_relatorio_nome);
        TextView cpf = convertView.findViewById(R.id.list_item_relatorio_cpf);
        TextView cidade = convertView.findViewById(R.id.list_item_relatorio_cidade);

        matricula.setText(listaPerfil.get(clienteIndex).getId()+"");
        nome.setText(listaPerfil.get(clienteIndex).getNome());
        cpf.setText(listaPerfil.get(clienteIndex).getCpf());
        cidade.setText(listaPerfil.get(clienteIndex).getCidade());

        return convertView;
    }
}

























