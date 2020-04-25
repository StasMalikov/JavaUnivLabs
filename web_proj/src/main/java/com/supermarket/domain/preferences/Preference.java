package com.supermarket.domain.preferences;


import com.supermarket.domain.Product;
import com.supermarket.domain.SupermarketUser;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "preference_id")
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SupermarketUser> users;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;
}
