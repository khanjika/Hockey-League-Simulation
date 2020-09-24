import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void printHelloTest(){
        Main mainTest = new Main();
        assertEquals("Hello Group 9!!!",mainTest.printHello());
    }
}