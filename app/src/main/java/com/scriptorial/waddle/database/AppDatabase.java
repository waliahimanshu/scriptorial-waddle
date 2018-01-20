package com.scriptorial.waddle.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.scriptorial.waddle.database.Posts.Posts;
import com.scriptorial.waddle.database.Posts.PostsDao;
import com.scriptorial.waddle.database.user.User;
import com.scriptorial.waddle.database.user.UserDao;

@Database(entities = {User.class, Posts.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static String applicationName;
    private static final String DB_NAME = applicationName + ".db";
    private static volatile AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
            applicationName = getApplicationName(context);
        }
        return instance;
    }

    private static AppDatabase create(final Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DB_NAME).allowMainThreadQueries() //for test only
                .fallbackToDestructiveMigration() // what ?
                .build();
    }


    private static String getApplicationName(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public abstract UserDao getUserDao();

    public abstract PostsDao getPostsDao();

}