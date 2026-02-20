package com.example.pizzarecipes.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {
    private final Context ctx;
    private final List<Produit> pizzas;

    public PizzaAdapter(Context ctx, List<Produit> pizzas) {
        this.ctx = ctx;
        this.pizzas = pizzas;
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pizzas.get(position).getId();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(ctx).inflate(R.layout.row_pizza, parent, false);
        }
        ImageView img = convertView.findViewById(R.id.imgPizza);
        TextView tvNom = convertView.findViewById(R.id.tvNom);
        TextView tvMeta = convertView.findViewById(R.id.tvMeta);

        Produit p = pizzas.get(position);
        img.setImageResource(p.getImageRes());
        tvNom.setText(p.getNom());
        tvMeta.setText(p.getDuree() + " • " + p.getPrix() + " £");

        return convertView;
    }
}

