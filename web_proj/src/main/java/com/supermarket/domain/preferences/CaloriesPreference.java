package com.supermarket.domain.preferences;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class CaloriesPreference extends Preference {
    private int maxCaloriel;
    private int minCalories;
}
