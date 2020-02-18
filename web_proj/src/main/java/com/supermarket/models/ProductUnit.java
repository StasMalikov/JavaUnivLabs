package com.supermarket.models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class ProductUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * продукт, от которого наследуется данный эеземпляр продукта.
     */
    @ManyToOne
    @JoinColumn
    private Product productInfo;

    /**
     * дата изготовлениея.
     */
    private Calendar productionDate;

    /**
     * количество товара.
     */
    private double quantity;
}
