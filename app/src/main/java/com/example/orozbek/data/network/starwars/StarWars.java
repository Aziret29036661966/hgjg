package com.example.orozbek.data.network.starwars;

import com.example.orozbek.domain.entity.Info;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StarWars {

    @GET("people")
    Call<Info> getPeople();

}
