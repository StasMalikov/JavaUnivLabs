package com.supermarket.controllers;

import com.supermarket.domain.SupermarketUser;
import com.supermarket.domain.enums.Role;
import com.supermarket.repos.ProductRepo;
import com.supermarket.repos.SupermarketUserRepo;
import com.supermarket.repos.UserPreferencesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserPreferencesRepo userPreferencesRepo;

    @Autowired
    private SupermarketUserRepo supermarketUserRepo;

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        model.put("products", productRepo.findAll());
        return "index";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping("/registration")
    public String addUser(SupermarketUser user, Map<String, Object> model) {
        SupermarketUser userFromDb = supermarketUserRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "Пользователь с таким логином уже зареристрирован!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        supermarketUserRepo.save(user);

        return "redirect:/login";
    }
}
