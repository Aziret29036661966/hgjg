package com.example.orozbek.ui.fragment.main;

import androidx.lifecycle.ViewModelProvider;

import com.example.orozbek.base.BaseFragment;
import com.example.orozbek.databinding.FragmentMainBinding;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class MainFragment extends BaseFragment<FragmentMainBinding> {

    private MainViewModel viewModel;
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

    private void initViewModel() {
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        viewModel.getPeople();
    }

    private void initAdapter() {
        adapterMainFragment = new AdapterMain();
        binding.rvRc.setAdapter(adapterMainFragment);
    }

    @Override
    protected void setupObservers() {

        getPeople();

    }

    private void getPeople() {
        viewModel.getLiveData().observe(getViewLifecycleOwner(), info -> {
            adapterMainFragment.setList(info.getResults());
        });
    }

}