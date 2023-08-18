package com.example.mycar.tela.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mycar.MenuPrincipal;
import com.example.mycar.R;
import com.example.mycar.SplashScreen;
import com.example.mycar.classes.Variaveis;
import com.example.mycar.tela.Servicos.Info_Servicos;
import com.example.mycar.tela.Servicos.ListaServicos;
import com.example.mycar.tela.Usuario.Info_Automoveis;
import com.example.mycar.tela.Usuario.ListaAutomoveis;
import com.example.mycar.tela.Usuario.MenuUsuario;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Tela de Login");

        // Encontre os botões por seus IDsR.id.botaoTempSpla
        Button botaoTempSplash = findViewById(R.id.botaoTempSplash);
        Button botaoTempCadastro = findViewById(R.id.botaoTempCadastro);
        Button botaoTempCarregamento = findViewById(R.id.botaoTempCarregamento);
        Button botaoInfoServicos = findViewById(R.id.botaoInfoServicos);
        Button botaoListaServicos = findViewById(R.id.botaoListaServicos);
        Button botaoInfoAutomoveis = findViewById(R.id.botaoInfoAutomoveis);
        Button botaoListaAutomoveis = findViewById(R.id.botaoListaAutomoveis);
        Button botaoMenuUsuario = findViewById(R.id.botaoMenuUsuario);


        // Defina o OnClickListener para cada botão
        botaoTempSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SplashScreen.class);
                startActivity(intent);
            }
        });

        botaoTempCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Cadastro.class);
                startActivity(intent);
            }
        });

        botaoTempCarregamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Carregamento.class);
                startActivity(intent);
            }
        });

        botaoInfoServicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Info_Servicos.class);
                startActivity(intent);
            }
        });

        botaoListaServicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, ListaServicos.class);
                startActivity(intent);
            }
        });

        botaoInfoAutomoveis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Info_Automoveis.class);
                startActivity(intent);
            }
        });

        botaoListaAutomoveis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, ListaAutomoveis.class);
                startActivity(intent);
            }
        });

        botaoMenuUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MenuUsuario.class);
                startActivity(intent);
            }
        });
    }
}