package com.example.tarunsmac.moviesapp;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.tarunsmac.moviesapp.services.interfaces.*;

/**
 * Created by tarunsmac on 17/03/18.
 */

public class App extends Application {
    public InternetConnectionListener mInternetConnectionListener;

    // Singleton instance
    private static App sInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        // Setup singleton instance
        sInstance = this;
    }

    // Getter to access Singleton instance
    public static App getInstance() {
        return sInstance ;
    }

    public void setInternetConnectionListener(InternetConnectionListener listener) {
        mInternetConnectionListener = listener;
    }

    public void removeInternetConnectionListener() {
        mInternetConnectionListener = null;
    }

    public boolean isInternetAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

