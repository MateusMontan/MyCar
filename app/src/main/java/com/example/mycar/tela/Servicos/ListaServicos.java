package com.example.mycar.tela.Servicos;

import static com.example.mycar.classes.Variaveis.database;
import static com.example.mycar.classes.Variaveis.services;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.ServiceState;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import com.example.mycar.R;
import com.example.mycar.classes.AdapterServicos;
import com.example.mycar.classes.Servicos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaServicos extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicos);
        setTitle("Lista de Serviços");

        View view;

        atualizaAdapter("");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizaAdapter("");
            }
        });
    }

    public ArrayList<Servicos> filtrarServicos(ArrayList<Servicos> services, String filtro){
        ArrayList<Servicos> tempServicos = new ArrayList<Servicos>();

        for (Servicos servico: services ) {
            if(servico.)
        }

        return;
    }

    public void atualizaAdapter(String filtro){
        ArrayList<Servicos> servicosFiltrados = filtrarServicos(services, filtro);
        AdapterServicos adapter = new AdapterServicos(this, services);
        GridView listViewServices = findViewById(R.id.gridview);
        listViewServices.setAdapter(adapter);
    }
}