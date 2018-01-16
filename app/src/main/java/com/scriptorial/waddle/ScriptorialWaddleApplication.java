package com.scriptorial.waddle;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class ScriptorialWaddleApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
