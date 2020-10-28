package com.pim.criptocoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pim.criptocoin.admin.AdminActivity;
import com.pim.criptocoin.agencia.AgenciaActivity;
import com.pim.criptocoin.alert.Alerta;
import com.pim.criptocoin.cliente.ClienteActivity;
import com.pim.criptocoin.model.Perfil;
import com.pim.criptocoin.service.PostService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCadastrar = findViewById(R.id.btnCadastrar_Login);
        Button btnEntrar = findViewById(R.id.btnEntrar_Login);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        //autoLoginTeste();
        //Alerta alerta = new Alerta();
        //alerta.abreAlerta(this);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputUsuario = findViewById(R.id.inputUsuario_Login);
                EditText inputSenha = findViewById(R.id.inputSenha_Login);

                Perfil p = new Perfil();
                p.setEmail(inputUsuario.getText().toString());
                p.setSenha(inputSenha.getText().toString());

                PostService postService = new PostService();
                postService.enviaRequestAutenticarPerfil(p,getApplicationContext());

                /*if(inputUsuario.getText().toString().equals("agencia") && inputSenha.getText().toString().equals("123456")){
                    Intent intent = new Intent(MainActivity.this, AgenciaActivity.class);
                    MainActivity.this.startActivity(intent);
                }

                if(inputUsuario.getText().toString().equals("cliente") && inputSenha.getText().toString().equals("123456")){
                    Intent intent = new Intent(MainActivity.this, ClienteActivity.class);
                    MainActivity.this.startActivity(intent);
                }

                if(inputUsuario.getText().toString().equals("admin") && inputSenha.getText().toString().equals("123456")){
                    Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                    MainActivity.this.startActivity(intent);
                }*/

            }
        });

    }

    public void autoLoginTeste(){
        Intent intent = new Intent(MainActivity.this, AgenciaActivity.class);
        MainActivity.this.startActivity(intent);
    }
}