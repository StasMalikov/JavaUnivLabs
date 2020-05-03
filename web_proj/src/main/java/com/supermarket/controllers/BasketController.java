package com.supermarket.controllers;

import com.supermarket.domain.Basket;
import com.supermarket.domain.Product;
import com.supermarket.domain.SupermarketUser;
import com.supermarket.repos.BasketRepo;
import com.supermarket.repos.ProductRepo;
import com.supermarket.repos.SupermarketUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/basket")
@PreAuthorize("hasAuthority('USER')")
public class BasketController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    BasketRepo basketRepo;

    @Autowired
    SupermarketUserRepo supermarketUserRepo;

    @PostMapping("/add")
    public String index(@AuthenticationPrincipal SupermarketUser user, @RequestParam String product_id, Map<String, Object> model) {

        Product product  = productRepo.findById(product_id).get();
        Basket basket = user.getReservedBasket();
        if (basket == null) {
            basket =  basketRepo.save(new Basket(user));
            basket.addProduct(product);
            user.addBasket(basket);

            model.put("message1", product.getName());
        } else {
            if(basket.haveProduct(product.getId())) {
                model.put("message2", product.getName());
            }else {
                basket.addProduct(product);
                model.put("message1", product.getName());
            }
        }

        basketRepo.save(basket);
        supermarketUserRepo.save(user);

        model.put("products", productRepo.findAll());
        return "index";
    }
}
