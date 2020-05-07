package com.supermarket.domain.view;

import com.supermarket.domain.Ingredient;
import com.supermarket.domain.ProductBasket;
import com.supermarket.domain.preferences.CaloriesPreference;

import java.util.ArrayList;
import java.util.List;

public class DetailedProductBasket {

    private ProductBasket productBasket;
    private double moneySum;
    private double caloriesSum;

    public DetailedProductBasket(ProductBasket productBasket){
        this.productBasket = productBasket;
        moneySum = calculateMoneySum();
        caloriesSum = calculateCaloriesSum();
    }

    public static List<DetailedProductBasket> toDetailedProductBasket(List<ProductBasket> productBaskets){
        List<DetailedProductBasket> detailedProductBaskets = new ArrayList<>();
        for(ProductBasket pb : productBaskets){
            detailedProductBaskets.add(new DetailedProductBasket(pb));
        }
        return detailedProductBaskets;
    }


    public double calculateMoneySum(){

        return productBasket.getCount()*
                (productBasket.getProduct().getPrice().getPrice()*
                        (1 - productBasket.getProduct().getPrice().getDiscount()));
    }

    public double calculateCaloriesSum(){
        double productMultiplier = 0;
        for(Ingredient ingredient: productBasket.getProduct().getIngredients()){
            productMultiplier += ingredient.getCalories();
        }
        return productMultiplier*productBasket.getCount();
    }

    public ProductBasket getProductBasket() {
        return productBasket;
    }

    public void setProductBasket(ProductBasket productBasket) {
        this.productBasket = productBasket;
    }

    public double getMoneySum() {
        return moneySum;
    }

    public void setMoneySum(double moneySum) {
        this.moneySum = moneySum;
    }

    public double getCaloriesSum() {
        return caloriesSum;
    }

    public void setCaloriesSum(double caloriesSum) {
        this.caloriesSum = caloriesSum;
    }
}
