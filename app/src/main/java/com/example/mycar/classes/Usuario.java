package com.example.mycar.classes;

public class Usuario {
    public String nome;
    public String email;
    public String senha;

    // Construtor vazio necessário para o Firebase
    public Usuario() {
    }

    // Construtor com os campos
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}