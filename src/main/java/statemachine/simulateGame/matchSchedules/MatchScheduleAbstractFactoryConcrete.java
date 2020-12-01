package statemachine.simulateGame.matchSchedules;

public class MatchScheduleAbstractFactoryConcrete extends MatchScheduleAbstractFactory {

    private static IDeadlines deadlines;
    private static IRegularSeasonSchedule regularSeasonSchedule;
    private static IPlayoffSchedule playoffSchedule;

    @Override
    public IDeadlines getDeadline() {
        if (deadlines == null) {
            deadlines = new Deadlines();
            logger.info("New Object of Deadline Class is created");
        }
        return deadlines;
    }

    @Override
    public void setDeadline(IDeadlines deadline) {
        deadlines = deadline;
    }

    @Override
    public IRegularSeasonSchedule getRegularSeason() {
        if (regularSeasonSchedule == null) {
            regularSeasonSchedule = new RegularSeasonSchedule();
            logger.info("New Object of regularSeasonSchedule Class is created");
        }
        return regularSeasonSchedule;
    }

    @Override
    public void setRegularSeason(IRegularSeasonSchedule regularSeason) {
        regularSeasonSchedule = regularSeason;
    }

    @Override
    public IPlayoffSchedule getPLayOff() {
        if (playoffSchedule == null) {
            playoffSchedule = new PlayoffSchedule();
            logger.info("New Object of playoffSchedule Class is created");
        }
        return playoffSchedule;
    }

    @Override
    public void setPlayOff(IPlayoffSchedule playOff) {
        playoffSchedule = playOff;
    }
}
