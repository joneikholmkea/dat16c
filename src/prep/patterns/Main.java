package prep.patterns;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox();
        Scene scene = new Scene(hBox, 400,400);
        Button button1 = new Button("B1");
        hBox.getChildren().addAll(button1);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
