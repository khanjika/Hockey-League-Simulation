import cli.InitialCli;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class Main {
    public static void main(String[] args)  {

        InitialCli obj =new InitialCli();

        obj.initializedCommunication("D:\\JsonRead\\demo.txt");


    }

}
