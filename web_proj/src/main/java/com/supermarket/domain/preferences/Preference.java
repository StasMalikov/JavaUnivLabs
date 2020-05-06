package com.supermarket.domain.preferences;

import com.supermarket.domain.ProductPreferences;
import com.supermarket.domain.UserPreferences;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "preference_id")
    private Long id;

    @ManyToMany(mappedBy = "preferences", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserPreferences> userPreferences;

    @ManyToMany(mappedBy = "preferencesProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductPreferences> productPreferences;
}
