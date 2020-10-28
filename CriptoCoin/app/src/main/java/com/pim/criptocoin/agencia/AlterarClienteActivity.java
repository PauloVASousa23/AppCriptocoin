package com.pim.criptocoin.agencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pim.criptocoin.R;
import com.pim.criptocoin.model.Perfil;
import com.pim.criptocoin.service.PostService;

public class AlterarClienteActivity extends AppCompatActivity {

    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_cliente);

        bundle = getIntent().getExtras();

        final EditText inputNome = findViewById(R.id.inputNome_Alterar_Cliente);
        EditText inputRg = findViewById(R.id.inputRg_Alterar_Cliente);
        EditText inputCpf = findViewById(R.id.inputCpf_Alterar_Cliente);
        final EditText inputEmail = findViewById(R.id.inputEmail_Alterar_Cliente);
        final EditText inputTelefone = findViewById(R.id.inputTelefone_Alterar_Cliente);
        final EditText inputCep = findViewById(R.id.inputCep_Alterar_Cliente);
        final EditText inputEstado = findViewById(R.id.inputEstado_Alterar_Cliente);
        final EditText inputCidade = findViewById(R.id.inputCidade_Alterar_Cliente);
        final EditText inputLogradouro = findViewById(R.id.inputLogradouro_Alterar_Cliente);
        Button btnAtualizar = findViewById(R.id.btnAtualizar_Alterar_Cliente);

        final Perfil perfil = new Perfil();
        perfil.setId(getIntent().getIntExtra("Id",0));
        perfil.setNome(getIntent().getStringExtra("Nome"));
        perfil.setRg(getIntent().getStringExtra("Rg"));
        perfil.setCpf(getIntent().getStringExtra("Cpf"));
        perfil.setEmail(getIntent().getStringExtra("Email"));
        perfil.setTelefone(getIntent().getStringExtra("Telefone"));
        perfil.setCep(getIntent().getStringExtra("Cep"));
        perfil.setBairro(getIntent().getStringExtra("Bairro"));
        perfil.setCidade(getIntent().getStringExtra("Cidade"));
        perfil.setEndereco(getIntent().getStringExtra("Endereco"));
        perfil.setSenha(getIntent().getStringExtra("Senha"));
        perfil.setAgencia(getIntent().getIntExtra("Agencia",0));
        perfil.setPermissao(getIntent().getIntExtra("Permissao",0));

        inputNome.setText(perfil.getNome());
        inputRg.setText(perfil.getRg());
        inputCpf.setText(perfil.getCpf());
        inputEmail.setText(perfil.getEmail());
        inputTelefone.setText(perfil.getTelefone());
        inputCep.setText(perfil.getCep());
        inputEstado.setText(perfil.getBairro());
        inputCidade.setText(perfil.getCidade());
        inputLogradouro.setText(perfil.getEndereco());

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perfil.setNome(inputNome.getText().toString());
                perfil.setEmail(inputEmail.getText().toString());
                perfil.setTelefone(inputTelefone.getText().toString());
                perfil.setCep(inputCep.getText().toString());
                perfil.setBairro(inputEstado.getText().toString());
                perfil.setCidade(inputCidade.getText().toString());
                perfil.setEndereco(inputLogradouro.getText().toString());
                PostService postService = new PostService();
                postService.enviaRequestAtualizarPerfil(perfil,getApplicationContext());
            }
        });
    }
}