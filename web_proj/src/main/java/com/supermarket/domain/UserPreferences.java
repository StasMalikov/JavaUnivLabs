package com.supermarket.domain;

import com.supermarket.domain.preferences.Preference;
import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "user_preferences")
public class UserPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @OneToOne(mappedBy = "userPreferences")
    private SupermarketUser user;

    /**
     * Предпочтения пользователя.
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_preference",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "preference_id")
    )
    private Set<Preference> preferences;

    public UserPreferences(){}

    public UserPreferences(SupermarketUser user){
        this.user = user;
        preferences = new HashSet<>();
    }

    public void addPreference(Preference preference){
        preferences.add(preference);
    }

    public void deletePreference(Preference preference){
        preferences.remove(preference);
    }
}
