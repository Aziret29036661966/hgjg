package com.example.orozbek.ui.fragment.films.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orozbek.databinding.ItemFilmsBinding;

import com.example.orozbek.domain.entity.films.FilmsResult;

import java.util.ArrayList;
import java.util.List;

public class AdapterFilms extends RecyclerView.Adapter<AdapterFilms.ViewHolder> {

    public List<FilmsResult> list = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setList(List<FilmsResult> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmsBinding itemFilmsBinding = ItemFilmsBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(itemFilmsBinding);
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
        private final ItemFilmsBinding itemFilmsBinding;

        public ViewHolder(ItemFilmsBinding itemFilmsBinding) {
            super(itemFilmsBinding.getRoot());
            this.itemFilmsBinding = itemFilmsBinding;
        }

        @SuppressLint("SetTextI18n")
        public void onBind(FilmsResult filmsResult) {
            itemFilmsBinding.txtName.setText(filmsResult.getTitle());
            itemFilmsBinding.txtDirector.setText(filmsResult.getDirector());
            itemFilmsBinding.txtEpisode.setText(filmsResult.getEpisode_id() + " ");
            itemFilmsBinding.txtProducer.setText(filmsResult.getProducer());
        }
    }
}
