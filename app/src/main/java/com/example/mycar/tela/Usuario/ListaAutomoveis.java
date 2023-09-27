package com.example.mycar.tela.Usuario;

import static com.example.mycar.classes.Variaveis.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.mycar.R;
import com.example.mycar.classes.AdapterAutomoveis;
import com.example.mycar.classes.Automovel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListaAutomoveis extends AppCompatActivity {

    public static ArrayList<Automovel> carros;
    public static ArrayList<Automovel> caminhoes;
    public static ArrayList<Automovel> motos;

    ListView listViewCaminhoes;
    ListView listViewCarros;
    ListView listViewMotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_automoveis);
        setTitle("Lista de Automóveis");


        listViewCarros = findViewById(R.id.listViewCarros);
        listViewCaminhoes = findViewById(R.id.listViewCaminhoes);
        listViewMotos = findViewById(R.id.listViewMotos);

        database =  FirebaseDatabase.getInstance();

        DatabaseReference reference_carros = database.getReference("usuarios/maF9VK0I2XeTmUV85RziKVC94za2/automoveis/carros");
        carros = new ArrayList<>();

        DatabaseReference reference_caminhoes = database.getReference("usuarios/maF9VK0I2XeTmUV85RziKVC94za2/automoveis/caminhoes");
        caminhoes = new ArrayList<>();

        DatabaseReference reference_motos = database.getReference("usuarios/maF9VK0I2XeTmUV85RziKVC94za2/automoveis/motos");
        motos = new ArrayList<>();


        reference_carros.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot servicoSnapshot : dataSnapshot.getChildren()) {
                    Automovel value = servicoSnapshot.getValue(Automovel.class);
                    if (value != null) {
                        carros.add(new Automovel(value.getCategoria(),value.getCor(),value.getMarca(),
                                value.getModelo(),value.getPlaca()));
                    }
                }
                atualizaCarrosAdapter();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TESTE", "Failed to read value.", error.toException());
            }
        });

        reference_caminhoes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot servicoSnapshot : dataSnapshot.getChildren()) {
                    Automovel value = servicoSnapshot.getValue(Automovel.class);
                    if (value != null) {
                        caminhoes.add(new Automovel(value.getCategoria(),value.getCor(),value.getMarca(),
                                value.getModelo(),value.getPlaca()));
                    }
                }
                atualizaCaminhoesAdapter();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TESTE", "Failed to read value.", error.toException());
            }
        });

        reference_motos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot servicoSnapshot : dataSnapshot.getChildren()) {
                    Automovel value = servicoSnapshot.getValue(Automovel.class);
                    if (value != null) {
                        motos.add(new Automovel(value.getCategoria(),value.getCor(),value.getMarca(),
                                value.getModelo(),value.getPlaca()));
                    }
                }
                atualizaMotosAdapter();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TESTE", "Failed to read value.", error.toException());
            }
        });
    }

    public void atualizaCarrosAdapter(){
        AdapterAutomoveis adapter = new AdapterAutomoveis(this, carros);
        if(carros.isEmpty()){
            listViewCarros.setVisibility(View.INVISIBLE);
        }else{
            listViewCarros.setVisibility(View.VISIBLE);
            listViewCarros.setAdapter(adapter);
        }
    }

    public void atualizaCaminhoesAdapter(){
        AdapterAutomoveis adapter = new AdapterAutomoveis(this, caminhoes);
        if(caminhoes.isEmpty()){
            listViewCaminhoes.setVisibility(View.INVISIBLE);
        }else{
            listViewCaminhoes.setVisibility(View.VISIBLE);
            listViewCaminhoes.setAdapter(adapter);
        }
    }

    public void atualizaMotosAdapter(){
        AdapterAutomoveis adapter = new AdapterAutomoveis(this, motos);
        if(motos.isEmpty()){
            listViewMotos.setVisibility(View.INVISIBLE);
        }else{
            listViewMotos.setVisibility(View.VISIBLE);
            listViewMotos.setAdapter(adapter);
        }
    }
}
