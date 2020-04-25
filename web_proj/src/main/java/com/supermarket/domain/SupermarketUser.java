package com.supermarket.domain;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "supermarket_user")
@Data
public class SupermarketUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    private String username;
    private String password;
    private Date birthday;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "preferences_id", referencedColumnName = "id")
    private UserPreferences preferences;

    @Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Basket> baskets;

}
