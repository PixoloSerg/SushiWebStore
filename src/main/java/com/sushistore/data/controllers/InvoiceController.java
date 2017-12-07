/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.controllers;

import com.sushistore.data.entities.Invoice;
import com.sushistore.data.utills.ConnectionPool;
import com.sushistore.data.utills.DataWrapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author P5
 */
public class InvoiceController {    
    protected static Invoice getInvoice(ResultSet rs) throws SQLException {
        Invoice i = new Invoice();
        i.setAddress(rs.getString(Invoice.ADDRESS));
        i.setClientId(rs.getInt(Invoice.CLIENTID));
        i.setDescription(rs.getString(Invoice.DESCRIPTION));
        i.setId(rs.getLong("ID"));
//        i.setInvoiceDate( rs.getDate(i.INVOICEDATE) );
        i.setPointsSum(rs.getBigDecimal(Invoice.POINTSSUM));
        i.setTotalAmount(rs.getInt(Invoice.TOTALAMOUNT));
        i.setTotalSum(rs.getBigDecimal(Invoice.TOTALSUM));
        return i;
    }
    
    public static Invoice getInvoiceById(Long id) {
        ResultSet rs = null;
        Invoice invoice = null;
        String query = "SELECT * FROM INVOICE WHERE ID=?";
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
                PreparedStatement ps = connection.prepareStatement(query)){
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next())
                invoice = getInvoice(rs);                        
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DataWrapper.closeStatement(rs);
        }        
        return invoice;
    }
}
