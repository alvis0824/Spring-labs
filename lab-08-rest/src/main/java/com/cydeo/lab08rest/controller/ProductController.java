package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO product){  // ResponseWrapper --> for customizing our Json body
        return ResponseEntity.ok(new ResponseWrapper("Product is successfully created"
                , productService.createProduct(product), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO product){
        return ResponseEntity.ok(new ResponseWrapper("Product is successfully updated"
                , productService.updateProduct(product), HttpStatus.OK));
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getProductList(){
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved"
                , productService.getProductList(), HttpStatus.OK));
    }

    @GetMapping("/top3")
    public ResponseEntity<ResponseWrapper> getTop3ProductList(){
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved"
                , productService.getTop3ProductList(), HttpStatus.OK));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getProductListByName(@PathVariable("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved"
                , productService.getProductListByName(name), HttpStatus.OK));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseWrapper> getProductListByCategory(@PathVariable("id") Long id){
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved"
                , productService.getProductListByCategory(id), HttpStatus.OK));
    }

    @PostMapping("/categoryandprice")
    public ResponseEntity<ResponseWrapper> getProductListByCategoryAndPrice(@RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved"
                , productService.getProductListByCategoryAndPrice(productRequest.getCategoryList(), productRequest.getPrice()), HttpStatus.OK));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<ResponseWrapper> getProductListByPrice(@PathVariable BigDecimal price){
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved"
                , productService.countProductByPrice(price), HttpStatus.OK));
    }

    @GetMapping("/price/{price}/quantity/{quantity}")
    public ResponseEntity<ResponseWrapper> getProductListByPriceAndQuantity(@PathVariable BigDecimal price, @PathVariable("quantity") Integer quantity){
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved"
                , productService.getProductListByPriceAndQuantity(price, quantity), HttpStatus.OK));
    }
}
