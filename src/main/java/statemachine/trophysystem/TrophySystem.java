package statemachine.trophysystem;

import cli.CliAbstractFactory;
import cli.IDisplay;
import leagueobjectmodel.ILeagueModel;

public class TrophySystem {

    EndOfPlayOffStandingSubject subject;
    EndOfSeasonStandingSubject subject1;
    AwardWinnersSubject subject2;
    IDisplay display = CliAbstractFactory.getInstance().getDisplay();

    private static TrophySystem unique_instance = new TrophySystem();

    public static TrophySystem getInstance() {
        return unique_instance;
    }

    public TrophySystem() {
        subject = EndOfPlayOffStandingSubject.getInstance();

        IObserver observer = new TeamStandingObserver();
        IObserver observer1 = new ForwardStandingObserver();
        IObserver observer2 = new DefensemanStandingObserver();
        IObserver observer3 = new CoachStandingObserver();
        IObserver observer4 = new GoalieStandingObserver();
        IObserver observer5 = new PlayerStandingObserver();

        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer4);

        subject1 = EndOfSeasonStandingSubject.getInstance();
        subject1.attach(observer);
        subject1.attach(observer3);
        subject1.attach(observer5);

        subject2 = AwardWinnersSubject.getInstance();
        subject2.attach(observer);
        subject2.attach(observer1);
        subject2.attach(observer2);
        subject2.attach(observer3);
        subject2.attach(observer4);
        subject2.attach(observer5);
    }

    public void performCalculationBeforePlayOff(ILeagueModel leagueModel,int year){
        subject.notifyObservers(leagueModel, year);
    }

    public void performCalculationAfterPlayOff(ILeagueModel leagueModel,int year) {
        subject1.notifyObservers(leagueModel, year);
    }

    public void awardWinners(){
        subject2.notifyObservers(display);
    }
}
