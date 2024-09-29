package com.example.marrige_hall_managment_system;

import java.sql.*;

public class DatabaseConnection {
    public Connection connection;
    public Connection establishConnection() {
        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Connect to the database
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "system", "Oracle_1");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return connection;
    }

}
