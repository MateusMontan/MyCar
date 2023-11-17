package com.example.mycar.tela.Usuario.AutomoveisServicos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mycar.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SA_Oleo extends AppCompatActivity {
    private static final int PICK_FILE_REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_oleo);

        Button botao = findViewById(R.id.ButtonDocument);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*"); // Alteração aqui para limitar a seleção a imagens
                startActivityForResult(intent, PICK_FILE_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == RESULT_OK) {
            Uri selectedFileUri = data.getData();

            try {
                // Obtém o InputStream do arquivo selecionado
                InputStream inputStream = getContentResolver().openInputStream(selectedFileUri);

                // Cria um arquivo no diretório de armazenamento interno do aplicativo com extensão de imagem
                File internalFile = new File(getFilesDir(), "seuarquivo.png"); // Pode ser .jpg, .png, etc.

                // Cria um FileOutputStream para o arquivo interno
                FileOutputStream outputStream = new FileOutputStream(internalFile);

                // Copia o conteúdo do InputStream para o FileOutputStream
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }

                // Fecha os fluxos de entrada e saída
                inputStream.close();
                outputStream.close();

                Toast.makeText(this, "Foto salva no armazenamento interno", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Erro ao salvar a foto", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
