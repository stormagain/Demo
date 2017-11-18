package com.demo;

import android.app.Application;

/**
 * Created by 37X21=777 on 17/11/18.
 */

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        Alert.alertAnyWhere();
        super.onCreate();
    }
}
