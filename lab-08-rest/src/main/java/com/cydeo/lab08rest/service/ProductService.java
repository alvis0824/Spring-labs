package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductDTO> getProductList();

    List<ProductDTO> getTop3ProductList();

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(ProductDTO productDTO);

    ProductDTO getProductListByName(String name);

    List<ProductDTO> getProductListByCategory(Long id);

    Integer countProductByPrice(BigDecimal price);

    List<ProductDTO> getProductListByCategoryAndPrice(List<Long> categoryList, BigDecimal price);

    List<ProductDTO> getProductListByPriceAndQuantity(BigDecimal price, Integer quantity);
}
