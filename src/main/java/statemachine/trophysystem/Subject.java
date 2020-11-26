package statemachine.trophysystem;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public abstract class Subject {
    private List<IObserver> observers;

    public Subject(){
        observers =new ArrayList<IObserver>();
    }

    public void attach(IObserver observer){
        observers.add(observer);
        notifyObservers();
    }

    public void detach(IObserver observer){
        observers.add(observer);
    }

    public void notifyObservers(){
        ListIterator<IObserver> observerList = observers.listIterator();
        while(observerList.hasNext()){
            observerList.next().update();
        }
    }
}
