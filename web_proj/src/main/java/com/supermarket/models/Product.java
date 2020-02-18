package com.supermarket.models;

import com.supermarket.enums.ProdType;
import com.supermarket.enums.WeightType;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * название товара.
     */
    private String name;

    /**
     * скидка на товар.
     */
    private double discount;

    /**
     * цена на товар.
     */
    private double price;

    /**
     * срок годности.
     */
    private Integer expirationDate;


    /**
     * тип измеряемости товара.
     */
    @Enumerated(EnumType.STRING)
    private WeightType weightType;


    /**
     * категория товара.
     */
    @Enumerated(EnumType.STRING)
    private ProdType prodType;

    @OneToMany(mappedBy = "productInfo", cascade = CascadeType.ALL)
    private Set<ProductUnit> productUnits;

    public Product() {}

    public Product(String name, double discount, double price, Integer expirationDate,
                   WeightType weightType, ProdType prodType) {
        this.name = name;
        this.discount = discount;
        this.price = price;
        this.expirationDate = expirationDate;
        this.weightType = weightType;
        this.prodType = prodType;
    }

    public Set<ProductUnit> getProductUnits() {
        return productUnits;
    }

    public void setProductUnits(Set<ProductUnit> productUnits) {
        this.productUnits = productUnits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    public WeightType getWeightType() {
        return weightType;
    }

    public void setWeightType(WeightType weightType) {
        this.weightType = weightType;
    }

    public ProdType getProdType() {
        return prodType;
    }

    public void setProdType(ProdType prodType) {
        this.prodType = prodType;
    }
}
