package com.example.orozbek.data.network.di;



import static com.example.orozbek.BuildConfig.MY_URL;

import com.example.orozbek.data.network.repos.MainRepoImpl;
import com.example.orozbek.data.network.starwars.StarWars;
import com.example.orozbek.domain.repo.MainRepository;
import com.example.orozbek.domain.useCases.GetPeopleUseCase;
import com.example.orozbek.ui.fragment.main.MainViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    public MainViewModel mainViewModel(GetPeopleUseCase mainRepoImpl){
        return new MainViewModel(mainRepoImpl);
    }

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
    public MainRepository provideRepo(StarWars api) {
        return new MainRepoImpl(api);
    }
}
