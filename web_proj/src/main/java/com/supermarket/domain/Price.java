package com.supermarket.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "price_id")
    private Long id;

    private double discount;

    private double price;

    @OneToMany(mappedBy = "price", cascade = CascadeType.ALL)
    private List<Product> productUnits;

}
