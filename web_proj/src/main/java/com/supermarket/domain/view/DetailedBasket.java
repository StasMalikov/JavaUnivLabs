package com.supermarket.domain.view;

import com.supermarket.domain.Basket;
import com.supermarket.domain.Ingredient;
import com.supermarket.domain.ProductBasket;

import java.util.ArrayList;
import java.util.List;

public class DetailedBasket {

   private Basket basket;
   private double moneySum;
   private double caloriesSum;

   public DetailedBasket(Basket basket) {
       this.basket = basket;
       moneySum = calculateMoneySum();
       caloriesSum = calculateCaloriesSum();
   }

   public static List<DetailedBasket> toDetailedBaskets(List<Basket> baskets){
       List<DetailedBasket> detailedBaskets = new ArrayList<>();
       for(Basket b : baskets){
           detailedBaskets.add(new DetailedBasket(b));
       }
       return detailedBaskets;
   }

    public double calculateMoneySum(){
        double result = 0;
        for(ProductBasket productBasket: basket.getProductBaskets()){
            result += productBasket.getCount()*
                    (productBasket.getProduct().getPrice().getPrice()*
                            (1 - productBasket.getProduct().getPrice().getDiscount()));
        }
        return result;
    }

    public double calculateCaloriesSum(){
       double result = 0;
        for(ProductBasket productBasket: basket.getProductBaskets()){
            double productMultiplier = 0;
            for(Ingredient ingredient: productBasket.getProduct().getIngredients()){
                productMultiplier += ingredient.getCalories();
            }
            result += productMultiplier*productBasket.getCount();
        }
        return result;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
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
