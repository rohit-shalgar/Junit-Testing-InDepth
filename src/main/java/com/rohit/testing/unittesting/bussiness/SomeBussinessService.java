package com.rohit.testing.unittesting.bussiness;

import com.rohit.testing.unittesting.model.Item;
import org.springframework.stereotype.Component;

@Component
public class SomeBussinessService {

    public Item retrieveItem() {

        return Item.builder()
                .id(1)
                .name("Ball")
                .price(10).build();

    }
}
