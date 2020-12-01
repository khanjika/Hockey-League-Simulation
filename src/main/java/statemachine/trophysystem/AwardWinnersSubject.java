package statemachine.trophysystem;

public class AwardWinnersSubject extends Subject{

    private static AwardWinnersSubject unique_instance = new AwardWinnersSubject();

    public static AwardWinnersSubject getInstance() {
        return unique_instance;
    }
}
