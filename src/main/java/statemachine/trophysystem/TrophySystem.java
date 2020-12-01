package statemachine.trophysystem;

import cli.CliAbstractFactory;
import cli.ICli;
import leagueobjectmodel.ILeagueModel;
import org.apache.log4j.Logger;

public class TrophySystem implements ITrophySystem{

    EndOfPlayOffStandingSubject subject;
    EndOfSeasonStandingSubject subject1;
    AwardWinnersSubject subject2;
    ICli display = CliAbstractFactory.getInstance().getCli();

    final static Logger logger = Logger.getLogger(TrophySystem.class);

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

    @Override
    public void performCalculationBeforePlayOff(ILeagueModel leagueModel,int year){
        if(leagueModel == null){
            logger.error(TrophySystemConstants.LogError.getValue());
            throw new NullPointerException(TrophySystemConstants.ExceptionError.getValue());
        }
        subject.notifyObservers(leagueModel, year);
    }

    @Override
    public void performCalculationAfterPlayOff(ILeagueModel leagueModel,int year) {
        if(leagueModel == null) {
            logger.error(TrophySystemConstants.LogError.getValue());
            throw new NullPointerException(TrophySystemConstants.ExceptionError.getValue());
        }
        subject1.notifyObservers(leagueModel, year);
    }

    @Override
    public void awardWinners(){
        subject2.notifyObservers(display);
    }
}
