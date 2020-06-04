package com.supermarket.domain.preferences;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.supermarket.domain.ProductPreferences;
import com.supermarket.domain.UserPreferences;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public abstract class Preference {

    @Id
    @JsonProperty("id")
    protected String id;

    @JsonProperty("preferenceType")
    protected String preferenceType;

    @JsonProperty("userPreferences")
    @ManyToMany(mappedBy = "preferences", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserPreferences> userPreferences;

    @JsonProperty("preferencesProduct")
    @ManyToMany(mappedBy = "preferencesProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductPreferences> productPreferences;
}
