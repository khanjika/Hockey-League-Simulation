import cli.CliAbstractFactory;
import cli.ICli;
import org.apache.log4j.Logger;
import statemachine.states.StateMachine;


public class Main {

    final static Logger logger = Logger.getLogger(Main.class);
    ICli cli = CliAbstractFactory.getInstance().getCli();

    public static void main(String[] args) throws Exception {
        System.out.println("Main class");
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
