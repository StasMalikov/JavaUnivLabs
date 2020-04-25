package com.supermarket.repos;

import com.supermarket.domain.SupermarketUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupermarketUserRepo extends JpaRepository<SupermarketUser, Long> {
}
