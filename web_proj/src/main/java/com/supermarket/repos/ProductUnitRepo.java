package com.supermarket.repos;

import com.supermarket.domain.ProductUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductUnitRepo extends JpaRepository<ProductUnit, Long> {}
