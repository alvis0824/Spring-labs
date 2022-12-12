package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.AddressRepository;
import com.cydeo.lab08rest.repository.CustomerRepository;
import com.cydeo.lab08rest.service.AddressService;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final CustomerService customerService;
    private final MapperUtil mapperUtil;

    public AddressServiceImpl(AddressRepository addressRepository, CustomerService customerService, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.customerService = customerService;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<AddressDTO> findAll() {
        return addressRepository.findAll().stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) {
        Address address = addressRepository.save(mapperUtil.convert(addressDTO, new Address()));
        return mapperUtil.convert(address, new AddressDTO());
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        Address address = mapperUtil.convert(addressDTO, new Address());

        address.setCustomer(mapperUtil.convert(customerService.findById(addressDTO.getCustomerId()), new Customer()));

        Address updatedAddress = addressRepository.save(address);

        return mapperUtil.convert(updatedAddress, new AddressDTO());
    }

    @Override
    public List<AddressDTO> retrieveByCustomerId(Long id) {
        return addressRepository.retrieveByCustomerId(id).stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> retrieveStartsWith(String address) {
        return addressRepository.findAllByStreetStartingWith(address).stream()
                .map(address1 -> mapperUtil.convert(address1,new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getByCustomerIdAndName(Long id, String name) {
        return addressRepository.findAllByCustomerIdAndName(id,name).stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }
}
