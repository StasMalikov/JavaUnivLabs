package com.supermarket.domain;

import com.supermarket.domain.enums.BacketStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "backet")
public class Backet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * покупатель.
     */
    private SupermarketUser customer;

    /**
     * покупки.
     */
    private List<ProductUnit> purchases;

    /**
     * дата покупки.
     */
    private Date purchasesDate;

    /**
     * состояние, в котором находится заказ.
     */
    private BacketStatus status;
}
