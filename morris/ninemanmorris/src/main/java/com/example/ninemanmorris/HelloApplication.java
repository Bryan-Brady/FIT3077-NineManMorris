package com.example.ninemanmorris;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Nine Man Morris");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


//Default layout for hello-view.fxml

//<?xml version="1.0" encoding="UTF-8"?>
//
//<?import javafx.geometry.Insets?>
//<?import javafx.scene.control.Label?>
//<?import javafx.scene.layout.VBox?>
//
//<?import javafx.scene.control.Button?>
//<VBox alignment="CENTER" spacing="20.0" xmlns:fx="http://javafx.com/fxml"
//        fx:controller="com.example.ninemanmorris.HelloController">
//<padding>
//<Insets bottom="20.0" left="20.0" right="20.0" top="20.0"/>
//</padding>
//
//<Label fx:id="welcomeText"/>
//<Button text="Hello!" onAction="#onHelloButtonClick"/>
//</VBox>
