package statemachine.states.statemachine.states;


;
import leagueobjectmodel.*;
import statemachine.states.statemachine.StateMachine;
import java.util.Calendar;
import java.util.Scanner;

public class PlayerSeasonsChoiceState implements ITransition {
    StateMachine stateMachine;
   LeagueModel currentModel;
    Integer enteredInput;
    ITransition persistLeagueState;
    InitializeSeasonState initializeSeasonState;

    public PlayerSeasonsChoiceState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

//    public PlayerSeasonsChoiceState(LeagueModel leagueModel, StateMachine stateMachine) {
//        this.stateMachine = stateMachine;
//        this.currentModel = leagueModel;
//    }
//
    public void updatePlayerSeasonChoiceStateValue(LeagueModel leagueModel, StateMachine stateMachine){
        this.stateMachine = stateMachine;
        this.currentModel = leagueModel;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public Integer getEnteredInput() {
        return enteredInput;
    }

    public void setEnteredInput(Integer enteredInput) {
        this.enteredInput = enteredInput;
    }

    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        System.out.println("Enter Number of season you want to simulate");
        Scanner scannerObject = new Scanner(System.in);
        setEnteredInput(scannerObject.nextInt());
        System.out.println("You have entered " + enteredInput);
        exit();
    }

    @Override
    public void exit() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 0; i < enteredInput; i++) {
//            initializeSeasonState = new InitializeSeasonState(stateMachine, currentModel, currentYear + i);
//            stateMachine.setInitiailizeSeasonState(initializeSeasonState);
            stateMachine.getUpdateStateValue().updateInitializeSeasonStateValue(stateMachine,currentModel,currentYear+i);
            stateMachine.setCurrentState(stateMachine.getInitlailizeSeasonState());
            stateMachine.getCurrentState().entry();

        }

        for(ConferenceModel conferenceModel:currentModel.getConferences()){
            for(DivisonModel divisonModel:conferenceModel.getDivisions()){
                for(TeamsModel teamsModel:divisonModel.getTeams()){
                    for(PlayerModel playerModel:teamsModel.getPlayers()){
                        System.out.println(playerModel.getPlayerName()+" has goal "+playerModel.getGoalScorerCount());
                        if(playerModel.getPosition().equals("defense")){
                            System.out.println(playerModel.getPlayerName()+" is Defense and has penalty count of "+playerModel.getTotalPenaltyCount());
                        }
                        if(playerModel.getPosition().equals("goalie")){
                            System.out.println(playerModel.getPlayerName()+" is goalie having save count "+playerModel.getSaveForGoalie());
                        }
                    }
                }
            }
        }
        //This will be used to store the information
//        stateMachine.getUpdateStateValue().updatePersistStateValue(currentModel, stateMachine, currentYear);
//        stateMachine.setPersistLeagueStae(persistLeagueState);
//        stateMachine.setCurrentState(stateMachine.getPersistLeagueState());
//        stateMachine.getCurrentState().entry();

    }
}

