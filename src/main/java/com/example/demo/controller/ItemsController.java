package com.example.demo.controller;

import com.example.demo.items.Items;
import com.example.demo.model.UsersModel;
import com.example.demo.service.FileUploadUtil;
import com.example.demo.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/items")
    public String listOfItems(Model model) {
//        Iterable<Items> itemsIterable = itemsService.getAllItems();
//        itemsIterable.forEach(items -> {
//            items.
//        });
//        Items savedItems = new Items();
        model.addAttribute("items", itemsService.getAllItems());
        System.out.println(itemsService.getAllItems());
//        String uploadDir = "./item-photos/" + savedItems.getItem_id();
//        Path uploadPath = Paths.get(uploadDir);
        return "items";
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
        String updatedFileName = UUID.randomUUID() + fileName;
//        String uploadDirectoryName = "./item-photos/" + items.getItem_id();
        String uploadDirectoryName = "item-photos";
//        items.setImage(updatedFileName);
//        itemsService.saveItem(items);
        Path uploadPath = Paths.get(uploadDirectoryName);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(updatedFileName);
            items.setImage(filePath.toFile().getAbsolutePath());
            itemsService.saveItem(items);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Could not save uploaded file: " + fileName);
        }
//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
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
    public String updateItem(@PathVariable Integer id, @ModelAttribute("item") Items item) {
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
    // IF user is registered and he/she has uploaded the item then offer him/her this page
    @GetMapping("/items/{id}")
    public String deleteItem(@PathVariable Integer id) {
        itemsService.deleteItemById(id);
        return "redirect:/items";
    }
}