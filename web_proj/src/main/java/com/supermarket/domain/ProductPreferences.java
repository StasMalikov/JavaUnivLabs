package com.supermarket.domain;

import com.supermarket.domain.preferences.Preference;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class ProductPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @OneToOne(mappedBy = "productPreferences")
    private Product product;

    /**
     * Предпочтения относящиеся к товару.
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "product_preference",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "preference_id")
    )
    private Set<Preference> preferencesProduct;
}
