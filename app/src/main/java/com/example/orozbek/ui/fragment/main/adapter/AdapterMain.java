package com.example.orozbek.ui.fragment.main.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orozbek.databinding.ItemPeopleBinding;

import com.example.orozbek.domain.entity.people.PeopleResult;

import java.util.ArrayList;
import java.util.List;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {

    public List<PeopleResult> list = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setList(List<PeopleResult> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPeopleBinding binding = ItemPeopleBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemPeopleBinding binding;

        public ViewHolder(ItemPeopleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(PeopleResult result) {
            binding.txtHeight.setText(result.getHeight());
            binding.txtName.setText(result.getName());
            binding.txtMass.setText(result.getMass());

        }
    }

}

