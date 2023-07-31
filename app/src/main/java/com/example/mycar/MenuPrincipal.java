package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mycar.tela.Servicos.ListaServicos;
import com.example.mycar.tela.Usuario.ListaAutomoveis;

public class MenuPrincipal extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        setTitle("Menu Principal");

        Button buttonServico = findViewById(R.id.buttonServico);
        Button buttonUsuario = findViewById(R.id.buttonUsuario);


        buttonServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ListaServicos.class);
                v.getContext().startActivity(intent);

            }
        });

        buttonUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ListaAutomoveis.class);
                v.getContext().startActivity(intent);

            }
        });


    }
}