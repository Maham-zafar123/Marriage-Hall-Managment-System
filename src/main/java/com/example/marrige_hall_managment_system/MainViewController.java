package com.example.marrige_hall_managment_system;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Button adminbtn;

    @FXML
    private Button custbtn;

    @FXML
    void AdminBtnClicked(ActionEvent event) throws IOException {
        System.out.println("Admin Button Clicked");
        Stage stage = (Stage) adminbtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin_login.fxml"));
       Scene scene = new Scene(fxmlLoader.load());
       stage.setScene(scene);
    }

    @FXML
    void custBtnClicked(ActionEvent event) throws IOException {
        System.out.println("Customer Button Clicked");
        Stage stage = (Stage) custbtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

}
