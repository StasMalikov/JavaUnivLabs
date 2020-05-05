package com.supermarket.repos;

import com.supermarket.domain.Basket;
import com.supermarket.domain.SupermarketUser;
import com.supermarket.domain.enums.BasketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepo extends JpaRepository<Basket, Long> {

    Basket findByStatus(BasketStatus status);

    Basket findByCustomerAndStatus(SupermarketUser customer, BasketStatus status);

    List<Basket> findAllByStatusAndCustomer(BasketStatus status, SupermarketUser customer);
}
