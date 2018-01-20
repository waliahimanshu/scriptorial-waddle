package com.scriptorial.waddle.publisher;

import android.support.annotation.NonNull;
import com.scriptorial.waddle.database.Posts.Posts;
import com.scriptorial.waddle.database.Posts.PostsRepositoryImpl;

public class UserContentInputViewModel {

    private final PostsRepositoryImpl mPostsRepository;

    public UserContentInputViewModel(PostsRepositoryImpl postsRepository) {
        mPostsRepository = postsRepository;
    }


    @NonNull
    public void insertPosts(Posts posts) {
         mPostsRepository.insertUserPostEssay(posts);
    }

}
