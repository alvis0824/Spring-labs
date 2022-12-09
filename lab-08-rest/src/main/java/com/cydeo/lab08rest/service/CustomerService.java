package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> findAll();

    CustomerDTO retrieveByEmail(String email);

    void createCustomer(CustomerDTO customer);

    void updateCustomer(CustomerDTO customer);

    CustomerDTO findById(Long customerId);
}
