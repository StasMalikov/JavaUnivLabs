package com.supermarket.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingredient_id")
    private Long id;

    private String name;

    /**
     * calories per 100 grams.
     */
    private Integer calories;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    public Ingredient() {}

    public Ingredient(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

}
