package com.supermarket.domain;

import com.supermarket.domain.enums.BacketStatus;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
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


    //@Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<ProductBasket> productBaskets;

    private Date purchasesDate;

    private BacketStatus status;
}
