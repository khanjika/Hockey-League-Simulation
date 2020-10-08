package states;

public interface ITransition {
    void entry();
    void task();
    void exit();
}
