package com.supermarket.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SupermarketUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private Date birthday;

    public SupermarketUser() {}

    public SupermarketUser(String username, String password, Date birthday) {
        this.username = username;
        this.password = password;
        this.birthday = birthday;
    }

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
}
