package com.example.marrige_hall_managment_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class CustomerLoginController {
    @FXML
    private Button cust_login_btn;

    @FXML
    private Button cust_signup_btn;

    @FXML
    private PasswordField passwordtextfield;

    @FXML
    private TextField usernamaetextfield;
    @FXML
    private Label messagelabel;
    @FXML
    void cust_login_btn_clicked(ActionEvent event) throws IOException {
        System.out.println("Customer Pressed Login button");
        if (usernamaetextfield.getText().isBlank() == false && passwordtextfield.getText().isBlank() == false ) {
                if (validateLogin()) {
                    messagelabel.setText("Congratulations! you have logged IN");
                    Alert alter = new Alert(Alert.AlertType.INFORMATION);
                    alter.setTitle("Successs");
                    alter.setContentText("Congratulations! you have looged IN");
                    alter.show();
                    Stage stage = (Stage) cust_login_btn.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("marriage_hall_selection2.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    stage.setTitle("Hello!");
                    stage.setScene(scene);

                } else {
                    messagelabel.setText("Invalid Credentials! Try Again....");
                }
        } else {
            messagelabel.setText("Username or password can't be blank");
        }
    }

    @FXML
    void cust_signup_btn_clicked(ActionEvent event) throws IOException {
        System.out.println("Customer Pressed Sigin Button");
        Stage stage = (Stage) cust_signup_btn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    public boolean validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.establishConnection();
        try {
            PreparedStatement statement = connectDB.prepareStatement("SELECT customerEmail,customerPassword FROM CUSTOMERS_T WHERE customerEmail = ? AND customerPassword = ?");
            statement.setString(1, usernamaetextfield.getText());
            statement.setString(2, passwordtextfield.getText());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
