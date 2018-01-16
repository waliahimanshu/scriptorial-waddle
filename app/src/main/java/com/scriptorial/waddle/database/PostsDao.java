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
    void insert(Posts posts);

    @Update
    void update(Posts... posts);

    @Delete
    void delete(Posts... posts);

    @Query("SELECT * FROM Posts")
    List<Posts> getAllRepos();

    @Query("SELECT * FROM Posts WHERE userId=:userId")
    List<Posts> findPostsForUser(final int userId);
}