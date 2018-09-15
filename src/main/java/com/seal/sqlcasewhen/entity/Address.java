package com.seal.sqlcasewhen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id @GeneratedValue
    long id;

    String city;
}
