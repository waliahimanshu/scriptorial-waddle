package com.scriptorial.waddle.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class User {
    @PrimaryKey public @NonNull final String id;
    public final String firstName;
    public final String lastName;
    public final String photoUri;

    public User(@NonNull String id, String firstName, String lastName, String photoUri) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoUri = photoUri;
    }
}