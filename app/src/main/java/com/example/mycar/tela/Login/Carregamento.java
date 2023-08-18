package com.example.mycar.tela.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mycar.MenuPrincipal;
import com.example.mycar.R;

public class Carregamento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carregamento);

        Button botaoMenuPrincipal = findViewById(R.id.botaoMenuPrincipal);

        botaoMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Carregamento.this, MenuPrincipal.class);
                startActivity(intent);
            }
        });
    }
}