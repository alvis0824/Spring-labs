package com.cydeo.lab07ormqueries.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
public class Customer extends BaseEntity{

    private String email;
    private String firstName;
    private String lastName;
    private String userName;
    @OneToOne(mappedBy = "customer")
    private Balance balance;

}
