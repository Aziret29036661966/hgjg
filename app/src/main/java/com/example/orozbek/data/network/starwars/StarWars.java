package com.example.orozbek.data.network.starwars;

import com.example.orozbek.domain.entity.films.FilmsInfo;
import com.example.orozbek.domain.entity.people.PeopleInfo;
import com.example.orozbek.domain.entity.planets.PlanetsInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StarWars {

    @GET("people")
    Call<PeopleInfo> getPeople();

    @GET("planets")
    Call<PlanetsInfo> getPlanets();

    @GET("films")
    Call<FilmsInfo> getFilms();
}
