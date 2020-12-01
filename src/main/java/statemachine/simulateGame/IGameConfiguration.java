package statemachine.simulateGame;

import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.PlayerModel;

import java.util.List;

public interface IGameConfiguration {

    void setAbstractFactoryObject(GameSimulationAbstractFactory gameSimulationAbstractFactory);

    void setAverageShotsOnGoal(int averageShotsOnGoal);

    void setLeagueModelObject(LeagueModel leagueModelObject);

    List<PlayerModel> getListOfGoalieOfTeamOne();

    void setListOfGoalieOfTeamOne(List<PlayerModel> listOfGoalieOfTeamOne);

    List<PlayerModel> getListOfGoaliesOfTeamTwo();

    void setListOfGoaliesOfTeamTwo(List<PlayerModel> listOfGoaliesOfTeamTwo);

    List<PlayerModel> getListOfForwardOfTeamOne();

    void setListOfForwardOfTeamOne(List<PlayerModel> listOfForwardOfTeamOne);

    List<PlayerModel> getListOfForwardOfTeamTwo();

    void setListOfForwardOfTeamTwo(List<PlayerModel> listOfForwardOfTeamTwo);

    List<PlayerModel> getListOfDefenseOfTeamOne();

    void setListOfDefenseOfTeamOne(List<PlayerModel> listOfDefenseOfTeamOne);

    List<PlayerModel> getListOfDefenseOfTeamTwo();

    void setListOfDefenseOfTeamTwo(List<PlayerModel> listOfDefenseOfTeamTwo);

    List<PlayerModel> getCurrentShiftGoalieOfTeamOne();

    void setCurrentShiftGoalieOfTeamOne(List<PlayerModel> currentShiftGoalieOfTeamOne);

    List<PlayerModel> getCurrentShiftGoalieOfTeamTwo();

    void setCurrentShiftGoalieOfTeamTwo(List<PlayerModel> currentShiftGoalieOfTeamTwo);

    List<PlayerModel> getCurrentShiftDefenseOfTeamOne();

    void setCurrentShiftDefenseOfTeamOne(List<PlayerModel> currentShiftDefenseOfTeamOne);

    List<PlayerModel> getCurrentShiftDefenseOfTeamTwo();

    void setCurrentShiftDefenseOfTeamTwo(List<PlayerModel> currentShiftDefenseOfTeamTwo);

    List<PlayerModel> getCurrentShiftForwardOfTeamOne();

    void setCurrentShiftForwardOfTeamOne(List<PlayerModel> currentShiftForwardOfTeamOne);

    List<PlayerModel> getCurrentShiftForwardOfTeamTwo();

    void setCurrentShiftForwardOfTeamTwo(List<PlayerModel> currentShiftForwardOfTeamTwo);

    void setAverageShotsOnGoal() throws Exception;

    void setPenaltyCounter(int penaltyCounter);

     int getPenaltyCounter();

     int getAverageShotsOnGoal();
}
