package com.supermarket.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * скидка на товар.
     */
    private double discount;

    /**
     * цена на товар.
     */
    private double price;

}
