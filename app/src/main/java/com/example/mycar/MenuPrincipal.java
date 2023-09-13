package com.example.mycar;

import static com.example.mycar.classes.Variaveis.database;
import static com.example.mycar.classes.Variaveis.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mycar.classes.Servicos;
import com.example.mycar.tela.Servicos.ListaServicos;
import com.example.mycar.tela.Usuario.ListaAutomoveis;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        setTitle("Menu Principal");

        Button ButtonServicos = findViewById(R.id.buttonServicos);
        Button buttonUsuario = findViewById(R.id.buttonUsuario);

        ButtonServicos.setOnClickListener(new View.OnClickListener() {
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

        database =  FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("servicos");
        services = new ArrayList<>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot servicoSnapshot : dataSnapshot.getChildren()) {
                    Servicos value = servicoSnapshot.getValue(Servicos.class);
                    if (value != null) {
                        services.add(new Servicos(value.getIcon(), value.getNome(),value.getWhatsapp(),value.getX(), value.getY()));
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TESTE", "Failed to read value.", error.toException());
            }
        });


    }
}
