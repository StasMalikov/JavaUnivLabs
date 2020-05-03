package com.supermarket.services;

import com.supermarket.domain.Ingredient;
import com.supermarket.domain.Price;
import com.supermarket.domain.Product;
import com.supermarket.domain.SupermarketUser;
import com.supermarket.domain.enums.ProdType;
import com.supermarket.domain.enums.Role;
import com.supermarket.domain.enums.WeightType;
import com.supermarket.domain.preferences.AlcoholPreference;
import com.supermarket.domain.preferences.CaloriesPreference;
import com.supermarket.domain.preferences.PropertyPreference;
import com.supermarket.repos.IngredientRepo;
import com.supermarket.repos.PriceRepo;
import com.supermarket.repos.ProductRepo;
import com.supermarket.repos.SupermarketUserRepo;
import com.supermarket.repos.preferences.AlcoholPreferenceRepo;
import com.supermarket.repos.preferences.CaloriesPreferenceRepo;
import com.supermarket.repos.preferences.PropertyPreferenceRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@ConditionalOnProperty(name = "app.init-db", havingValue = "true")
public class DbInitializer implements CommandLineRunner {

    private IngredientRepo ingredientRepo;
    private AlcoholPreferenceRepo alcoholPreferenceRepo;
    private CaloriesPreferenceRepo caloriesPreferenceRepo;
    private PropertyPreferenceRepo propertyPreferenceRepo;
    private SupermarketUserRepo supermarketUserRepo;
    private ProductRepo productRepo;
    private PriceRepo priceRepo;


    public DbInitializer(IngredientRepo ingredientRepo, AlcoholPreferenceRepo alcoholPreferenceRepo,
                         CaloriesPreferenceRepo caloriesPreferenceRepo, PropertyPreferenceRepo propertyPreferenceRepo,
                         SupermarketUserRepo supermarketUserRepo, ProductRepo productRepo,
                         PriceRepo priceRepo){

        this.ingredientRepo = ingredientRepo;
        this.alcoholPreferenceRepo = alcoholPreferenceRepo;
        this.caloriesPreferenceRepo = caloriesPreferenceRepo;
        this.propertyPreferenceRepo = propertyPreferenceRepo;
        this.supermarketUserRepo = supermarketUserRepo;
        this.productRepo = productRepo;
        this.priceRepo = priceRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        initPrice();
        initIngredients();
        initPreferences();
        initUsers();
        initProducts();
    }


    public void initProducts(){
        productRepo.deleteAll();

        Calendar c1 = new GregorianCalendar();
        Set<Ingredient> i1 = new HashSet<>();
        i1.add(ingredientRepo.findByName("Сахар"));
        i1.add(ingredientRepo.findByName("Мука"));
        i1.add(ingredientRepo.findByName("Куриное яйцо"));
        productRepo.save( new Product("Хлеб",5, 120, c1,
                WeightType.KILOGRAM, ProdType.BREAD, i1, priceRepo.findByPrice(30)));

        Set<Ingredient> i2 = new HashSet<>();
        i2.add(ingredientRepo.findByName("Огурцы"));
        i2.add(ingredientRepo.findByName("Помидоры"));
        productRepo.save( new Product("Салат овощной",3, 24, c1,
                WeightType.KILOGRAM, ProdType.VEGETABLES, i2, priceRepo.findByPrice(200)));

    }

    public void initPrice() {
        priceRepo.deleteAll();

        priceRepo.save(new Price(0, 30));
        priceRepo.save(new Price(0, 200));
    }

    public void initUsers() {
        supermarketUserRepo.deleteAll();

        SupermarketUser user = new SupermarketUser();
        user.setUsername("user");
        user.setPassword("user");
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        supermarketUserRepo.save(user);

        SupermarketUser admin = new SupermarketUser();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setActive(true);
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        roles.add(Role.ADMIN);
        admin.setRoles(roles);
        supermarketUserRepo.save(admin);
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

        ingredientRepo.save(new Ingredient("Сахар", 398));
        ingredientRepo.save(new Ingredient("Шоколад", 544));
        ingredientRepo.save(new Ingredient("Мука", 321));
        ingredientRepo.save(new Ingredient("Молоко 2,5%", 52));
        ingredientRepo.save(new Ingredient("Сливки 15%", 161));
        ingredientRepo.save(new Ingredient("Скумбрия", 191));
        ingredientRepo.save(new Ingredient("Огурцы", 15));
        ingredientRepo.save(new Ingredient("Помидоры", 20));
        ingredientRepo.save(new Ingredient("Морковь", 32));
        ingredientRepo.save(new Ingredient("Говядина", 191));
        ingredientRepo.save(new Ingredient("Свинина жирная", 484));
        ingredientRepo.save(new Ingredient("Куриное яйцо", 157));
    }
}
