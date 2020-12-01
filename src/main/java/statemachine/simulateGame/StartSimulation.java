package statemachine.simulateGame;

import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class StartSimulation implements IStartSimulation{

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
    private int maxPenalty=4;
    private static IGameConfiguration gameConfiguration;
    private  GameSimulationAbstractFactory objFactory;
    private LeagueObjectModelAbstractFactory leagueObjectModelAbstractFactory;
    final static Logger logger = Logger.getLogger(StartSimulation.class);
    public StartSimulation() {
    }

    public void setRequiredAttributeForSimulation(TeamsModel teamOne, TeamsModel teamTwo, LeagueModel leagueModel, boolean isPlayOff, GameSimulationAbstractFactory obj) throws Exception {
       if(teamOne==null || teamTwo==null || leagueModel==null || obj==null){
           throw new NullPointerException();
       }
        teamOneObject = teamOne;
        teamTwoObject = teamTwo;
        leagueModelObject = leagueModel;
        isThisPlayOff = isPlayOff;
        this.objFactory=obj;
        gameConfiguration=obj.getGameConfig();
        leagueObjectModelAbstractFactory=LeagueObjectModelAbstractFactory.getInstance();
    }

    public void separatePlayerByPosition(){
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

        if(listOfDefenseOfTeamOne==null||listOfDefenseOfTeamTwo==null||listOfForwardOfTeamOne==null||listOfForwardOfTeamTwo==null||listOfGoalieOfTeamOne==null||listOfGoaliesOfTeamTwo==null){
            logger.error("Null pointer exception while separating player by position and adding them to the list");
            throw new NullPointerException();
        }
        else {
            gameConfiguration.setListOfForwardOfTeamOne(listOfForwardOfTeamOne);
            gameConfiguration.setListOfForwardOfTeamTwo(listOfForwardOfTeamTwo);
            gameConfiguration.setListOfDefenseOfTeamOne(listOfDefenseOfTeamOne);
            gameConfiguration.setListOfDefenseOfTeamTwo(listOfDefenseOfTeamTwo);
            gameConfiguration.setListOfGoalieOfTeamOne(listOfGoalieOfTeamOne);
            gameConfiguration.setListOfGoaliesOfTeamTwo(listOfGoaliesOfTeamTwo);
            objFactory.getSwapTurn().setAbstractFactoryObject(objFactory);
        }
    }

    public void setAverageShotsOnGoal() throws Exception{
        gameConfiguration.setAbstractFactoryObject(objFactory);
        gameConfiguration.setAverageShotsOnGoal();
    }

    public void initializeShifts() throws Exception{
        fillCurrentShiftData();
        for (int period = 0; period < 3; period++) {
            if (period == 2 && isThisPlayOff==false) {
                replaceCurrentGoalie();
            }
            for (int shifts= 0; shifts < 40; shifts++) {
                if (shifts == 37) {
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
            logger.error("Exception occurred while performing shift simulation between two teams");
            throw e;
        }
    }

    public float getShootingState(List<PlayerModel> playerModelList){
        if(playerModelList==null){
            throw new NullPointerException();
        }
        return leagueObjectModelAbstractFactory.getPlayer().getShootingState(playerModelList);
    }

    public float getCheckingState(List<PlayerModel> playerModelList) {
        if(playerModelList==null){
            throw new NullPointerException();
        }
        return leagueObjectModelAbstractFactory.getPlayer().getCheckingState(playerModelList);
    }

    public float getSavingState(List<PlayerModel> playerModelList) {
        if(playerModelList==null){
            throw new NullPointerException();
        }
        return leagueObjectModelAbstractFactory.getPlayer().getSavingState(playerModelList);
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
            logger.error("Exception while filling current shift information"+e.getMessage());
            throw e;
        }
    }


    public void performPenaltyDuringSimulation(List<PlayerModel> currentDefenseList) {
        try {
            currentDefenseList.get(0).setTotalPenaltyCount(currentDefenseList.get(0).getTotalPenaltyCount() + 1);
            currentDefenseList.get(0).setCurrentPenaltyCount(4);
            penaltyCounter = maxPenalty;
        } catch (NullPointerException e) {
            logger.error("Exception while performing penalty for the currentDefense list"+e.getMessage());
            throw e;
        }
    }

    public void replaceCurrentGoalie() {
        objFactory.getSwapTurn().swapTurnOfGoalie();
    }

    public void replaceDefenseAndForward() {
        objFactory.getSwapTurn().swapTurnOfForwardAndDefense();
    }

    public PlayerModel getBestGoalieFromTheTeam(List<PlayerModel> list) throws NullPointerException{
        if(list==null){
            logger.error("List is null while getting best goalie from the team during game simulation");
            throw new NullPointerException();
        }
        return leagueObjectModelAbstractFactory.getTeams().getBestGoalieFromTheTeam(list);
    }
}
