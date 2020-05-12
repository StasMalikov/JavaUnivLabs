package com.supermarket.services;

import com.supermarket.domain.*;
import com.supermarket.domain.enums.ProdType;
import com.supermarket.domain.enums.Role;
import com.supermarket.domain.enums.WeightType;
import com.supermarket.domain.preferences.AlcoholPreference;
import com.supermarket.domain.preferences.CaloriesPreference;
import com.supermarket.domain.preferences.PropertyPreference;
import com.supermarket.repos.*;
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
    private ProductRepo productRepo;
    private PriceRepo priceRepo;
    private SupermarketUserSevice supermarketUserSevice;
    // not used
    private BasketRepo basketRepo;
    private ProductBasketRepo productBasketRepo;
    private ProductPreferencesRepo productPreferencesRepo;
    private UserPreferencesRepo userPreferencesRepo;

    public DbInitializer(IngredientRepo ingredientRepo, AlcoholPreferenceRepo alcoholPreferenceRepo,
                         CaloriesPreferenceRepo caloriesPreferenceRepo, PropertyPreferenceRepo propertyPreferenceRepo,
                         ProductRepo productRepo,
                         PriceRepo priceRepo, BasketRepo basketRepo, ProductBasketRepo productBasketRepo,
                         ProductPreferencesRepo productPreferencesRepo, UserPreferencesRepo userPreferencesRepo,
                         SupermarketUserSevice supermarketUserSevice){

        this.ingredientRepo = ingredientRepo;
        this.alcoholPreferenceRepo = alcoholPreferenceRepo;
        this.caloriesPreferenceRepo = caloriesPreferenceRepo;
        this.propertyPreferenceRepo = propertyPreferenceRepo;
        this.productRepo = productRepo;
        this.priceRepo = priceRepo;
        this.supermarketUserSevice = supermarketUserSevice;

        // not used
        this.basketRepo = basketRepo;
        this.productBasketRepo = productBasketRepo;
        this.productPreferencesRepo = productPreferencesRepo;
        this.userPreferencesRepo = userPreferencesRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        //deleteAll();
        // not used
        initProductBasket();
        initProductPreferences();
        initUserPreferences();
        initBasket();


        //used
        initPrice();
        initIngredients();
        initPreferences();
        initUsers();
        initProducts();
    }

    public void deleteAll(){
        productBasketRepo.deleteAll();
        productPreferencesRepo.deleteAll();
        userPreferencesRepo.deleteAll();
        basketRepo.deleteAll();

        List<Product> pList = productRepo.findAll();
        for(Product p : pList){
            p.clearIngredients();
            productRepo.save(p);
        }

        List<Ingredient> iList = ingredientRepo.findAll();
        for(Ingredient i : iList){
            i.clearProducts();
            ingredientRepo.save(i);
        }
        productRepo.deleteAll();

        caloriesPreferenceRepo.deleteAll();
        alcoholPreferenceRepo.deleteAll();
        propertyPreferenceRepo.deleteAll();


        ingredientRepo.deleteAll();
        supermarketUserSevice.deleteAll();
    }

    public void initProductBasket() {

    }

    public void initProductPreferences() {

    }

    public void initUserPreferences() {

    }

    public void initBasket() {

    }

    public void initProducts(){

        Calendar c1 = new GregorianCalendar();
        Set<Ingredient> i1 = new HashSet<>();
        i1.add(ingredientRepo.findByName("Сахар"));
        i1.add(ingredientRepo.findByName("Мука"));
        i1.add(ingredientRepo.findByName("Соль"));
        i1.add(ingredientRepo.findByName("Куриное яйцо"));
        productRepo.save( new Product("Хлеб",5, 120, c1,
                WeightType.KILOGRAM, ProdType.BREAD, i1, priceRepo.findByPrice(30)));

        Set<Ingredient> i2 = new HashSet<>();
        i2.add(ingredientRepo.findByName("Огурцы"));
        i2.add(ingredientRepo.findByName("Помидоры"));
        i2.add(ingredientRepo.findByName("Соль"));
        i2.add(ingredientRepo.findByName("Масло оливковое"));
        productRepo.save( new Product("Салат овощной",3, 24, c1,
                WeightType.KILOGRAM, ProdType.VEGETABLES, i2, priceRepo.findByPrice(150)));

        Set<Ingredient> i3 = new HashSet<>();
        i3.add(ingredientRepo.findByName("Сахар"));
        i3.add(ingredientRepo.findByName("Мука"));
        i3.add(ingredientRepo.findByName("Куриное яйцо"));
        i3.add(ingredientRepo.findByName("Шоколад"));
        productRepo.save( new Product("Булочка с шоколадом",7, 30, c1,
                WeightType.PIECE, ProdType.BREAD, i3, priceRepo.findByPrice(45)));

        Set<Ingredient> i4 = new HashSet<>();
        i4.add(ingredientRepo.findByName("Вода"));
        i4.add(ingredientRepo.findByName("Висковые зерновые десциляторы"));
        productRepo.save( new Product("Виски Джим Бим",2, 500, c1,
                WeightType.PIECE, ProdType.ALCOHOL, i4, priceRepo.findByPrice(400)));

        Set<Ingredient> i5 = new HashSet<>();
        i5.add(ingredientRepo.findByName("Вода"));
        productRepo.save( new Product("Вода Архыз питьевая столовая газ",10, 1000, c1,
                WeightType.PIECE, ProdType.SOFTDRINK, i5, priceRepo.findByPrice(35)));

        Set<Ingredient> i6 = new HashSet<>();
        i6.add(ingredientRepo.findByName("Свинина жирная"));
        i6.add(ingredientRepo.findByName("Куриное яйцо"));
        i6.add(ingredientRepo.findByName("Мука"));
        productRepo.save( new Product("Отбивная из свинины",3, 24, c1,
                WeightType.KILOGRAM, ProdType.MEAT, i6, priceRepo.findByPrice(450)));
    }

    public void initPrice() {

        priceRepo.save(new Price(0, 30));
        priceRepo.save(new Price(0, 150));
        priceRepo.save(new Price(0, 45));
        priceRepo.save(new Price(0, 400));
        priceRepo.save(new Price(0, 35));
        priceRepo.save(new Price(0, 450));
    }

    public void initUsers() {

        SupermarketUser user = new SupermarketUser("user", "user");
        supermarketUserSevice.registerUser(user);

        SupermarketUser user2 = new SupermarketUser("u", "u");
        supermarketUserSevice.registerUser(user2);

        SupermarketUser admin = new SupermarketUser("admin", "admin");
        supermarketUserSevice.registerAdmin(admin);
    }

    public void initPreferences(){

//        caloriesPreferenceRepo.save(new CaloriesPreference(0, 2000));
//        caloriesPreferenceRepo.save(new CaloriesPreference(3000, 0));
//
//        alcoholPreferenceRepo.save(new AlcoholPreference(0,0));
//        alcoholPreferenceRepo.save(new AlcoholPreference(40,300));
//        alcoholPreferenceRepo.save(new AlcoholPreference(10,750));

        propertyPreferenceRepo.save(new PropertyPreference("muslim religion"));
    }

    public void initIngredients(){

        ingredientRepo.save(new Ingredient("Сахар", 398));
        ingredientRepo.save(new Ingredient("Соль", 70));
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
        ingredientRepo.save(new Ingredient("Масло оливковое", 300));
        ingredientRepo.save(new Ingredient("Вода", 20));
        ingredientRepo.save(new Ingredient("Висковые зерновые десциляторы", 250));
    }
}
