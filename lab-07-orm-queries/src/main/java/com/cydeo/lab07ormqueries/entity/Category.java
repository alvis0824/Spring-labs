package com.cydeo.lab07ormqueries.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Category extends BaseEntity {

    private String name;
}
