package com.example.demo.service;

import com.example.demo.items.Items;

import java.util.List;

public interface ItemsService {

    public List<Items> getAllItems();

    public Items findItemsById(int id);

    public void addItems(Items item);

    public void updateItems(Items item);

    public void deleteItems(int id);
}