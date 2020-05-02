package com.supermarket.services;

import com.supermarket.domain.Price;
import com.supermarket.domain.Product;
import com.supermarket.repos.PriceRepo;
import com.supermarket.repos.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.init-db", havingValue = "true")
public class DbInitializer implements CommandLineRunner {

    private PriceRepo priceRepo;
    private ProductRepo productRepo;

    public DbInitializer(PriceRepo priceRepo, ProductRepo productRepo){
        this.priceRepo = priceRepo;
        this.productRepo = productRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Price p1 = new Price(0.1, 100);
        Product pr1 = new Product();
        pr1.setPrice(p1);
        priceRepo.save(p1);
        productRepo.save(pr1);
    }
}
