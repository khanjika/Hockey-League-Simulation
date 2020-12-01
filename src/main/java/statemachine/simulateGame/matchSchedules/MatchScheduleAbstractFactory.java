package statemachine.simulateGame.matchSchedules;

import org.apache.log4j.Logger;

public abstract class MatchScheduleAbstractFactory {

    private static MatchScheduleAbstractFactory instance;
    final static Logger logger = Logger.getLogger(MatchScheduleAbstractFactory.class);

    public static MatchScheduleAbstractFactory getMatchScheduleInstance(){
        if(instance==null){
            logger.info("New Object of MatchScheduleAbstractFactory is created");
            instance=new MatchScheduleAbstractFactoryConcrete();
        }
        return instance;
    }

    public abstract IDeadlines getDeadline();

    public abstract void setDeadline(IDeadlines deadline);

    public abstract IRegularSeasonSchedule getRegularSeason();

    public abstract void setRegularSeason(IRegularSeasonSchedule regularSeason);

    public abstract IPlayoffSchedule getPLayOff();

    public abstract void setPlayOff(IPlayoffSchedule playOff);

}
