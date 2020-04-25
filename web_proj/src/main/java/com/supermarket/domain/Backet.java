package com.supermarket.domain;

import com.supermarket.domain.enums.BacketStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Backet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * покупатель.
     */
    private SupermarketUser customer;

    /**
     * покупки.
     */
    private List<ProductUnit> purchases;

    /**
     * дата покупки.
     */
    private Date purchasesDate;

    /**
     * состояние, в котором находится заказ.
     */
    private BacketStatus status;

    public SupermarketUser getCustomer() {
        return customer;
    }

    public void setCustomer(SupermarketUser customer) {
        this.customer = customer;
    }

    public List<ProductUnit> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<ProductUnit> purchases) {
        this.purchases = purchases;
    }

    public Date getPurchasesDate() {
        return purchasesDate;
    }

    public void setPurchasesDate(Date purchasesDate) {
        this.purchasesDate = purchasesDate;
    }

    public BacketStatus getStatus() {
        return status;
    }

    public void setStatus(BacketStatus status) {
        this.status = status;
    }
}
