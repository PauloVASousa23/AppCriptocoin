package com.pim.criptocoin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pim.criptocoin.model.Perfil;
import com.pim.criptocoin.service.PostService;

public class CadastroActivity extends AppCompatActivity {
    EditText inputUsuario;
    EditText inputRg;
    EditText inputCpf;
    EditText inputEmail;
    EditText inputTelefone;
    EditText inputCep;
    EditText inputEstado;
    EditText inputCidade;
    EditText inputEndereco;
    EditText inputSenha;
    EditText inputReSenha;
    Button btnCadastrar;
    Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inputUsuario = findViewById(R.id.inputUsuario_Cadastro);
        inputRg = findViewById(R.id.inputRg_Cadastro);
        inputCpf = findViewById(R.id.inputCpf_Cadastro);
        inputEmail = findViewById(R.id.inputEmail_Cadastro);
        inputTelefone = findViewById(R.id.inputTelefone_Cadastro);
        inputCep = findViewById(R.id.inputCep_Cadastro);
        inputEstado = findViewById(R.id.inputEstado_Cadastro);
        inputCidade = findViewById(R.id.inputCidade_Cadastro);
        inputEndereco = findViewById(R.id.inputEndereco_Cadastro);
        inputSenha = findViewById(R.id.inputSenha_Cadastro);
        inputReSenha = findViewById(R.id.inputReSenha_Cadastro);
        btnCadastrar = findViewById(R.id.btnCadastrar_Cadastro);
        btnLimpar = findViewById(R.id.btnLimpar_Cadastro);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(
                        inputUsuario.getText().length() < 5 ||
                        inputRg.getText().length() < 5 ||
                        inputCpf.getText().length() < 5 ||
                        inputEmail.getText().length() < 5 ||
                        inputTelefone.getText().length() < 5 ||
                        inputCep.getText().length() < 5 ||
                        inputEstado.getText().length() < 5 ||
                        inputCidade.getText().length() < 5 ||
                        inputEndereco.getText().length() < 5 ||
                        inputSenha.getText().length() < 5 ||
                        inputReSenha.getText().length() < 5
                ){
                    Toast.makeText(getApplicationContext(),"Um dos campos está vazio ou pequeno!",Toast.LENGTH_LONG).show();
                }else{
                    if(inputSenha.getText().toString().equals(inputReSenha.getText().toString())){
                        Perfil p = new Perfil();
                        p.setNome(inputUsuario.getText().toString());
                        p.setRg(inputRg.getText().toString());
                        p.setCpf(inputCpf.getText().toString());
                        p.setEmail(inputEmail.getText().toString());
                        p.setTelefone(inputTelefone.getText().toString());
                        p.setCep(inputCep.getText().toString());
                        p.setBairro(inputEstado.getText().toString());
                        p.setCidade(inputCidade.getText().toString());
                        p.setEndereco(inputEndereco.getText().toString());
                        p.setSenha(inputSenha.getText().toString());
                        p.setPermissao(1);
                        p.setAgencia(1);
                        PostService postService = new PostService();
                        postService.enviaRequestPerfil(p,getApplicationContext());
                    }else{
                        Toast.makeText(getApplicationContext(),"As senhas digitadas não são iguais!",Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }

}