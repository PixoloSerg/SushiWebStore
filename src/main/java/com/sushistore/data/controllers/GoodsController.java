/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.controllers;

import com.sushistore.data.entities.Goods;
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
public class GoodsController {
    
    private static Goods getGoods(ResultSet rs) throws SQLException {
        Goods g = new Goods();
        g.setCalorie(rs.getInt("CALORIE"));
        g.setCarbohydrate(rs.getInt("CARBOHYDRATE"));
        g.setChef(rs.getBoolean("CHEF"));
        g.setDescription(rs.getString("DESCRIPTION"));
        g.setFat(rs.getInt("FAT"));
        g.setGoodsName(rs.getString("GOODSNAME"));
        g.setGroupId(rs.getInt("GROUPID"));
        g.setId(rs.getInt("ID"));
        g.setImages(rs.getString("IMAGES"));
        g.setIngridients(rs.getString("INGRIDIENTS"));
        g.setIsNew(rs.getBoolean("ISNEW"));
        g.setNewer(rs.getByte("NEWER"));
        g.setPoint(rs.getBigDecimal("POINT"));
        g.setPopular(rs.getBoolean("POPULAR"));
        g.setPopularity(rs.getByte("POPULARITY"));
        g.setPrice(rs.getBigDecimal("PRICE"));
        g.setProtein(rs.getInt("PROTEIN"));
        return g;
    }
    
    public static Goods getGoodsById(Integer id) {
        Goods goods = null;
        ResultSet rs = null;
        String query = "SELECT * FROM GOODS WHERE ID = ?";
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
                PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next())
                goods = getGoods(rs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DataWrapper.closeStatement(rs);
        }
        return goods;
    }
    
    public static List<Goods> getGoodsByCategoryId(Integer categoryId) {
        List<Goods> list = null;
	ResultSet rs = null;
        String query = "SELECT G.* FROM GOODS G JOIN GOODS_CATEGORY GC ON G.ID = GC.GOODSID WHERE GC.CATEGORYID = ?";
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
                PreparedStatement ps = connection.prepareStatement(query)){
	    ps.setInt(1, categoryId);
	    rs = ps.executeQuery();
            list = new ArrayList<>();
            while(rs.next()) 
                list.add(getGoods(rs));                        
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
	    DataWrapper.closeStatement(rs);
	}	
        return list;
    }
    
    protected static List<Goods> getGoodsListByQuery(String query) {
        List<Goods> list = null;        
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()){
            list = new ArrayList<>();
            while(rs.next())
                list.add(getGoods(rs));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;        
    }
    
    public static List<Goods> getGoodsByPopularity() {
        String query = "SELECT G.* FROM GOODS G WHERE G.POPULAR=TRUE ORDER BY G.POPULARITY";
        return getGoodsListByQuery(query);
    }
    
    public static List<Goods> getGoodsByRecommendation() {
        String query = "SELECT G.* FROM GOODS G WHERE G.RECOMMEND=TRUE ORDER BY G.RECOMMENDATION";
        return getGoodsListByQuery(query);
    }
    
    public static List<Goods> getGoodsBySale() {
        String query = "SELECT G.* FROM GOODS G WHERE G.SALE=TRUE ORDER BY G.SALEWEIGHT";
        return getGoodsListByQuery(query);
    }
    
    public static List<Goods> getGoodsByNew() {
        String query = "SELECT G.* FROM GOODS G WHERE G.ISNEW=TRUE ORDER BY G.NEWER";
        return getGoodsListByQuery(query);
    }
        
    public static List<Goods> getGoodsByChef() {
        String query = "SELECT G.* FROM GOODS G WHERE G.CHEF=TRUE";
        return getGoodsListByQuery(query);
    }
    
    public static List<Goods> getGoodsByVegetarian() {
        String query = "SELECT G.* FROM GOODS G WHERE G.VEGETARIAN=TRUE ORDER";
        return getGoodsListByQuery(query);
    }
    
    public static List<Goods> getGoodsBySpicy() {
        String query = "SELECT G.* FROM GOODS G WHERE G.SPICY=TRUE";
        return getGoodsListByQuery(query);
    }
    
}
