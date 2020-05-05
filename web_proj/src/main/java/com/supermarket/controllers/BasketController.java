package com.supermarket.controllers;

import com.supermarket.domain.Basket;
import com.supermarket.domain.Product;
import com.supermarket.domain.ProductBasket;
import com.supermarket.domain.SupermarketUser;
import com.supermarket.repos.BasketRepo;
import com.supermarket.repos.ProductBasketRepo;
import com.supermarket.repos.ProductRepo;
import com.supermarket.repos.SupermarketUserRepo;
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
    private ProductBasketRepo productBasketRepo;

    @PostMapping("/add")
    public String add(@AuthenticationPrincipal SupermarketUser user, @RequestParam String product_id, Map<String, Object> model) {

        Product product  = productRepo.findById(product_id).get();
        Basket basket = user.getReservedBasket();
        if (basket == null) {

            basket =  new Basket(user);
            ProductBasket pb = new ProductBasket(product,1,basket);
            basket.addProduct(pb);
            pb.setBasket(basket);
            user.addBasket(basket);

            model.put("message1", product.getName());
            productBasketRepo.save(pb);
            basketRepo.save(basket);
            supermarketUserRepo.save(user);
        } else {
            if(basket.haveProduct(product.getId())) {
                model.put("message2", product.getName());
            }else {
                ProductBasket pb = new ProductBasket(product,1,basket);
                basket.addProduct(pb);
                pb.setBasket(basket);

                model.put("message1", product.getName());
                productBasketRepo.save(pb);
                basketRepo.save(basket);
            }
        }
        model.put("products", productRepo.findAll());
        return "index";
    }

    @GetMapping("/")
    public String getReserved(@AuthenticationPrincipal SupermarketUser user, Map<String, Object> model) {
        Basket basket = user.getReservedBasket();
        if (basket == null) {
            model.put("message1", ".");
        } else {
            List<ProductBasket> list = basket.getProductBaskets();
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

        Basket basket = user.getReservedBasket();
        ProductBasket pb = productBasketRepo.findById(productBasket_id).get();
        if (submit.equals("Удалить")){
            basket.deleteProductBasket(pb);
            productBasketRepo.delete(pb);
            basketRepo.save(basket);

        } else {
            pb.setCount(count);
            basket.updateProductBasket(pb);
            productBasketRepo.save(pb);
            basketRepo.save(basket);
        }

        List<ProductBasket> list = basket.getProductBaskets();
        if (list.size() == 0) {
            model.put("message1", ".");
        }else {
            model.put("products", list);
        }

        return "basket";
    }

}
