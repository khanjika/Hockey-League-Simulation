package training;

import java.util.Random;

public class TrainingConstants {
    Random rand;
    
    public int getRandomNumber() {
        return rand.nextInt(2);
    }

}
