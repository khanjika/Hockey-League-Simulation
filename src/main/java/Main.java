import statemachine.StateMachine;


public class Main {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.StateEntry(args);
    }

    public void StateEntry(String[] args) throws Exception {
        StateMachine stateMachine = new StateMachine();
        stateMachine.getUpdateStateValue().updateImportJsonStateValue(stateMachine,args);
        stateMachine.setCurrentState(stateMachine.getImportJson());
        stateMachine.entry();

    }

}
