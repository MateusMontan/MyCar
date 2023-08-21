package com.example.mycar.classes;

// ServiceAdapter.java
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.mycar.R;
import com.example.mycar.tela.Servicos.Info_Servicos;
import com.example.mycar.tela.Usuario.Info_Automoveis;

import java.util.List;

public class AdapterAutomoveis extends ArrayAdapter<Automovel> {

    public AdapterAutomoveis(Context context, List<Automovel> services) {
        super(context, 0, services);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obter o objeto Service para esta posição
        Automovel service = getItem(position);

        // Verificar se a view está sendo reutilizada, caso contrário, inflar a view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.botao_adapter_automovel, parent, false);
        }

        // Configurar o botão do layout
        Button btnService = convertView.findViewById(R.id.Btn1);

        btnService.setText(service.getModelo());
        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Info_Automoveis.class);
                v.getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}




