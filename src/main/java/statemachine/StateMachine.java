package statemachine;

import states.*;

public class StateMachine {
    ITransition importJson;
    ITransition playerTeamChoice;
    ITransition loadTeam;
    ITransition createTeam;
    ITransition playerSeasonsChoice;
    ITransition simulate;

    ITransition currentState;

    public StateMachine() {

        importJson = new ImportJsonState(this);
        playerTeamChoice = new PlayerTeamChoiceState(this);
        loadTeam = new LoadTeamState(this);
        createTeam = new CreateTeamState(this);
        playerSeasonsChoice = new PlayerSeasonsChoiceState(this);
        simulate = new SimulateState(this);
        currentState = importJson;
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

    public ITransition getPlayerSeasonsChoice() {
        return playerSeasonsChoice;
    }

    public void setPlayerSeasonsChoice(ITransition playerSeasonsChoice) {
        this.playerSeasonsChoice = playerSeasonsChoice;
    }

    public ITransition getSimulate() {
        return simulate;
    }

    public void setSimulate(ITransition simulate) {
        this.simulate = simulate;
    }

    public ITransition getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ITransition newState){
        currentState = newState;
    }

    public void entry(){
        currentState.entry();
    }

    public void task(){
        currentState.task();
    }

    public void exit(){
        currentState.exit();
    }

    public ITransition fileImported(){
        return playerTeamChoice;
    }

    public ITransition playerChoiceLoadTeam(){
        return loadTeam;
    }

    public ITransition playerChoiceCreateTeam(){
        return createTeam;}

    public ITransition teamLoaded(){
        return playerSeasonsChoice;
    }

    public ITransition newTeamCreated(){
        return playerSeasonsChoice;
    }

    public ITransition simulateSeasons(){
        return simulate;
    }
}
