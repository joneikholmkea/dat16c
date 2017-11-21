package prep.patterns.mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator implements MediatorInterface {

    private List<Plane> planes = new ArrayList<>();
    @Override
    public void signUp(Plane plane) {
            planes.add(plane);
    }


    @Override
    public void receive(String message, Plane plane) {
        for (Plane plane_ : planes) {
            if(plane.equals(plane_)){
                System.out.println("plane objects are equal");
                plane_.receiveLandingStatus("land");
            }else{
                plane_.receiveLandingStatus("Do not land");

            }
        }
    }
}
