package com.example.oguzhan.feeder;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Oguzhan on 11.01.2018.
 */

public class SensorDurumu extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
