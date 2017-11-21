package designpatterns.strategy;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        FerrariAlgorithm ferrariAlgorithm = new FerrariAlgorithm();
        car.setGoAlgorithm(ferrariAlgorithm);
        car.go();
    }
}
