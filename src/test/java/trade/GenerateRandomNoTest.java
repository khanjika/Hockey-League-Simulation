package trade;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class GenerateRandomNoTest {

    trade.GenerateRandomNo generateNo = new trade.GenerateRandomNo ();

    @Test
    void generateRandomNumber() {
        float no = generateNo.generateRandomNumber ();
        Assert.assertNotEquals (no, 2.0f);
    }

}
