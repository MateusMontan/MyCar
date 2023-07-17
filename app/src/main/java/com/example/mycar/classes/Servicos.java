package com.example.mycar.classes;

public class Servicos {
    private String nome;
    private String whatsapp;

    public Servicos(){

    }
    public Servicos(String nome, String whatsapp) {
        this.nome = nome;
        this.whatsapp = whatsapp;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }
}
