package com.example.mycar.tela.Servicos;

import static com.example.mycar.classes.Variaveis.cidadeescolhida;
import static com.example.mycar.classes.Variaveis.cidades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.mycar.R;
import com.example.mycar.classes.AdapterServicos;
import com.example.mycar.classes.Servico;

import java.util.ArrayList;
import java.util.List;

public class ListaServicos extends AppCompatActivity {

    protected boolean filtroAtivado;
    protected String tempTipoFiltro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicos);
        setTitle("Lista de Serviços");
        filtroAtivado = false;
        atualizaAdapter(cidadeescolhida.getServicos());

        LinearLayout postodegasolina = findViewById(R.id.postodegasolina);
        postodegasolina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar("0");
            }
        });

        LinearLayout autoeletrica = findViewById(R.id.autoeletrica);
        autoeletrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar("1");
            }
        });

        LinearLayout mecanica = findViewById(R.id.mecanica);
        mecanica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar("2");
            }
        });

        LinearLayout borracharia = findViewById(R.id.borracharia);
        borracharia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar("3");
            }
        });

        LinearLayout autosocorro = findViewById(R.id.autosocorro);
        autosocorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar("4");
            }
        });

        LinearLayout lanternagem = findViewById(R.id.lanternagem);
        lanternagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar("5");
            }
        });
    }

    public void filtrar(String tipo){
        String temp = "";
        if(filtroAtivado == false || tempTipoFiltro != tipo) {
            filtroAtivado = true;
            tempTipoFiltro = temp = tipo;
        }else {
            filtroAtivado = false;
        }
        Log.d("Teste 2","Temp: "+temp + "Filtro: "+filtroAtivado);
        filtrarServicos(temp);
    }

    public void filtrarServicos(String tipo){
        ArrayList<Servico> servicoFiltrados = new ArrayList<Servico>();

        boolean hasType = false;
        for (Servico servico: cidadeescolhida.getServicos() ) {

            Log.d("Teste 2","Tipo: " + servico.getTipo().toString());
            if (servico.getTipo().contains(tipo) ) {
                hasType = true;
            }
            if (hasType == true) {
                servicoFiltrados.add(servico);
                hasType = false;
            }
        }

        atualizaAdapter(servicoFiltrados);
    }

    public void atualizaAdapter(List<Servico> servicoFiltrados){
        AdapterServicos adapter = new AdapterServicos(this, servicoFiltrados);
        GridView listViewServices = findViewById(R.id.gridview);
        listViewServices.setAdapter(adapter);
    }


}