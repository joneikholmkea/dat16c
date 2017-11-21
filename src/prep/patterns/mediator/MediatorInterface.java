package prep.patterns.mediator;

public interface MediatorInterface {

    public void signUp(Plane plane);
    public void receive(String message, Plane plane);
}
