package com.example.mycar.tela.Servicos;

import static com.example.mycar.classes.Variaveis.database;
import static com.example.mycar.classes.Variaveis.services;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.ServiceState;
import android.util.Log;
import android.widget.ListView;

import com.example.mycar.R;
import com.example.mycar.classes.AdapterServicos;
import com.example.mycar.classes.Servicos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListaServicos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicos);
        setTitle("Lista de Serviços");

        atualizaAdapter();
    }

    public void atualizaAdapter(){
        AdapterServicos adapter = new AdapterServicos(this, services);
        ListView listViewServices = findViewById(R.id.listViewServices);
        listViewServices.setAdapter(adapter);
    }
}