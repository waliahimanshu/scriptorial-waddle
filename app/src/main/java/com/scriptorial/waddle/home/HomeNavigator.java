package com.scriptorial.waddle.home;

import com.scriptorial.waddle.home.login.LoginActivity;
import com.scriptorial.waddle.publisher.UserContentInputActivity;
import com.scriptorial.waddle.util.BaseNavigatorImpl;

public class HomeNavigator {
    private final BaseNavigatorImpl baseNavigator;

    public HomeNavigator(BaseNavigatorImpl baseNavigator) {
        this.baseNavigator = baseNavigator;
    }

    public void launchLoginScreen() {
        baseNavigator.startActivity(LoginActivity.class);
    }

    public void launchWriterInputScreen() {
        baseNavigator.startActivity(UserContentInputActivity.class);
    }


}
