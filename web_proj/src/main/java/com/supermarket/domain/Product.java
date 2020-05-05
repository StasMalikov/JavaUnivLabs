package com.supermarket.domain;

import com.supermarket.domain.enums.ProdType;
import com.supermarket.domain.enums.WeightType;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    private String id;

    private String name;

    /**
     * срок годности в часах.
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "product_ingredient",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients;

    private Calendar productionDate;

    /**
     * количество товара.
     */
    private double quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="price_id", nullable=false)
    private Price price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "preferences_id", referencedColumnName = "id")
    private ProductPreferences preferences;


    @Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductBasket> productBaskets;

    public void clearIngredients(){
        ingredients.clear();
    }

    public Product() {
        id = UUID.randomUUID().toString();
    }

    public Product(String name, double quantity, Integer expirationDate, Calendar productionDate,
                   WeightType weightType, ProdType prodType, Set<Ingredient> ingredients, Price price) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.expirationDate = expirationDate;
        this.productionDate = productionDate;
        this.weightType = weightType;
        this.prodType = prodType;
        this.ingredients = ingredients;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, double quantity, Integer expirationDate, Calendar productionDate,
                   WeightType weightType, ProdType prodType, Set<Ingredient> ingredients, Price price, ProductPreferences preferences) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.expirationDate = expirationDate;
        this.productionDate = productionDate;
        this.weightType = weightType;
        this.prodType = prodType;
        this.ingredients = ingredients;
        this.price = price;
        this.preferences = preferences;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public ProductPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(ProductPreferences preferences) {
        this.preferences = preferences;
    }

    public List<ProductBasket> getProductBaskets() {
        return productBaskets;
    }

    public void setProductBaskets(List<ProductBasket> productBaskets) {
        this.productBaskets = productBaskets;
    }
}
