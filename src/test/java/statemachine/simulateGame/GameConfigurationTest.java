package statemachine.simulateGame;

import leagueobjectmodel.PlayerModel;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameConfigurationTest {

    IGameConfiguration gameConfiguration;
    List<PlayerModel> mockList;

    @BeforeEach
    void setGameConfiguration() {
        gameConfiguration = GameSimulationAbstractFactoryTest.getGameSimulationInstance().getGameConfig();
    }

    @Before
    void setMockList() {
        mockList.add(new PlayerModel());
    }

    @Test
    void setAverageShotsOnGoal() {
        gameConfiguration.setAverageShotsOnGoal(2);
        assertEquals(gameConfiguration.getAverageShotsOnGoal(), 2);
    }

    @Test
    void getListOfGoalieOfTeamOne() {
        gameConfiguration.setListOfGoalieOfTeamOne(mockList);
        assertEquals(gameConfiguration.getListOfGoalieOfTeamOne(), mockList);
    }

    @Test
    void setListOfGoalieOfTeamOne() {
        gameConfiguration.setListOfGoalieOfTeamOne(mockList);
        assertEquals(gameConfiguration.getListOfGoalieOfTeamOne(), mockList);
    }

    @Test
    void getListOfGoaliesOfTeamTwo() {
        gameConfiguration.setListOfGoaliesOfTeamTwo(mockList);
        assertEquals(gameConfiguration.getListOfGoaliesOfTeamTwo(), mockList);
    }

    @Test
    void setListOfGoaliesOfTeamTwo() {
        gameConfiguration.setListOfGoaliesOfTeamTwo(mockList);
        assertEquals(gameConfiguration.getListOfGoaliesOfTeamTwo(), mockList);
    }

    @Test
    void getListOfForwardOfTeamOne() {
        gameConfiguration.setListOfForwardOfTeamOne(mockList);
        assertEquals(gameConfiguration.getListOfForwardOfTeamOne(), mockList);
    }

    @Test
    void setListOfForwardOfTeamOne() {
        gameConfiguration.setListOfForwardOfTeamOne(mockList);
        assertEquals(gameConfiguration.getListOfForwardOfTeamOne(), mockList);
    }

    @Test
    void getListOfForwardOfTeamTwo() {
        gameConfiguration.setListOfForwardOfTeamTwo(mockList);
        assertEquals(gameConfiguration.getListOfForwardOfTeamTwo(),mockList);
    }

    @Test
    void setListOfForwardOfTeamTwo() {
        gameConfiguration.setListOfForwardOfTeamTwo(mockList);
        assertEquals(gameConfiguration.getListOfForwardOfTeamTwo(),mockList);
    }

    @Test
    void getListOfDefenseOfTeamOne() {
        gameConfiguration.setListOfDefenseOfTeamOne(mockList);
        assertEquals(gameConfiguration.getListOfDefenseOfTeamOne(),mockList);
    }

    @Test
    void setListOfDefenseOfTeamOne() {
        gameConfiguration.setListOfDefenseOfTeamOne(mockList);
        assertEquals(gameConfiguration.getListOfDefenseOfTeamOne(),mockList);
    }

    @Test
    void getListOfDefenseOfTeamTwo() {
        gameConfiguration.setListOfDefenseOfTeamTwo(mockList);
        assertEquals(gameConfiguration.getListOfDefenseOfTeamTwo(),mockList);
    }

    @Test
    void setListOfDefenseOfTeamTwo() {
        gameConfiguration.setListOfDefenseOfTeamTwo(mockList);
        assertEquals(gameConfiguration.getListOfDefenseOfTeamTwo(),mockList);
    }

    @Test
    void getCurrentShiftGoalieOfTeamOne() {
        gameConfiguration.setCurrentShiftGoalieOfTeamOne(mockList);
        assertEquals(gameConfiguration.getCurrentShiftGoalieOfTeamOne(),mockList);
    }

    @Test
    void setCurrentShiftGoalieOfTeamOne() {
        gameConfiguration.setCurrentShiftGoalieOfTeamOne(mockList);
        assertEquals(gameConfiguration.getCurrentShiftGoalieOfTeamOne(),mockList);
    }

    @Test
    void getCurrentShiftGoalieOfTeamTwo() {
        gameConfiguration.setCurrentShiftGoalieOfTeamTwo(mockList);
        assertEquals(gameConfiguration.getCurrentShiftGoalieOfTeamTwo(),mockList);
    }
    @Test
    void setCurrentShiftGoalieOfTeamTwo() {
        gameConfiguration.setCurrentShiftGoalieOfTeamTwo(mockList);
        assertEquals(gameConfiguration.getCurrentShiftGoalieOfTeamTwo(),mockList);
    }

    @Test
    void getCurrentShiftDefenseOfTeamOne() {
        gameConfiguration.setCurrentShiftDefenseOfTeamOne(mockList);
        assertEquals(gameConfiguration.getCurrentShiftDefenseOfTeamOne(),mockList);
    }

    @Test
    void setCurrentShiftDefenseOfTeamOne() {
        gameConfiguration.setCurrentShiftDefenseOfTeamOne(mockList);
        assertEquals(gameConfiguration.getCurrentShiftDefenseOfTeamOne(),mockList);
    }

    @Test
    void getCurrentShiftDefenseOfTeamTwo() {
        gameConfiguration.setCurrentShiftDefenseOfTeamTwo(mockList);
        assertEquals(gameConfiguration.getCurrentShiftDefenseOfTeamTwo(),mockList);
    }

    @Test
    void setCurrentShiftDefenseOfTeamTwo() {
        gameConfiguration.setCurrentShiftDefenseOfTeamTwo(mockList);
        assertEquals(gameConfiguration.getCurrentShiftDefenseOfTeamTwo(),mockList);
    }

    @Test
    void getCurrentShiftForwardOfTeamOne() {
        gameConfiguration.setCurrentShiftForwardOfTeamOne(mockList);
        assertEquals(gameConfiguration.getCurrentShiftForwardOfTeamOne(),mockList);
    }

    @Test
    void setCurrentShiftForwardOfTeamOne() {
        gameConfiguration.setCurrentShiftForwardOfTeamOne(mockList);
        assertEquals(gameConfiguration.getCurrentShiftForwardOfTeamOne(),mockList);
    }

    @Test
    void getCurrentShiftForwardOfTeamTwo() {
        gameConfiguration.setCurrentShiftForwardOfTeamTwo(mockList);
        assertEquals(gameConfiguration.getCurrentShiftForwardOfTeamTwo(),mockList);
    }

    @Test
    void setCurrentShiftForwardOfTeamTwo() {
        gameConfiguration.setCurrentShiftForwardOfTeamTwo(mockList);
        assertEquals(gameConfiguration.getCurrentShiftForwardOfTeamTwo(),mockList);
    }

    @Test
    void getPenaltyCounter() {
        gameConfiguration.setPenaltyCounter(1);
        assertEquals(gameConfiguration.getPenaltyCounter(),1);
    }

    @Test
    void setPenaltyCounter() {
        gameConfiguration.setPenaltyCounter(1);
        assertEquals(gameConfiguration.getPenaltyCounter(),1);
    }

}
