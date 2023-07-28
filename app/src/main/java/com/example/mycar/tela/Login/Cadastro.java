package com.example.mycar.tela.Login;

import static com.example.mycar.classes.Variaveis.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mycar.R;
import com.example.mycar.classes.GeradorDeChave;
import com.example.mycar.classes.Usuario;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cadastro extends AppCompatActivity {

    private DatabaseReference usuariosRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        setTitle("Cadastro");

        EditText editNome = findViewById(R.id.editNome);
        EditText editEmail = findViewById(R.id.editEmail);
        EditText editPassword = findViewById(R.id.editSenha);

        Button botaoEnviar = findViewById(R.id.buttonEnviarCadastro);

        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //CRIAR VERIFICAÇÃO DE CAMPO - VERIFICAR CARACTERES
                database =  FirebaseDatabase.getInstance();

                DatabaseReference myRef = database.getReference("usuarios");

                adicionarNovoUsuario(
                        editNome.getText().toString(),
                        editEmail.getText().toString(),
                        editPassword.getText().toString()
                );



            }
        });

    }

    private void adicionarNovoUsuario(String nome, String email, String senha) {
        // Obtém a referência ao nó "usuarios"
        usuariosRef = FirebaseDatabase.getInstance().getReference().child("usuarios");

        // Gera uma nova chave única para o novo usuário
        String novaChaveUsuario = usuariosRef.push().getKey();

        // Cria o novo usuário com os campos fornecidos
        Usuario novoUsuario = new Usuario(nome, email, senha);


        // Insere o novo usuário com a chave personalizada
        usuariosRef.child(new GeradorDeChave().gerarChaveSegura()).setValue(novoUsuario);;

    }
}