/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.controllers;

import com.sushistore.data.utills.ConnectionPool;
import com.sushistore.data.entities.Address;
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
public class AddressController {
    private static Address getAddress(ResultSet rs) throws SQLException {        
        Address info = new Address();
        info.setId(rs.getInt("id"));
        info.setCity(rs.getString("city"));
        info.setDistrict(rs.getString("district"));
        info.setStreet(rs.getString("street"));
        info.setStreetnumber(rs.getShort("streetnumber"));
        info.setPhone(rs.getString("phone"));        
        return info;
    }
    public static Address getAddressById(Integer id) {
        ConnectionPool pool = ConnectionPool.getConnectionPool();        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Address info = null;
        String query = "SELECT * FROM ADDRESS WHERE ID=?";
        try(Connection connection = pool.getConnection()) {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next())
                info = getAddress(rs);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DataWrapper.closeStatement(rs);
            DataWrapper.closeStatement(ps);
        }        
        return info;
    }
    
    public static Address getAddressByCity(String city) {
        ResultSet rs = null;
        Address info = null;
        String query = "SELECT * FROM ADDRESS WHERE CITY=?";
        try(Connection connection = ConnectionPool.getConnectionPool().getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, city);
            rs = ps.executeQuery();
            if(rs.next())
                info = getAddress(rs);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            DataWrapper.closeStatement(rs);
        }
        return info;
    }
    
    public static List<Address> getAddresses() {        
        List<Address> list = null;
        String query = "SELECT * FROM ADDRESS";
        try(Connection connection = ConnectionPool.getConnectionPool().getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            list = new ArrayList<>();
            while(rs.next()) {
                list.add(getAddress(rs));                
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;        
    }
}
