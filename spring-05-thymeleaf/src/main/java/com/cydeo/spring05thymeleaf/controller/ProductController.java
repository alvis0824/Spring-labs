package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.repository.ProductRepository;
import com.cydeo.spring05thymeleaf.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductServiceImpl productService;

    public ProductController(ProductRepository productRepository, ProductServiceImpl productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }


    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("productList", productRepository.findAll());
        return "product/list";
    }

    @GetMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/create-product";
    }

    @PostMapping("/create-product")
    public String createProduct(@ModelAttribute("product") Product product, Model model) {
        productService.productCreate(product);
        productRepository.save(product);
        model.addAttribute("productList", productRepository.findAll());
        return "product/list";
    }
}
