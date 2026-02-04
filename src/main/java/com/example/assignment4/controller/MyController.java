package com.example.assignment4.controller;

import com.example.assignment4.dao.MenuItemDAO;
import com.example.assignment4.dto.MenuItemDTO;
import com.example.assignment4.model.MenuItem;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MyController {

    @GetMapping
    public List<MenuItem> getMenu() throws SQLException {
        return MenuItemDAO.getAllItems();
    }

    @PostMapping
    public String addItem(@RequestBody MenuItemDTO dto) throws SQLException {
        MenuItemDAO.addItem(dto.getName(), dto.getPrice(), dto.getCategory());
        return "Item added";
    }

    @DeleteMapping("/{name}")
    public String deleteItem(@PathVariable String name) throws SQLException {
        MenuItemDAO.deleteItem(name);
        return "Item deleted";
    }

    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}
