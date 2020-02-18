package com.supermarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ProductsController {
    @GetMapping("/products/add")
    public String greeting(Map<String, Object> model) {
        return "add_product";
    }
}
