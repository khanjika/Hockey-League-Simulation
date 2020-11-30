package statemachine.states.statemachine.states.simulateGame;

import leagueobjectmodel.PlayerModel;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SwapTurnTest {

    IGameConfiguration gameConfiguration;
    ISwapTurn swapTurn;
    GameSimulationAbstractFactory factory;
    GameSimulationAbstractFactoryTest factoryMock;

    @BeforeEach
    void setGameConfiguration() {
        gameConfiguration=GameSimulationAbstractFactoryTest.getGameSimulationInstance().getGameConfig();
        swapTurn = GameSimulationAbstractFactoryTest.getGameSimulationInstance().getSwapTurn();
        factory = GameSimulationAbstractFactory.getGameSimulationInstance();
        factoryMock=GameSimulationAbstractFactoryTest.getGameSimulationInstance();
    }

    @Test
    void swapTurnOfTeam() {
        swapTurn.setAbstractFactoryObject(factory);
        List<PlayerModel> mockListOne = factoryMock.getMockList();
        gameConfiguration.setCurrentShiftForwardOfTeamOne(mockListOne);
        gameConfiguration.setCurrentShiftDefenseOfTeamOne(mockListOne);
        gameConfiguration.setCurrentShiftGoalieOfTeamOne(mockListOne);
        List<PlayerModel> mockListTwo = factoryMock.getMockList();
        gameConfiguration.setCurrentShiftForwardOfTeamTwo(mockListTwo);
        gameConfiguration.setCurrentShiftDefenseOfTeamTwo(mockListTwo);
        gameConfiguration.setCurrentShiftGoalieOfTeamTwo(mockListTwo);
        swapTurn.swapTurnOfTeam();
        assertNotEquals(gameConfiguration.getCurrentShiftForwardOfTeamOne(),gameConfiguration.getCurrentShiftForwardOfTeamTwo());

    }

    @Test
    void swapTurnOfGoalie() {
        swapTurn.setAbstractFactoryObject(factory);
        List<PlayerModel> mockListOne = factoryMock.getMockList();
        gameConfiguration.setCurrentShiftGoalieOfTeamOne(mockListOne);
        gameConfiguration.setListOfGoalieOfTeamOne(mockListOne);
        List<PlayerModel> mockListTwo = factoryMock.getMockList();
        gameConfiguration.setCurrentShiftGoalieOfTeamTwo(mockListTwo);
        gameConfiguration.setListOfGoaliesOfTeamTwo(mockListTwo);
        swapTurn.swapTurnOfGoalie();
        assertTrue(gameConfiguration.getCurrentShiftGoalieOfTeamOne().contains(gameConfiguration.getListOfGoalieOfTeamOne().get(1)));
    }

    @Test
    void swapTurnOfForwardAndDefense() {
    }

    @Test
    void setAbstractFactoryObject() {
        swapTurn.setAbstractFactoryObject(factory);
    }
}
