package com.example.marrige_hall_managment_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class AdminMainController {

    @FXML
    private Button cancelbooking_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private Button viewbookingbtn;

    @FXML
    private Button viewcustomers_btn;

    @FXML
    void cancelbooking_btn_clicked(ActionEvent event) throws IOException {
        System.out.println("CAncel booking button pressed");
//        Stage stage = (Stage) cancelbooking_btn.getScene().getWindow();
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("manager-delete-booking.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
    }

    @FXML
    void logout_btn_clicked(ActionEvent event) throws IOException {
        System.out.println("Logout Button clicked");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Sure to Log Out....");
        alert.setTitle("Confirmation");
        alert.setContentText("You Will be redirected to Log-in Screen, if you Press 'OK'");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Stage stage = (Stage) logout_btn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin_login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello!");
            stage.setScene(scene);
        }
    }

    @FXML
    void viewbookingbtn_clicked(ActionEvent event) throws IOException {
        System.out.println("View booking button prssed");
//        Stage stage = (Stage) cancelbooking_btn.getScene().getWindow();
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("manager-view-booking.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
    }

    @FXML
    void viewcustomers_btn_clicked(ActionEvent event) throws IOException {
        System.out.println("View customers button presses");
//        Stage stage = (Stage) cancelbooking_btn.getScene().getWindow();
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("manager-view-customer.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
    }

}
