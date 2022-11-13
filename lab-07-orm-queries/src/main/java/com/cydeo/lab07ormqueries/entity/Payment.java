package com.cydeo.lab07ormqueries.entity;

import com.cydeo.lab07ormqueries.enums.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Payment extends BaseEntity{

    private BigDecimal paidPrice;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @OneToOne(mappedBy = "payment")
    private Order order;
}
