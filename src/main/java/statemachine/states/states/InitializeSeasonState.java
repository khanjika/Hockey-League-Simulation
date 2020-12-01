package statemachine.states.states;



import cli.CliAbstractFactory;
import cli.ICli;
import leagueobjectmodel.*;
import org.apache.log4j.Logger;
import statemachine.states.StateMachine;
import statemachine.simulateGame.matchSchedules.IDeadlines;
import statemachine.simulateGame.matchSchedules.IPlayoffSchedule;
import statemachine.simulateGame.matchSchedules.IRegularSeasonSchedule;
import statemachine.simulateGame.matchSchedules.MatchScheduleAbstractFactory;
import statemachine.trophysystem.ITrophySystem;
import statemachine.trophysystem.TrophySystemAbstractFactory;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class InitializeSeasonState implements ITransition {

    IDeadlines iDeadlines;
    StateMachine stateMachine;
    ILeagueModel updatedLeagueModelObject;
    ITransition agingState;
    ITransition simulateGameState;
    IRegularSeasonSchedule iRegularSeasonSchedule;
    ITransition trainingState;
    ITransition tradingState;
    ITransition persistLeagueState;
    IPlayoffSchedule playoffSchedule;
    int hundredDayCount=100;
    ITrophySystem trophySystem;
    private int totalMatches;
    private int currentSimulationYear;
    private int resetCount=1;
    final static Logger logger = Logger.getLogger(InitializeSeasonState.class);
    public InitializeSeasonState(StateMachine stateMachine) {
        logger.info("Initializing InitlaizeSeason State");
        this.stateMachine = stateMachine;
    }
    ICli cli = CliAbstractFactory.getInstance().getCli();

    public void updateInitializeSeasonStateValue(StateMachine stateMachine, ILeagueModel updatedLeagueModel, int currentYear){
        if(currentYear==0){
            logger.error("Year is not intialized properly");
            throw new IllegalArgumentException("Year is not intialized properly");
        }
        this.stateMachine = stateMachine;
        this.updatedLeagueModelObject = updatedLeagueModel;
        currentSimulationYear = currentYear;
        iDeadlines = MatchScheduleAbstractFactory.getMatchScheduleInstance().getDeadline();
        trophySystem = TrophySystemAbstractFactory.instance().createTrophySystem();
        LeagueObjectModelAbstractFactory.getInstance().setLeague(updatedLeagueModel);
        trophySystem = TrophySystemAbstractFactory.instance().createTrophySystem();
    }

    @Override
    public void entry() throws Exception {
        iRegularSeasonSchedule = MatchScheduleAbstractFactory.getMatchScheduleInstance().getRegularSeason();
        List<List<ITeamsModel>> currentSeasonSchedule = iRegularSeasonSchedule.generateSeasonSchedule(updatedLeagueModelObject);
        if(currentSeasonSchedule==null){
            logger.error("Schedule is not propelry initialized in during the season intialization");
            throw new NullPointerException("Schedule is not propelry initialized in during the season intialization");
        }
        totalMatches = currentSeasonSchedule.size();
        long availableDaysForMatches = DAYS.between(iDeadlines.getRegularSeasonStartDate(currentSimulationYear), iDeadlines.getEndOfRegularSeasonDate(currentSimulationYear + 1));
        long matchesPlayedInOneDay = totalMatches / availableDaysForMatches;
        long availableDaysForTrade = DAYS.between(iDeadlines.getRegularSeasonStartDate(currentSimulationYear), iDeadlines.getTradeDeadlineDate(currentSimulationYear + 1));
        LocalDate regularSeasonStartDate = iDeadlines.getRegularSeasonStartDate(currentSimulationYear);
        int currentDaysCount = 0;
        LocalDate currentDate = regularSeasonStartDate;

        try{
        for (int i = 1; i <= availableDaysForMatches; i++) {
            stateMachine.getUpdateStateValue().updateAgingStateValue(stateMachine,updatedLeagueModelObject);
            stateMachine.setCurrentState(stateMachine.getAgingState());
            stateMachine.setCurrentDate(currentDate);
            stateMachine.getCurrentState().entry();
            if (i % hundredDayCount == 0) {
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

            currentDate = regularSeasonStartDate.plusDays(i);

        }}
        catch (Exception e){
            logger.error("Exception while initializing gmae simulation");
            throw e;
        }

        trophySystem.performCalculationBeforePlayOff(updatedLeagueModelObject,currentSimulationYear);

        LocalDate playOffStartDate = iDeadlines.getPlayOffStartDate(currentSimulationYear);
        currentDate = playOffStartDate;
        long availableDaysForPlayOff = DAYS.between(iDeadlines.getPlayOffStartDate(currentSimulationYear), iDeadlines.getLastDayOfStanleyCup(currentSimulationYear + 1));
        int trainingDaysPassed = (int) availableDaysForPlayOff;
        playoffSchedule = MatchScheduleAbstractFactory.getMatchScheduleInstance().getPLayOff();
        List<List<ITeamsModel>> playOffSchedule = playoffSchedule.generatePlayoffSchedule(updatedLeagueModelObject);
        if(playOffSchedule==null){
            logger.error("PlayOffSchedule is not propelry initialized in during the season intialization");
            throw new NullPointerException("PlayOffSchedule is not propelry initialized in during the season intialization");
        }
        int numberOfPlayOffMatch = playOffSchedule.size();
        for (int i = 0; i < numberOfPlayOffMatch; i++) {
            if (trainingDaysPassed % hundredDayCount == 0) {
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

        ITeamsModel winnerTeam = new TeamsModel();
        for (List<ITeamsModel> list : playOffSchedule) {
            for (ITeamsModel teamsModel : list) {
                if (teamsModel.getWinPoint() > winnerTeam.getWinPoint()) {
                    winnerTeam = teamsModel;
                }
            }
        }

        cli.printOutput("Stanly Cup Winner Determined");
        cli.printOutput("Winner is " + winnerTeam.getTeamName() + " With Points " + winnerTeam.getWinPoint() + " For the year " + currentSimulationYear);

        stateMachine.setCurrentState(stateMachine.getPlayerDraftState());
        stateMachine.setCurrentDate(iDeadlines.getPlayerDraftStartDate(currentSimulationYear));
        stateMachine.getCurrentState().entry();

        cli.printOutput("Stanly Cup Winner Determined");
        cli.printOutput("Winner is " + winnerTeam.getTeamName() + " With Points " + winnerTeam.getWinPoint() + " For the year " + currentSimulationYear);

        trophySystem.performCalculationAfterPlayOff(updatedLeagueModelObject, currentSimulationYear);
        task();
    }

    @Override
    public void task() throws Exception {
        cli.printOutput("--------Regular Season Complete------");
        for(IConferenceModel conferenceModel:updatedLeagueModelObject.getConferences()){
            for(IDivisonModel divisonModel:conferenceModel.getDivisions()){
                for(ITeamsModel teamsModel:divisonModel.getTeams()){
                    int goalByTeam=0;
                    int penaltyCOunt=0;
                    int saveCount=0;
                    for(PlayerModel playerModel:teamsModel.getPlayers()){
                        goalByTeam=playerModel.getGoalScorerCount()+goalByTeam;
                        penaltyCOunt=playerModel.getTotalPenaltyCount()+penaltyCOunt;
                        saveCount=playerModel.getSaveForGoalie()+saveCount;
                    }
                    float valeu =goalByTeam/totalMatches;
                    double averagePenaltyCount=0;
                    if(penaltyCOunt==0){
                        penaltyCOunt=resetCount;
                    }
                    try {
                       averagePenaltyCount= totalMatches/penaltyCOunt;
                    }
                    catch (ArithmeticException exception){
                        logger.error("Divide By  zero exception in average penalty count "+exception.getMessage());
                        throw exception;
                    }
                    double averageSaveCount = 0;
                    if(saveCount==0){
                        saveCount=resetCount;
                    }
                    try {
                        averageSaveCount = totalMatches/saveCount;
                    }
                    catch (ArithmeticException exception){
                        logger.error("Divide By  zero exception in save count "+exception.getMessage());
                        throw exception;
                    }
                    cli.printOutput("Goal For the Team is "+goalByTeam+" Team Name "+teamsModel.getTeamName()+" Average is "+valeu);
                    cli.printOutput("Total penalty count is "+penaltyCOunt+" Average penalty per game is "+averagePenaltyCount);
                    cli.printOutput("Total Save count is "+saveCount+" Average penalty per game is "+averageSaveCount);
                }
            }
        }
        exit();
    }

    @Override
    public void exit() throws Exception {
        cli.printOutput("Season simulation ends for the year " + currentSimulationYear);
        MatchScheduleAbstractFactory.getMatchScheduleInstance().setRegularSeason(null);
        MatchScheduleAbstractFactory.getMatchScheduleInstance().setPlayOff(null);
        stateMachine.getUpdateStateValue().updateTrophyStateValue(updatedLeagueModelObject, stateMachine , currentSimulationYear);
        stateMachine.setCurrentState(stateMachine.getTrophySystemState());
        stateMachine.getCurrentState().entry();
    }
}
