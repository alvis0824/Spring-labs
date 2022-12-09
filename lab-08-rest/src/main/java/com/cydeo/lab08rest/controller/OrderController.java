package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public ResponseEntity<ResponseWrapper> createOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(new ResponseWrapper("Order is successfully created",
                orderService.createOrder(orderDTO), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(new ResponseWrapper("Order is successfully updated",
                orderService.updateOrder(orderDTO), HttpStatus.OK));
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getOrderList(){
        return ResponseEntity.ok(new ResponseWrapper("Order list is successfully retrieved",
                orderService.getOrderList(), HttpStatus.OK));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseWrapper> getOrderListByEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(new ResponseWrapper("Order list is successfully retrieved",
                orderService.getOrderListByEmail(email), HttpStatus.OK));
    }

    @GetMapping("/paymentMethod/{paymentMethod}")
    public ResponseEntity<ResponseWrapper> getOrderListByPaymentMethod(@PathVariable("paymentMethod") PaymentMethod paymentMethod){
        return ResponseEntity.ok(new ResponseWrapper("Order list is successfully retrieved",
                orderService.getOrderListByPaymentMethod(paymentMethod), HttpStatus.OK));
    }
}
