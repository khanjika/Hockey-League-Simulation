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
    ITransition persistLeagueStae;


    public StateMachine() {

        System.out.println("Object of state machine is created "+this);
        importJson = new ImportJsonState(this);
        System.out.println("Object of ImportJsonState is created "+importJson);
        playerTeamChoice = new PlayerTeamChoiceState(this);
        System.out.println("Object of PlayerTeamChoiceState is created "+playerTeamChoice);
        loadTeam = new LoadTeamState(this);
        System.out.println("Object of LoadTeamState is created "+loadTeam);
        createTeam = new CreateTeamState(this);
        System.out.println("Object of CreateTeamState is created "+createTeam);
        playerSeasonsChoice = new PlayerSeasonsChoiceState(this);
        System.out.println("Object of PlayerSeasonsChoiceState id created "+playerSeasonsChoice);
        simulate = new SimulateState(this);
        System.out.println("Object of SimulateState is created "+simulate);
        persistLeagueStae=new PersistLeagueState(this);
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


    public ITransition getPersistLeagueStae() {
        return persistLeagueStae;
    }

    public void setPersistLeagueStae(ITransition persistLeagueStae) {
        this.persistLeagueStae = persistLeagueStae;
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

    public void entry() throws Exception {
        currentState.entry();
    }

    public void task() throws Exception {
        currentState.task();
    }

    public void exit() throws Exception {
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
