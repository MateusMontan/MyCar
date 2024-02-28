package com.example.mycar.classes;

import static com.example.mycar.classes.Variaveis.automovelescolhido;
// ServiceAdapter.java
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycar.R;
import com.example.mycar.tela.Servicos.Info_Servicos;
import com.example.mycar.tela.Usuario.AutomoveisServicos.SA_Oleo;
import com.example.mycar.tela.Usuario.Info_Automoveis;
import com.example.mycar.tela.Usuario.ListaAutomoveis;
import com.example.mycar.tela.Usuario.ListaAutoservicos;

import java.util.List;
import java.util.function.Function;

public class AdapterAutomoveis extends ArrayAdapter<Automovel> {

    protected Context adapContext;
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
                Intent intent = new Intent(v.getContext(), ListaAutoservicos.class);
                automovelescolhido = service.clone();
                v.getContext().startActivity(intent);
            }
        });

        btnService.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //ListaAutomoveis.exibirPopUp();

                return true;
            }
        });
        return convertView;

    }


}




