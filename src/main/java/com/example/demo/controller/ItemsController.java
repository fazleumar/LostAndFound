package com.example.demo.controller;

import com.example.demo.items.Items;
import com.example.demo.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/items")
    public String listOfItems(Model model) {
        model.addAttribute("items", itemsService.getAllItems());
        return "items";
    }

    @GetMapping("/items/add")
    public String addItemForm(Model model) {
        Items items = new Items();
        model.addAttribute("items", items);
        return "add_item";
    }

//    @PostMapping("/items")
//    public String saveItem(@ModelAttribute("items") Items item) {
//        itemsService.saveItem(item);
//        return "redirect:/items";
//    }

    @PostMapping("/items")
    public String saveItem(@ModelAttribute("items") Items item) {
        itemsService.saveItem(item);
        return "redirect:/items";
    }

//    @Value("${tomtom.apikey}")
//    private String tomTomApiKey;
//
//    @GetMapping("/api.tomtom.com/map/2/tile/basic/20/1/1.pbf?key=xa9LGWuC2HBkv8OLZsRCSJhxsAVJmH6q&view=PK")
//    public String homePage(Model model) {
//        model.addAttribute("apikey", tomTomApiKey);
//        return "map";
//    }

//    https://{api.tomtom.com}/map/{2}/tile/{basic}/{20}/{1}/{1}.{pbf}?key={xa9LGWuC2HBkv8OLZsRCSJhxsAVJmH6q}&view={PK}

    @GetMapping("/items/edit/{id}")
    public String editItem (@PathVariable Integer id, Model model) {
        model.addAttribute("items", itemsService.getItemById(id));
        return "edit_item";
    }

    @PostMapping("/items/{id}")
    public String updateItem(@PathVariable Integer id, @ModelAttribute("item") Items item, Model model) {
        Items existingItem = itemsService.getItemById(id);
        existingItem.setItem_id(id);
        existingItem.setReport_type(item.getReport_type());
        existingItem.setTitle(item.getTitle());
        existingItem.setDescription(item.getDescription());
        existingItem.setReported_by(item.getReported_by());
        existingItem.setLatitude(item.getLatitude());
        existingItem.setLongitude(item.getLongitude());

        itemsService.saveItem(existingItem);
        return "redirect:/items";
    }

    // Handler to handle delete item request

    @GetMapping("/items/{id}")
    public String deleteItem(@PathVariable Integer id) {
        itemsService.deleteItemById(id);
        return "redirect:/items";
    }
}