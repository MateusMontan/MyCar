package com.example.mycar.tela.Servicos;

import static com.example.mycar.classes.Variaveis.servicoescolhido;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
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
    private ImageView iconImageView;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_servicos);

        textView = findViewById(R.id.textView);
        iconImageView = findViewById(R.id.iconImageView);
        setTitle(servicoescolhido.getNome());

        textView.setText(servicoescolhido.getWhatsapp());

        openWhatsApp(iconImageView);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);





    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sydney = new LatLng(-21.540535205935736, -42.64215893165753);
        mMap.addMarker(new MarkerOptions().position(sydney).title(servicoescolhido.getNome()));

        float zoomLevel = 17.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel));

    }


    public void openWhatsApp(ImageView whatsapp) {
        String numerotelefone = servicoescolhido.getWhatsapp();
        String mensagem = "Olá, estou procurando seu serviço!";
        String mensagemcodificada = Uri.encode(mensagem);
        String url = "https://wa.me/" + numerotelefone + "?text=" + mensagemcodificada;


        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

}
