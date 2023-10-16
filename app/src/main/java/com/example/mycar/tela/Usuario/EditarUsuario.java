package com.example.mycar.tela.Usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mycar.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class EditarUsuario extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);

        textView = findViewById(R.id.EditUser);

        String novoEmail = "novoemail@gmail.com";
        String novoNome = "Novo Nome";
        String novaSenha = "novasenha123";

        // Referência para o nó "usuarios/mateus/dados"
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("usuarios").child("mateus").child("dados");

        // Atualize os valores desejados
        Map<String, Object> updates = new HashMap<>();
        updates.put("email", novoEmail);
        updates.put("nome", novoNome);
        updates.put("senha", novaSenha);

        databaseReference.updateChildren(updates, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    // Atualização bem-sucedida
                } else {
                    // Lidar com erros, se houver
                }
            }
        });
    }

}