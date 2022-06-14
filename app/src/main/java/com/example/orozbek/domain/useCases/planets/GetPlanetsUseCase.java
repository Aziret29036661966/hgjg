package com.example.orozbek.domain.useCases.planets;

import androidx.lifecycle.LiveData;

import com.example.orozbek.domain.entity.planets.PlanetsInfo;
import com.example.orozbek.domain.repo.MainRepository;

import javax.inject.Inject;

public class GetPlanetsUseCase {

    private final MainRepository repository;

    @Inject
    public GetPlanetsUseCase(MainRepository repository) {
        this.repository = repository;
    }

    public LiveData<PlanetsInfo> getPlanets() {
        return repository.getPlanets();
    }

}
