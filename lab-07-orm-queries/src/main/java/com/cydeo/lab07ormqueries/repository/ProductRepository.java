package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Category;
import com.cydeo.lab07ormqueries.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Write a derived query to get top 3 product order by price desc
    List<Product> findTop3ByOrderByPriceDesc();

    //Write a derived query to get product by specific name
    List<Product> findByName(String name);

    //Write a derived query to get product by specific category
    List<Product> findByCategory(Category category);

    //Write a derived query to get count by price greater than specific amount
    Integer countByPriceGreaterThan(BigDecimal price);

    //Write a derived query to get all product by quantity greater than or equal specific count
    List<Product> findAllByQuantityGreaterThanEqual(Integer count);

    //Write a native query to get all product by price greater than specific amount and quantity lower than specific count
    List<Product> findAllByPriceGreaterThanAndQuantityLessThan(BigDecimal price, Integer count);

    //Write a native query to get all product by specific categoryId
    @Query(value = "SELECT * FROM product p JOIN product_category_rel pcr ON p.id = pcr.p_id WHERE pcr.c_id = ?1", nativeQuery = true)
    List<Product> getByCategoryId(Long id);

    //Write a native query to get all product by specific categoryId and price greater than specific amount
    @Query(value = "SELECT * FROM product p JOIN product_category_rel pcr ON p.id = pcr.p_id WHERE pcr.c_id = ?1 AND p.price = ?2", nativeQuery = true)
    List<Product> getByCategoryIdAndPrice(@Param("id") Long id, @Param("price") BigDecimal price);
}
