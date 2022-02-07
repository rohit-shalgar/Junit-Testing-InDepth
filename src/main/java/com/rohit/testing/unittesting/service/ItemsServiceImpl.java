package com.rohit.testing.unittesting.service;

import com.rohit.testing.unittesting.entity.Item;
import com.rohit.testing.unittesting.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemsServiceImpl {

    private ItemRepository itemRepository;

    public List<Item> getAllItems() {

        return itemRepository.findAll()
                .stream()
                .peek(item -> item.setValue(item.getPrice() * item.getId()))
                .collect(Collectors.toList());

    }

}
