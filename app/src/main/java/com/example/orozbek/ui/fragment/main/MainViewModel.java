package com.example.orozbek.ui.fragment.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.orozbek.domain.entity.people.PeopleInfo;
import com.example.orozbek.domain.useCases.people.GetPeopleUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private GetPeopleUseCase getPeopleUsecase;

    @Inject
    public MainViewModel(GetPeopleUseCase getPeopleUsecase) { this.getPeopleUsecase = getPeopleUsecase; }

    public void getPeople() {
        getPeopleUsecase.getPeople();
    }

    public LiveData<PeopleInfo> getLiveData() {
        return getPeopleUsecase.getPeople();
    }

}
