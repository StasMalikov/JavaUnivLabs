package com.supermarket.domain;

import com.supermarket.domain.enums.Preferences;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Product product;

    @ElementCollection(targetClass = Preferences.class, fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private Set<Preferences> preferences;
}
