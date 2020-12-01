package leagueobjectmodel;

import org.junit.jupiter.api.Test;
import LeagueMockObject.MockLeague;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GamePlayConfigModelTest {

    @Test
    void getGameResolver() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        IGamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
    }

    @Test
    void setGameResolver() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        IGamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
    }

    @Test
    void getTraining() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        IGamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
        gamePlayConfigModel1.setTraining(gamePlayConfigModel.getTraining());
        assertEquals(gamePlayConfigModel.getTraining(), gamePlayConfigModel1.getTraining(), "Error in gettraining of GamePlayConfig");
    }

    @Test
    void setTraining() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        IGamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
        gamePlayConfigModel1.setTraining(gamePlayConfigModel.getTraining());
        assertEquals(gamePlayConfigModel.getTraining(), gamePlayConfigModel1.getTraining(), "Error in settraining of GamePlayConfig");
    }

    @Test
    void getTrading() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        IGamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
        gamePlayConfigModel1.setTrading(gamePlayConfigModel.getTrading());
        assertEquals(gamePlayConfigModel.getTrading(), gamePlayConfigModel1.getTrading(), "Error in settraining of GamePlayConfig");
    }

    @Test
    void setTrading() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        IGamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
        gamePlayConfigModel1.setTrading(gamePlayConfigModel.getTrading());
        assertEquals(gamePlayConfigModel.getTrading(), gamePlayConfigModel1.getTrading(), "Error in settraining of GamePlayConfig");
    }
}
