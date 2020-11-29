package statemachine.trophysystem;

public class EndOfPlayOffStandingSubject extends Subject{

    private static EndOfPlayOffStandingSubject unique_instance = new EndOfPlayOffStandingSubject();

    public static EndOfPlayOffStandingSubject getInstance() {
        return unique_instance;
    }

}
