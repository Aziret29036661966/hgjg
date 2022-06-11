package com.example.orozbek.domain.di;


import static com.example.orozbek.BuildConfig.MY_URL;

import com.example.orozbek.data.network.repos.CallBackResult;
import com.example.orozbek.data.network.repos.MainRepo;
import com.example.orozbek.data.network.repos.StarWars;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public StarWars providerAPI() {
        return new Retrofit.Builder()
                .baseUrl(MY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(StarWars.class);
    }

    @Provides
    @Singleton
    public MainRepo provideRepo(StarWars api, CallBackResult callBackResult) {
        return new MainRepo(api, callBackResult);
    }
}
