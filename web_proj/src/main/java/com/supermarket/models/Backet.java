package com.supermarket.models;

import com.supermarket.enums.BacketStatus;
import java.util.Date;
import java.util.List;

public class Backet {
    /**
     * покупатель.
     */
    private User customer;

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

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
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
