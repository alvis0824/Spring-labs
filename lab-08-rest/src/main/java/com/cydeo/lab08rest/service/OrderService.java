package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getOrderList();
    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(OrderDTO orderDTO);

    List<OrderDTO> getOrderListByEmail(String email);

    List<OrderDTO> getOrderListByPaymentMethod(PaymentMethod paymentMethod);
}
