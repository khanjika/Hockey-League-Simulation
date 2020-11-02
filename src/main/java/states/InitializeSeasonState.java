package states;

import conference.ConferenceModel;
import divison.DivisonModel;
import league.LeagueModel;
import matchSchedules.*;
import players.PlayerModel;
import statemachine.StateMachine;
import teams.TeamsModel;
import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class InitializeSeasonState implements ITransition {

    IDeadlines iDeadlines;
    StateMachine stateMachine;
    LeagueModel updatedLeagueModelObject;
    ITransition agingState;
    ITransition simulateGameState;
    IRegularSeasonSchedule iRegularSeasonSchedule;
    ITransition trainingState;
    ITransition tradingState;
    IPlayoffSchedule playoffSchedule;
    private int currentSimulationYear;

    public InitializeSeasonState(StateMachine stateMachine){
        this.stateMachine=stateMachine;
    }
    public InitializeSeasonState(StateMachine stateMachine, LeagueModel updatedLeagueModel, int currentYear) {
        this.stateMachine = stateMachine;
        this.updatedLeagueModelObject = updatedLeagueModel;
        currentSimulationYear = currentYear;
        iDeadlines = new Deadlines();
    }

    @Override
    public void entry() {
        iRegularSeasonSchedule = new RegularSeasonSchedule();
        List<List<TeamsModel>> currentSeasonSchedule = iRegularSeasonSchedule.generateSeasonSchedule(updatedLeagueModelObject);
        int totalMatches = currentSeasonSchedule.size();
        long availableDaysForMatches = DAYS.between(iDeadlines.getRegularSeasonStartDate(currentSimulationYear), iDeadlines.getEndOfRegularSeasonDate(currentSimulationYear + 1));
        long matchesPlayedInOneDay = totalMatches / availableDaysForMatches;
        long availableDaysForTrade = DAYS.between(iDeadlines.getRegularSeasonStartDate(currentSimulationYear), iDeadlines.getTradeDeadlineDate(currentSimulationYear + 1));
        LocalDate regularSeasonStartDate = iDeadlines.getRegularSeasonStartDate(currentSimulationYear);
        int currentDaysCount=0;
        LocalDate currentDate=regularSeasonStartDate;
        for (int i = 1; i <= availableDaysForMatches; i++) {
            if (i % 100 == 0) {
                trainingState=new TrainingState(stateMachine,updatedLeagueModelObject);
                stateMachine.setTrainingState(trainingState);
                stateMachine.setCurrentDate(currentDate);
                stateMachine.setCurrentState(stateMachine.getTrainingState());
                stateMachine.getCurrentState().entry();
            }
            currentDaysCount++;
            for (int j = (i - 1) * (int) matchesPlayedInOneDay; j < i * matchesPlayedInOneDay; j++) {
                simulateGameState=new SimulateGameState(stateMachine,updatedLeagueModelObject,currentSeasonSchedule.get(j).get(0),currentSeasonSchedule.get(j).get(1));
                stateMachine.setSimulateGameState(simulateGameState);
                stateMachine.setCurrentState(stateMachine.getSimulateGameState());
                stateMachine.setCurrentDate(currentDate);
                stateMachine.getCurrentState().entry();
            }
            if(currentDaysCount<availableDaysForTrade){
                tradingState=new TradingState(stateMachine,updatedLeagueModelObject);
                stateMachine.setTradingState(tradingState);
                stateMachine.setCurrentState(stateMachine.getTradingState());
                stateMachine.getCurrentState().entry();

            }
            agingState=new AgingState(stateMachine,updatedLeagueModelObject);
            stateMachine.setAgingState(agingState);
            stateMachine.setCurrentState(stateMachine.getAgingState());
            stateMachine.setCurrentDate(currentDate);
            stateMachine.getCurrentState().entry();
            currentDate=regularSeasonStartDate.plusDays(i);

        }

         performPlayoffmatch();
        LocalDate playOffStartDate=iDeadlines.getPlayOffStartDate(currentSimulationYear);
        currentDate=playOffStartDate;
        long availableDaysForPlayOff=DAYS.between(iDeadlines.getPlayOffStartDate(currentSimulationYear), iDeadlines.getLastDayOfStanleyCup(currentSimulationYear + 1));
        int trainingDaysPassed= (int) availableDaysForPlayOff;
        playoffSchedule=new PlayoffSchedule();
        List<List<TeamsModel>> playOffSchedule = playoffSchedule.generatePlayoffSchedule(updatedLeagueModelObject);
        int numberOfPlayOffMatch=playOffSchedule.size();
        for(int i=0;i<numberOfPlayOffMatch;i++){
            if(trainingDaysPassed%100==0){
                trainingState=new TrainingState(stateMachine,updatedLeagueModelObject);
                stateMachine.setTrainingState(trainingState);
                stateMachine.setCurrentState(stateMachine.getTrainingState());
                stateMachine.getCurrentState().entry();
            }
            simulateGameState=new SimulateGameState(stateMachine,updatedLeagueModelObject,playOffSchedule.get(i).get(0),playOffSchedule.get(i).get(1));
            stateMachine.setSimulateGameState(simulateGameState);
            stateMachine.setCurrentState(stateMachine.getSimulateGameState());
            stateMachine.setCurrentDate(currentDate);
            stateMachine.getCurrentState().entry();
            trainingDaysPassed++;
            currentDate=playOffStartDate.plusDays(i);
        }

        TeamsModel winnerTeam = new TeamsModel();
        for(List<TeamsModel> list:playOffSchedule){
            for(TeamsModel teamsModel:list){
              if(teamsModel.getWinPoint()>winnerTeam.getWinPoint()){
                  winnerTeam=teamsModel;
              }
            }
        }

        System.out.println("Stanly Cup Winner Determined");
        System.out.println("Winner is "+winnerTeam.getTeamName()+ " With Points "+winnerTeam.getWinPoint()+ " For the year "+ currentSimulationYear);
        task();
    }

   void performPlayoffmatch(){

    }
    @Override
    public void task() {
        exit();
    }

    @Override
    public void exit() {
        System.out.println("Season simulation ends");
    }
}
