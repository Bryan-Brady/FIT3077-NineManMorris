package com.example.ninemanmorris;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class NMMApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NMMApplication.class.getResource("NNM-view.fxml"));
        Button button = new Button();
        button.setText("SAMPLE BUTTON");
        button.setTranslateX(150);
        button.setTranslateY(60);
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Nine Man Morris");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}


