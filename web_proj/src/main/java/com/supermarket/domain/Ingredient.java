package com.supermarket.domain;

import javax.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer calories;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Product products;
}
