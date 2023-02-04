package com.example.practica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("authtoryzation.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setMaxHeight(1000);
        stage.setMinHeight(100);
        stage.setMaxWidth(1000);
        stage.setMinWidth(100);
        stage.setTitle("Авторизвция");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}