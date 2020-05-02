package com.supermarket.domain;

import com.supermarket.domain.enums.ProdType;
import com.supermarket.domain.enums.WeightType;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private String id;

    private String name;

    /**
     * срок годности.
     */
    private Integer expirationDate;

    /**
     * тип измеряемости товара.
     */
    @Enumerated(EnumType.STRING)
    private WeightType weightType;

    /**
     * категория товара.
     */
    @Enumerated(EnumType.STRING)
    private ProdType prodType;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "product_ingredient",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients;

    private Calendar productionDate;

    /**
     * количество товара.
     */
    private double quantity;

    @ManyToOne
    @JoinColumn(name="price_id", nullable=false)
    private Price price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "preferences_id", referencedColumnName = "id")
    private ProductPreferences preferences;

    @Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductBasket> productBaskets;

    public Product() {
        id = UUID.randomUUID().toString();
    }
}
