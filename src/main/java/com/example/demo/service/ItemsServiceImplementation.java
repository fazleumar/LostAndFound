package com.example.demo.service;

import com.example.demo.items.Items;
import com.example.demo.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImplementation implements ItemsService {
    @Autowired
    private ItemsRepository itemsRepository;

    public ItemsServiceImplementation(ItemsRepository itemsRepository) {
        super();
        this.itemsRepository = itemsRepository;
    }
    @Override
    public List<Items> getAllItems() {
        return itemsRepository.findAll();
    }

    @Override
    public Items saveItem(Items item) {
        return itemsRepository.save(item);
    }

    @Override
    public Items getItemById(Integer id) {
        return itemsRepository.findById(id).get();
    }

    @Override
    public Items updateItem(Items item) {
        return itemsRepository.save(item);
    }

    @Override
    public void deleteItemById(Integer id) {
        itemsRepository.deleteById(id);
    }
}