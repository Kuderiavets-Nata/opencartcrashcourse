package com.opencart.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

    private static Connection connection;

    private static void setUp() {
        try {
            String url = "jdbc:mysql://localhost:3306/openshop";
            connection = DriverManager.getConnection(url, "root", "");
            System.out.println("Database connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unlockUser(String email) {
        setUp();
        try {
            Statement stmt = connection.createStatement();
            String sql = "UPDATE oc_customer_login SET total = 1 WHERE email = '" + email + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tearDown();
    }

    private static void tearDown() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println("Disconnect DB");
        }
    }
}
