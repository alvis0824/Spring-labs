package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Product;
import com.cydeo.lab04springmvc.service.ProductService;
import com.cydeo.lab04springmvc.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @RequestMapping("search-product/{name}")
    public String searchProduct(@PathVariable String name, Model model){

        ProductService productService = new ProductServiceImpl();
        List<Product> list = productService.searchProduct(name);
        model.addAttribute("productList", list);

        return "product/product-list";
    }
}
