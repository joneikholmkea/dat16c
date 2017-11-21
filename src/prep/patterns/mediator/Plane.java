package prep.patterns.mediator;

import javafx.scene.control.Button;

public abstract class Plane extends Button {

    protected MediatorInterface mediator;
    protected String name;

    public Plane() {
    }

    public Plane(MediatorInterface mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        setText(name);
        setMinWidth(200);
    }

    public abstract void receiveLandingStatus(String message);
    public abstract void requestToLand(String planeName);
    public abstract void signup();
}
