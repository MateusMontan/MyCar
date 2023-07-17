package com.example.mycar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.mycar.classes.Servicos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MenuPrincipal extends AppCompatActivity {
    public static DatabaseReference databaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView lista1 = findViewById(R.id.ListViewServicos);


        databaseRef = FirebaseDatabase.getInstance().getReference();
        // Write a message to the database

        // Read from the database
        DatabaseReference servicosRef = databaseRef.child("servicos");
        servicosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot servicosSnapshot : dataSnapshot.getChildren()) {
                    String servicosId = servicosSnapshot.getKey();
                    Servicos servicos = servicosSnapshot.getValue(Servicos.class);
                    Log.w("TAG","Id:"+servicosId+"Nome:"+servicos.getNome()+" Whatsapp: "+servicos.getWhatsapp());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Firebase", "Erro ao ler dados do Firebase: " + databaseError.getMessage());
            }
        });
    }
}