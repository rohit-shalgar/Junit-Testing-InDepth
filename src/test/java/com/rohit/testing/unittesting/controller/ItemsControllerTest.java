package com.rohit.testing.unittesting.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rohit.testing.unittesting.model.Item;
import com.rohit.testing.unittesting.repository.ItemRepository;
import com.rohit.testing.unittesting.service.ItemsServiceImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemsController.class)
public class ItemsControllerTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemsServiceImpl itemsService;

    @MockBean
    private ItemRepository itemRepository;

    @SneakyThrows
    @Test
    public void helloWorld_Basic() {

        String expectedBody = objectMapper.writeValueAsString(getItem());
        RequestBuilder request = MockMvcRequestBuilders.get("/get-item");

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();


        Assertions.assertEquals(expectedBody, result.getResponse().getContentAsString());

    }

    @SneakyThrows
    @Test
    public void helloWorld_WithSomeBusinessLayer() {

        String expectedBody = objectMapper.writeValueAsString(getItem());
        RequestBuilder request = MockMvcRequestBuilders.get("/get-item");

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(expectedBody))
                .andReturn();

        Assertions.assertNotNull(result);

    }

    @SneakyThrows
    @Test
    public void getAllItemsFromDBTest() {

        when(itemsService.getAllItems()).thenReturn(getItems());
        String expectedBody = objectMapper.writeValueAsString(getItems());
        RequestBuilder request = MockMvcRequestBuilders.get("/get-all-items");

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertAll(
                () -> Assertions.assertNotNull(result),
                () -> Assertions.assertEquals(expectedBody, result.getResponse().getContentAsString()),
                () -> verify(itemsService, atMostOnce()).getAllItems()
        );

    }

    private List<com.rohit.testing.unittesting.entity.Item> getItems() {

        com.rohit.testing.unittesting.entity.Item item1 = new com.rohit.testing.unittesting.entity.Item();
        item1.setId(1);
        item1.setName("Ball");
        item1.setPrice(20);
        com.rohit.testing.unittesting.entity.Item item2 = new com.rohit.testing.unittesting.entity.Item();
        item2.setId(2);
        item2.setName("Bat");
        item2.setPrice(400);

        return Arrays.asList(item1, item2);

    }

    private Item getItem() {

        return Item.builder()
                .id(1)
                .name("Ball")
                .price(10)
                .build();

    }

}
