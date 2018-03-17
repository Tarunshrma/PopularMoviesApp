package com.example.tarunsmac.moviesapp.services.implementation;

import com.example.tarunsmac.moviesapp.App;
import com.example.tarunsmac.moviesapp.helpers.Constants;
import com.example.tarunsmac.moviesapp.services.interfaces.MovieApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tarunsmac on 10/03/18.
 */

class BaseMovieService {

    final MovieApi service;


    BaseMovieService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(provideOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(MovieApi.class);
    }

    private OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
        okhttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okhttpClientBuilder.readTimeout(30, TimeUnit.SECONDS);
        okhttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS);

        okhttpClientBuilder.addInterceptor(new NetworkConnectionInterceptor() {
            @Override
            public boolean isInternetAvailable() {
                return App.getInstance().isInternetAvailable();
            }

            @Override
            public void onInternetUnavailable() {
                // we can broadcast this event to activity/fragment/service
                // through LocalBroadcastReceiver or
                // RxBus/EventBus
                // also we can call our own interface method
                // like this.
                App.getInstance().mInternetConnectionListener.onInternetUnavailable();
            }
        });

        return okhttpClientBuilder.build();
    }


}
