/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.controllers;

import com.sushistore.data.entities.Client;
import com.sushistore.data.utills.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author P5
 */
public class ClientController {
    
    private static Client getClient(ResultSet rs) throws SQLException {
        Client c = new Client();
        c.setAddress(rs.getString( Client.ADDRESS ));
        c.setEmail(rs.getString( Client.EMAIL ));
        c.setFirstName(rs.getString( Client.FIRSTNAME ));
        c.setId(rs.getInt( "ID" ));
        c.setLastName(rs.getString( Client.LASTNAME ));
        c.setPoints(rs.getBigDecimal( Client.POINTS ));
        return c;
    }
    
    public static Client getClientById(Integer id) {
        ResultSet rs = null;
        Client client = null;
        String query = "SELECT 8 FROM CLIENT WHERE ID=?";
        try (Connection con = ConnectionPool.getConnectionPool().getConnection();
                PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next())
                client = getClient(rs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return client;
    }
    
}
