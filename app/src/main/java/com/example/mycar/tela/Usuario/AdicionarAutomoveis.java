package com.example.mycar.tela.Usuario;

import static com.example.mycar.classes.Variaveis.database;
import static com.example.mycar.tela.Usuario.ListaAutomoveis.caminhoes;
import static com.example.mycar.tela.Usuario.ListaAutomoveis.carros;
import static com.example.mycar.tela.Usuario.ListaAutomoveis.motos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.mycar.MenuPrincipal;
import com.example.mycar.R;
import com.example.mycar.classes.Automovel;
import com.example.mycar.tela.Login.Login;
import com.google.firebase.database.DatabaseReference;

public class AdicionarAutomoveis extends AppCompatActivity {

    protected Spinner tipocategoria;

    protected EditText placaEdit, modeloEdit, marcaEdit, corEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_automoveis);
        tipocategoria = findViewById(R.id.spinnerCategoria);
        placaEdit = findViewById(R.id.EditPlaca);
        modeloEdit = findViewById(R.id.EditModelo);
        marcaEdit = findViewById(R.id.EditMarca);
        corEdit = findViewById(R.id.EditCor);
        Button adicionar = findViewById(R.id.buttonInserir);

        Spinner spinnerCategoria = findViewById(R.id.spinnerCategoria);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                new String[]{"Carro", "Moto", "Caminhão"}
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoria.setAdapter(adapter);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String index = "100";
                String tipoVeiculo = "carros"; //Vem do spinner
                String categoria = "B";
                String cor = corEdit.getText().toString();
                String marca = marcaEdit.getText().toString();
                String modelo = modeloEdit.getText().toString();
                String placa = placaEdit.getText().toString();

                Automovel temp = new Automovel(categoria, cor, marca, modelo, placa);

                if (tipoVeiculo == "carros") {
                    carros.add(temp);
                    index = String.valueOf(carros.indexOf(temp));
                } else if (tipoVeiculo == "motos") {
                    motos.add(temp);
                    index = String.valueOf(motos.indexOf(temp));
                } else if (tipoVeiculo == "caminhoes") {
                    caminhoes.add(temp);
                    index = String.valueOf(caminhoes.indexOf(temp));
                }

                String idUsuario = "maF9VK0I2XeTmUV85RziKVC94za2";
                DatabaseReference refAutomovel = database.getReference("usuarios/" + idUsuario + "/automoveis/" + tipoVeiculo);
                DatabaseReference novoAutomovelRef = refAutomovel.child(index);
                novoAutomovelRef.setValue(temp);

                Intent intent = new Intent(AdicionarAutomoveis.this, MenuPrincipal.class);
                startActivity(intent);

                finish();

            }
        });
    }
}