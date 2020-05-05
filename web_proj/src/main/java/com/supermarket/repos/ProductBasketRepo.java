package com.supermarket.repos;

import com.supermarket.domain.Basket;
import com.supermarket.domain.Product;
import com.supermarket.domain.ProductBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductBasketRepo extends JpaRepository<ProductBasket, String> {
   Optional<ProductBasket> findById(String id);

   List<ProductBasket> findAllByBasket(Basket basket);

   List<ProductBasket> findAllByBasketAndId(Basket basket, String id);

   List<ProductBasket> findByProductAndBasket(Product product, Basket basket);
}
