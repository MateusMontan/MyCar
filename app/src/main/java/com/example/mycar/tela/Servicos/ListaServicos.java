package com.example.mycar.tela.Servicos;

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

    public static ArrayList<Servicos> services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicos);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("servicos");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Servicos value = dataSnapshot.getValue(Servicos.class);
                //services.add(value);
                Log.w("TESTE",value.getNome() + value.getWhatsapp());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TESTE", "Failed to read value.", error.toException());
            }
        });


        //AdapterServicos adapter = new AdapterServicos(this, services);
        //ListView listViewServices = findViewById(R.id.listViewServices);
        //listViewServices.setAdapter(adapter);
    }
}