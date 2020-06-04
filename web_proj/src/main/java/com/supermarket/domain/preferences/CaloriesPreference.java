package com.supermarket.domain.preferences;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@Entity
public class CaloriesPreference extends Preference {

    @JsonProperty("maxCalories")
    private int maxCalories;

    @JsonProperty("minCalories")
    private int minCalories;

    public CaloriesPreference(){
        id = UUID.randomUUID().toString();
        preferenceType = "CaloriesPreference";
    }

    public CaloriesPreference(int minCalories, int maxCalories){
        this.maxCalories = maxCalories;
        this.minCalories = minCalories;
        id = UUID.randomUUID().toString();
        preferenceType = "CaloriesPreference";
    }
}
