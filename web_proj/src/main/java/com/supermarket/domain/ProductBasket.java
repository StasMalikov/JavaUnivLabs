package com.supermarket.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "product_basket")
public class ProductBasket {

    @Id
    @Column(name = "id")
    private String id;

    private double count;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="basket_id", nullable=true)
    private Basket basket;

    public ProductBasket(){
        id = UUID.randomUUID().toString();
    }

    public ProductBasket(Product product, double count, Basket basket){
        id = UUID.randomUUID().toString();
        this.product = product;
        this.count = count;
        this.basket = basket;
    }
}
