package prep.patterns.mediator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox();
        Scene scene = new Scene(hBox, 600,300);
        MediatorInterface mediator = new Mediator();
        Plane airbus = new PassengerPlane(mediator, "Airbus");
        Plane boeing = new PassengerPlane(mediator, "Boeing");
        Plane embraer = new PassengerPlane(mediator, "embraer");
        hBox.getChildren().addAll(airbus, boeing, embraer);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}