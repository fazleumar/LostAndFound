package com.example.demo.controller;

import com.example.demo.items.Items;
import com.example.demo.service.ItemsService;
import com.example.demo.service.SaveImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

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
        System.out.println(itemsService.getAllItems());
        return "items";
    }

    @GetMapping("/")
    public String listOfItemsOnHomePage(Model model, String keyword) {
        if (keyword != null) {
            model.addAttribute("items", itemsService.findByKeyword(keyword));
        } else {
            model.addAttribute("items", itemsService.getAllItems());
        }
        return "index";
    }

    // IF user is registered then offer him/her this page
    @GetMapping("/items/add")
    public String addItemForm(Model model) {
        Items items = new Items();
        model.addAttribute("items", items);
        return "add_item";
    }

    // IF user is registered then offer him/her this page

    @PostMapping("/items")
    public String saveItem(@ModelAttribute(name = "items") Items items,
                           @RequestParam("product_image") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        items.setImage(fileName);
        Items saveItems = itemsService.saveItem(items);
        String uploadDir = "item-photos/" + saveItems.getItem_id();
        SaveImageService.saveFile(uploadDir, fileName, multipartFile);
        return "redirect:/items";
    }

    // IF user is registered and he/she has uploaded the item then offer him/her this page
    @GetMapping("/items/edit/{id}")
    public String editItem (@PathVariable Integer id, Model model) {
        model.addAttribute("items", itemsService.getItemById(id));
        return "edit_item";
    }

    // IF user is registered and he/she has uploaded the item then offer him/her this page
    @PostMapping("/items/{id}")
    public String updateItem(@PathVariable Integer id, @ModelAttribute("item") Items item, @RequestParam("product_image") MultipartFile multipartFile) throws IOException {
        Items existingItem = itemsService.getItemById(id);
        existingItem.setItem_id(id);
        existingItem.setReport_type(item.getReport_type());
        existingItem.setTitle(item.getTitle());
        existingItem.setDescription(item.getDescription());
        existingItem.setReported_by(item.getReported_by());
        existingItem.setLatitude(item.getLatitude());
        existingItem.setLongitude(item.getLongitude());

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        existingItem.setImage(fileName);
        String uploadDir = "item-photos/" + existingItem.getItem_id();
        SaveImageService.saveFile(uploadDir, fileName, multipartFile);

        itemsService.saveItem(existingItem);
        return "redirect:/items";
    }

    // Handler to handle delete item request
    // IF user is registered and he/she has uploaded the item then offer him/her this page
    @GetMapping("/items/{id}")
    public String deleteItem(@PathVariable Integer id) {
        itemsService.deleteItemById(id);
        return "redirect:/items";
    }
}