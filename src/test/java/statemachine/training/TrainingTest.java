package statemachine.training;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.LeagueModelTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class TrainingTest {
    @Test
    void trainingLogicTest() {
        ILeagueModel testModel = LeagueModelTest.getLeagueObject();
        ILeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        ITraining training = TrainingAbstractFactory.getInstance().getTraining();
        ITeamsModel team = testModel.getConferences().get(0).getDivisions().get(0).getTeams().get(0);
        training.setInjuriesModel(testModel.getGameplayConfig().getInjuries());
        training.performTraining(team.getPlayers().get(0), team.getHeadCoach(), LocalDate.parse("2021-04-02"));
        assertFalse(testModel.toString().equals(leagueModel.toString()));
    }
}
