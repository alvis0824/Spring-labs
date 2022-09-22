package com.cydeo.service;

import com.cydeo.model.Product;
import org.springframework.context.annotation.Bean;

public interface StockService {
    boolean checkStockIsAvailable(Product product, int quantity);
}
