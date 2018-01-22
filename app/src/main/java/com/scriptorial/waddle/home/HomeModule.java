package com.scriptorial.waddle.home;

import android.app.Activity;
import android.content.Context;
import com.scriptorial.waddle.database.user.LocalSqlDataSource;
import com.scriptorial.waddle.database.user.UserRepository;
import com.scriptorial.waddle.util.BaseNavigatorImpl;

public class HomeModule {

    public static HomeViewModel provideHomeViewModel(Activity activity) {
        Context context = activity.getApplicationContext();
        HomeNavigator homeNavigator = new HomeNavigator(new BaseNavigatorImpl(activity));
        FirebaseAuthWrapperImpl firebaseWrapper = new FirebaseAuthWrapperImpl();
        UserRepository userRepository = new UserRepository(LocalSqlDataSource.getInstance(context));
        return new HomeViewModel(homeNavigator, firebaseWrapper, userRepository);
    }
}
