package com.example.mycar.classes;

public class Usuario implements Cloneable{
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Usuario clone() {
        try {
            return (Usuario) super.clone();
        } catch (CloneNotSupportedException e) {
            // Tratar a exceção, se necessário
            return null;
        }
    }
}