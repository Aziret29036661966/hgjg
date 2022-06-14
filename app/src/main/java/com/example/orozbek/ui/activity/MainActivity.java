package com.example.orozbek.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;


import android.os.Bundle;

import com.example.orozbek.R;
import com.example.orozbek.databinding.ActivityMain2Binding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMain2Binding binding;
    private NavController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initController();
        initBottomNavigation();
    }

    private void initController() {
        NavHostFragment navHostController = (NavHostFragment)
                this.getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment);
        if (navHostController != null) {
            controller = navHostController.getNavController();
        }
    }

    private void initBottomNavigation() {
        NavigationUI.setupWithNavController(binding.bottomNavigation, controller);
    }
}