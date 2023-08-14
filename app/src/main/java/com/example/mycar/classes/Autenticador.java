package com.example.mycar.classes;


import com.google.firebase.auth.FirebaseAuth;

public class Autenticador {

    private static FirebaseAuth firebaseAuth;

    public static FirebaseAuth FirebaseAutenticar(){
        if(firebaseAuth == null){
            firebaseAuth = FirebaseAuth.getInstance();
        }

        return firebaseAuth;
    }
}
