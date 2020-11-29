package cli;

import java.util.Scanner;

public class MockCli implements ICli{
    private Scanner sc = new Scanner(System.in);

    @Override
    public void printOutput(Object output) {
        System.out.println(output);
    }

    @Override
    public String readStringInput(){
        return sc.nextLine().toLowerCase();
    }

    @Override
    public int readIntInput() {
        return sc.nextInt();
    }
}
