package statemachine.trophysystem;

public class Display implements IObserver{

    @Override
    public void update() {
        System.out.println("Inside Display");
    }
}
