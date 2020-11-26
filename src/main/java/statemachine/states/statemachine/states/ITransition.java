package statemachine.states.statemachine.states;

public interface ITransition {
    void entry();

    void task();

    void exit();
}
