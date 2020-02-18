package com.supermarket.controllers;

import com.supermarket.enums.ProdType;
import com.supermarket.enums.WeightType;
import com.supermarket.models.Product;
import com.supermarket.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

@Controller
public class ProductsController {
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/products/add")
    public String addUserView(Map<String, Object> model) {
        model.put("weightType", WeightType.values());
        model.put("prodType", ProdType.values());
        return "add_product";
    }

    @PostMapping("/products/add")
    public String greeting(@RequestParam String name, @RequestParam double price,
                           @RequestParam String weightType, @RequestParam Integer discount,
                           @RequestParam String prodType, @RequestParam Integer days,
                           @RequestParam Integer months, @RequestParam Integer years,
                           @RequestParam Integer hours, Map<String, Object> model) {

        Product product = new Product(name, discount*0.01, price,
                years*8760 + months*730 + days*24 + hours,
                WeightType.valueOf(weightType), ProdType.valueOf(prodType));

        productRepo.save(product);
        model.put("message", "Продукт успешно сохранён");
        return "greeting";
    }
}
