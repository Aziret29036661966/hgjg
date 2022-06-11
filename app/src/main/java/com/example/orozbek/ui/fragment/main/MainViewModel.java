package com.example.orozbek.ui.fragment.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.orozbek.data.network.repos.MainRepo;
import com.example.orozbek.domain.entity.Info;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel  extends ViewModel {

    private final MainRepo repository;
    private LiveData<Info> liveData;


    @Inject
    public MainViewModel(MainRepo repository) {
        this.repository = repository;
        liveData = new MutableLiveData<>();
    }
    public void getPeople() { liveData = repository.getPeople(); }

    public LiveData<Info> getLiveData() {
        return liveData;
    }
}
