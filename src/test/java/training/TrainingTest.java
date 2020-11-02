package training;

import league.LeagueModel;
import league.LeagueModelTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class TrainingTest {
    @Test
    void trainingLogicTest(){
        LeagueModel testModel = LeagueModelTest.getLeagueObject();
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        Training training = new Training();
//
//        training.trainingLogic(leagueModel, LocalDate.parse("2021-04-02"));
//        assertFalse(testModel.toString().equals(leagueModel.toString()));

    }
}
