package statemachine.simulateGame;

import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.TeamsModel;

public interface IStartSimulation {

    void separatePlayerByPosition() throws Exception;

    void setAverageShotsOnGoal() throws Exception;

    void initializeShifts() throws Exception;

    void setRequiredAttributeForSimulation(TeamsModel teamOne, TeamsModel teamTwo, LeagueModel leagueModel, boolean isPlayOff, GameSimulationAbstractFactory obj) throws Exception;
}
