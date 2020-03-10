package com.supermarket.models;

import com.supermarket.enums.Preferences;
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

    /**
     * Принадлежность продукта к предпочтениям.
     */
    @ElementCollection(targetClass = Preferences.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Preferences> prodProperties;

    @OneToMany(mappedBy = "productInfo", cascade = CascadeType.ALL)
    private Set<ProductUnit> productUnits;

    public Product() {}

    public Set<Preferences> getProdProperties() {
        return prodProperties;
    }

    public void setProdProperties(Set<Preferences> prodProperties) {
        this.prodProperties = prodProperties;
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
