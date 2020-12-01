package statemachine.states.statemachine.states;



import leagueobjectmodel.*;
import org.apache.log4j.Logger;
import statemachine.states.statemachine.StateMachine;
import statemachine.states.statemachine.states.matchSchedules.IDeadlines;
import statemachine.states.statemachine.states.matchSchedules.MatchScheduleAbstractFactory;

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
        System.out.println(gamePlayConfigModel.getAging().getMaximumAge());
        iPlayerModel.setAgingModel(gamePlayConfigModel.getAging());
        iPlayerModel.setFreeAgentsList(leagueModel.getFreeAgents());
        iFreeAgentModel.setAgingModel(gamePlayConfigModel.getAging());

//        try {
//            for (IFreeAgentModel freeAgent : leagueModel.getFreeAgents()) {
//                freeAgent.setAgingModel(gamePlayConfigModel.getAging());
//                freeAgent.aging(freeAgent, currentDate, daysToAge);
//            }
//        } catch (Exception e) {
//            logger.error("Error while traversing the Freeagent");
//            throw e;
//        }
//        for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
//            for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
//                for (ITeamsModel teamsModel : divisonModel.getTeams()) {
//                    for (PlayerModel playerModelTemp : teamsModel.getPlayers()) {
//                     rthMonth());
//                    }
//                    sortTeams.sortActiveRoasters(teamsModel.getPlayers());
//                }
//            }
//        }

        try {
        for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                for (ITeamsModel teamsModel : divisonModel.getTeams()) {
                    for (PlayerModel playerModelTemp : teamsModel.getPlayers()) {
                        System.out.println(playerModelTemp.getBirthDay()+"--"+playerModelTemp.getBirthMonth());
                        System.out.println(playerModelTemp.getPlayerName()+"---"+playerModelTemp.getBirthDay()+"--"+playerModelTemp.getBirthMonth());
                        iPlayerModel.aging(playerModelTemp, daysToAge, currentDate);
                    }
                    sortTeams.sortActiveRoasters(teamsModel.getPlayers());
                }
            }
        }} catch (Exception e) {
            logger.error("Error while parsing the league object and calculate aging");
            throw e;
        }

    }

    @Override
    public void exit() {
        LeagueObjectModelAbstractFactory.getInstance().setSortTeam(null);
        LeagueObjectModelAbstractFactory.getInstance().setPlayer(null);
    }

}
