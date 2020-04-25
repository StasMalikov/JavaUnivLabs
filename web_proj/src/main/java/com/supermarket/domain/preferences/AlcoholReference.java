package com.supermarket.domain.preferences;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class AlcoholReference extends Preference {

    /**
     * градус.
     */
    private double maxLevel;

    /**
     * количество.
     */
    private double maxCount;
}
