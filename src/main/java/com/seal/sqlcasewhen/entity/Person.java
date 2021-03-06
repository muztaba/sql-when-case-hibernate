package com.seal.sqlcasewhen.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Person {
    
    @Id @GeneratedValue
    long id;
    
    String Name;
    
    int age;

    @OneToOne
    Address address;
}
