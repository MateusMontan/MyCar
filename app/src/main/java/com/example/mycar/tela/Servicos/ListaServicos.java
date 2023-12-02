package com.example.mycar.tela.Servicos;

import static com.example.mycar.classes.Variaveis.database;
import static com.example.mycar.classes.Variaveis.services;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.ServiceState;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
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

    protected boolean filtroAtivado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicos);
        setTitle("Lista de Serviços");
        filtroAtivado = false;
        atualizaAdapter(services);

        LinearLayout linearLayout = findViewById(R.id.posto);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar("1");
            }
        });
    }

    public void filtrar(String tipo){
        String temp = "";
        if(filtroAtivado == false) {
            filtroAtivado = true;
            temp = tipo;
        }else {
            filtroAtivado = false;
        }
        filtrarServicos(temp);
    }

    public void filtrarServicos(String tipo){
        ArrayList<Servicos> servicosFiltrados = new ArrayList<Servicos>();

        boolean hasType = false;
        for (Servicos servico: services ) {

            Log.d("Teste 1","Tipo: " + servico.getTipo().toString());
            if (servico.getTipo().toString() == tipo.toString()) {
                hasType = true;
            }
            if (hasType == true) {
                servicosFiltrados.add(servico);
                hasType = false;
            }
        }

        atualizaAdapter(servicosFiltrados);
    }

    public void atualizaAdapter(ArrayList<Servicos> servicosFiltrados){
        AdapterServicos adapter = new AdapterServicos(this, servicosFiltrados);
        GridView listViewServices = findViewById(R.id.gridview);
        listViewServices.setAdapter(adapter);
    }


}