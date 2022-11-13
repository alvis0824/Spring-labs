package com.cydeo.lab06orm.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends BaseEntity{

    private String email;
    private String firstName;
    private String lastName;
    private String userName;
    @OneToOne(mappedBy = "customer")
    private Balance balance;

}
