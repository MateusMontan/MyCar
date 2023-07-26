package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mycar.tela.Login.Cadastro;
import com.example.mycar.tela.Login.Carregamento;
import com.example.mycar.tela.Login.Login;
import com.example.mycar.tela.Servicos.Info_Servicos;
import com.example.mycar.tela.Servicos.ListaServicos;
import com.example.mycar.tela.Usuario.Info_Automoveis;
import com.example.mycar.tela.Usuario.ListaAutomoveis;
import com.example.mycar.tela.Usuario.MenuUsuario;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    }
}