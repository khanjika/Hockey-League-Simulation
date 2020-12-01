package statemachine.trophysystem;

public class EndOfSeasonStandingSubject extends Subject{

    private static EndOfSeasonStandingSubject unique_instance = new EndOfSeasonStandingSubject();

    public static EndOfSeasonStandingSubject getInstance() {
        return unique_instance;
    }


}
