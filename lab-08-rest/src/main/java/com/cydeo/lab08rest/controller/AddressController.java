package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAddressList(){
        return ResponseEntity.ok(new ResponseWrapper("Addresses are successfully retrieved", addressService.findAll(), HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO address){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper("Address is successfully created",
                addressService.create(address), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateAddress(@RequestBody AddressDTO address){
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully updated",
                addressService.update(address), HttpStatus.OK));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerId(@PathVariable("customerId") Long customerId){
        return ResponseEntity.ok(new ResponseWrapper("Addresses are successfully retrieved",
                addressService.retrieveByCustomerId(customerId), HttpStatus.OK));
    }

    @GetMapping("/startsWith/{address}")
    public ResponseEntity<ResponseWrapper> getAddressListByStartsWithAddress(@PathVariable("address") String address){
        return ResponseEntity.ok(new ResponseWrapper("Address starts with " + address + "is successfully retrieved",
                addressService.retrieveStartsWith(address), HttpStatus.OK));
    }

    @GetMapping("/customer/{customerId}/name/{name}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerAndName(@PathVariable("customerId") Long customerId, @PathVariable("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully retrieved",
                addressService.getByCustomerIdAndName(customerId, name), HttpStatus.OK));
    }
}
