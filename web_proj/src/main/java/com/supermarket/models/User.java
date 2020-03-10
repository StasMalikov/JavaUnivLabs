package com.supermarket.models;

import com.supermarket.enums.Preferences;

import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import java.util.Date;
import java.util.Set;

public class User {

    private String username;
    private String password;
    private Date birthday;

    public User(String username, String password, Date birthday, Set<Preferences> preferences) {
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.preferences = preferences;
    }

    /**
     * Предпочтения пользователя.
     */
    @ElementCollection(targetClass = Preferences.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Preferences> preferences;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Preferences> getPreferences() {
        return preferences;
    }

    public void setPreferences(Set<Preferences> preferences) {
        this.preferences = preferences;
    }
}
