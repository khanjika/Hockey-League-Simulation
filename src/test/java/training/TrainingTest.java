package training;

import league.LeagueModel;
import league.LeagueModelTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainingTest {
    @Test
    void trainingLogicTest(){
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        Training training = new Training();
        assertTrue(training.trainingLogic(leagueModel));
    }
}
