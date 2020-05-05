package com.supermarket.controllers;

import com.supermarket.domain.Basket;
import com.supermarket.domain.Product;
import com.supermarket.domain.ProductBasket;
import com.supermarket.domain.SupermarketUser;
import com.supermarket.domain.enums.BasketStatus;
import com.supermarket.repos.BasketRepo;
import com.supermarket.repos.ProductRepo;
import com.supermarket.repos.SupermarketUserRepo;
import com.supermarket.services.ProductBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
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

    @Autowired
    private ProductBasketService productBasketService;

    @PostMapping("/add")
    public String add(@AuthenticationPrincipal SupermarketUser user, @RequestParam String product_id, Map<String, Object> model) {

        Product product  = productRepo.findById(product_id).get();
        Basket basket = basketRepo.findByCustomerAndStatus(user, BasketStatus.RESERVED);
        if (basket == null) {

            basket = basketRepo.save(new Basket(user));
            productBasketService.addProductBasket(product,1,basket);
            model.put("message1", product.getName());

        } else {
            if(productBasketService.productBasketInBasket(product, basket)) {
                model.put("message2", product.getName());
            }else {
                productBasketService.addProductBasket(product,1,basket);
                model.put("message1", product.getName());
            }
        }
        model.put("products", productRepo.findAll());
        return "index";
    }

    @GetMapping("/")
    public String getReserved(@AuthenticationPrincipal SupermarketUser user, Map<String, Object> model) {
        Basket basket =  basketRepo.findByCustomerAndStatus(user, BasketStatus.RESERVED);
        if (basket == null) {
            model.put("message1", ".");
        } else {
            List<ProductBasket> list = productBasketService.getProductBaskets(basket);
            if (list.size() == 0) {
                model.put("message1", ".");
            }else {
                model.put("products", list);
            }
        }
        return "basket";
    }

    @PostMapping("/update")
    public String update(@AuthenticationPrincipal SupermarketUser user, @RequestParam String productBasket_id,
                         @RequestParam String submit, @RequestParam double count, Map<String, Object> model) {

        Basket basket =  basketRepo.findByCustomerAndStatus(user, BasketStatus.RESERVED);
        ProductBasket pb = productBasketService.findById(productBasket_id);
        if (submit.equals("Удалить")){
            productBasketService.deleteProductBasket(pb);
        } else {
            productBasketService.updateCountProductBasket(pb, count);
        }

        List<ProductBasket> list = productBasketService.getProductBaskets(basket);
        if (list.size() == 0) {
            model.put("message1", ".");
        }else {
            model.put("products", list);
        }

        return "basket";
    }

}
