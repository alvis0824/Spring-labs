package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.AddressRepository;
import com.cydeo.lab08rest.repository.CustomerRepository;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    private final MapperUtil mapperUtil;

    public AddressServiceImpl(AddressRepository addressRepository, CustomerRepository customerRepository, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<AddressDTO> findAll() {
        return addressRepository.findAll().stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public void create(AddressDTO address) {
        address.setId(UUID.randomUUID().getMostSignificantBits());
        Address addressToSave = mapperUtil.convert(address, new Address());
        addressRepository.save(addressToSave);
    }

    @Override
    public void update(AddressDTO addressDTO) {
        Address addressToSave = mapperUtil.convert(addressDTO, new Address());
        addressRepository.save(addressToSave);
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
        return addressRepository.findAllByCustomerAndName(customerRepository.findById(id).get(), name).stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }
}
