package com.cydeo.lab07ormqueries.repository;
import com.cydeo.lab07ormqueries.entity.Cart;
import com.cydeo.lab07ormqueries.enums.CartState;
import com.cydeo.lab07ormqueries.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    //Write a derived query to get all cart by specific discount type
    List<Cart> findAllByDiscountDiscountType(DiscountType discountType);

    //Write a JPQL query to get all cart by customer
    @Query("SELECT c FROM Cart c WHERE c.customer.id = ?1")
    List<Cart> getCartByCustomer(Long id);

    //Write a derived query to get all cart by customer and cart state
    List<Cart> findAllByCustomerIdAndCartState(Long id, CartState cartState);

    //Write a derived query to get all cart by customer and cart state and discount is null condition
    List<Cart> findAllByCustomerIdAndCartStateAndDiscountIsNull(Long id, CartState cartState);

    //Write a native query to get all cart by customer and cart state and discount is not null condition
    @Query(value = "SELECT * FROM cart c JOIN customer cu ON c.customer_id = cu.id WHERE cu.id = ?1 AND c.cart_state = ?2 AND discount_id <> NULL ",nativeQuery = true)
    List<Cart> getByCustomerCartStateDiscountNotNull(@Param("customerId") Long customerId, @Param("cartState") CartState cartState);

}
