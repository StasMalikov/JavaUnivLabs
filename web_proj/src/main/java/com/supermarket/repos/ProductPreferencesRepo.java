package com.supermarket.repos;

import com.supermarket.domain.ProductPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPreferencesRepo extends JpaRepository<ProductPreferences, Long> {
}
