package com.supermarket.domain.preferences;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@Entity
public class PropertyPreference extends Preference {

    @JsonProperty("property")
    private String property;

    public PropertyPreference(){
        id = UUID.randomUUID().toString();
        preferenceType = "PropertyPreference";
    }

    public PropertyPreference(String property) {
        this.property = property;
        id = UUID.randomUUID().toString();
        preferenceType = "PropertyPreference";
    }
}
