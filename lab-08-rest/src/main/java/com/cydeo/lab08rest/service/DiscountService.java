package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    List<DiscountDTO> getDiscountList();
    DiscountDTO getDiscountByName(String name);

    DiscountDTO createDiscount(DiscountDTO discount);

    DiscountDTO updateDiscount(DiscountDTO discount);
}
