package com.pim.criptocoin.adapters;

import android.content.Context;
import android.content.Intent;
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
import com.pim.criptocoin.agencia.AlterarClienteActivity;
import com.pim.criptocoin.agencia.ConsultarClienteActivity;
import com.pim.criptocoin.model.Perfil;

import java.util.ArrayList;

public class ConsultarClientePerfilAdapter extends ArrayAdapter<Perfil> {
    private ArrayList<Perfil> listaPerfil;

    public ConsultarClientePerfilAdapter(@NonNull Context context, int resource, ArrayList<Perfil> listaPerfil) {
        super(context, resource,listaPerfil);
        this.listaPerfil = listaPerfil;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int clienteIndex = position;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_consultar,parent,false);
        }

        TextView matricula = convertView.findViewById(R.id.list_item_consultar_cliente_matricula);
        TextView nome = convertView.findViewById(R.id.list_item_consultar_cliente_nome);
        TextView cpf = convertView.findViewById(R.id.list_item_consultar_cliente_cpf);
        TextView cidade = convertView.findViewById(R.id.list_item_consultar_cliente_cidade);
        ImageView btnEditar = convertView.findViewById(R.id.list_item_consultar_cliente_btnEditar);

        matricula.setText(listaPerfil.get(clienteIndex).getId()+"");
        nome.setText(listaPerfil.get(clienteIndex).getNome());
        cpf.setText(listaPerfil.get(clienteIndex).getCpf());
        cidade.setText(listaPerfil.get(clienteIndex).getCidade());
        btnEditar.setTag(matricula.getText());
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AlterarClienteActivity.class);
                intent.putExtra("Id",listaPerfil.get(clienteIndex).getId());
                intent.putExtra("Nome",listaPerfil.get(clienteIndex).getNome());
                intent.putExtra("Rg",listaPerfil.get(clienteIndex).getRg());
                intent.putExtra("Cpf",listaPerfil.get(clienteIndex).getCpf());
                intent.putExtra("Email",listaPerfil.get(clienteIndex).getEmail());
                intent.putExtra("Telefone",listaPerfil.get(clienteIndex).getTelefone());
                intent.putExtra("Cep",listaPerfil.get(clienteIndex).getCep());
                intent.putExtra("Bairro",listaPerfil.get(clienteIndex).getBairro());
                intent.putExtra("Cidade",listaPerfil.get(clienteIndex).getCidade());
                intent.putExtra("Endereco",listaPerfil.get(clienteIndex).getEndereco());
                intent.putExtra("Senha",listaPerfil.get(clienteIndex).getSenha());
                intent.putExtra("Agencia",listaPerfil.get(clienteIndex).getAgencia());
                intent.putExtra("Permissao",listaPerfil.get(clienteIndex).getPermissao());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}

























