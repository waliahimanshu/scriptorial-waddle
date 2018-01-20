package com.scriptorial.waddle.database.user;

public class UserRoomDataSource implements UserRepository {

    private final UserDao mUserDao;

    public UserRoomDataSource(UserDao userDao) {
        mUserDao = userDao;
    }

    @Override
    public void insertUser(User user) {
        mUserDao.insert(user);
    }

    @Override
    public User findUserById(String userId) {
        return mUserDao.findById(userId);
    }
}

