/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.company2566;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Arthit LungYa
 */
public class DatabaseConnector {

    private Connection conn;
    private Statement statement;

    public void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_db", "root", "");
                statement = conn.createStatement();
                System.out.println("Connected to the database");
            } catch (SQLException ex) {
                System.err.println("Error connecting to the database: " + ex.getMessage());
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("MySQL JDBC Driver not found");
        }
    }

    public void testConnection() {
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    System.out.println("Connection is valid");
                } else {
                    System.out.println("Connection is closed");
                }
            } catch (SQLException e) {
                System.err.println("Error checking connection validity: " + e.getMessage());
            }
        } else {
            System.out.println("Connection is null");
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("Error executing query: " + ex.getMessage());
            return null;
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return conn;
    }
    

}
