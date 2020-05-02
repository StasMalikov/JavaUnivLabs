package com.supermarket.services;

import com.supermarket.domain.Ingredient;
import com.supermarket.domain.preferences.AlcoholPreference;
import com.supermarket.domain.preferences.CaloriesPreference;
import com.supermarket.domain.preferences.PropertyPreference;
import com.supermarket.repos.IngredientRepo;
import com.supermarket.repos.preferences.AlcoholPreferenceRepo;
import com.supermarket.repos.preferences.CaloriesPreferenceRepo;
import com.supermarket.repos.preferences.PropertyPreferenceRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.init-db", havingValue = "true")
public class DbInitializer implements CommandLineRunner {

    private IngredientRepo ingredientRepo;
    private AlcoholPreferenceRepo alcoholPreferenceRepo;
    private CaloriesPreferenceRepo caloriesPreferenceRepo;
    private PropertyPreferenceRepo propertyPreferenceRepo;


    public DbInitializer(IngredientRepo ingredientRepo, AlcoholPreferenceRepo alcoholPreferenceRepo,
                         CaloriesPreferenceRepo caloriesPreferenceRepo, PropertyPreferenceRepo propertyPreferenceRepo){

        this.ingredientRepo = ingredientRepo;
        this.alcoholPreferenceRepo = alcoholPreferenceRepo;
        this.caloriesPreferenceRepo = caloriesPreferenceRepo;
        this.propertyPreferenceRepo = propertyPreferenceRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        initIngredients();
        initPreferences();
    }

    public void initPreferences(){
        caloriesPreferenceRepo.deleteAll();
        alcoholPreferenceRepo.deleteAll();
        propertyPreferenceRepo.deleteAll();


        caloriesPreferenceRepo.save(new CaloriesPreference(0, 2000));
        caloriesPreferenceRepo.save(new CaloriesPreference(3000, 0));

        alcoholPreferenceRepo.save(new AlcoholPreference(0,0));
        alcoholPreferenceRepo.save(new AlcoholPreference(40,300));
        alcoholPreferenceRepo.save(new AlcoholPreference(10,750));

        propertyPreferenceRepo.save(new PropertyPreference("muslim religion"));
    }

    public void initIngredients(){
        ingredientRepo.deleteAll();

        List<Ingredient> ing = new ArrayList<>();
        ing.add(new Ingredient("Сахар", 398));
        ing.add(new Ingredient("Шоколад", 544));
        ing.add(new Ingredient("Мука", 321));
        ing.add(new Ingredient("Молоко 2,5%", 52));
        ing.add(new Ingredient("Сливки 15%", 161));
        ing.add(new Ingredient("Скумбрия", 191));
        ing.add(new Ingredient("Огурцы", 15));
        ing.add(new Ingredient("Помидоры", 20));
        ing.add(new Ingredient("Морковь", 32));
        ing.add(new Ingredient("Говядина", 191));
        ing.add(new Ingredient("Свинина жирная", 484));
        ing.add(new Ingredient("Куриное яйцо", 157));

        ingredientRepo.saveAll(ing);
    }
}
