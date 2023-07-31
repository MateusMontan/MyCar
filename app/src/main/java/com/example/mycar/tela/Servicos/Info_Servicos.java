package com.example.mycar.tela.Servicos;

import static com.example.mycar.classes.Variaveis.servicoescolhido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mycar.R;

public class Info_Servicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_servicos);
        setTitle("Informações");
        if(servicoescolhido != null){
            setTitle(servicoescolhido.getNome());
        }

    }
}