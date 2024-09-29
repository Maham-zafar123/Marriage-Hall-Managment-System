package com.example.marrige_hall_managment_system;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerSignupController {
    @FXML
    private ToggleGroup Gender;

    @FXML
    private TextField cityfield;
    @FXML
    private Label messagelabel;
    @FXML
    private TextField contactfield;



    @FXML
    private Button cust_backtologin_btn;

    @FXML
    private Button cust_register_btn;

    @FXML
    private TextField emailfield;

    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private RadioButton tmale;

    @FXML
    private TextField namefield;

    @FXML
    private TextField passwordfield;

    @FXML
    void cust_backtologin_btn_clicked(ActionEvent event) throws IOException {
        System.out.println("Back to Login was pressed");
        Stage stage = (Stage) cust_backtologin_btn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    String name,email,contact,city,gender,password;
    public void getvals() {
        name = namefield.getText();
        email = emailfield.getText();
        contact = contactfield.getText();
        city = cityfield.getText();
        if (male.isSelected()){
            gender = "Male";
        }
        if (female.isSelected()){
            gender="Female";
        }
        if (tmale.isSelected()){
            gender="Other";
        }
        password = passwordfield.getText();
    }
    @FXML
    void cust_register_btn_clicked(ActionEvent event) throws SQLException {
        getvals();
        System.out.println("Register button clicked...");
        if (name.isBlank() ==false && email.isBlank()==false && contact.isBlank()==false &&
                city.isBlank()==false && password.isBlank()==false && gender.isBlank()==false){
            if (RegisterUser()){
                messagelabel.setText(" Congratulations!!  User Registered Successfully!!");
            }else {
                messagelabel.setText("Wrong info Added!!");
            }
        }
    }

    public boolean RegisterUser() throws SQLException {
        try{
            DatabaseConnection db = new DatabaseConnection();
            Connection connection = db.establishConnection();
//        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO Customer_T (customerID, customerName, customerContact, customerCity, customerGender, customerEmail, customerPassword) VALUES (5,'Bilal', '03035320990','khanewal', 'Male', 'cocaboya7@gmail.com', 'bilal@2004')");
            String sql = "INSERT INTO Customers_T (customerID, customerName, customerContact, customerCity, customerGender, customerEmail, customerPassword) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 11);
            statement.setString(2, name);
            statement.setString(3, contact);
            statement.setString(4, city);
            statement.setString(5, gender);
            statement.setString(6, email);
            statement.setString(7, password);

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }}
