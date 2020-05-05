package com.supermarket.repos;

import com.supermarket.domain.ProductBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductBasketRepo extends JpaRepository<ProductBasket, String> {
   Optional<ProductBasket> findById(String id);
}
