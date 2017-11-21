package designpatterns.strategy.observer;

public class RunExample {

    public static void main(String[] args) {

        Storage database = new Database();
        Observer boss = new Boss();
        Observer logger = new Logger();
        database.register(boss);
        database.register(logger);
        database.save("001", "First message written");
    }
}
