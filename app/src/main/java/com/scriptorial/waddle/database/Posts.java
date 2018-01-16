package com.scriptorial.waddle.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = User.class,
                                parentColumns = "id",
                                childColumns = "userId",
                                onDelete = CASCADE))
public class Posts {
    @PrimaryKey public final int id;
    public final int userId;
    public final String posts;

    public Posts(int id, int userId, String posts) {
        this.id = id;
        this.userId = userId;
        this.posts = posts;
    }
}
