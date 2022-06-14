package com.example.orozbek.ui.fragment.main;

import com.example.orozbek.ui.base.BaseFragment;
import com.example.orozbek.databinding.FragmentMainBinding;
import com.example.orozbek.ui.fragment.main.adapter.AdapterMain;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class MainFragment extends BaseFragment<FragmentMainBinding> {
    @Inject
    public MainViewModel viewModel;
    private AdapterMain adapterMainFragment;

    @Override
    protected FragmentMainBinding getBinding() {
        return FragmentMainBinding.inflate(getLayoutInflater());
    }

    @Override
    public void setupUI() {
        initViewModel();
        initAdapter();
    }

    private void initViewModel() { viewModel.getPeople(); }

    private void initAdapter() {
        adapterMainFragment = new AdapterMain();
        binding.rvRc.setAdapter(adapterMainFragment);
    }

    @Override
    protected void setupObservers() {
        getPeople();
    }

    private void getPeople() {
        viewModel.getLiveData().observe(getViewLifecycleOwner(), info -> adapterMainFragment.setList(info.getResults()));
    }

}