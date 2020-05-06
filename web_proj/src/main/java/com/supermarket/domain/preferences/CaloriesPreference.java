package com.supermarket.domain.preferences;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class CaloriesPreference extends Preference {
    private int maxCalories;
    private int minCalories;

    public CaloriesPreference(){}

    public CaloriesPreference(int minCalories, int maxCalories){
        this.maxCalories = maxCalories;
        this.minCalories = minCalories;
    }
}
