package com.example.mycar.tela.Servicos;

import static com.example.mycar.classes.Variaveis.servicoescolhido;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycar.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;

public class Info_Servicos extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView textView;
    private ImageView iconImageView;
    private ImageView imageView3;

    private ImageView imageView5;

    private ImageView imageLogo;


    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_servicos);

        textView = findViewById(R.id.textNomeServico);
        iconImageView = findViewById(R.id.ImageViewWhatsapp);
        imageView3 = findViewById(R.id.ImageViewLigar);
        imageView5 = findViewById(R.id.imageViewEmail);
        //imageLogo = findViewById(R.id.ImageViewServico);

        textView.setText(servicoescolhido.getNome());
        //imageLogo.setImageResource(getResources().getIdentifier(servicoescolhido.getIcon(), "drawable", getPackageName()));


        iconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numerotelefone = servicoescolhido.getWhatsapp();
                String mensagem = "Olá!";
                String mensagemcodificada = Uri.encode(mensagem);
                String url = "https://wa.me/+" + numerotelefone + "?text=" + mensagemcodificada;

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String numeroTelefone = servicoescolhido.getWhatsapp();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + numeroTelefone));
                startActivity(intent);
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        imageView4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_SENDTO);
//                intent.setData(Uri.parse("mailto:"));
//
//                String textoemail = servicoescolhido.getEmail();
//                intent.putExtra(Intent.EXTRA_EMAIL, textoemail);
//                intent.putExtra(Intent.EXTRA_SUBJECT, "Assunto do E-mail");
//                intent.putExtra(Intent.EXTRA_TEXT, "Corpo do E-mail");
//
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(Info_Servicos.this, "Nenhum aplicativo de e-mail disponível", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });


        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String informacao = servicoescolhido.getWhatsapp();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", informacao);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(getApplicationContext(), "Número de telefone copiado", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng local = new LatLng(Double.parseDouble(servicoescolhido.getX()), Double.parseDouble(servicoescolhido.getY()));
        mMap.addMarker(new MarkerOptions().position(local).title(servicoescolhido.getNome()));


        float zoomLevel = 17.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local, zoomLevel));

    }

}
