package com.supermarket.domain.preferences;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@Entity
public class AlcoholPreference extends Preference {

    /**
     * градус.
     */
    @JsonProperty("maxLevel")
    private double maxLevel;

    /**
     * количество.
     */
    @JsonProperty("maxCount")
    private double maxCount;

    public AlcoholPreference() {
        id = UUID.randomUUID().toString();
        preferenceType = "AlcoholPreference";
    }

    public AlcoholPreference(double maxLevel, double maxCount) {
        this.maxCount = maxCount;
        this.maxLevel = maxLevel;
        id = UUID.randomUUID().toString();
        preferenceType = "AlcoholPreference";
    }
}
