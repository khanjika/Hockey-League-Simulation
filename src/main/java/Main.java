import cli.InitialCli;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.DatabaseConnection;
import freeagent.FreeAgentPersistent;
import league.LeaguePersistent;
import statemachine.StateMachine;
import states.ImportJsonState;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.StateEntry(args);
    }

    public void StateEntry(String[] args) {
        StateMachine stateMachine = new StateMachine();
        stateMachine.setCurrentState(new ImportJsonState(args,stateMachine));
        stateMachine.entry();

    }

}
