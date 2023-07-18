package com.example.mycar.tela.Servicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.ServiceState;
import android.widget.ListView;

import com.example.mycar.R;
import com.example.mycar.classes.AdapterServicos;
import com.example.mycar.classes.Servicos;

import java.util.ArrayList;

public class ListaServicos extends AppCompatActivity {

    public static ArrayList<Servicos> services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicos);

        // Criar uma lista de serviços (substitua com seus próprios dados)
        ArrayList<Servicos> services = new ArrayList<>();
        services.add(new Servicos("Serviço 1", "Descrição do serviço 1"));
        services.add(new Servicos("Serviço 2", "Descrição do serviço 2"));
        services.add(new Servicos("Serviço 3", "Descrição do serviço 3"));

        // Criar o adaptador personalizado e associá-lo ao ListView
        AdapterServicos adapter = new AdapterServicos(this, services);
        ListView listViewServices = findViewById(R.id.listViewServices);
        listViewServices.setAdapter(adapter);
    }
}