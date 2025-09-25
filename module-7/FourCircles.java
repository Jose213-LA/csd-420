// Name: Jose Flores
// Date: 9/20/2025
// Assignment: M7
/* Purpose: This program demonstrates how to use external 
            CSS to style and arrange shapes in a JavaFX application.*/

package fourcirclesapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FourCircles extends Application {

    @Override
    public void start(Stage stage) {
        // Left VBox with one white circle
        Circle leftWhiteCircle = new Circle(50);
        leftWhiteCircle.getStyleClass().add("plaincircle");

        VBox vbox = new VBox();
        vbox.getChildren().add(leftWhiteCircle);
        vbox.getStyleClass().add("border");
        vbox.setAlignment(Pos.CENTER);             // Center circle vertically inside VBox
        vbox.setPadding(new Insets(10, 0, 10, 0)); // Add top & bottom padding to prevent touching edges

        // Right HBox with white, red, and green circles
        Circle whiteCircle = new Circle(50);
        whiteCircle.getStyleClass().add("plaincircle");

        Circle redCircle = new Circle(50);
        redCircle.setId("redcircle");

        Circle greenCircle = new Circle(50);
        greenCircle.setId("greencircle");

        HBox rightHBox = new HBox(10, whiteCircle, redCircle, greenCircle);
        rightHBox.setAlignment(Pos.CENTER_LEFT);
        rightHBox.setPadding(new Insets(10, 0, 10, 0)); // Padding top & bottom

        // Combine vbox and rightHBox into one row
        HBox allCirclesRow = new HBox(20, vbox, rightHBox);
        allCirclesRow.setAlignment(Pos.TOP_CENTER);  // Align circles towards top center of HBox
        allCirclesRow.setPrefHeight(300);            // Tall HBox

        // Wrap in a VBox to center the whole layout vertically in the window
        VBox root = new VBox(allCirclesRow);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("/fourcirclesapp/mystyle.css").toExternalForm());

        stage.setTitle("Exercise31_01");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}