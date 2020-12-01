package statemachine.simulateGame;

import org.apache.log4j.Logger;

public abstract class GameSimulationAbstractFactory {

    private static GameSimulationAbstractFactory instance;
    final static Logger logger = Logger.getLogger(GameSimulationAbstractFactory.class);

    public static GameSimulationAbstractFactory getGameSimulationInstance(){
            if(instance==null){
                logger.info("New Object of GameSimulationAbstractFactory is created");
                instance=new GameSimulationAbstractFactoryConcrete();
            }
            return instance;
    }

    public abstract ISwapTurn getSwapTurn();

    public abstract void setSwapTurn(ISwapTurn swapTurn);

    public abstract IGameConfiguration getGameConfig();

    public abstract void setGameConfig(IGameConfiguration gameConfig);

    public abstract IStartSimulation getStartSimulation();

    public abstract void setStartSimulation(IStartSimulation simulation);
}
