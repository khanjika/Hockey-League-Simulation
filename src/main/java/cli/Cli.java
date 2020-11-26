package cli;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Cli implements ICli {

    private Scanner sc;
    private PrintStream out;
    private InputStream in;

    public Cli(){
        sc = CliAbstractFactory.getInstance().getSc();
        out = CliAbstractFactory.getInstance().getOut();
        in = CliAbstractFactory.getInstance().getIn();
    }

    @Override
    public void printOutput(Object output){
        out.println(output);
    }

    @Override
    public String readStringInput(){
        return sc.nextLine().toLowerCase();
    }

    @Override
    public int readIntInput(){
        return sc.nextInt();
    }

}
