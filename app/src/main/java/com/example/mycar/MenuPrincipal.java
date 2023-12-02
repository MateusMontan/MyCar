package com.example.mycar;

import static com.example.mycar.classes.Variaveis.database;
import static com.example.mycar.classes.Variaveis.services;
import static com.example.mycar.classes.Variaveis.usuarioEscolhido;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.mycar.classes.Servicos;
import com.example.mycar.classes.Usuario;
import com.example.mycar.tela.Servicos.ListaServicos;
import com.example.mycar.tela.Usuario.EditarUsuario;
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

        View ViewAutomoveis = findViewById(R.id.automoveis);
        View ViewServicos = findViewById(R.id.servicos);
        ImageView imagePerfil = findViewById(R.id.perfil);

        imagePerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditarUsuario.class);
                v.getContext().startActivity(intent);
            }
        });


        ViewServicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ListaServicos.class);
                v.getContext().startActivity(intent);

            }
        });

        ViewAutomoveis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ListaAutomoveis.class);
                v.getContext().startActivity(intent);

            }
        });

        database =  FirebaseDatabase.getInstance();

        DatabaseReference UserRef = database.getReference("usuarios").child("maF9VK0I2XeTmUV85RziKVC94za2").child("dados");

        UserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Usuario usuario = snapshot.getValue(Usuario.class);

                    if(usuario != null){
                        usuarioEscolhido = usuario.clone();
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference myRef = database.getReference("servicos");
        services = new ArrayList<>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot servicoSnapshot : dataSnapshot.getChildren()) {
                    Servicos value = servicoSnapshot.getValue(Servicos.class);
                    if (value != null) {
                        services.add(new Servicos(value.getIcon(), value.getNome(),value.getWhatsapp(),value.getX(), value.getY(), value.getEmail(),"1"));
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
