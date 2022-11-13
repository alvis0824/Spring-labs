package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Discount;
import com.cydeo.lab07ormqueries.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    //Write a derived query to get discount by name
    List<Discount> findAllByName(String name);

    //Write a derived query to get all discounts greater than discount amount
    List<Discount> findAllByDiscountGreaterThan(BigDecimal discountAmount);

    //Write a derived query to get all discounts by specific discount type
    List<Discount> findAllByDiscountType(DiscountType discountType);

    //Write a JPQL query to get all discounts amount between range of discount amount
    @Query("SELECT d FROM Discount d WHERE d.discount BETWEEN ?1 AND ?2")
    List<Discount> getDiscountByAmountBetween(BigDecimal amount1, BigDecimal amount2);
}
