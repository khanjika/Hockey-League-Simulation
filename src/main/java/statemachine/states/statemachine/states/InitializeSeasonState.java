package statemachine.states.statemachine.states;

import leagueobjectmodel.ConferenceModel;
import leagueobjectmodel.DivisonModel;
import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.PlayerModel;
import statemachine.states.statemachine.states.matchSchedules.*;
import statemachine.states.statemachine.StateMachine;
import leagueobjectmodel.TeamsModel;

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
    ITransition persistLeagueState;
    IPlayoffSchedule playoffSchedule;
    private int totalMatches;
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
        iDeadlines = MatchScheduleAbstractFactory.getMatchScheduleInstance().getDeadline();
    }

    @Override
    public void entry() {
        iRegularSeasonSchedule = MatchScheduleAbstractFactory.getMatchScheduleInstance().getRegularSeason();
        List<List<TeamsModel>> currentSeasonSchedule = iRegularSeasonSchedule.generateSeasonSchedule(updatedLeagueModelObject);
        totalMatches = currentSeasonSchedule.size();
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
                stateMachine.getUpdateStateValue().updateSimulateGameStateValue(stateMachine, updatedLeagueModelObject, currentSeasonSchedule.get(j).get(0), currentSeasonSchedule.get(j).get(1),false);
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
        playoffSchedule = MatchScheduleAbstractFactory.getMatchScheduleInstance().getPLayOff();
        List<List<TeamsModel>> playOffSchedule = playoffSchedule.generatePlayoffSchedule(updatedLeagueModelObject);
        int numberOfPlayOffMatch = playOffSchedule.size();
        for (int i = 0; i < numberOfPlayOffMatch; i++) {
            if (trainingDaysPassed % 100 == 0) {
                stateMachine.setCurrentState(stateMachine.getTrainingState());
                stateMachine.setCurrentDate(currentDate);
                stateMachine.getUpdateStateValue().updateTrainingSateValue(stateMachine,updatedLeagueModelObject);
                stateMachine.getCurrentState().entry();
            }
            stateMachine.getUpdateStateValue().updateSimulateGameStateValue(stateMachine, updatedLeagueModelObject, playOffSchedule.get(i).get(0), playOffSchedule.get(i).get(1),true);
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
        task();
    }

    @Override
    public void task() {
        System.out.println("--------Regular Season Complete------");
        for(ConferenceModel conferenceModel:updatedLeagueModelObject.getConferences()){
            for(DivisonModel divisonModel:conferenceModel.getDivisions()){
                for(TeamsModel teamsModel:divisonModel.getTeams()){
                    int goalByTeam=0;
                    int penaltyCOunt=0;
                    int saveCount=0;
                    for(PlayerModel playerModel:teamsModel.getPlayers()){
                        goalByTeam=playerModel.getGoalScorerCount()+goalByTeam;
                        penaltyCOunt=playerModel.getTotalPenaltyCount()+penaltyCOunt;
                        saveCount=playerModel.getSaveForGoalie()+saveCount;
//                        if(playerModel.getPosition().equals("defense")){
//                            System.out.println(playerModel.getPlayerName()+" is Defense and has penalty count of "+playerModel.getTotalPenaltyCount());
//                        }
//                        if(playerModel.getPosition().equals("goalie")){
//                            System.out.println(playerModel.getPlayerName()+" is goalie having save count "+playerModel.getSaveForGoalie());
//                        }
                    }
                    System.out.println(totalMatches);
                    float valeu =goalByTeam/totalMatches;
                    double averagePenaltyCount=0;
                    try {
                       averagePenaltyCount= totalMatches/penaltyCOunt;
                    }
                    catch (ArithmeticException exception){
                        System.out.println("Divide By  zero exception in average penalty count "+exception.getMessage());
                    }
                    System.out.println(teamsModel.getTeamName()+" HAs saving count "+saveCount);
                    double averageSaveCount = 0;
                    try {
                        averageSaveCount = totalMatches/saveCount;
                    }
                    catch (ArithmeticException exception){
                        System.out.println("Divide by zero in average save count "+exception.getMessage());
                    }
                    System.out.println("Goal For the Team is "+goalByTeam+" Team Name "+teamsModel.getTeamName()+" Average is "+valeu);
                    System.out.println("Total penalty count is "+penaltyCOunt+" Average penalty per game is "+averagePenaltyCount);
                    System.out.println("Total Save count is "+saveCount+" Average penalty per game is "+averageSaveCount);
                }
            }
        }
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

        MatchScheduleAbstractFactory.getMatchScheduleInstance().setRegularSeason(null);
        MatchScheduleAbstractFactory.getMatchScheduleInstance().setPlayOff(null);
    }
}
