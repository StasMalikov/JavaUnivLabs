package com.supermarket.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_basket")
public class ProductBasket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private double count;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="basket_id", nullable=false)
    private Basket basket;

    public ProductBasket(){}

    public ProductBasket(Product product, double count, Basket basket){
        this.product = product;
        this.count = count;
        this.basket = basket;
    }
}
