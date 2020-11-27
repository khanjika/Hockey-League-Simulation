package statemachine.states.statemachine.states.simulateGame;

import leagueobjectmodel.*;
import org.omg.CORBA.TRANSACTION_MODE;

import java.util.ArrayList;
import java.util.List;


public class StartSimulation implements IStartSimulation{

    private static TeamsModel teamOneObject;
    private static TeamsModel teamTwoObject;
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
    private int penaltyCounter = 0;
    private boolean isThisPlayOff;
    private static IGameConfiguration gameConfiguration;
    GameSimulationAbstractFactory objFactory;
    IPlayerModel playerModel;

    public StartSimulation(){ }

    public void setRequiredAttributeForSimulation(TeamsModel teamOne, TeamsModel teamTwo, LeagueModel leagueModel, boolean isPlayOff, GameSimulationAbstractFactory obj) throws Exception {
        teamOneObject = teamOne;
        teamTwoObject = teamTwo;
        leagueModelObject = leagueModel;
        isThisPlayOff = isPlayOff;
        if (obj == null) {
            throw new NullPointerException();
        }
        this.objFactory = obj;
        gameConfiguration = obj.getGameConfig();
        playerModel = LeagueObjectModelAbstractFactory.getInstance().getPlayer();
        System.out.println("Data is set for the simulation ");
    }

    @Override
    public void separatePlayerByPosition() throws Exception {
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

    @Override
    public void setAverageShotsOnGoal() throws Exception {
        gameConfiguration.setAbstractFactoryObject(objFactory);
        gameConfiguration.setAverageShotsOnGoal();
    }

    @Override
    public void initializeShifts() throws Exception {
        try {
            fillCurrentShiftData();
        }
        catch (Exception e){
            throw new Exception();
        }
        for (int i = 0; i < 3; i++) {
            if (i == 2 && isThisPlayOff == false) {
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
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public float getShootingState(List<PlayerModel> playerModelList) {
        if (playerModelList == null) {
            throw new NullPointerException();
        }
        return playerModel.getShootingState(playerModelList);
    }

    public float getCheckingState(List<PlayerModel> playerModelList) {
        if (playerModelList == null) {
            throw new NullPointerException();
        }
        return playerModel.getCheckingState(playerModelList);
    }

    public float getSavingState(List<PlayerModel> playerModelList) {
        if (playerModelList == null) {
            throw new NullPointerException();
        }
        return playerModel.getSavingState(playerModelList);
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
            if (isThisPlayOff) {
                currentShiftGoalieOfTeamOne.add(getBestGoalieFromTheTeam(listOfGoalieOfTeamOne));
                currentShiftGoalieOfTeamTwo.add(getBestGoalieFromTheTeam(listOfGoaliesOfTeamTwo));
            } else {
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
            System.out.println("Exception while filling current shift information" + e.getMessage());
        }
    }


    public void performPenaltyDuringSimulation(List<PlayerModel> currentDefenseList) {
        try {
            currentDefenseList.get(0).setTotalPenaltyCount(currentDefenseList.get(0).getTotalPenaltyCount() + 1);
            currentDefenseList.get(0).setCurrentPenaltyCount(4);
            penaltyCounter = 4;
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

    public void replaceCurrentGoalie() {
        objFactory.getSwapTurn().swapTurnOfGoalie();
    }

    public void replaceDefenseAndForward() {
        objFactory.getSwapTurn().swapTurnOfForwardAndDefense();
    }

    public PlayerModel getBestGoalieFromTheTeam(List<PlayerModel> list) {
        if (list == null) {
            throw new NullPointerException();
        }
        ITeamsModel teamsModel=LeagueObjectModelAbstractFactory.getInstance().getTeams();
        return teamsModel.getBestGoalieFromTheTeam(list);
    }
}
