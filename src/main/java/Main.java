import statemachine.StateMachine;
import states.ImportJsonState;


public class Main {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.StateEntry(args);
    }

    public void StateEntry(String[] args) throws Exception {
        StateMachine stateMachine = new StateMachine();
        stateMachine.setCurrentState(new ImportJsonState(args, stateMachine));
        stateMachine.entry();

    }

}
