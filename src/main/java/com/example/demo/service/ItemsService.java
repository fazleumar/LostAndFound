package com.example.demo.service;

import com.example.demo.items.Items;

import java.util.List;

public interface ItemsService {
    List<Items> getAllItems();

    Items saveItem(Items item);
    Items getItemById(Integer id);
    Items updateItem(Items item);
    void deleteItemById(Integer id);
    List<Items> findByKeyword(String keyword);
}
