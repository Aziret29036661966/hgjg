package com.example.orozbek.data.network.repos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.orozbek.domain.entity.Info;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepo {
    private final StarWars api;
    private final CallBackResult callBackResult;

    @Inject
    public MainRepo(StarWars api, CallBackResult callBackResult) {
        this.api = api;
        this.callBackResult = callBackResult;
    }

    public LiveData<Info> getPeople(){
        MutableLiveData<Info> liveData = new MutableLiveData<>();
        api.getPeople().enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callBackResult.onSuccess(response.body());
                }
                else {
                    callBackResult.onFail(response.message());
                }

                }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {
                callBackResult.onFail(t.getMessage());
            }
        });
        return liveData;
    }

}
