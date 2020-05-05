package com.supermarket.services;

import com.supermarket.repos.BasketRepo;
import com.supermarket.repos.ProductBasketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    private BasketRepo basketRepo;
    private ProductBasketRepo productBasketRepo;

    @Autowired
    public BasketService(BasketRepo basketRepo, ProductBasketRepo productBasketRepo){
        this.basketRepo = basketRepo;
        this.productBasketRepo = productBasketRepo;
    }

}
