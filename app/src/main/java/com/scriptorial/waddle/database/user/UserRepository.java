package com.scriptorial.waddle.database.user;

import com.scriptorial.waddle.database.DataSource;

public class UserRepository implements DataSource<User> {

    public final LocalSqlDataSource localSqlDataSource;

    public UserRepository(LocalSqlDataSource localSqlDataSource) {
        this.localSqlDataSource = localSqlDataSource;
    }

    @Override
    public void add(User item) {
        localSqlDataSource.add(item);
    }

    @Override
    public void add(Iterable<User> items) {
        localSqlDataSource.add(items);
    }

    @Override
    public void update(User item) {
        localSqlDataSource.update(item);
    }

    @Override
    public void remove(User item) {
        localSqlDataSource.remove(item);
    }

    @Override
    public User findById(String id) {
        return localSqlDataSource.findById(id);
    }
}
