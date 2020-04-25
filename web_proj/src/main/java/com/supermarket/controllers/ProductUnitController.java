package com.supermarket.controllers;

import com.supermarket.repos.ProductRepo;
import com.supermarket.repos.ProductUnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class ProductUnitController {
    @Autowired
    ProductUnitRepo productUnitRepo;

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/product_units")
    public String productUnits(Map<String, Object> model) {
        model.put("names", productRepo.getNames());
        return "product_units";
    }

    @PostMapping("/product_units/get_names")
    public String findNames(String findName,String submit, Map<String, Object> model) {
        if (submit.equals("Найти")) {
            String str = new String();
            model.put("names", productRepo.findNames(findName));
        } else {
            model.put("names", productRepo.getNames());
        }
        return "product_units";
    }


}
