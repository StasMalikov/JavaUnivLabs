package com.supermarket.domain.preferences;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class AlcoholPreference extends Preference {

    /**
     * градус.
     */
    private double maxLevel;

    /**
     * количество.
     */
    private double maxCount;

    public AlcoholPreference() {}

    public AlcoholPreference(double maxLevel, double maxCount) {
        this.maxCount = maxCount;
        this.maxLevel = maxLevel;
    }
}
