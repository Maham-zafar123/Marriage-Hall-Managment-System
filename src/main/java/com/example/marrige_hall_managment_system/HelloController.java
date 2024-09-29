package com.example.marrige_hall_managment_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.sql.*;
import java.sql.Connection; // Add this import statement

public class HelloController {

    @FXML
    private Button admin_main_btn;

    @FXML
    private Button cust_main_btn;

    @FXML
    void admin_main_btn_clicked(ActionEvent event) {
        System.out.println("Admin Button clicked");
    }

    @FXML
    void cust_main_btn_clicked(ActionEvent event) {
        System.out.println("Customer Button Clicked");
    }
    private Connection connection; // Add this line to declare the connection variable

    // Existing code...

    private void establishConnection() {
        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Connect to the database
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "system", "Oracle_1");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
