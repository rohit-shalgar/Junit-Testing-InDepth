package com.rohit.testing.unittesting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.management.ConstructorParameters;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Data
@NoArgsConstructor
public class Item {

    @Id
    private int id;

    private String name;

    private int price;

    @Transient
    private int value;

}
