package com.scriptorial.waddle.database.Posts;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import com.scriptorial.waddle.database.user.User;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = User.class,
                                parentColumns = "id",
                                childColumns = "userId",
                                onDelete = CASCADE))
public class Posts {
    @PrimaryKey public final int id;
    public final String userId;
    public final String postEssay;
    public final String postCustomQuestion;

    public Posts(int id, String userId, String postEssay, String postCustomQuestion) {
        this.id = id;
        this.userId = userId;
        this.postEssay = postEssay;
        this.postCustomQuestion = postCustomQuestion;
    }
}
