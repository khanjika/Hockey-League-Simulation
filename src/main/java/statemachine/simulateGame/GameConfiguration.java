package statemachine.simulateGame;

import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.PlayerModel;
import leagueobjectmodel.PlayerPosition;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class GameConfiguration implements IGameConfiguration {
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
    final static Logger logger = Logger.getLogger(GameConfiguration.class);
    GameSimulationAbstractFactory objFactory;
    int penaltyCounter = 0;


    public void setAbstractFactoryObject(GameSimulationAbstractFactory gameSimulationAbstractFactory){
     this.objFactory=gameSimulationAbstractFactory;
    }

    public void setAverageShotsOnGoal(int averageShotsOnGoal) {
        this.averageShotsOnGoal = averageShotsOnGoal;
    }

    public  void setLeagueModelObject(LeagueModel leagueModelObject) {
        GameConfiguration.leagueModelObject = leagueModelObject;
    }

    public List<PlayerModel> getListOfGoalieOfTeamOne() {
        return listOfGoalieOfTeamOne;
    }

    public void setListOfGoalieOfTeamOne(List<PlayerModel> listOfGoalieOfTeamOne) {
        this.listOfGoalieOfTeamOne = listOfGoalieOfTeamOne;
    }

    public List<PlayerModel> getListOfGoaliesOfTeamTwo() {
        return listOfGoaliesOfTeamTwo;
    }

    public void setListOfGoaliesOfTeamTwo(List<PlayerModel> listOfGoaliesOfTeamTwo) {
        this.listOfGoaliesOfTeamTwo = listOfGoaliesOfTeamTwo;
    }

    public List<PlayerModel> getListOfForwardOfTeamOne() {
        return listOfForwardOfTeamOne;
    }

    public void setListOfForwardOfTeamOne(List<PlayerModel> listOfForwardOfTeamOne) {
        this.listOfForwardOfTeamOne = listOfForwardOfTeamOne;
    }

    public List<PlayerModel> getListOfForwardOfTeamTwo() {
        return listOfForwardOfTeamTwo;
    }

    public void setListOfForwardOfTeamTwo(List<PlayerModel> listOfForwardOfTeamTwo) {
        this.listOfForwardOfTeamTwo = listOfForwardOfTeamTwo;
    }

    public List<PlayerModel> getListOfDefenseOfTeamOne() {
        return listOfDefenseOfTeamOne;
    }

    public void setListOfDefenseOfTeamOne(List<PlayerModel> listOfDefenseOfTeamOne) {
        this.listOfDefenseOfTeamOne = listOfDefenseOfTeamOne;
    }

    public List<PlayerModel> getListOfDefenseOfTeamTwo() {
        return listOfDefenseOfTeamTwo;
    }

    public void setListOfDefenseOfTeamTwo(List<PlayerModel> listOfDefenseOfTeamTwo) {
        this.listOfDefenseOfTeamTwo = listOfDefenseOfTeamTwo;
    }

    public List<PlayerModel> getCurrentShiftGoalieOfTeamOne() {
        return currentShiftGoalieOfTeamOne;
    }

    public void setCurrentShiftGoalieOfTeamOne(List<PlayerModel> currentShiftGoalieOfTeamOne) {
        this.currentShiftGoalieOfTeamOne = currentShiftGoalieOfTeamOne;
    }

    public List<PlayerModel> getCurrentShiftGoalieOfTeamTwo() {
        return currentShiftGoalieOfTeamTwo;
    }

    public void setCurrentShiftGoalieOfTeamTwo(List<PlayerModel> currentShiftGoalieOfTeamTwo) {
        this.currentShiftGoalieOfTeamTwo = currentShiftGoalieOfTeamTwo;
    }

    public List<PlayerModel> getCurrentShiftDefenseOfTeamOne() {
        return currentShiftDefenseOfTeamOne;
    }

    public void setCurrentShiftDefenseOfTeamOne(List<PlayerModel> currentShiftDefenseOfTeamOne) {
        this.currentShiftDefenseOfTeamOne = currentShiftDefenseOfTeamOne;
    }

    public List<PlayerModel> getCurrentShiftDefenseOfTeamTwo() {
        return currentShiftDefenseOfTeamTwo;
    }

    public void setCurrentShiftDefenseOfTeamTwo(List<PlayerModel> currentShiftDefenseOfTeamTwo) {
        this.currentShiftDefenseOfTeamTwo = currentShiftDefenseOfTeamTwo;
    }

    public List<PlayerModel> getCurrentShiftForwardOfTeamOne() {
        return currentShiftForwardOfTeamOne;
    }

    public void setCurrentShiftForwardOfTeamOne(List<PlayerModel> currentShiftForwardOfTeamOne) {
        this.currentShiftForwardOfTeamOne = currentShiftForwardOfTeamOne;
    }

    public List<PlayerModel> getCurrentShiftForwardOfTeamTwo() {
        return currentShiftForwardOfTeamTwo;
    }

    public void setCurrentShiftForwardOfTeamTwo(List<PlayerModel> currentShiftForwardOfTeamTwo) {
        this.currentShiftForwardOfTeamTwo = currentShiftForwardOfTeamTwo;
    }

    public int getPenaltyCounter() {
        return penaltyCounter;
    }

    @Override
    public int getAverageShotsOnGoal() {
        return averageShotsOnGoal;
    }

    public void setPenaltyCounter(int penaltyCounter) {
        this.penaltyCounter = penaltyCounter;
    }

    public void setAverageShotsOnGoal() throws Exception{
        float teamOneShootingState = 0;
        float teamTwoShootingState = 0;
        float teamOneSkatingState = 0;
        float teamTwoSkatingState = 0;
        try {
            for (PlayerModel playerModel : listOfDefenseOfTeamOne) {
                if (playerModel.getPosition().equals(PlayerPosition.DEFENSE.toString())) {
                    teamOneShootingState = playerModel.getShooting();
                }
                teamOneSkatingState = playerModel.getSkating();
            }
            for (PlayerModel playerModel : listOfDefenseOfTeamTwo) {
                if (playerModel.getPosition().equals(PlayerPosition.DEFENSE.toString())) {
                    teamTwoShootingState = playerModel.getShooting();
                }
                teamTwoSkatingState = playerModel.getSkating();
            }
            if (teamOneShootingState >= teamTwoShootingState) {
                int skatingStateDifference= (int) (teamOneSkatingState-teamTwoSkatingState);
                if(skatingStateDifference<10){
                    averageShotsOnGoal=averageShotsOnGoal-skatingStateDifference;
                }else {
                    averageShotsOnGoal=averageShotsOnGoal-10;
                }

            }
            objFactory.getGameConfig().setAverageShotsOnGoal(averageShotsOnGoal);
            logger.info("Average goal on shots are set");
        }
        catch (NullPointerException nullPointerException){
            logger.error("Null pointer exception in the setAverageGoal Method");
            throw nullPointerException;
        }
        catch (Exception e){
            logger.error("Exception occured in the setAverageGoal Method");
            throw e;
        }

    }

}
