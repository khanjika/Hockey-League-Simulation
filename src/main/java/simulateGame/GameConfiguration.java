package simulateGame;

import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.PlayerModel;
import leagueobjectmodel.TeamsModel;

import java.util.ArrayList;
import java.util.List;

public class GameConfiguration {
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


    public static TeamsModel getTeamOneObject() {
        return teamOneObject;
    }

    public static void setTeamOneObject(TeamsModel teamOneObject) {
        GameConfiguration.teamOneObject = teamOneObject;
    }

    public static TeamsModel getTeamTwoObject() {
        return teamTwoObject;
    }

    public static void setTeamTwoObject(TeamsModel teamTwoObject) {
        GameConfiguration.teamTwoObject = teamTwoObject;
    }

    public int getAverageShotsOnGoal() {
        return averageShotsOnGoal;
    }

    public void setAverageShotsOnGoal(int averageShotsOnGoal) {
        this.averageShotsOnGoal = averageShotsOnGoal;
    }

    public boolean isThisPlayOff() {
        return isThisPlayOff;
    }

    public void setThisPlayOff(boolean thisPlayOff) {
        isThisPlayOff = thisPlayOff;
    }

    public static LeagueModel getLeagueModelObject() {
        return leagueModelObject;
    }

    public static void setLeagueModelObject(LeagueModel leagueModelObject) {
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

    public void setPenaltyCounter(int penaltyCounter) {
        this.penaltyCounter = penaltyCounter;
    }
}
