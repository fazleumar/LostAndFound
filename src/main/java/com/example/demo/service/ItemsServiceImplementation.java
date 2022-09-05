package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.ItemsDaoImplementation;
import com.example.demo.items.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImplementation implements ItemsService {

    @Autowired
    private ItemsDaoImplementation itemsDAOImplementation;

    @Override
    public List<Items> getAllItems() {
        return itemsDAOImplementation.getAllItems();
    }

    @Override
    public Items findItemsById(int id) {
        return itemsDAOImplementation.findItemsById(id);
    }

    @Override
    public void addItems(Items item) {
        itemsDAOImplementation.addItems(item);
    }

    @Override
    public void updateItems(Items item) {
        itemsDAOImplementation.updateItems(item);
    }

    @Override
    public void deleteItems(int id) {
        itemsDAOImplementation.deleteItems(id);
    }
}