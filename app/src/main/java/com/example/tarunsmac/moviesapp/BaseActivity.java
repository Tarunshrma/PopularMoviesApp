package com.example.tarunsmac.moviesapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tarunsmac.moviesapp.services.interfaces.InternetConnectionListener;

/**
 * Created by tarunsmac on 10/03/18.
 */

public abstract class BaseActivity extends AppCompatActivity implements InternetConnectionListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Register to track internet status
        App.getInstance().setInternetConnectionListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        App.getInstance().removeInternetConnectionListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        App.getInstance().setInternetConnectionListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.getInstance().setInternetConnectionListener(this);
    }

    @Override
    public void onInternetUnavailable() {
        // hide content UI
        // show No Internet Connection UI
    }
}
