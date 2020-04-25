package com.supermarket.domain;

import com.supermarket.domain.enums.Preferences;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private SupermarketUser user;

    /**
     * Предпочтения пользователя.
     */
    @ElementCollection(targetClass = Preferences.class, fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private Set<Preferences> preferences;
}
