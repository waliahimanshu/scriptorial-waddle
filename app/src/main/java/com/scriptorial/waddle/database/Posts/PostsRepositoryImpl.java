package com.scriptorial.waddle.database.Posts;


public class PostsRepositoryImpl {

    private final PostsDao mPostsDao;

    public PostsRepositoryImpl(PostsDao postsDao) {
        mPostsDao = postsDao;
    }

    public void insertUserPostEssay(Posts posts) {
        mPostsDao.insert(posts);
    }

}

