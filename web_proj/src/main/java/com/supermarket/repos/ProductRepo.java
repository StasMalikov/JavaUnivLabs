package com.supermarket.repos;

import com.supermarket.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT p.name FROM Product p  WHERE p.name is not NULL")
    List<String> getNames();

    @Query("SELECT p.name FROM Product p WHERE p.name like %:name%")
    List<String> findNames(String name);
}
