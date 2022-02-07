package com.rohit.testing.unittesting.controller;

import com.rohit.testing.unittesting.model.Item;
import com.rohit.testing.unittesting.service.ItemsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ItemsController {

   private ItemsServiceImpl itemService;

    @GetMapping(value = "/get-item",produces = "application/json")
    @ResponseBody
    public ResponseEntity<Item> getDummyItem(){

        Item dummyItem = Item.builder()
                .id(1)
                .name("Ball")
                .price(10).build();

        return ResponseEntity.ok(dummyItem);

    }

    @GetMapping(value = "/get-all-items")
    public ResponseEntity<List<com.rohit.testing.unittesting.entity.Item>> getAllItemsFromDatabase(){

        return ResponseEntity.ok(itemService.getAllItems());

    }

}
