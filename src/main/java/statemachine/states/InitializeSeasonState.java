package statemachine.states;

import leagueobjectmodel.ConferenceModel;
import leagueobjectmodel.DivisonModel;
import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.PlayerModel;
import statemachine.states.matchSchedules.*;
import statemachine.StateMachine;
import leagueobjectmodel.TeamsModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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
    ITransition persistLeagueState;
    IPlayoffSchedule playoffSchedule;
    private int currentSimulationYear;

    public InitializeSeasonState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

//    public InitializeSeasonState(StateMachine stateMachine, LeagueModel updatedLeagueModel, int currentYear) {
//        this.stateMachine = stateMachine;
//        this.updatedLeagueModelObject = updatedLeagueModel;
//        currentSimulationYear = currentYear;
//        iDeadlines = new Deadlines();
//    }

    public void updateInitializeSeasonStateValue(StateMachine stateMachine, LeagueModel updatedLeagueModel, int currentYear){
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
        int currentDaysCount = 0;
        LocalDate currentDate = regularSeasonStartDate;
        for (int i = 1; i <= availableDaysForMatches; i++) {
            if (i % 100 == 0) {
                stateMachine.setCurrentDate(currentDate);
                stateMachine.setCurrentState(stateMachine.getTrainingState());
                stateMachine.getUpdateStateValue().updateTrainingSateValue(stateMachine,updatedLeagueModelObject);
                stateMachine.getCurrentState().entry();
            }
            currentDaysCount++;
            for (int j = (i - 1) * (int) matchesPlayedInOneDay; j < i * matchesPlayedInOneDay; j++) {
                stateMachine.getUpdateStateValue().updateSimulateGameStateValue(stateMachine, updatedLeagueModelObject, currentSeasonSchedule.get(j).get(0), currentSeasonSchedule.get(j).get(1));
                stateMachine.setCurrentState(stateMachine.getSimulateGameState());
                stateMachine.setCurrentDate(currentDate);
                stateMachine.getCurrentState().entry();
            }
            if (currentDaysCount < availableDaysForTrade) {
                stateMachine.getUpdateStateValue().updateTradingStateValue(stateMachine,updatedLeagueModelObject);
                stateMachine.setCurrentState(stateMachine.getTradingState());
                stateMachine.getCurrentState().entry();
            }
           stateMachine.getUpdateStateValue().updateAgingStateValue(stateMachine,updatedLeagueModelObject);
            stateMachine.setCurrentState(stateMachine.getAgingState());
            stateMachine.setCurrentDate(currentDate);
            stateMachine.getCurrentState().entry();
            currentDate = regularSeasonStartDate.plusDays(i);

        }
        LocalDate playOffStartDate = iDeadlines.getPlayOffStartDate(currentSimulationYear);
        currentDate = playOffStartDate;
        long availableDaysForPlayOff = DAYS.between(iDeadlines.getPlayOffStartDate(currentSimulationYear), iDeadlines.getLastDayOfStanleyCup(currentSimulationYear + 1));
        int trainingDaysPassed = (int) availableDaysForPlayOff;
        playoffSchedule = new PlayoffSchedule();
        List<List<TeamsModel>> playOffSchedule = playoffSchedule.generatePlayoffSchedule(updatedLeagueModelObject);
        int numberOfPlayOffMatch = playOffSchedule.size();
        for (int i = 0; i < numberOfPlayOffMatch; i++) {
            if (trainingDaysPassed % 100 == 0) {
                stateMachine.setCurrentState(stateMachine.getTrainingState());
                stateMachine.setCurrentDate(currentDate);
                stateMachine.getUpdateStateValue().updateTrainingSateValue(stateMachine,updatedLeagueModelObject);
                stateMachine.getCurrentState().entry();
            }
            stateMachine.getUpdateStateValue().updateSimulateGameStateValue(stateMachine, updatedLeagueModelObject, playOffSchedule.get(i).get(0), playOffSchedule.get(i).get(1));
            stateMachine.setCurrentState(stateMachine.getSimulateGameState());
            stateMachine.setCurrentDate(currentDate);
            stateMachine.getCurrentState().entry();
            trainingDaysPassed++;
            currentDate = playOffStartDate.plusDays(i);
        }

        TeamsModel winnerTeam = new TeamsModel();
        for (List<TeamsModel> list : playOffSchedule) {
            for (TeamsModel teamsModel : list) {
                if (teamsModel.getWinPoint() > winnerTeam.getWinPoint()) {
                    winnerTeam = teamsModel;
                }
            }
        }

        System.out.println("Stanly Cup Winner Determined");
        System.out.println("Winner is " + winnerTeam.getTeamName() + " With Points " + winnerTeam.getWinPoint() + " For the year " + currentSimulationYear);

        //Drafting State
        //stateMachine.getUpdateStateValue().updateSimulateGameStateValue(stateMachine, updatedLeagueModelObject, playOffSchedule.get(i).get(0), playOffSchedule.get(i).get(1));
        stateMachine.setCurrentState(stateMachine.getPlayerDraftState());
        stateMachine.setCurrentDate(iDeadlines.getPlayerDraftStartDate(currentSimulationYear));
        stateMachine.getCurrentState().entry();
        task();
    }

    @Override
    public void task() {
        exit();
    }

    @Override
    public void exit() {
        System.out.println("Season simulation ends for the year " + currentSimulationYear);
        for(ConferenceModel conferenceModel:updatedLeagueModelObject.getConferences()){
            for(DivisonModel divisonModel:conferenceModel.getDivisions()){
                System.out.println(divisonModel.getDivisionName());
                for(TeamsModel teamsModel:divisonModel.getTeams()){
                    System.out.println(teamsModel.getTeamName()+" "+teamsModel.getGeneralManager());
                    for(PlayerModel playerModel:teamsModel.getPlayers()){
                        System.out.println(playerModel.getPlayerName()+" "+playerModel.getPosition()+" "+playerModel.getAge()+"  "+playerModel.getSkating()+"  "+playerModel.getShooting()+" "+playerModel.getChecking());
                    }
                }
            }
        }
    }
}
