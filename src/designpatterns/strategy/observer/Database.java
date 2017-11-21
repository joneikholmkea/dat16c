package designpatterns.strategy.observer;

import java.util.ArrayList;
import java.util.List;

public class Database extends Storage {

    private List<Observer> observers = new ArrayList<>();

    private String lastId;
    private String lastContent;

    public void save(String recordId, String content){
        lastId = recordId;
        lastContent = content;
        System.out.println("Database has saved record: " + recordId
        + " with content: " + content);
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.notifyMe(lastId, lastContent);
        }

    }
}
