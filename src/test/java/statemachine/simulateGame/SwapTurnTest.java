package statemachine.simulateGame;

import leagueobjectmodel.PlayerModel;
import org.junit.jupiter.api.AfterEach;
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

    @AfterEach
    void clearData(){
        GameSimulationAbstractFactoryTest.getGameSimulationInstance().setGameConfig(null);
        GameSimulationAbstractFactoryTest.getGameSimulationInstance().setSwapTurn(null);
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
        swapTurn.setAbstractFactoryObject(factory);
        List<PlayerModel> mockListOne=factoryMock.getMockList();
        List<PlayerModel> mockListTwo=factoryMock.getMockList();
        List<PlayerModel> mockListThree=factoryMock.getMockList();
        List<PlayerModel> mockListFour=factoryMock.getMockList();

        gameConfiguration.setCurrentShiftDefenseOfTeamOne(mockListOne);
        gameConfiguration.setCurrentShiftDefenseOfTeamTwo(mockListTwo);
        gameConfiguration.setCurrentShiftForwardOfTeamOne(mockListOne);
        gameConfiguration.setCurrentShiftForwardOfTeamTwo(mockListTwo);

        gameConfiguration.setListOfDefenseOfTeamOne(mockListThree);
        gameConfiguration.setListOfForwardOfTeamOne(mockListThree);

        gameConfiguration.setListOfDefenseOfTeamTwo(mockListFour);
        gameConfiguration.setListOfForwardOfTeamTwo(mockListFour);
        swapTurn.swapTurnOfForwardAndDefense();
        assertTrue(gameConfiguration.getCurrentShiftDefenseOfTeamOne().contains(mockListThree.get(2)));
        assertTrue(gameConfiguration.getCurrentShiftDefenseOfTeamTwo().contains(mockListTwo.get(2)));
        assertTrue(gameConfiguration.getCurrentShiftForwardOfTeamOne().contains(mockListOne.get(2)));
        assertTrue(gameConfiguration.getCurrentShiftForwardOfTeamTwo().contains(mockListTwo.get(2)));
    }

    @Test
    void setAbstractFactoryObject() {
        swapTurn.setAbstractFactoryObject(factory);
    }
}
