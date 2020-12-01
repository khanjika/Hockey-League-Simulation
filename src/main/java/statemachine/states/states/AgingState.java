package statemachine.states.states;

import leagueobjectmodel.*;
import org.apache.log4j.Logger;
import statemachine.states.StateMachine;
import statemachine.simulateGame.matchSchedules.IDeadlines;
import statemachine.simulateGame.matchSchedules.MatchScheduleAbstractFactory;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class AgingState implements ITransition {

    IDeadlines iDeadlines;
    StateMachine stateMachine;
    ILeagueModel leagueModel;
    LocalDate currentDate;
    IPlayerModel iPlayerModel;
    IFreeAgentModel iFreeAgentModel;
    ISortTeams sortTeams;
    private int daysToAge;
    private final int DAYS_TO_AGE_AFTER_SEASON_ENDS = 183;
    private final int oneDaysToAge = 1;

    final static Logger logger = Logger.getLogger(AgingState.class);

    public AgingState(StateMachine stateMachine) {
        logger.info("Initializing Aging State");
        this.stateMachine = stateMachine;
    }

    public void updateAgingStateValue(StateMachine stateMachine, ILeagueModel leagueModel) throws Exception {
        if (stateMachine == null || leagueModel == null) {
            logger.error("LeagueModel or state is not intialized");
            throw new NullPointerException("LeagueModel or state is not intialized");
        } else {
            this.stateMachine = stateMachine;
            this.leagueModel = leagueModel;
            iDeadlines = MatchScheduleAbstractFactory.getMatchScheduleInstance().getDeadline();
        }
    }

    @Override
    public void entry() throws Exception {
        sortTeams = LeagueObjectModelAbstractFactory.getInstance().getSortTeams();
        iPlayerModel = LeagueObjectModelAbstractFactory.getInstance().getPlayer();
        iFreeAgentModel = LeagueObjectModelAbstractFactory.getInstance().getFreeAgentModel();
        task();
    }

    @Override
    public void task() throws Exception {
        daysToAge = oneDaysToAge;
        currentDate = stateMachine.getCurrentDate();
        int currentYear = currentDate.getYear();
        long tempDays = DAYS.between(currentDate, iDeadlines.getEndOfRegularSeasonDate(currentYear));
        if (tempDays == 1) {
            daysToAge = DAYS_TO_AGE_AFTER_SEASON_ENDS;
        }

        IGamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        iPlayerModel.setAgingModel(gamePlayConfigModel.getAging());
        iPlayerModel.setFreeAgentsList(leagueModel.getFreeAgents());
        iFreeAgentModel.setAgingModel(gamePlayConfigModel.getAging());

    }

    @Override
    public void exit() {
        LeagueObjectModelAbstractFactory.getInstance().setSortTeam(null);
        LeagueObjectModelAbstractFactory.getInstance().setPlayer(null);
    }

}
