package com.example.pizzarecipes.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

public class DetailPizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        long id = getIntent().getLongExtra("id", -1);
        Produit p = ProduitService.getInstance().findById(id);

        ImageView img = findViewById(R.id.img);
        TextView title = findViewById(R.id.title);
        TextView meta = findViewById(R.id.meta);
        TextView ingredients = findViewById(R.id.ingredients);
        TextView desc = findViewById(R.id.desc);
        TextView steps = findViewById(R.id.steps);

        Button btnRetour = findViewById(R.id.btnRetour);
        btnRetour.setOnClickListener(v -> {
            finish(); // This closes the activity and goes back
        });

        if(p != null) {
            img.setImageResource(p.getImageRes());
            title.setText(p.getNom());
            meta.setText(p.getDuree() + " • " + p.getPrix() + " €");
            ingredients.setText(p.getIngredients());
            desc.setText(p.getDescription());
            steps.setText(p.getEtapes());
        }
        else {
            title.setText("Pizza introuvable");
        }
    }
}
