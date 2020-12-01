package statemachine.simulateGame;

import leagueobjectmodel.PlayerModel;

import java.util.List;

public abstract class GameSimulationAbstractFactoryTest {
    private static GameSimulationAbstractFactoryTest instance;

    public static GameSimulationAbstractFactoryTest getGameSimulationInstance() {
        if (instance == null) {
            instance = new GameSimulationAbstractFactoryConcreteTest();
        }
        return instance;
    }

    public abstract ISwapTurn getSwapTurn();

    public abstract void setSwapTurn(ISwapTurn swapTurn);

    public abstract IGameConfiguration getGameConfig();

    public abstract void setGameConfig(IGameConfiguration gameConfig);

    public abstract IStartSimulation getStartSimulation();

    public abstract void setStartSimulation(IStartSimulation simulation);

    public  abstract List<PlayerModel> getMockList();
}
