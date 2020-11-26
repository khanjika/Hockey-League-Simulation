package statemachine.trophysystem;

public class test {
    public static void main(String[] args) {
        Subject subject = new BestTeam();
        IObserver observer = new TrophySystem();
        IObserver observer1 = new Display();
        subject.attach(observer);
        subject.attach(observer1);
    }
}
