package com.example.mycar.tela.Servicos;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mycar.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Info_Servicos extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView textView;
    private DatabaseReference mDatabase;
    private String nomeLista; // Variável para armazenar o nome da lista de serviços

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_servicos);

        textView = findViewById(R.id.textView);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("servicos");

        nomeLista = getIntent().getStringExtra("nomeLista");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // ... Resto do seu código ...
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sydney = new LatLng(-21.540535205935736, -42.64215893165753);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Zaquine Pneus"));

        float zoomLevel = 20.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel));

        // Atualizando o TextView com o nome da lista
        textView.setText("Nome da Lista: " + nomeLista);
    }
}
