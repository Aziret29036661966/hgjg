package com.example.orozbek.data.network.repos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.orozbek.data.network.starwars.StarWars;
import com.example.orozbek.domain.entity.Info;
import com.example.orozbek.domain.entity.Result;
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
    public MutableLiveData<Info> getPeople() {
        MutableLiveData<Info> liveData = new MutableLiveData<>();
        api.getPeople().enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        liveData.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {

            }
        });
        return liveData;
    }
}