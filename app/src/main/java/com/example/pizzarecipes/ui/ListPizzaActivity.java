package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.adapter.PizzaAdapter;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

import java.util.List;

public class ListPizzaActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        ListView lvPizzas = findViewById(R.id.lvPizzas);
        List<Produit> pizzas = ProduitService.getInstance().findAll();
        lvPizzas.setAdapter(new PizzaAdapter(this, pizzas));

        lvPizzas.setOnItemClickListener((parent, view, position, id) -> {
            Intent it = new Intent(this, DetailPizzaActivity.class);
            it.putExtra("id", pizzas.get(position).getId());
            startActivity(it);
        });
    }
}
