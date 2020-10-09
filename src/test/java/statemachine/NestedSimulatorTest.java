package statemachine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NestedSimulatorTest {
    @Test
    void getSeasons()
    {
        NestedSimulator nestedSimulator = new NestedSimulator(2);
        assertEquals(nestedSimulator.getSeasons(),2);
    }

    @Test
    void setSeasons()
    {
        NestedSimulator nestedSimulator = new NestedSimulator();
        nestedSimulator.setSeasons(2);
        assertEquals(nestedSimulator.getSeasons(),2);
    }
}
