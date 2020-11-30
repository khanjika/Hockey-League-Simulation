package leagueobjectmodel;

import org.junit.jupiter.api.Test;
import trade.MockLeague;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GamePlayConfigModelTest {

    @Test
    void getAging() {
        MockLeague leagueModel = new MockLeague();
        LeagueModel leagueModel1 = MockLeague.getLeagueObject();
        GamePlayConfigModel gamePlayConfigModel = leagueModel1.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();

        assertEquals(gamePlayConfigModel.getAging(), gamePlayConfigModel1.getAging(), "Error in getAging of GamePlayConfig");
    }

    @Test
    void setAging() {
        MockLeague leagueModel = new MockLeague();
        LeagueModel leagueModel1 = MockLeague.getLeagueObject();
        GamePlayConfigModel gamePlayConfigModel = leagueModel1.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
        assertEquals(gamePlayConfigModel.getAging(), gamePlayConfigModel1.getAging(), "Error in setAging of GamePlayConfig");
    }

    @Test
    void getGameResolver() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
    }

    @Test
    void setGameResolver() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
    }

    @Test
    void getInjuries() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
 //       gamePlayConfigModel1.setInjuries(gamePlayConfigModel.getInjuries());
        assertEquals(gamePlayConfigModel.getInjuries(), gamePlayConfigModel1.getInjuries(), "Error in getInjuries of GamePlayConfig");
    }

    @Test
    void setInjuries() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
      //  gamePlayConfigModel1.setInjuries(gamePlayConfigModel.getInjuries());
        assertEquals(gamePlayConfigModel.getInjuries(), gamePlayConfigModel1.getInjuries(), "Error in setInjuries of GamePlayConfig");
    }

    @Test
    void getTraining() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
        gamePlayConfigModel1.setTraining(gamePlayConfigModel.getTraining());
        assertEquals(gamePlayConfigModel.getTraining(), gamePlayConfigModel1.getTraining(), "Error in gettraining of GamePlayConfig");
    }

    @Test
    void setTraining() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
        gamePlayConfigModel1.setTraining(gamePlayConfigModel.getTraining());
        assertEquals(gamePlayConfigModel.getTraining(), gamePlayConfigModel1.getTraining(), "Error in settraining of GamePlayConfig");
    }

    @Test
    void getTrading() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
        gamePlayConfigModel1.setTrading(gamePlayConfigModel.getTrading());
        assertEquals(gamePlayConfigModel.getTrading(), gamePlayConfigModel1.getTrading(), "Error in settraining of GamePlayConfig");
    }

    @Test
    void setTrading() {
        MockLeague league = new MockLeague();
        LeagueModel leagueModel = MockLeague.getLeagueObject();
        GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        GamePlayConfigModel gamePlayConfigModel1 = new GamePlayConfigModel();
        gamePlayConfigModel1.setTrading(gamePlayConfigModel.getTrading());
        assertEquals(gamePlayConfigModel.getTrading(), gamePlayConfigModel1.getTrading(), "Error in settraining of GamePlayConfig");
    }
}
