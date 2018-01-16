package com.scriptorial.waddle.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface PostsDao {

    @Insert
    void insert(Posts repo);

    @Update
    void update(Posts... repos);

    @Delete
    void delete(Posts... repos);

    @Query("SELECT * FROM repo")
    List<Posts> getAllRepos();

    @Query("SELECT * FROM repo WHERE userId=:userId")
    List<Posts> findPostsForUser(final int userId);
}