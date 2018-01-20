package com.scriptorial.waddle.database.user;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user where firstName LIKE  :firstName AND lastName LIKE :lastName")
    User findByName(String firstName, String lastName);

    @Query("SELECT COUNT(*) from user")
    int countUsers();

    @Insert
    void insertAll(User... users);


    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user where id == :userId")
    User findById(String userId);
}
