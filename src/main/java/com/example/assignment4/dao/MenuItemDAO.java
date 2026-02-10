package com.example.assignment4.dao;


import com.example.assignment4.db.DBConnection;
import com.example.assignment4.model.MenuItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemDAO {

    public static List<MenuItem> getAllItems() throws SQLException {

        List<MenuItem> items = new ArrayList<>();

        String sql = "SELECT name, price, category FROM menu_item";
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            items.add(new MenuItem(
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getString("category")
            ));
        }

        conn.close();
        return items;
    }

    public static void addItem(String name, double price, String category)
            throws SQLException {

        String sql =
                "INSERT INTO menu_item (name, price, category) VALUES (?, ?, ?)";

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, name);
        ps.setDouble(2, price);
        ps.setString(3, category);

        ps.executeUpdate();
        conn.close();
    }

    public static void deleteItem(String name) throws SQLException {

        String sql = "DELETE FROM menu_item WHERE name = ?";

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);

        ps.executeUpdate();
        conn.close();
    }
    public static void updatePrice(String name, double price) throws SQLException {
        String sql = "UPDATE menu_item SET price = ? WHERE name = ?";

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setDouble(1, price);   // ✅ ВАЖНО
        ps.setString(2, name);

        ps.executeUpdate();
        conn.close();
    }

}

