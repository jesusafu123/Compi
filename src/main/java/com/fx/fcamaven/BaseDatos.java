/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fx.fcamaven;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author jesus
 */
public class BaseDatos {

    private static final Connection con = initConexion();
    
    private static Connection initConexion() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ambito?serverTimezone=UTC", "root", "");
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Connection getConexion() {
        return con;
    }
}
