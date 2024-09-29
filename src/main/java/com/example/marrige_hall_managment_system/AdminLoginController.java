package com.example.marrige_hall_managment_system;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginController {

    @FXML
    private Button admin_login_btn;
    @FXML
    private Button switchbutton;

    @FXML
    private PasswordField passwordtextfield;

    @FXML
    private TextField usernamaetextfield;
public static String username;
    @FXML
    void admin_login_btn_clicked(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        System.out.println("Manager Pressed Login button");
        if (usernamaetextfield.getText().isBlank()==false && passwordtextfield.getText().isBlank()==false){
            if (validateLogin()){

//                messagelabel.setText("Congratulations! you have logged IN");
                alert.setTitle("Success!!!");
                alert.setContentText("you have logged IN");
                alert.setHeaderText(null);
                alert.show();
                username = usernamaetextfield.getText();
                Stage stage = (Stage) admin_login_btn.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin-view-interface.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
            }else {
                alert.setTitle("Failed");
                alert.setContentText("Invalid! Try Again....");
                alert.show();
            }
        }else {
            alert.setTitle("Failed");
            alert.setContentText("No field can be empty");
            alert.show();
        }

    }


    public boolean validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.establishConnection();
        try {
            PreparedStatement statement = connectDB.prepareStatement("SELECT managerEmail,password FROM Manager WHERE managerEmail = ? AND password = ?");
            statement.setString(1, usernamaetextfield.getText());
            statement.setString(2, passwordtextfield.getText());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Data Base Error ");
            return false;
        }

    }
    @FXML
    void switchbutton_clicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) switchbutton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

}
