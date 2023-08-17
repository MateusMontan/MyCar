package com.example.mycar.classes;

public class Servicos implements Cloneable{
    private String nome;
    private String whatsapp;

    private double x;
    private double y;

    public void setX(double x) {
        this.x = x;
    }


    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }


    public double getY() {
        return y;
    }

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

    public Servicos clone() {
        try {
            return (Servicos) super.clone();
        } catch (CloneNotSupportedException e) {
            // Tratar a exceção, se necessário
            return null;
        }
    }
}
