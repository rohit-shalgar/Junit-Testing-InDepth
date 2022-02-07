package com.rohit.testing.unittesting.service;

import com.rohit.testing.unittesting.entity.Item;
import com.rohit.testing.unittesting.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class ItemsServiceImplTest {

    ItemRepository itemRepository = mock(ItemRepository.class);
    ItemsServiceImpl itemsService = new ItemsServiceImpl(itemRepository);

    @Test
    public void getAllItemsTest() {

        when(itemRepository.findAll()).thenReturn(getItems());
        List<Item> items = itemsService.getAllItems();
        Assertions.assertAll(
                () -> Assertions.assertNotNull(items),
                () -> Assertions.assertEquals(20, items.get(0).getValue()),
                () -> Assertions.assertEquals(items.get(1).getValue(), 800)
        );

        verify(itemRepository, atMostOnce()).findAll();

    }

    @Test
    public void getAllItems_EmptyResponseTest() {

        when(itemRepository.findAll()).thenReturn(new ArrayList<>());
        List<Item> items = itemsService.getAllItems();
        Assertions.assertAll(
                () -> Assertions.assertNotNull(items),
                () -> Assertions.assertEquals(0,items.size())
        );

        verify(itemRepository, atMostOnce()).findAll();

    }

    private List<Item> getItems() {

        Item item1 = new Item();
        item1.setId(1);
        item1.setName("Ball");
        item1.setPrice(20);
        Item item2 = new Item();
        item2.setId(2);
        item2.setName("Bat");
        item2.setPrice(400);

        return Arrays.asList(item1, item2);

    }

}
