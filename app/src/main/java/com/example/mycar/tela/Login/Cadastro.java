package com.example.mycar.tela.Login;

import static com.example.mycar.classes.Variaveis.database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycar.R;
import com.example.mycar.classes.Autenticador;
import com.example.mycar.classes.GeradorDeChave;
import com.example.mycar.classes.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cadastro extends AppCompatActivity {

    private DatabaseReference usuariosRef;

    private Usuario usuario;

    private FirebaseAuth firebaseAuth;

    private EditText editNome, editEmail, editPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        setTitle("Cadastro");

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editSenha);

        Button botaoEnviar = findViewById(R.id.buttonEnviarCadastro);

        Button botaoLogin = findViewById(R.id.buttonLogin);
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cadastro.this, Login.class);
                startActivity(intent);
            }
        });

        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validarCampos()){
                    criarUsuario();
                }

            }
        });

    }

    private void criarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome(editNome.getText().toString());
        usuario.setEmail(editEmail.getText().toString());
        usuario.setSenha(editPassword.getText().toString());

        firebaseAuth = Autenticador.FirebaseAutenticar();

        firebaseAuth.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Cadastro.this, "Cadastro concluido!", Toast.LENGTH_SHORT).show();
                }else{

                }
            }
        });
    }

    private boolean validarCampos(){

        return true;
    }
}