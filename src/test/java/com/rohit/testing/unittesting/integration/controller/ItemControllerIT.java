package com.rohit.testing.unittesting.integration.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    //external dependencies can be mocked out with @mockbean
    //the test will run with springboot context with the mocked bean
    //eg- returning data from itemrepo.

    @Test
    public void getAllItemsITTest(){

        String restResponse = restTemplate.getForObject("/get-all-items",String.class);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(restResponse),
                () -> JSONAssert.assertEquals("[{id:1001,name:Ball,price:10,value:10010},{id:1002,name:Bat,price:400,value:400800},{id:1003,name:Stumps,price:20,value:20060}]",restResponse,true)
        );

    }

}
