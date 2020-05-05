package com.supermarket.domain;

import com.supermarket.domain.enums.BasketStatus;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @Column(name = "basket_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private SupermarketUser customer;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<ProductBasket> productBaskets;

    private Date purchasesDate;

    private BasketStatus status;

    public Basket(){
        productBaskets = new ArrayList<>();
        status = BasketStatus.RESERVED;
    }

    public Basket(SupermarketUser customer){
        this.customer = customer;
        productBaskets = new ArrayList<>();
        status = BasketStatus.RESERVED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SupermarketUser getCustomer() {
        return customer;
    }

    public void setCustomer(SupermarketUser customer) {
        this.customer = customer;
    }

    public List<ProductBasket> getProductBaskets() {
        return productBaskets;
    }

    public void setProductBaskets(List<ProductBasket> productBaskets) {
        this.productBaskets = productBaskets;
    }

    public Date getPurchasesDate() {
        return purchasesDate;
    }

    public void setPurchasesDate(Date purchasesDate) {
        this.purchasesDate = purchasesDate;
    }

    public BasketStatus getStatus() {
        return status;
    }

    public void setStatus(BasketStatus status) {
        this.status = status;
    }
}
