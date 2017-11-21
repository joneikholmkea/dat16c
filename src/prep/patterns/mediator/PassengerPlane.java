package prep.patterns.mediator;

import javafx.scene.control.Button;

public class PassengerPlane extends Plane {


    public PassengerPlane(MediatorInterface mediator, String name) {
        super(mediator, name);
        signup();
        this.setOnAction(e -> {
            this.requestToLand(name);
            System.out.println(name + " was pressed");
                }
        );
    }

    @Override
    public void receiveLandingStatus(String message) {
            if(message.equals("land")){
                this.setText("Landing the PassengerPlane");
                this.setDisable(true);
                this.setStyle("-fx-background-color: lightgreen");
            }else {
                this.setDisable(false);
                this.setStyle("-fx-background-color: gray");
                this.setText("Not Cleared for Landing");
            }
    }

    @Override
    public void requestToLand(String planeName) {
        this.mediator.receive(planeName, this);
    }

    @Override
    public void signup() {
        mediator.signUp(this);
    }
}
