package com.example.mycar.tela.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycar.MenuPrincipal;
import com.example.mycar.R;
import com.example.mycar.SplashScreen;
import com.example.mycar.tela.Servicos.Info_Servicos;
import com.example.mycar.tela.Servicos.ListaServicos;
import com.example.mycar.tela.Usuario.Info_Automoveis;
import com.example.mycar.tela.Usuario.ListaAutomoveis;
import com.example.mycar.tela.Usuario.MenuUsuario;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        Button botaoLogin = findViewById(R.id.buttonLogar);
        Button botaoCadastro = findViewById(R.id.botaoCadastro);

        EditText editUser = findViewById(R.id.EditUser);
        EditText editSenha = findViewById(R.id.editTextPassword);

        editUser.setText("mateusinfocefetmg@gmail.com");
        editSenha.setText("123456");


        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TESTE", "onClick: "+editUser.getText().toString()+editSenha.getText().toString());
                if(editUser.getText().toString().equals("mateusinfocefetmg@gmail.com") ){
                    if(editSenha.getText().toString().equals("123456")){
                        Intent intent = new Intent(Login.this, MenuPrincipal.class);
                        startActivity(intent);

                        finish();
                    }else{
                        Toast.makeText(Login.this, "Senha incorreta!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Login.this, "Email do usuario não encontrado!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Cadastro.class);
                startActivity(intent);
            }
        });

    }
}