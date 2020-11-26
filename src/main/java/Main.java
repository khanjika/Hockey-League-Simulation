import org.apache.log4j.Logger;
import statemachine.states.statemachine.StateMachine;


public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        logger.debug ("inside main");
        main.StateEntry(args);
    }

    public void StateEntry(String[] args) throws Exception {
        StateMachine stateMachine = new StateMachine();
        stateMachine.getUpdateStateValue().updateImportJsonStateValue(stateMachine,args);
        stateMachine.setCurrentState(stateMachine.getImportJson());
        stateMachine.entry();
    }

}
