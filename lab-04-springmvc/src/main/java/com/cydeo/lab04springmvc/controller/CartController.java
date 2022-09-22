package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Cart;
import com.cydeo.lab04springmvc.model.CartItem;
import com.cydeo.lab04springmvc.service.CartService;
import com.cydeo.lab04springmvc.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class CartController {

    CartService cartService = new CartServiceImpl();
    List<Cart> cartList = cartService.retrieveCartList();

    @RequestMapping("/cart-list")
    public String cartList(Model model){

        model.addAttribute("cartList", cartList);

        return "cart/cart-list";
    }

    @RequestMapping("cart-list/{id}")
    public String cartDetail(@PathVariable UUID id, Model model){

        List<CartItem> cartItemList = cartService.retrieveCartDetail(id);

        model.addAttribute("cartItemList", cartItemList);

        return "cart/cart-detail";
    }
}
