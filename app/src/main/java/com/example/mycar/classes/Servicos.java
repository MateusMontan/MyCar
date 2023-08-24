package com.example.mycar.classes;

public class Servicos implements Cloneable{
    private String nome;
    private String whatsapp;

    private String x;
    private String y;

    private String icon;

    public void setX(String x) {
        this.x = x;
    }


    public String getX() {
        return x;
    }

    public void setY(String y) {
        this.y = y;
    }


    public String getY() {
        return y;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    public String getIcon() {
        return icon;
    }

    public Servicos(){

    }
    public Servicos(String icon, String nome, String whatsapp, String x, String y) {
        this.nome = nome;
        this.whatsapp = whatsapp;
        this.x = x;
        this.y = y;
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
