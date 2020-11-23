package training;

import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.LeagueModelTest;
import org.junit.jupiter.api.Test;


public class TrainingTest {
    @Test
    void trainingLogicTest() {
        LeagueModel testModel = LeagueModelTest.getLeagueObject();
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        Training training = new Training();
//
//        training.trainingLogic(leagueModel, LocalDate.parse("2021-04-02"));
//        assertFalse(testModel.toString().equals(leagueModel.toString()));

    }
}
