package com.scriptorial.waddle.home;

import com.google.firebase.auth.FirebaseAuth;

public class FirebaseAuthWrapperImpl implements FirebaseWrapper {
    @Override
    public FirebaseAuth getFirebaseAuthentication() {
        return FirebaseAuth.getInstance();
    }
}
