package com.supermarket.repos;

import com.supermarket.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT p.name FROM Product p  WHERE p.name is not NULL")
    List<String> getNames();

    @Query("SELECT p.name FROM Product p WHERE p.name like %:name%")
    List<String> findNames(String name);
}
