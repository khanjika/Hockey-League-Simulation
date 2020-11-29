package statemachine.trophysystem;

import cli.ICli;
import cli.IDisplay;
import leagueobjectmodel.ILeagueModel;

import java.util.*;

public abstract class Subject {
    private List<IObserver> observers;

    public Subject(){
        this.observers =new ArrayList<>();
    }

    public void attach(IObserver observer){
        observers.add(observer);
    }

    public void notifyObservers(ILeagueModel leagueModel, int year){
        for (IObserver observer : observers){
            observer.update(leagueModel, year);
        }
    }

    public void notifyObservers(ICli display){
        for (IObserver observer : observers){
            observer.getHistoryOfWinners(display);
        }
    }
}
