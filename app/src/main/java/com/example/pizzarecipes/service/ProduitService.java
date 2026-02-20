package com.example.pizzarecipes.service;

import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.dao.IDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    private static ProduitService INSTANCE;
    private final List<Produit> data = new ArrayList<>();

    private ProduitService() {
        seed(); // préremplissage
    }

    public static ProduitService getInstance() {
        if (INSTANCE == null) INSTANCE = new ProduitService();
        return INSTANCE;
    }

    private void seed() {
        data.add(new Produit("BARBECUED CHICKEN PIZZA", 3.0,
                com.example.pizzarecipes.R.mipmap.pizza1, "35 min",
                "- 2 boneless skinless chicken breast halves\n- 1 cup barbecue sauce...",
                "Pizza au poulet barbecue simple et rapide.",
                "STEP 1: Griller le poulet.\nSTEP 2: Garnir et cuire."));
        data.add(new Produit("SPINACH PIZZA", 2.0,
                com.example.pizzarecipes.R.mipmap.pizza2, "25 min",
                "- Sauce Alfredo, épinards, tomates, fromage.",
                "Pizza crémeuse et légère aux légumes.",
                "STEP 1: Étaler la pâte.\nSTEP 2: Ajouter la garniture."));
    }

    @Override
    public Produit create(Produit produit) {
        data.add(produit);
        return produit;
    }

    @Override
    public Produit update(Produit produit) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == produit.getId()) {
                data.set(i, produit);
                return produit;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        return data.removeIf(produit -> produit.getId() == id);
    }

    @Override
    public Produit findById(long id) {
        for (Produit produit : data) {
            if (produit.getId() == id) return produit;
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return Collections.unmodifiableList(data);
    }
}
