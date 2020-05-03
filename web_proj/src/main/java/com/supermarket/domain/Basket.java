package com.supermarket.domain;

import com.supermarket.domain.enums.BasketStatus;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
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

    public void addProduct(Product product){
        productBaskets.add(new ProductBasket(product, 1, this));
    }

}
