package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> findAll();

    void create(AddressDTO address);

    void update(AddressDTO addressDTO);

    List<AddressDTO> retrieveByCustomerId(Long id);

    List<AddressDTO> retrieveStartsWith(String address);

    List<AddressDTO> getByCustomerIdAndName(Long id, String name);
}