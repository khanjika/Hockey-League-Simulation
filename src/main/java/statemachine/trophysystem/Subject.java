package statemachine.trophysystem;

import cli.ICli;
import leagueobjectmodel.ILeagueModel;
import org.apache.log4j.Logger;

import java.util.*;

public abstract class Subject {
    final static Logger logger = Logger.getLogger(Subject.class);
    private List<IObserver> observers;

    public Subject(){
        this.observers =new ArrayList<>();
    }

    public void attach(IObserver observer){
        observers.add(observer);
    }

    public void notifyObservers(ILeagueModel leagueModel, int year){
        logger.info(TrophySystemConstants.LogInfoSubjectUpdate.getValue());
        for (IObserver observer : observers){
            observer.update(leagueModel, year);
        }
    }

    public void notifyObservers(ICli display){
        logger.info(TrophySystemConstants.LogInfoSubjectDisplay.getValue());
        for (IObserver observer : observers){
            observer.getHistoryOfWinners(display);
        }
    }
}
