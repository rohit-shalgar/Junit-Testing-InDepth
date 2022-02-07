package com.rohit.testing.unittesting.repository;

import com.rohit.testing.unittesting.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
