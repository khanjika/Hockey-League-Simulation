package statemachine.simulateGame.matchSchedules;

public class MatchScheduleAbstractFactoryConcreteTest extends MatchScheduleAbstractFactoryTest{

    @Override
    public IDeadlines getDeadline() {
        return MatchScheduleAbstractFactory.getMatchScheduleInstance().getDeadline();
    }

    @Override
    public void setDeadline(IDeadlines deadline) {
        MatchScheduleAbstractFactory.getMatchScheduleInstance().setDeadline(deadline);
    }

    @Override
    public IRegularSeasonSchedule getRegularSeason() {
        return MatchScheduleAbstractFactory.getMatchScheduleInstance().getRegularSeason();
    }

    @Override
    public void setRegularSeason(IRegularSeasonSchedule regularSeason) {
        MatchScheduleAbstractFactory.getMatchScheduleInstance().setRegularSeason(regularSeason);
    }

    @Override
    public IPlayoffSchedule getPLayOff() {
       return MatchScheduleAbstractFactory.getMatchScheduleInstance().getPLayOff();
    }

    @Override
    public void setPlayOff(IPlayoffSchedule playOff) {
        MatchScheduleAbstractFactory.getMatchScheduleInstance().setPlayOff(playOff);
    }
}
