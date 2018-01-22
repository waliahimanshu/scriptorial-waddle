package com.scriptorial.waddle.di;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.scriptorial.waddle.database.user.LocalSqlDataSource;
import com.scriptorial.waddle.database.user.UserRepository;
import com.scriptorial.waddle.util.BaseNavigator;
import com.scriptorial.waddle.util.BaseNavigatorImpl;

public class Injection {

    @NonNull
    public static UserRepository provideUserRepository(@NonNull Context context) {
        return new UserRepository(LocalSqlDataSource.getInstance(context));
    }


    @NonNull
    public static BaseNavigator createNavigationProvider(@NonNull Activity activity) {
        return new BaseNavigatorImpl(activity);
    }
}
