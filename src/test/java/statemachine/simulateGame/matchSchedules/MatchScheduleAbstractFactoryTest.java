package statemachine.simulateGame.matchSchedules;

public abstract class MatchScheduleAbstractFactoryTest {

    private static MatchScheduleAbstractFactory instance;

    public static MatchScheduleAbstractFactory getMatchScheduleInstance(){
        if(instance==null){
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
