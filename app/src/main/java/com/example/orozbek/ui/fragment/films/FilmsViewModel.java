package com.example.orozbek.ui.fragment.films;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.orozbek.domain.entity.films.FilmsInfo;

import com.example.orozbek.domain.useCases.films.GetFilmsUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class FilmsViewModel extends ViewModel {

    private final GetFilmsUseCase getFilmsUseCase;

    @Inject
    public FilmsViewModel(GetFilmsUseCase getFilmsUseCase) {
        this.getFilmsUseCase = getFilmsUseCase;
    }

    public void getFilms() {
        getFilmsUseCase.getFilms();
    }

    public LiveData<FilmsInfo> getData() {
        return getFilmsUseCase.getFilms();
    }


}
