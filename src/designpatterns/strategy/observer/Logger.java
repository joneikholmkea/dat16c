package designpatterns.strategy.observer;

public class Logger implements Observer {
    @Override
    public void notifyMe(String lastId, String lastContent) {

        System.out.print("Logger is notified: ");
        System.out.println("saved record: " + lastId
                + " with content: " + lastContent);

    }
}
