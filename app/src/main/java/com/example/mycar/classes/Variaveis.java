package com.example.mycar.classes;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Variaveis {

    public static FirebaseDatabase database;

    //COLOCAR NA SPLASH
    public void iniciarVariaveis(){
        database =  FirebaseDatabase.getInstance();
    }
}
