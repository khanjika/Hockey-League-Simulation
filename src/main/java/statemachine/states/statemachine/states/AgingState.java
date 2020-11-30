package statemachine.states.statemachine.states;


import leagueobjectmodel.ConferenceModel;
import leagueobjectmodel.DivisonModel;
import leagueobjectmodel.GamePlayConfigModel;
import leagueobjectmodel.LeagueModel;
import org.apache.log4j.Logger;
import statemachine.states.statemachine.states.matchSchedules.IDeadlines;
import leagueobjectmodel.IPlayerModel;
import leagueobjectmodel.PlayerModel;
import statemachine.states.statemachine.StateMachine;
import leagueobjectmodel.TeamsModel;
import statemachine.states.statemachine.states.matchSchedules.MatchScheduleAbstractFactory;
import leagueobjectmodel.*;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class AgingState implements ITransition {

    IDeadlines iDeadlines;
    StateMachine stateMachine;
    ILeagueModel leagueModel;
    LocalDate currentDate;
    IPlayerModel iPlayerModel;
    private int daysToAge;
    final static Logger logger = Logger.getLogger(AgingState.class);
    public AgingState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

     public void updateAgingStateValue(StateMachine stateMachine, ILeagueModel leagueModel){
         this.stateMachine = stateMachine;
         this.leagueModel = leagueModel;
         iDeadlines = MatchScheduleAbstractFactory.getMatchScheduleInstance().getDeadline();
    }

    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        ISortTeams sortTeams = new SortTeams();
        iPlayerModel = new PlayerModel();
        daysToAge = 1;
        currentDate = stateMachine.getCurrentDate();
        int currentYear = currentDate.getYear();
        long tempDays = DAYS.between(currentDate, iDeadlines.getEndOfRegularSeasonDate(currentYear));
        System.out.println(tempDays);
        if (tempDays == 1) {
            daysToAge = 183;
        }
        GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        System.out.println(gamePlayConfigModel.getAging().getMaximumAge());
        iPlayerModel.setAgingModel(gamePlayConfigModel.getAging());
        iPlayerModel.setFreeAgentsList(leagueModel.getFreeAgents());
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                for (TeamsModel teamsModel : divisonModel.getTeams()) {
                    System.out.println("TEAM NAME: "+ teamsModel.getTeamName());
                    for (PlayerModel playerModelTemp : teamsModel.getPlayers()) {
                        System.out.println("PLAYER NAME: "+playerModelTemp.getPlayerName());
                        iPlayerModel.aging(playerModelTemp, daysToAge, currentDate);
                    }
                    sortTeams.sortActiveRoasters(teamsModel.getPlayers());
                }
            }
        }
    }

    @Override
    public void exit() { }

}
