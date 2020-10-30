package training;

import gameplayconfig.InjuriesModel;
import gameplayconfig.InjuriesModelTest;
import gameplayconfig.TrainingModel;
import league.LeagueModel;
import league.LeagueModelTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class TrainingTest {
    @Test
    void trainingLogicTest(){
        LeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        System.out.println(leagueModel.getGameplayConfig().getInjuries().getRandomInjuryChance());
        Training training = new Training();
        training.trainingLogic(leagueModel, LocalDate.parse("2021-04-02"));
    }
}
