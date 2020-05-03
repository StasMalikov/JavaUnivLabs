package com.supermarket.repos;

import com.supermarket.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

    Optional<Product> findById(String id);
}
