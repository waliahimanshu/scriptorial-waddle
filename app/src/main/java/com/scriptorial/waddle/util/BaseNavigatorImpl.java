package com.scriptorial.waddle.util;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

public class BaseNavigatorImpl implements BaseNavigator {

    private @Nullable final WeakReference<Activity> activityWeakReference;

    public BaseNavigatorImpl(@NonNull Activity activity) {
         activityWeakReference = new WeakReference<>(activity);
    }

    @Override
    public void finishActivity() {

    }

    @Override
    public void startActivity(Class cls) {
        if (activityWeakReference != null) {
            Intent intent = new Intent(activityWeakReference.get(), cls);
            activityWeakReference.get().startActivity(intent);
        }
    }

    @Override
    public void finishActivityWithResult(int resultCode) {

    }
}
