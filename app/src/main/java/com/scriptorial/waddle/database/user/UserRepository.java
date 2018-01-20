package com.scriptorial.waddle.database.user;

public interface UserRepository {
    void insertUser(User user);

    User findUserById(String userId);
}
