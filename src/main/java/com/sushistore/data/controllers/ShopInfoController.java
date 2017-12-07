/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.controllers;

import com.sushistore.data.entities.About;
import com.sushistore.data.entities.Offer;
import com.sushistore.data.entities.RecommendBlock;
import com.sushistore.data.entities.SaleBlock;
import com.sushistore.data.entities.ShopInfo;
import com.sushistore.data.utills.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author P5
 */
public class ShopInfoController {
    
    public static ShopInfo getShopInfo() {
        ShopInfo shopInfo = null;
        final String query = "SELECT * FROM SHOPINFO WHERE ID=1";
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()){
            if(rs.next()) {
                shopInfo = new ShopInfo();
                shopInfo.setId(rs.getInt("ID"));
                shopInfo.setPopularBandTitle(rs.getString("POPULARBANDTITLE"));
                shopInfo.setNewBandTitle(rs.getString("NEWBANDTITLE"));
                shopInfo.setShopSlogan(rs.getString("SHOPSLOGAN"));
                
                About about = new About();
                about.setTitle(rs.getString("ABOUTTITLE"));
                about.setMsgTtitle(rs.getString("ABOUTMSGTITLE"));
                about.setMsgText(rs.getString("ABOUTMSGTEXT"));
                about.setServicePhone(rs.getString("ABOUTSERVICEPHONE"));
                shopInfo.setAbout(about);
                
                Offer offer = new Offer();
                offer.setTitle(rs.getString("OFFERTITLE"));
                offer.setText(rs.getString("OFFERTEXT"));
                shopInfo.setOffer(offer);
                
                RecommendBlock recommendBlock = new RecommendBlock();
                recommendBlock.setTitle(rs.getString("RECOMMENDBLOCKTITLE"));
                recommendBlock.setText(rs.getString("RECOMMENDBLOCKTEXT"));
                shopInfo.setRecommendBlock(recommendBlock);
                
                SaleBlock saleBlock = new SaleBlock();
                saleBlock.setTitle(rs.getString("SALEBLOCKTITLE"));
                saleBlock.setText(rs.getString("SALEBLOCKTEXT"));
                shopInfo.setSaleBlock(saleBlock);                                        
            }            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return shopInfo;
    }
    
}
