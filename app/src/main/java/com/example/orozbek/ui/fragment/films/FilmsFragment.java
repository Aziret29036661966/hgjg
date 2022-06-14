package com.example.orozbek.ui.fragment.films;


import com.example.orozbek.databinding.FragmentFilmsBinding;
import com.example.orozbek.ui.base.BaseFragment;
import com.example.orozbek.ui.fragment.films.adapter.AdapterFilms;


import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FilmsFragment extends BaseFragment<FragmentFilmsBinding> {
    @Inject
    public FilmsViewModel filmsViewModel;
    private AdapterFilms adapterFilms;

    @Override
    protected FragmentFilmsBinding getBinding() {
        return FragmentFilmsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void setupUI() {
        initViewModel();
        initAdapter();
    }

    private void initViewModel() {
        filmsViewModel.getFilms();
    }

    private void initAdapter() {
        adapterFilms = new AdapterFilms();
        binding.rvRcFilms.setAdapter(adapterFilms);
    }

    @Override
    protected void setupObservers() {
        getFilms();
    }

    private void getFilms() {
        filmsViewModel.getData().observe(getViewLifecycleOwner(), filmsInfo -> adapterFilms.setList(filmsInfo.getResults()));
    }

}