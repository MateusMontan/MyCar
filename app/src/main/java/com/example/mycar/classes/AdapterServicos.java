package com.example.mycar.classes;

// ServiceAdapter.java
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.mycar.R;

import java.util.List;

public class AdapterServicos extends ArrayAdapter<Servicos> {

    public AdapterServicos(Context context, List<Servicos> services) {
        super(context, 0, services);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obter o objeto Service para esta posição
        Servicos service = getItem(position);

        // Verificar se a view está sendo reutilizada, caso contrário, inflar a view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.botoes, parent, false);
        }

        // Configurar o botão do layout
        Button btnService = convertView.findViewById(R.id.Btn1);

        btnService.setText(service.getNome());
        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Coloque aqui o código para a ação do botão quando ele for clicado.
                // Por exemplo, pode ser a abertura de uma nova atividade ou qualquer ação desejada.
            }
        });

        return convertView;
    }
}

