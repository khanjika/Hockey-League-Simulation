package statemachine.states.statemachine.states.simulateGame;

import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.PlayerModel;
import leagueobjectmodel.PlayerPosition;
import leagueobjectmodel.TeamsModel;

import java.util.ArrayList;
import java.util.List;

//REMAINING THINGS AVERAGE SHOTS ON GOAL
public class StartSimulation {

    private static TeamsModel teamOneObject;
    private static TeamsModel teamTwoObject;
    private int averageShotsOnGoal = 40;
    private boolean isThisPlayOff;
    private static LeagueModel leagueModelObject;
    private List<PlayerModel> listOfGoalieOfTeamOne = new ArrayList<>();
    private List<PlayerModel> listOfGoaliesOfTeamTwo = new ArrayList<>();
    private List<PlayerModel> listOfForwardOfTeamOne = new ArrayList<>();
    private List<PlayerModel> listOfForwardOfTeamTwo = new ArrayList<>();
    private List<PlayerModel> listOfDefenseOfTeamOne = new ArrayList<>();
    private List<PlayerModel> listOfDefenseOfTeamTwo = new ArrayList<>();

    private List<PlayerModel> currentShiftGoalieOfTeamOne = new ArrayList<>();
    private List<PlayerModel> currentShiftGoalieOfTeamTwo = new ArrayList<>();
    private List<PlayerModel> currentShiftDefenseOfTeamOne = new ArrayList<>();
    private List<PlayerModel> currentShiftDefenseOfTeamTwo = new ArrayList<>();
    private List<PlayerModel> currentShiftForwardOfTeamOne = new ArrayList<>();
    private List<PlayerModel> currentShiftForwardOfTeamTwo = new ArrayList<>();

    int penaltyCounter = 0;
    private static IGameConfiguration gameConfiguration;

    GameSimulationAbstractFactory objFactory;
    public StartSimulation(TeamsModel teamOne, TeamsModel teamTwo, LeagueModel leagueModel, boolean isPlayOff,GameSimulationAbstractFactory obj) throws Exception {
        teamOneObject = teamOne;
        teamTwoObject = teamTwo;
        leagueModelObject = leagueModel;
        isThisPlayOff = isPlayOff;
        if(obj==null){
            throw new NullPointerException();
        }
        this.objFactory=obj;
        gameConfiguration=obj.getGameConfig();
    }


    public void separatePlayerByPosition() throws Exception{
        leagueModelObject.setPenaltyChance((float) 0.5);
        for (PlayerModel playerModel : teamOneObject.getPlayers()) {
            if (playerModel.getPosition().equals((PlayerPosition.FORWARD.toString()))) {
               listOfForwardOfTeamOne.add(playerModel);
            } else if (playerModel.getPosition().equals((PlayerPosition.GOALIE.toString()))) {
                listOfGoalieOfTeamOne.add(playerModel);
            } else {
                listOfDefenseOfTeamOne.add(playerModel);
            }
        }
        for (PlayerModel playerModel : teamTwoObject.getPlayers()) {
            if (playerModel.getPosition().equals((PlayerPosition.FORWARD.toString()))) {
                listOfForwardOfTeamTwo.add(playerModel);
            } else if (playerModel.getPosition().equals((PlayerPosition.GOALIE.toString()))) {
                listOfGoaliesOfTeamTwo.add(playerModel);
            } else {
                listOfDefenseOfTeamTwo.add(playerModel);
            }
        }
        gameConfiguration.setListOfForwardOfTeamOne(listOfForwardOfTeamOne);
        gameConfiguration.setListOfForwardOfTeamTwo(listOfForwardOfTeamTwo);
        gameConfiguration.setListOfDefenseOfTeamOne(listOfDefenseOfTeamOne);
        gameConfiguration.setListOfDefenseOfTeamTwo(listOfDefenseOfTeamTwo);
        gameConfiguration.setListOfGoalieOfTeamOne(listOfGoalieOfTeamOne);
        gameConfiguration.setListOfGoaliesOfTeamTwo(listOfGoaliesOfTeamTwo);
        objFactory.getSwapTurn().setAbstractFactoryObject(objFactory);
    }

    public void setAverageShotsOnGoal() throws Exception{
        gameConfiguration.setAbstractFactoryObject(objFactory);
        gameConfiguration.setAverageShotsOnGoal();
    }

    public void initializeShifts() throws Exception{
        fillCurrentShiftData();
        for (int i = 0; i < 3; i++) {
            if (i == 2 && isThisPlayOff==false) {
               replaceCurrentGoalie();
            }
            for (int j = 0; j < 40; j++) {
                if (j == 37) {
                    replaceDefenseAndForward();
                }
                performGameSimulation();
                if (penaltyCounter > 0) {
                    penaltyCounter--;
                }
                swapTurnOfTeam();
            }
        }
    }

    public void performGameSimulation() throws Exception {
        try {
            float attackingTeamShootingState = getShootingState(gameConfiguration.getCurrentShiftForwardOfTeamOne());
            float defendingTwoShootingState = getShootingState(gameConfiguration.getCurrentShiftForwardOfTeamTwo());
            float attackingTeamCheckingState = getCheckingState(gameConfiguration.getCurrentShiftDefenseOfTeamOne());
            float defendingTeamCheckingState = getCheckingState(gameConfiguration.getCurrentShiftDefenseOfTeamTwo());
            float attackingTeamSavingState = getSavingState(gameConfiguration.getCurrentShiftGoalieOfTeamOne());
            float defendingTeamSavingState = getSavingState(gameConfiguration.getCurrentShiftGoalieOfTeamTwo());

            if (attackingTeamShootingState >= defendingTwoShootingState) {
                if (defendingTeamCheckingState >= attackingTeamCheckingState && penaltyCounter == 0) {
                    double randomChanceNumber = Math.random();
                    if (randomChanceNumber >= leagueModelObject.getPenaltyChance()) {
                        performPenaltyDuringSimulation(gameConfiguration.getCurrentShiftDefenseOfTeamTwo());
                    }
                } else {
                    if (defendingTeamSavingState >= attackingTeamSavingState) {
                        int save = gameConfiguration.getListOfGoaliesOfTeamTwo().get(0).getSaveForGoalie();
                        gameConfiguration.getListOfGoaliesOfTeamTwo().get(0).setSaveForGoalie(save + 1);
                    } else {
                        int currentGaolCount = gameConfiguration.getListOfForwardOfTeamOne().get(0).getGoalScorerCount();
                        gameConfiguration.getListOfForwardOfTeamOne().get(0).setGoalScorerCount(currentGaolCount + 1);
                    }
                }

            } else {
                swapTurnOfTeam();
                performGameSimulation();
            }
        }
        catch (Exception e){
            throw new Exception();
        }
    }


    //i need to change the methods from here to playerModel.java
    public float getShootingState(List<PlayerModel> playerModelList){
        if(playerModelList==null){
            throw new NullPointerException();
        }
        float shootingState = 0;
        for (PlayerModel playerModel : playerModelList) {
            shootingState = shootingState + playerModel.getShooting();
        }
        return shootingState;
    }

    public float getCheckingState(List<PlayerModel> playerModelList) {
        if(playerModelList==null){
            throw new NullPointerException();
        }
        float checkingState = 0;
        for (PlayerModel playerModel : playerModelList) {
            if (playerModel.getCurrentPenaltyCount() > 0) {
                playerModel.setCurrentPenaltyCount(playerModel.getCurrentPenaltyCount() - 1);
            } else {
                checkingState = checkingState + playerModel.getChecking();
            }
        }
        return checkingState;
    }

    public float getSavingState(List<PlayerModel> playerModelList) {
        if(playerModelList==null){
            throw new NullPointerException();
        }
        float savingSate = 0;
        for (PlayerModel playerModel : playerModelList) {
            savingSate = savingSate + playerModel.getSaving();
        }
        return savingSate;
    }


    public void swapTurnOfTeam() {
        objFactory.getSwapTurn().swapTurnOfTeam();
    }


    public void fillCurrentShiftData() {
        try {
            currentShiftDefenseOfTeamOne.add(listOfDefenseOfTeamOne.get(0));
            currentShiftDefenseOfTeamOne.add(listOfDefenseOfTeamOne.get(1));
            currentShiftForwardOfTeamOne.add(listOfForwardOfTeamOne.get(0));
            currentShiftForwardOfTeamOne.add(listOfForwardOfTeamOne.get(1));
            currentShiftForwardOfTeamOne.add(listOfForwardOfTeamOne.get(2));
           if(isThisPlayOff){
               currentShiftGoalieOfTeamOne.add(getBestGoalieFromTheTeam(listOfGoalieOfTeamOne));
               currentShiftGoalieOfTeamTwo.add(getBestGoalieFromTheTeam(listOfGoaliesOfTeamTwo));
           }
           else {
               currentShiftGoalieOfTeamOne.add(listOfGoalieOfTeamOne.get(0));
               currentShiftGoalieOfTeamTwo.add(listOfGoaliesOfTeamTwo.get(0));
           }

            currentShiftDefenseOfTeamTwo.add(listOfDefenseOfTeamTwo.get(0));
            currentShiftDefenseOfTeamTwo.add(listOfDefenseOfTeamTwo.get(1));
            currentShiftForwardOfTeamTwo.add(listOfForwardOfTeamTwo.get(0));
            currentShiftForwardOfTeamTwo.add(listOfForwardOfTeamTwo.get(1));
            currentShiftForwardOfTeamTwo.add(listOfForwardOfTeamTwo.get(2));


            gameConfiguration.setCurrentShiftDefenseOfTeamOne(currentShiftDefenseOfTeamOne);
            gameConfiguration.setCurrentShiftDefenseOfTeamTwo(currentShiftDefenseOfTeamTwo);
            gameConfiguration.setCurrentShiftForwardOfTeamOne(currentShiftForwardOfTeamOne);
            gameConfiguration.setCurrentShiftForwardOfTeamTwo(currentShiftForwardOfTeamTwo);
            gameConfiguration.setCurrentShiftGoalieOfTeamOne(currentShiftGoalieOfTeamOne);
            gameConfiguration.setCurrentShiftGoalieOfTeamTwo(currentShiftGoalieOfTeamTwo);


        } catch (NullPointerException e) {
            System.out.println("Exception while filling current shift information"+e.getMessage());
        }
    }


    public void performPenaltyDuringSimulation(List<PlayerModel> currentDefenseList) {
        try {
            currentDefenseList.get(0).setTotalPenaltyCount(currentDefenseList.get(0).getTotalPenaltyCount() + 1);
            currentDefenseList.get(0).setCurrentPenaltyCount(4);
            penaltyCounter = 4;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void replaceCurrentGoalie() {
        objFactory.getSwapTurn().swapTurnOfGoalie();
    }

    public void replaceDefenseAndForward() {
        objFactory.getSwapTurn().swapTurnOfForwardAndDefense();
    }


    //need to change and call the method of the teamModel.java
    public PlayerModel getBestGoalieFromTheTeam(List<PlayerModel> list) {
        if(list==null){
            throw new NullPointerException();
        }
        PlayerModel currentBestGoalie = null;
        for (PlayerModel playerModel : list) {
            if (playerModel.getPosition().equals("goalie")) {
                if (currentBestGoalie == null) {
                    currentBestGoalie = playerModel;
                } else if (playerModel.getSaving() > currentBestGoalie.getSaving()) {
                    currentBestGoalie = playerModel;
                }
            }
        }
        return currentBestGoalie;
    }
}
