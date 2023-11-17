package com.example.mycar.tela.Usuario.AutomoveisServicos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.mycar.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SA_Oleo extends AppCompatActivity {
    private static final int PICK_FILE_REQUEST_CODE = 123;
    private static final int REQUEST_PERMISSION_CODE = 456;
    private File internalFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_oleo);

        // Verifica e solicita permissões
        if (checkPermission()) {
            setupUI();
        } else {
            requestPermission();
        }
    }

    private void setupUI() {
        Button botao = findViewById(R.id.ButtonDocument);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilePicker();
            }
        });
    }

    private boolean checkPermission() {
        // Verifica a permissão de leitura do armazenamento externo
        return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        // Solicita a permissão se não estiver concedida
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION_CODE);
    }

    private void openFilePicker() {
        // Abre o seletor de arquivos
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_FILE_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupUI();
            } else {
                Toast.makeText(this, "Permissão negada. Não é possível acessar a galeria.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == RESULT_OK) {
            Uri selectedFileUri = data.getData();

            try {
                // Obtém o InputStream do arquivo selecionado
                InputStream inputStream = getContentResolver().openInputStream(selectedFileUri);

                // Cria um diretório se não existir
                File directory = getFilesDir();
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Cria um arquivo no diretório de armazenamento interno do aplicativo com extensão de imagem
                internalFile = new File(directory, "arquivoFoto.png"); // Pode ser .jpg, .png, etc.

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
                exibirFoto(); // Chama o método para exibir a foto após salvar
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Erro ao salvar a foto: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void exibirFoto() {
        if (internalFile != null && internalFile.exists()) {
            ImageView imageView = findViewById(R.id.imageView3);
            imageView.setImageURI(Uri.fromFile(internalFile));
        } else {
            Toast.makeText(this, "A foto não está disponível.", Toast.LENGTH_SHORT).show();
        }
    }
}
