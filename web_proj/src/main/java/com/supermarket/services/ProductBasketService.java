package com.supermarket.services;

import com.supermarket.domain.Basket;
import com.supermarket.domain.Product;
import com.supermarket.domain.ProductBasket;
import com.supermarket.repos.ProductBasketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBasketService {

    private ProductBasketRepo productBasketRepo;

    @Autowired
    public ProductBasketService(ProductBasketRepo productBasketRepo){
        this.productBasketRepo = productBasketRepo;
    }

    public List<ProductBasket> getProductBaskets(Basket basket){
        return productBasketRepo.findAllByBasket(basket);
    }

    public void deleteProductBasket(ProductBasket productBasket){
        productBasketRepo.deleteById(productBasket.getId());
    }

    public void updateCountProductBasket(ProductBasket productBasket, double count){
        ProductBasket pb = productBasketRepo.findById(productBasket.getId()).get();
        pb.setCount(count);
        productBasketRepo.save(pb);
    }

    public void addProductBasket(Product product, double count, Basket basket){
        ProductBasket productBasket = new ProductBasket(product, count, basket);
        productBasketRepo.save(productBasket);
    }

    public ProductBasket findById(String id){
        return productBasketRepo.findById(id).get();
    }

    public boolean productBasketInBasket(Product product, Basket basket){
        List<ProductBasket> list = productBasketRepo.findByProductAndBasket(product, basket);
        if (list.size() == 0){
            return false;
        }
        return true;
    }
}
