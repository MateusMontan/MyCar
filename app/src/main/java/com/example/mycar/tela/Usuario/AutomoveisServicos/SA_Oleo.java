package com.example.mycar.tela.Usuario.AutomoveisServicos;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mycar.R;

public class SA_Oleo extends AppCompatActivity {

    private static final int PICK_FILE_REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_oleo);

        EditText edit = findViewById(R.id.EditUpload);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFilePicker();
            }
        });
    }

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, PICK_FILE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri selectedFileUri = data.getData();
            String nomeArquivo = getNomeArquivo(selectedFileUri);

            EditText edit = findViewById(R.id.EditUpload);
            edit.setText(nomeArquivo);
            edit.setEnabled(false);
            edit.setFocusable(false);
        }
    }

    private String getNomeArquivo(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DISPLAY_NAME};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        int column_index = ((Cursor) cursor).getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME);
        cursor.moveToFirst();
        String nomeArquivo = cursor.getString(column_index);
        cursor.close();
        return nomeArquivo;
    }
}
