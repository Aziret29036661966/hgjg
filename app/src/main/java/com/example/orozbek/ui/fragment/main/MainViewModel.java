package com.example.orozbek.ui.fragment.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.orozbek.data.network.repos.MainRepoImpl;
import com.example.orozbek.domain.entity.Info;
import com.example.orozbek.domain.repo.MainRepository;
import com.example.orozbek.domain.useCases.GetPeopleUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private LiveData<Info> liveData;
    private GetPeopleUseCase getPeopleUsecase;

    @Inject
    public MainViewModel(GetPeopleUseCase repository) {
        getPeopleUsecase = repository;
        liveData = new MutableLiveData<>();
    }

    public void getPeople() {
        getPeopleUsecase.getPeople();
    }
    public LiveData<Info> getLiveData() {
        return liveData;
    }
}
