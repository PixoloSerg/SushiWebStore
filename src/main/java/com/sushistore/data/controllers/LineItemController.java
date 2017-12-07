/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.controllers;

import com.sushistore.data.entities.Invoice;
import com.sushistore.data.entities.LineItem;
import com.sushistore.data.utills.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sveta
 */
public class LineItemController {
    
    private static LineItem getLineItem(ResultSet rs) throws SQLException {
        LineItem l = new LineItem();
        l.setAmount( rs.getInt( LineItem.AMOUNT ) );
        l.setGoodsId(rs.getInt( LineItem.GOODSID ) );
        l.setId(rs.getLong( "ID" ) );
        l.setInvoiceId(rs.getLong( LineItem.INVOICEID ) );
        l.setPoint(rs.getBigDecimal(LineItem.POINT ) );
        l.setPrice(rs.getBigDecimal(LineItem.PRICE ) );
        l.setSumm(rs.getBigDecimal(LineItem.SUMM ) );        
        return l;
    }
    
    public static List<LineItem> getLineItemsByInvoice(Invoice invoice) {
        List<LineItem> list = null;
        ResultSet rs = null;
        String query = "SELECT * FROM LINEITEM WHERE " + LineItem.INVOICEID + "=?";
        try (Connection con = ConnectionPool.getConnectionPool().getConnection();
                PreparedStatement ps = con.prepareStatement(query)){
            ps.setLong(1, invoice.getId());
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while(rs.next())
                list.add(getLineItem(rs));                
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
