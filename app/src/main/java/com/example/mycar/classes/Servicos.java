package com.example.mycar.classes;

public class Servicos implements Cloneable{

    private String tipo;
    /*
    Tipo de Servico

    0 - Posto de Gasolina
    1 - Autoeletrica
    2 - Mecanico
    3 - Borracharia
    4 - Concessionaria
    5 - Guincho
    6 - Lanternagem
     */

    private String nome;
    private String email;
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
    public Servicos(String icon, String nome, String whatsapp, String x, String y, String email, String tipo) {
        this.nome = nome;
        this.whatsapp = whatsapp;
        this.x = x;
        this.y = y;
        this.icon = icon;
        this.email = email;
        this.tipo = tipo;
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

    public String getTipo() {return tipo; }

    public void setTipo(String tipo){this.tipo = tipo;}


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
