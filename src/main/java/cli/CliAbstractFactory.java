package cli;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class CliAbstractFactory {
    private static CliAbstractFactory unique_instance = null;

    public static CliAbstractFactory getInstance(){
        if(unique_instance == null){
            unique_instance = new CliAbstractFactoryConcrete();
        }
        return unique_instance;
    }

    public abstract ICli getCli();

    public abstract void setCli(ICli cli);

    public abstract Scanner getSc();

    public abstract void setSc(Scanner sc);

    public abstract PrintStream getOut();

    public abstract void setOut(PrintStream out);

    public abstract InputStream getIn();

    public abstract void setIn(InputStream in);

    public abstract IDisplay getDisplay();

}
