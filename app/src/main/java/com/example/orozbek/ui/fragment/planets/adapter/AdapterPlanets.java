package com.example.orozbek.ui.fragment.planets.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orozbek.databinding.ItemPlanetsBinding;
import com.example.orozbek.domain.entity.planets.PlanetsResult;

import java.util.ArrayList;
import java.util.List;

public class AdapterPlanets extends RecyclerView.Adapter<AdapterPlanets.ViewHolder> {

    public List<PlanetsResult> list = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setList(List<PlanetsResult> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterPlanets.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPlanetsBinding binding = ItemPlanetsBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPlanets.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemPlanetsBinding binding;

        public ViewHolder(ItemPlanetsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(PlanetsResult planetsResult) {
            binding.txtOrbitalPeriod.setText(planetsResult.getOrbital_period());
            binding.txtName.setText(planetsResult.getName());
            binding.txtRotationPeriod.setText(planetsResult.getRotation_period());
        }
    }
}
