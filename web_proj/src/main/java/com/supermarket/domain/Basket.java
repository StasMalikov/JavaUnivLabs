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

    public boolean haveProduct(String productId){
        for(ProductBasket pb : productBaskets){
            if (pb.getProduct().getId().equals(productId))
                return true;
        }
        return false;
    }

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

    public void addProduct(ProductBasket product){
        productBaskets.add(product);
    }

    public void deleteProductBasket(ProductBasket productBasket){
        for(ProductBasket pb : productBaskets){
            if(pb.getId().equals(productBasket.getId())){
                productBaskets.remove(pb);
                break;
            }
        }
    }

    public void updateProductBasket(ProductBasket product){
        for(ProductBasket pb : productBaskets){
            if(pb.getId().equals(product.getId())){
                pb.setCount(product.getCount());
                break;
            }
        }
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
