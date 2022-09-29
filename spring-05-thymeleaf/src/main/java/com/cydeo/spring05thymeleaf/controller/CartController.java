package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class
CartController {

    private final CartServiceImpl cartService;

    public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/addToCart/{productId}/{quantity}")
    public String addToCart(@PathVariable UUID productId, @PathVariable Integer quantity, Model model){
        cartService.addToCart(productId, quantity);
        model.addAttribute("cartItemList",CartServiceImpl.CART.getCartItemList());
        model.addAttribute("cartTotalAmount",CartServiceImpl.CART.getCartTotalAmount());
        return "cart/show-cart";
    }

    @GetMapping("/delete/{productId}")
    public String delete(@PathVariable UUID productId, Model model){
        cartService.deleteFromCart(productId);
        model.addAttribute("cartItemList",CartServiceImpl.CART.getCartItemList());
        model.addAttribute("cartTotalAmount",CartServiceImpl.CART.getCartTotalAmount());
        return "cart/show-cart";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("cartItemList",CartServiceImpl.CART.getCartItemList());
        model.addAttribute("cartTotalAmount",CartServiceImpl.CART.getCartTotalAmount());
        return "cart/show-cart";
    }

}
