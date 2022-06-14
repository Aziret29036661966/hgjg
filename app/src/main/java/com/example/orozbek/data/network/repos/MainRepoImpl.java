package com.example.orozbek.data.network.repos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.orozbek.data.network.starwars.StarWars;
import com.example.orozbek.domain.entity.films.FilmsInfo;
import com.example.orozbek.domain.entity.people.PeopleInfo;
import com.example.orozbek.domain.entity.planets.PlanetsInfo;
import com.example.orozbek.domain.repo.MainRepository;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepoImpl implements MainRepository {
    private final StarWars api;

    @Inject
    public MainRepoImpl(StarWars api) {
        this.api = api;
    }

    @Override
    public MutableLiveData<PeopleInfo> getPeople() {
        MutableLiveData<PeopleInfo> liveData = new MutableLiveData<>();
        api.getPeople().enqueue(new Callback<PeopleInfo>() {
            @Override
            public void onResponse(@NonNull Call<PeopleInfo> call, @NonNull Response<PeopleInfo> response) {
                if (response.isSuccessful() && response.body() != null) {
                        liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<PeopleInfo> call, @NonNull Throwable t) {
            }
        });
        return liveData;
    }

    @Override
    public LiveData<PlanetsInfo> getPlanets() {
        MutableLiveData<PlanetsInfo> liveData = new MutableLiveData<>();
        api.getPlanets().enqueue(new Callback<PlanetsInfo>() {
            @Override
            public void onResponse(@NonNull Call<PlanetsInfo> call, @NonNull Response<PlanetsInfo> response) {
              if (response.isSuccessful() && response.body() != null){
                    liveData.setValue(response.body());
                 }
            }
            @Override
            public void onFailure(@NonNull Call<PlanetsInfo> call, @NonNull Throwable t) {

            }
        });
         return liveData;
    }

    @Override
    public LiveData<FilmsInfo> getFilms() {
        MutableLiveData<FilmsInfo> liveData = new MutableLiveData<>();
        api.getFilms().enqueue(new Callback<FilmsInfo>() {
            @Override
            public void onResponse(@NonNull Call<FilmsInfo> call, @NonNull Response<FilmsInfo> response) {
                if (response.isSuccessful() && response.body() !=null){
                    liveData.setValue(response.body());
                }
            }
            @Override
            public void onFailure(@NonNull Call<FilmsInfo> call, @NonNull Throwable t) {

            }
        });
        return liveData;
    }
}