/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.utills;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 *
 * @author P5
 */
public class ConnectionPool {
    private static ConnectionPool instance = null;
    private static DataSource dataSource = null;
    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:comp/env/jdbc/SushiStoreDB");
        } catch(NamingException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static synchronized ConnectionPool getConnectionPool() {
        if(instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }
    
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);            
        }        
    }
    
    public void closeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
