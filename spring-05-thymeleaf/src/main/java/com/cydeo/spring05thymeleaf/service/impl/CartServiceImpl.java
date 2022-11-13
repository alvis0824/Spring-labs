package com.cydeo.spring05thymeleaf.service.impl;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.CartItem;
import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO,new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){
        //todo retrieve product from repository method
        Product product = productService.findProductById(productId);
        //todo initialise cart item
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        //todo calculate cart total amount
        CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));
        //todo add to cart
        CART.getCartItemList().add(cartItem);
        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        //todo delete product object from cart using stream
        CartItem theCartItem = CART.getCartItemList().stream()
                .filter(cartItem -> cartItem.getProduct().getId().toString().equals(productId.toString()))
                .findFirst().orElseThrow();

        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(theCartItem.getTotalAmount()));

        return CART.getCartItemList().remove(theCartItem);
    }
}
