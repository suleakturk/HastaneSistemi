package com.example.hastanesistemi;

import java.sql.*;

public class DatabaseConnection {
    public Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/HastaneSistemi";
        String userName = "postgres";
        String password = "12345678";
        Connection baglanti;
        try {
            baglanti = DriverManager.getConnection(url,userName,password);
            System.out.println("Connected to db");
            return baglanti;

        } catch (SQLException e) {
            System.out.println("opps, there's en error") ;
            e.printStackTrace();
            return null;
        }
    }
}