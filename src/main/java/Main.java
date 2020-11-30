import org.apache.log4j.Logger;
import statemachine.states.statemachine.StateMachine;


public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        logger.debug("Main Class initilaized");
        Main.StateEntry(args);
    }

    public static void StateEntry(String[] args) throws Exception {
        try {
            StateMachine stateMachine = new StateMachine();
            stateMachine.getUpdateStateValue().updateImportJsonStateValue(stateMachine, args);
            stateMachine.setCurrentState(stateMachine.getImportJson());
            stateMachine.entry();
        } catch (Exception e) {
            throw e;
        }
    }


}
