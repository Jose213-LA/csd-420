// Name: Jose Flores
// Date: 8/17/2025
// Assignment: M1

package carddisplayapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class CardDisplay extends Application {

    private static final int TOTAL_CARDS = 52;
    private static final String CARD_PATH = "/cards/";
    private static final int CARD_WIDTH = 100;
    private static final int CARD_HEIGHT = 150;

    private HBox cardBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        cardBox = new HBox(10);
        displayRandomCards();

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> displayRandomCards());

        VBox root = new VBox(15, cardBox, refreshButton);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root);
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayRandomCards() {
        cardBox.getChildren().clear();

        List<Integer> cardNumbers = new ArrayList<>();
        for (int i = 1; i <= TOTAL_CARDS; i++) {
            cardNumbers.add(i);
        }

        Collections.shuffle(cardNumbers);

        cardNumbers.stream().limit(4).forEach(num -> {
            String imagePath = CARD_PATH + num + ".png";
            InputStream stream = getClass().getResourceAsStream(imagePath);

            if (stream == null) {
                System.out.println("❌ Could not find: " + imagePath);
            } else {
                Image image = new Image(stream);
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(CARD_WIDTH);
                imageView.setFitHeight(CARD_HEIGHT);
                cardBox.getChildren().add(imageView);
            }
        });
    }
}