import cli.InitialCli;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.DatabaseConnection;
import league.LeaguePersistent;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
//
//        DatabaseConnection connection = new DatabaseConnection();
//        connection.getConnection();
//
        LeaguePersistent leaguePersistent = new LeaguePersistent();
        leaguePersistent. addLeagueInforamtion();
        InitialCli obj = new InitialCli();

//        obj.initializedCommunication("D:\\JsonRead\\demo.txt");

    }

}
