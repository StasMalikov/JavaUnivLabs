package com.supermarket.controllers;

import com.supermarket.domain.Basket;
import com.supermarket.domain.ProductBasket;
import com.supermarket.domain.SupermarketUser;
import com.supermarket.domain.enums.BasketStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/preferences")
@PreAuthorize("hasAuthority('USER')")
public class PreferencesController {

    @GetMapping("/")
    public String getPreferences(@AuthenticationPrincipal SupermarketUser user, Map<String, Object> model) {
//        Basket basket =  basketRepo.findByCustomerAndStatus(user, BasketStatus.RESERVED);
//        if (basket == null) {
//            model.put("message1", ".");
//        } else {
//            List<ProductBasket> list = productBasketService.getProductBaskets(basket);
//            if (list.size() == 0) {
//                model.put("message1", ".");
//            }else {
//                model.put("products", list);
//            }
//        }
        return "preferences";
    }

}
