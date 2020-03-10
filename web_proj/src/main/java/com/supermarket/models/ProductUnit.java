package com.supermarket.models;

import com.supermarket.enums.ProdType;

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

    /**
     * скидка на товар.
     */
    private double discount;

    /**
     * цена на товар.
     */
    private double price;

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

    public double getDiscount() { return discount; }

    public void setDiscount(double discount) { this.discount = discount; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

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
