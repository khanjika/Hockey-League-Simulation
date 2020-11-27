package statemachine.trophysystem;

import java.util.*;

public abstract class Subject {
    private List<IObserver> observers;
    protected Map<String,Object> subjectMap;

    public Subject(){
        this.observers =new ArrayList<>();
        this.subjectMap = new HashMap<>();
    }

    public void attach(IObserver observer){
        observers.add(observer);
    }

    public void detach(IObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (IObserver observer : observers){
            observer.update(this);
        }
        subjectMap.clear();
    }

    public Object getValue(String key){
        return subjectMap.get(key);
    }
}
