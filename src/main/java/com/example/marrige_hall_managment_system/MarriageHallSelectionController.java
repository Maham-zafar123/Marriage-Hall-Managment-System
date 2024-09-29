package com.example.marrige_hall_managment_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;

public class MarriageHallSelectionController {

    @FXML
    private Hyperlink firstmarriagehall;

    @FXML
    private Hyperlink forthmarriagehall;

    @FXML
    private Hyperlink secondmarriagehall;

    @FXML
    private Hyperlink thirdmarriagehall;

    @FXML
    void firstmarriagehall_btn(ActionEvent event) throws IOException {
        Stage stage = (Stage) firstmarriagehall.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Provide_information.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);

    }

    @FXML
    void forthmarriagehall_btn(ActionEvent event) throws IOException {
        Stage stage = (Stage) forthmarriagehall.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Provide_information.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
    }

    @FXML
    void secondmarriagehall_btn(ActionEvent event) throws IOException{
        Stage stage = (Stage) secondmarriagehall.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Provide_information.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
    }

    @FXML
    void thirdmarriagehall_btn(ActionEvent event)throws IOException {
        Stage stage = (Stage) thirdmarriagehall.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Provide_information.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
    }

}
