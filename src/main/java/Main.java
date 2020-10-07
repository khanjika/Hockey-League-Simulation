import cli.InitialCli;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.DatabaseConnection;
import freeagent.FreeAgentPersistent;
import league.LeaguePersistent;
import statemachine.StateMachine;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
//
//        DatabaseConnection connection = new DatabaseConnection();
//        connection.getConnection();
//
//        InitialCli obj = new InitialCli();
//        obj.initializedCommunication();
//        obj.initializedCommunication("D:\\JsonRead\\demo.txt");

        StateMachine stateMachine = new StateMachine();
        while (true) {
            stateMachine.entry();
            if (stateMachine.getCurrentState() == stateMachine.getSimulate()) {
                break;
            }
            stateMachine.task();
            stateMachine.exit();
        }

    }

}
