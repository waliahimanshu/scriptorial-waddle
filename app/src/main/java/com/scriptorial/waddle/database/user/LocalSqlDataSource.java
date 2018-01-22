package com.scriptorial.waddle.database.user;

import android.content.Context;
import android.support.annotation.Nullable;
import com.scriptorial.waddle.database.AppDatabase;
import com.scriptorial.waddle.database.DataSource;

public class LocalSqlDataSource implements DataSource<User> {

    private @Nullable static LocalSqlDataSource INSTANCE;

    private final UserDao userDao;

    private LocalSqlDataSource(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User item) {
        userDao.insert(item);
    }

    @Override
    public void add(Iterable<User> items) {
    }

    @Override
    public void update(User item) {
    }

    @Override
    public void remove(User item) {
        userDao.delete(item);
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    public static LocalSqlDataSource getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new LocalSqlDataSource(AppDatabase.getInstance(context).getUserDao());
        }
        return INSTANCE;
    }
}
