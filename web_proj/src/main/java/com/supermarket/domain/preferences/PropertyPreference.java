package com.supermarket.domain.preferences;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class PropertyPreference extends Preference {
    private String property;
}
