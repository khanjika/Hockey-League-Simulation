package statemachine.states;

import org.apache.log4j.Logger;
import statemachine.states.states.*;
import statemachine.states.states.updateStateValue.IUpdateStateValue;
import statemachine.states.states.updateStateValue.UpdateStateValue;
import statemachine.states.states.PlayerDraftState;

import java.time.LocalDate;

public class StateMachine {
    final static Logger logger = Logger.getLogger(StateMachine.class);
    ITransition importJson;
    ITransition playerTeamChoice;
    ITransition loadTeam;
    ITransition createTeam;
    ITransition playerSeasonsChoice;
    ITransition currentState;
    ITransition persistLeagueState;
    ITransition trainingState;
    ITransition simulateGameState;
    ITransition initlailizeSeasonState;
    ITransition agingState;
    LocalDate currentDate;
    ITransition injuryCheckState;
    ITransition tradingState;
    IUpdateStateValue updateStateValue;
    ITransition playerDraftState;
    ITransition trophySystemState;


    public StateMachine() {
        logger.info ("intializing state machine object");
        importJson = new ImportJsonState(this);
        loadTeam = new LoadTeamState(this);
        createTeam = new CreateTeamState(this);
        playerSeasonsChoice = new PlayerSeasonsChoiceState(this);
        persistLeagueState = new PersistLeagueState(this);
        initlailizeSeasonState = new InitializeSeasonState(this);
        trainingState = new TrainingState(this);
        simulateGameState = new SimulateGameState(this);
        agingState = new AgingState(this);
        injuryCheckState = new InjuryCheckState(this);
        trainingState = new TrainingState(this);
        updateStateValue=new UpdateStateValue();
        tradingState=new TradingState(this);
        playerDraftState=new PlayerDraftState(this);
        trophySystemState = new TrophySystemState(this);
    }
    public IUpdateStateValue getUpdateStateValue() {
        return updateStateValue;
    }

    public void setUpdateStateValue(IUpdateStateValue updateStateValue) {
        this.updateStateValue = updateStateValue;
    }
    public ITransition getAgingState() {
        return agingState;
    }

    public void setAgingState(ITransition agingState) {
        this.agingState = agingState;
    }

    public ITransition getPersistLeagueState() {
        return persistLeagueState;
    }

    public void setPersistLeagueState(ITransition persistLeagueState) {
        this.persistLeagueState = persistLeagueState;
    }

    public ITransition getTrainingState() {
        return trainingState;
    }

    public void setTrainingState(ITransition trainingState) {
        this.trainingState = trainingState;
    }

    public ITransition getSimulateGameState() {
        return simulateGameState;
    }

    public void setSimulateGameState(ITransition simulateGameState) {
        this.simulateGameState = simulateGameState;
    }

    public ITransition getImportJson() {
        return importJson;
    }

    public void setImportJson(ITransition importJson) {
        this.importJson = importJson;
    }

    public ITransition getPlayerTeamChoice() {
        return playerTeamChoice;
    }

    public void setPlayerTeamChoice(ITransition playerTeamChoice) {
        this.playerTeamChoice = playerTeamChoice;
    }

    public ITransition getLoadTeam() {
        return loadTeam;
    }

    public void setLoadTeam(ITransition loadTeam) {
        this.loadTeam = loadTeam;
    }

    public ITransition getCreateTeam() {
        return createTeam;
    }

    public void setCreateTeam(ITransition createTeam) {
        this.createTeam = createTeam;
    }


    public void setPersistLeagueStae(ITransition persistLeagueStae) {
        this.persistLeagueState = persistLeagueStae;
    }

    public ITransition getPlayerSeasonsChoice() {
        return playerSeasonsChoice;
    }

    public void setPlayerSeasonsChoice(ITransition playerSeasonsChoice) {
        this.playerSeasonsChoice = playerSeasonsChoice;
    }

    public ITransition getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ITransition newState) {
        currentState = newState;
    }

    public void entry() throws Exception {
        currentState.entry();
    }

    public void task() throws Exception {
        currentState.task();
    }

    public void exit() throws Exception {
        currentState.exit();
    }

    public ITransition fileImported() {
        return playerTeamChoice;
    }

    public ITransition playerChoiceLoadTeam() {
        return loadTeam;
    }

    public ITransition playerChoiceCreateTeam() {
        return createTeam;
    }

    public ITransition teamLoaded() {
        return playerSeasonsChoice;
    }

    public ITransition newTeamCreated() {
        return playerSeasonsChoice;
    }

    public void setInitlailizeSeasonState(ITransition initlailizeSeasonState) {
        this.initlailizeSeasonState = initlailizeSeasonState;
    }

    public ITransition getInitlailizeSeasonState() {
        return initlailizeSeasonState;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public ITransition getInjuryCheckState() {
        return injuryCheckState;
    }

    public void setInjuryCheckState(ITransition injuryCheckState) {
        this.injuryCheckState = injuryCheckState;
    }

    public ITransition getTradingState() {
        return tradingState;
    }

    public void setTradingState(ITransition tradingState) {
        this.tradingState = tradingState;
    }
    public ITransition getPlayerDraftState() {
        return playerDraftState;
    }

    public void setPlayerDraftState(ITransition playerDraftState) {
        this.playerDraftState = playerDraftState;
    }
    public ITransition getTrophySystemState() {
        return trophySystemState;
    }

    public void setTrophySystemState(ITransition trophySystemState) {
        this.trophySystemState = trophySystemState;
    }

}
