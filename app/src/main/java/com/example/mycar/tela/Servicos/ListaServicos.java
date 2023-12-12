package com.example.mycar.tela.Servicos;

import static com.example.mycar.classes.Variaveis.database;
import static com.example.mycar.classes.Variaveis.services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
    protected String tempTipoFiltro;

    protected LinearLayout postodegasolina, autoeletrica, mecanica, borracharia, autosocorro,lanternagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicos);
        setTitle("Lista de Serviços");
        filtroAtivado = false;
        atualizaAdapter(services);

        postodegasolina = findViewById(R.id.postodegasolina);
        postodegasolina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar("0",postodegasolina);
            }
        });

        autoeletrica = findViewById(R.id.autoeletrica);
        autoeletrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar("1",autoeletrica);
            }
        });

        mecanica = findViewById(R.id.mecanica);
        mecanica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar("2",mecanica);
            }
        });

        borracharia = findViewById(R.id.borracharia);
        borracharia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar("3",borracharia);
            }
        });

        autosocorro = findViewById(R.id.autosocorro);
        autosocorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar("4",autosocorro);

            }
        });

        lanternagem = findViewById(R.id.lanternagem);
        lanternagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar("5",lanternagem);
            }
        });
    }

    public void filtrar(String tipo, LinearLayout selecionado){
        String temp = "";
        if(filtroAtivado == false || tempTipoFiltro != tipo) {
            selecionar(selecionado, 100);
            filtroAtivado = true;
            tempTipoFiltro = temp = tipo;
        }else {
            limpar();
            filtroAtivado = false;
        }
        Log.d("Teste 2","Temp: "+temp + "Filtro: "+filtroAtivado);
        filtrarServicos(temp);
    }

    public void filtrarServicos(String tipo){
        ArrayList<Servicos> servicosFiltrados = new ArrayList<Servicos>();

        boolean hasType = false;
        for (Servicos servico: services ) {

            Log.d("Teste 2","Tipo: " + servico.getTipo().toString());
            if (servico.getTipo().contains(tipo) ) {
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

    public void limpar(){
        postodegasolina.setBackgroundColor(Color.WHITE);
        autoeletrica.setBackgroundColor(Color.WHITE);
        mecanica.setBackgroundColor(Color.WHITE);
        borracharia.setBackgroundColor(Color.WHITE);
        autosocorro.setBackgroundColor(Color.WHITE);
        lanternagem.setBackgroundColor(Color.WHITE);

    }
    public void selecionar(LinearLayout selecionado, int alpha) {
        limpar();
        // Adicione bordas arredondadas ao layout
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadii(new float[]{20, 20, 20, 20, 20, 20, 20, 20}); // Ajuste os valores conforme necessário
        shape.setColor(ContextCompat.getColor(this, R.color.grey)); // Use o recurso de cor
        shape.setStroke(0, Color.BLACK); // Largura e cor da borda

        // Defina o fundo do layout
        selecionado.setBackground(shape);
    }



}