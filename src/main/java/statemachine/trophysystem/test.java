package statemachine.trophysystem;

import leagueobjectmodel.IHeadCoachModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;

public class test {

    public static void main(String[] args) {
        IHeadCoachModel coach = LeagueObjectModelAbstractFactory.getInstance().getHeadCoach();
        CoachStandingSubject subject = CoachStandingSubject.getInstance(); // game simulation
        IObserver observer = new CoachStandingObserver();
        subject.attach(observer);
        subject.notifyCoachStanding(coach); // game simulation
    }
}