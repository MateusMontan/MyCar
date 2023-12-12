package com.example.mycar.tela.Usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mycar.R;

public class AdicionarAutomoveis extends AppCompatActivity {

    protected Spinner tipocategoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_automoveis);
        tipocategoria = findViewById(R.id.spinnerCategoria);
        View placa = findViewById(R.id.EditPlaca);
        View modelo = findViewById(R.id.EditModelo);
        View marca = findViewById(R.id.EditMarca);
        View cor = findViewById(R.id.EditCor);


        // Referencie o Spinner no código
        Spinner spinnerCategoria = findViewById(R.id.spinnerCategoria);

        // Crie um ArrayAdapter com os itens "CARRO", "MOTO", "CAMINHÃO" e "OUTROS"
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                new String[]{"Carro", "Moto", "Caminhão", "Outros"}
        );

        // Especifique o layout a ser usado quando a lista de escolhas aparecer
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplique o adaptador ao spinner
        spinnerCategoria.setAdapter(adapter);
    }
}