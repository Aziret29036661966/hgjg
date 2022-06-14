package com.example.orozbek.ui.fragment.planets;

import com.example.orozbek.databinding.FragmentPlanetsBinding;

import com.example.orozbek.ui.base.BaseFragment;

import com.example.orozbek.ui.fragment.planets.adapter.AdapterPlanets;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PlanetsFragment extends BaseFragment<FragmentPlanetsBinding> {

    @Inject
    public PlanetsViewModel viewModel;
    private AdapterPlanets adapterPlanets;


    @Override
    protected FragmentPlanetsBinding getBinding() {
        return FragmentPlanetsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void setupUI() {
        initViewModel();
        initAdapter();
    }

    private void initAdapter() {
        viewModel.getPlanets();
    }

    private void initViewModel() {
        adapterPlanets = new AdapterPlanets();
        binding.rvRc.setAdapter(adapterPlanets);
    }

    @Override
    protected void setupObservers() {
         getPlanets();
    }

    private void getPlanets() {
        viewModel.LiveData().observe(getViewLifecycleOwner(), planetsInfo -> adapterPlanets.setList(planetsInfo.getResults()));
    }
}