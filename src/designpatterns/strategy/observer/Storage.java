package designpatterns.strategy.observer;

public abstract class Storage implements Subject {
    public abstract void save(String recordId, String content);
}
