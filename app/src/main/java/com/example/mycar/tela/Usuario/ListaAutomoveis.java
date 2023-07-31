package com.example.mycar.tela.Usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mycar.R;

public class ListaAutomoveis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_automoveis);
        setTitle("Automóveis");
    }
}