package simulateGame;

import leagueobjectmodel.ILeagueModel;

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

    public abstract GameConfiguration getGameConfig();

    public abstract void setGameConfig(GameConfiguration gameConfig);
}
