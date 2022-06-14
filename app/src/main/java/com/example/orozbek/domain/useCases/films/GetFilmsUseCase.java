package com.example.orozbek.domain.useCases.films;

import androidx.lifecycle.LiveData;

import com.example.orozbek.domain.entity.films.FilmsInfo;

import com.example.orozbek.domain.repo.MainRepository;

import javax.inject.Inject;

public class GetFilmsUseCase {
    private final MainRepository repository;
    @Inject
    public GetFilmsUseCase(MainRepository repository) {
        this.repository = repository;
    }

    public LiveData<FilmsInfo> getFilms() {
        return repository.getFilms();
    }
}
