package com.example.mycar.tela.Automoveis;

import static com.example.mycar.classes.Variaveis.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.ServiceState;
import android.util.Log;
import android.widget.ListView;

import com.example.mycar.R;
import com.example.mycar.classes.AdapterAutomoveis;
import com.example.mycar.classes.AdapterServicos;
import com.example.mycar.classes.Automovel;
import com.example.mycar.classes.Servicos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListaAutomoveis extends AppCompatActivity {

    public static ArrayList<Automovel> automovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicos);
        setTitle("Lista de Automóveis");

        database =  FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("usuarios/user-1690505825528/automoveis");
        automovel = new ArrayList<>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot servicoSnapshot : dataSnapshot.getChildren()) {
                    Automovel value = servicoSnapshot.getValue(Automovel.class);
                    if (value != null) {
                        automovel.add(new Automovel(value.getCategoria(),value.getCor(),value.getMarca(),
                                value.getModelo(),value.getPlaca()));
                    }
                }
                atualizaAdapter();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TESTE", "Failed to read value.", error.toException());
            }
        });
    }

    public void atualizaAdapter(){
        AdapterAutomoveis adapter = new AdapterAutomoveis(this, automovel);
        ListView listViewAutomoveis = findViewById(R.id.listViewAutomoveis);
        listViewAutomoveis.setAdapter(adapter);
    }
}
