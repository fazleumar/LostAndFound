package com.example.demo.controller;

import java.util.List;

import com.example.demo.items.Items;
import com.example.demo.service.ItemsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemsController {

    @Autowired
    private ItemsServiceImplementation itemsServiceImplementation;

    @GetMapping(value = "/items")
    public String getAllItems(Model model) {
        List<Items> list = itemsServiceImplementation.getAllItems();
        System.out.println(list);
        model.addAttribute("items_list", list);
        return "items";
    }

    @GetMapping(value = "/items/add")
    public String addItems(Model model) {
        Items item = new Items();
        model.addAttribute("items_list", item);
        return "items_form";
    }

    @GetMapping(value = "/items/update/{id}")
    public ModelAndView editItems(@PathVariable int id) {
        ModelAndView model = new ModelAndView();
        Items item = itemsServiceImplementation.findItemsById(id);
        model.addObject("itemsForm", item);
        model.setViewName("items_form");
        return model;
    }

    @PostMapping(value = "/items/save")
    public ModelAndView saveOrUpdate(@ModelAttribute("itemsForm") Items item) {
        if(item.getItemID() != null) {
            itemsServiceImplementation.updateItems(item);
        } else {
            itemsServiceImplementation.addItems(item);
        }
        return new ModelAndView("redirect:/items");
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteItems(@PathVariable("id") int id) {
        itemsServiceImplementation.deleteItems(id);
        return new ModelAndView("redirect:/items");
    }

    // Hi
}