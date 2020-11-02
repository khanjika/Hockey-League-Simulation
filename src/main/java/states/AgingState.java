package states;

import conference.ConferenceModel;
import divison.DivisonModel;
import gameplayconfig.GamePlayConfigModel;
import league.LeagueModel;
import matchSchedules.Deadlines;
import matchSchedules.IDeadlines;
import players.IPlayerModel;
import players.PlayerModel;
import statemachine.StateMachine;
import teams.TeamsModel;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class AgingState implements ITransition{

    IDeadlines iDeadlines;
    StateMachine stateMachine;
    LeagueModel leagueModel;
    LocalDate currentDate;
    IPlayerModel iPlayerModel;
    private int daysToAge;


    public AgingState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }
    public AgingState(StateMachine stateMachine, LeagueModel leagueModel) {
        this.stateMachine = stateMachine;
        this.leagueModel = leagueModel;
        iDeadlines=new Deadlines();
    }
    @Override
    public void entry() {
        task();
    }
    @Override
    public void task() {
        iPlayerModel=new PlayerModel();
        daysToAge=1;
        currentDate=stateMachine.getCurrentDate();
        int currentYear=currentDate.getYear();
        long tempDays = DAYS.between(currentDate, iDeadlines.getEndOfRegularSeasonDate(currentYear));
        System.out.println(tempDays);
        if(tempDays==1){
                daysToAge=183;
        }
        GamePlayConfigModel gamePlayConfigModel=leagueModel.getGameplayConfig();
        iPlayerModel.setAgingModel(gamePlayConfigModel.getAging());
        iPlayerModel.setFreeAgentsList(leagueModel.getFreeAgents());
        for(ConferenceModel conferenceModel:leagueModel.getConferences()){
            for(DivisonModel divisonModel:conferenceModel.getDivisions()){
                for(TeamsModel teamsModel:divisonModel.getTeams()){
                        for(PlayerModel playerModelTemp:teamsModel.getPlayers()){
                            iPlayerModel.aging(playerModelTemp,daysToAge,currentDate);
                        }
                    }
                }
            }
        }
    @Override
    public void exit() {

    }

}
