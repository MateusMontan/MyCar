package com.example.mycar.tela.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.mycar.MenuPrincipal;
import com.example.mycar.R;
import com.example.mycar.SplashScreen;
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
        Button botaoLogin = findViewById(R.id.buttonLogar);
        Button botaoCadastro = findViewById(R.id.botaoCadastro);


        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MenuPrincipal.class);
                startActivity(intent);
            }
        });
        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Cadastro.class);
                startActivity(intent);
            }
        });

    }
}