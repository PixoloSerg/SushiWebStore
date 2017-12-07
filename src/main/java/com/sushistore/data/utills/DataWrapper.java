/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.utills;

/**
 *
 * @author P5
 */
public class DataWrapper {
    
    public static void closeStatement(AutoCloseable c) {
        if(c == null) return;
        try {
            c.close();
        } catch(Exception e) {
            
        }
    }
    
}
