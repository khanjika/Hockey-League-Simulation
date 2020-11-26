package statemachine.states.statemachine.states.simulateGame;

public abstract class GameSimulationAbstractFactory {

    private static GameSimulationAbstractFactoryConcrete instance;

    public static GameSimulationAbstractFactory getGameSimulationInstance(){
            if(instance==null){
                instance=new GameSimulationAbstractFactoryConcrete();
            }
            return instance;
    }


    public abstract ISwapTurn getSwapTurn();

    public abstract void setSwapTurn(ISwapTurn swapTurn);

    public abstract IGameConfiguration getGameConfig();

    public abstract void setGameConfig(IGameConfiguration gameConfig);
}
