package com.supermarket.domain;

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
    @JoinColumn(name="product_id", nullable=false)
    private Product productInfo;

    /**
     * дата изготовлениея.
     */
    private Calendar productionDate;

    /**
     * количество товара.
     */
    private double quantity;

    /**
     * цена товара.
     */
    private Price price;

    public ProductUnit() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(Product productInfo) {
        this.productInfo = productInfo;
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
