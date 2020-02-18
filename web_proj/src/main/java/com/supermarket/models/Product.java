package com.supermarket.models;

import com.supermarket.enums.ProdType;
import com.supermarket.enums.WeightType;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private double discount;
    private double price;
    private Date productionDate;
    private Date expirationDate;

    @Enumerated(EnumType.STRING)
    private WeightType weightType;

    @Enumerated(EnumType.STRING)
    private ProdType prodType;
    private double quantity;

    public Product() {}

    public Product(Long id ,String name, double discount, double price,
                   Date productionDate, Date expirationDate,
                   WeightType weightType, ProdType prodType, double quantity) {

        this.id = id;
        this.name = name;
        this.discount = discount;
        this.price = price;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.weightType = weightType;
        this.prodType = prodType;
        this.quantity = quantity;
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

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}

//package com.example.sweater.domain;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Objects;
//import java.util.Set;
//
//@Entity
////public class Product {
////
////    @Id
////    private Long id;
////
////    private String name;
////
////    @ManyToMany
////    @JoinTable(
////            name = "product_store",
////            joinColumns = @JoinColumn(name = "product__id"),
////            inverseJoinColumns = @JoinColumn(name = "store__id")
////    )
////    private Set<Store> stores= new HashSet<>();
////
////    private Integer price;
////
////    private Integer bonuses;
////
////    public Product() {}
////
////    public Product(Long id, String name, Set<Store> stores, Integer price, Integer bonuses) {
////        this.id = id;
////        this.name = name;
////        this.stores = stores;
////        this.price = price;
////        this.bonuses = bonuses;
////    }
////
////    public void addStore(Store s) {
////        stores.add(s);
////    }
////
////    public Long getId() {
////        return id;
////    }
////
////    public void setId(Long id) {
////        this.id = id;
////    }
////
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    public Set<Store> getStores() {
////        return stores;
////    }
////
////    public void setStores(Set<Store> stores) {
////        this.stores = stores;
////    }
////
////    public Integer getPrice() {
////        return price;
////    }
////
////    public void setPrice(Integer price) {
////        this.price = price;
////    }
////
////    public Integer getBonuses() {
////        return bonuses;
////    }
////
////    public void setBonuses(Integer bonuses) {
////        this.bonuses = bonuses;
////    }
////
////    @Override
////    public String toString() {
////        return "Product{" +
////                "id=" + id +
////                ", name='" + name + '\'' +
////                ", stores=" + stores +
////                ", price=" + price +
////                ", bonuses=" + bonuses +
////                '}';
////    }
////
////    @Override
////    public boolean equals(Object o) {
////        if (this == o) return true;
////        if (o == null || getClass() != o.getClass()) return false;
////        Product product = (Product) o;
////        return Objects.equals(getId(), product.getId()) &&
////                Objects.equals(getName(), product.getName()) &&
////                Objects.equals(getStores(), product.getStores()) &&
////                Objects.equals(getPrice(), product.getPrice()) &&
////                Objects.equals(getBonuses(), product.getBonuses());
////    }
////
////    @Override
////    public int hashCode() {
////        return Objects.hash(getId(), getName(), getStores(), getPrice(), getBonuses());
////    }
////}
//
