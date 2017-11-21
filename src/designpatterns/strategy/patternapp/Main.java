package designpatterns.strategy.patternapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox menuKnapper = new VBox();
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(menuKnapper);
        Label label = new Label("her kommer indholdet...");
        borderPane.setCenter(label);
        Button observerBtn = new Button("Observer");
        Button strategyBtn = new Button("Strategy");
        Button flyweightBtn = new Button("Flyweight");
        Scene scene = new Scene(borderPane, 500,700);
        menuKnapper.getChildren().addAll(observerBtn,strategyBtn,flyweightBtn);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
