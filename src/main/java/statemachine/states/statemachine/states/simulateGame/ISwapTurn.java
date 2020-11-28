package statemachine.states.statemachine.states.simulateGame;

public interface ISwapTurn {

    void swapTurnOfTeam();
    void swapTurnOfGoalie();
    void swapTurnOfForwardAndDefense();
    void setAbstractFactoryObject(GameSimulationAbstractFactory gameSimulationAbstractFactory);

}
