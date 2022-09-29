package com.cydeo.spring05thymeleaf;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl;
import com.cydeo.spring05thymeleaf.service.impl.ProductServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
public class Spring05ThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring05ThymeleafApplication.class, args);
    }

}
