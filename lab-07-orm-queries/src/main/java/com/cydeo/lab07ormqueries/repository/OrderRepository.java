package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Order;
import com.cydeo.lab07ormqueries.enums.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //Write a derived query to get top 5 orders by order by total price desc
    List<Order> findTop5ByOrderByTotalPriceDesc();

    //Write a derived query to get all orders by customer email
    List<Order> findAllByCustomerEmail(String email);

    //Write a derived query to get all orders by specific payment method
    List<Order> findAllByPaymentPaymentMethod(PaymentMethod paymentMethod);

    //Write a JPQL query to get all orders by specific payment method
    @Query("SELECT o FROM Order o WHERE o.payment.paymentMethod = ?1")
    List<Order> getByPaymentMethod(PaymentMethod paymentMethod);

    //Write a derived query to get all orders by specific customer email
//    List<Order> findAllByCustomerEmail(String email);

    //Write a derived query to check is there any orders by customer email
    boolean existsByCustomerEmail(String email);

    //Write a native query to get all orders by specific product name
    @Query(value = "SELECT * FROM orders o " +
            "JOIN cart c ON o.cart_id = c.id " +
            "JOIN cart_item ci ON c.id = ci.cart_id " +
            "JOIN product p ON ci.product_id = p.id " +
            "WHERE p.name = ?1", nativeQuery = true)
    List<Order> getByProductName(@Param("name") String name);

    //Write a native query to get all orders by specific categoryId
    @Query(value = "SELECT * FROM orders o " +
            "JOIN cart c ON o.cart_id = c.id " +
            "JOIN cart_item ci ON c.id = ci.cart_id " +
            "JOIN product p ON ci.product_id = p.id " +
            "JOIN category ca ON ca.id = p.c_id" +
            "WHERE ca.id = ?1", nativeQuery = true)
    List<Order> getByCategoryId(@Param("id") Long id);

    //Write a JPQL query to get all orders by totalPrice and paidPrice are equals
    @Query("SELECT o FROM Order o WHERE o.paidPrice = o.totalPrice")
    List<Order> findAllByTotalPriceEqualsPaidPrice();

    //Write a JPQL query to get all orders by totalPrice and paidPrice are not equals and discount is not null
    @Query("SELECT o FROM Order o WHERE o.paidPrice <> o.totalPrice AND o.cart.discount IS NOT NULL ")
    List<Order> findAllByTotalPriceNotEqualsPaidPriceAndCartDiscountIsNotNull();
}
