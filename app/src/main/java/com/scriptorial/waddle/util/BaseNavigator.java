package com.scriptorial.waddle.util;

public interface BaseNavigator {

    void finishActivity();

    void startActivity(Class cls);

    void finishActivityWithResult(int resultCode);
}

