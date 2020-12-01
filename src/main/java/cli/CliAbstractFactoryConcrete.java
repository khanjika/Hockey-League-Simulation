package cli;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CliAbstractFactoryConcrete extends CliAbstractFactory {

    private ICli cli;
    private Scanner sc;
    private PrintStream out;
    private InputStream in;
    private IDisplay displayPersons;

    @Override
    public ICli getCli() {
        if(cli == null){
            cli = new Cli();
        }
        return cli;
    }

    @Override
    public void setCli(ICli cli) {
        this.cli = cli;
    }

    @Override
    public Scanner getSc() {
        if(sc == null){
            sc = new Scanner(System.in);
        }
        return sc;
    }

    @Override
    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public PrintStream getOut() {
        if(out == null){
            out = System.out;
        }
        return out;
    }

    @Override
    public void setOut(PrintStream out) {
        this.out = out;
    }

    @Override
    public InputStream getIn() {
        if(in == null){
            in = System.in;
        }
        return in;
    }

    @Override
    public void setIn(InputStream in) {
        this.in = in;
    }

    @Override
    public IDisplay getDisplay() {
        if(displayPersons == null){
            displayPersons = new Display();
        }
        return displayPersons;
    }
}
