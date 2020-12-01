package statemachine.simulateGame;

public interface ISwapTurn {

    void swapTurnOfTeam();
    void swapTurnOfGoalie();
    void swapTurnOfForwardAndDefense();
    void setAbstractFactoryObject(GameSimulationAbstractFactory gameSimulationAbstractFactory);

}
