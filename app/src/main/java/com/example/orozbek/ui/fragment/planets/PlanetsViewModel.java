package com.example.orozbek.ui.fragment.planets;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.orozbek.domain.entity.planets.PlanetsInfo;
import com.example.orozbek.domain.useCases.planets.GetPlanetsUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PlanetsViewModel extends ViewModel {

    private final GetPlanetsUseCase getPlanetsUseCase;

    @Inject
    public PlanetsViewModel(GetPlanetsUseCase repository) {
        getPlanetsUseCase = repository;
    }

    public void getPlanets() {
        getPlanetsUseCase.getPlanets();
    }

    public LiveData<PlanetsInfo> LiveData() { return getPlanetsUseCase.getPlanets(); }

}
