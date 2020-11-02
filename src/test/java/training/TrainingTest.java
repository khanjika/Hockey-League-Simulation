package training;

import league.LeagueModel;
import league.LeagueModelTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class TrainingTest {
    @Test
    void trainingLogicTest(){
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        Training training = new Training();
       // training.trainingLogic(leagueModel, LocalDate.parse("2021-04-02"));
    }
}
