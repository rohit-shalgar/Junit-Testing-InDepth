package com.rohit.testing.unittesting.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class Item {

    private int id;
    private String name;
    private int price;
}
