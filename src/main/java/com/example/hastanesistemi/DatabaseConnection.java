package com.example.hastanesistemi;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    public static void main(String[] args) {
       String url = "jdbc:postgresql://localhost:5432/HastaneSistemi";
        String userName = "postgres";
        String password = "12345678";

        Connection connection;
        {
            try {
                connection = DriverManager.getConnection(url,userName,password);
                System.out.println("Connected to db");

            } catch (SQLException e) {
                System.out.println("opps, there's en error") ;
                e.printStackTrace();
            }
        }
    }
}