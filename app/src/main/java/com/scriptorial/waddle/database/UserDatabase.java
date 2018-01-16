package com.scriptorial.waddle.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static final String DB_NAME = "userDatabase.db";
    private static volatile UserDatabase instance;

    public static synchronized UserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static UserDatabase create(final Context context) {
        return Room
                .databaseBuilder(context, UserDatabase.class, DB_NAME)
                .allowMainThreadQueries() //for test only
                .build();
    }

    public abstract UserDao getUserDao();
}