package designpatterns.strategy.observer;

public class Boss implements Observer {
    @Override
    public void notifyMe(String lastId, String lastContent) {
        System.out.print("Boss is notified: ");
        System.out.println("saved record: " + lastId
                + " with content: " + lastContent);
    }
}
