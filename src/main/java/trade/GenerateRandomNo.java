package trade;

import java.util.Random;

public class GenerateRandomNo implements IGenerateRandomNo {
    @Override
    public float generateRandomNumber() {
        Random random = new Random ();
        float randomNo = 0;
        randomNo = random.nextFloat ();
        return randomNo;
    }
}
