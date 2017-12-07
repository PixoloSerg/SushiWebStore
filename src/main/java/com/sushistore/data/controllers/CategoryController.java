/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.controllers;

import com.sushistore.data.entities.Category;
import com.sushistore.data.utills.ConnectionPool;
import com.sushistore.data.utills.DataWrapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author P5
 */
public class CategoryController {
    private static Category getCategory(ResultSet rs) throws SQLException {
        Category c = new Category();
        c.setId(rs.getInt("ID"));
        c.setCategoryName(rs.getString("CATEGORYNAME"));
        c.setDescription(rs.getString("DESCRIPTION"));
        c.setIcon(rs.getNString("ICON"));
        c.setImage(rs.getString("IMAGE"));
        c.setInmenu(rs.getBoolean("INMENU"));
        c.setMenuWeight(rs.getShort("MENUWEIGHT"));
        c.setParent_id(rs.getInt("PARENTID"));
        c.setVisible(rs.getBoolean("VISIBLE"));
        c.setWeight(rs.getShort("WEIGHT"));                   
        return c;
    }
    
    public static Category getCategoryById(Integer id) {
        Category category = null;
        ResultSet rs = null;
        String query = "SELECT * FROM CATEGORY WHERE ID=?";
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next())
                category = getCategory(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DataWrapper.closeStatement(rs);
        }
        return category;
    }
    
    public static List<Category> getCategoriesByMenu() {
        List<Category> list = null;
        String query = "SELECT * FROM CATEGORY C WHERE C.INMENU = TRUE ORDER BY MENUWEIGHT DESC";
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()){
            list = new ArrayList<>();
            while(rs.next()) {
                list.add(getCategory(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public static List<Category> getCategoriesByVisibility() {
        List<Category> list = null;
        String query = "SELECT * FROM CATEGORY C WHERE C.VISIBLE = TRUE ORDER BY WEIGHT DESC";
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()){
            list = new ArrayList<>();
            while(rs.next()) {
                list.add(getCategory(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }    
}
