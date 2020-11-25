package cli;

public interface ICli {
    void printOutput(Object output);

    String readStringInput();

    int readIntInput();
}
