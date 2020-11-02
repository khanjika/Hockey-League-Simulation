package league;

import coach.CoachModel;
import coach.CoachModelTest;
import conference.ConferenceModel;
import conference.ConferenceModelTest;
import divison.DivisonModel;
import freeagent.FreeAgentModel;
import freeagent.FreeAgentModelTest;
import gameplayconfig.*;
import org.junit.jupiter.api.Test;
import players.PlayerModel;
import players.PlayerModelTest;
import teams.TeamsModel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LeagueModelTest {

    @Test
    void getLeagueNameTest() {
        LeagueModel leagueModel = new LeagueModel();
        leagueModel.setLeagueName("League one");
        assertEquals("League one", leagueModel.getLeagueName(), "Failed to get league name in division object");
    }

    @Test
    void setLeagueNameTest() {
        LeagueModel leagueModel = new LeagueModel();
        leagueModel.setLeagueName("League one");
        assertEquals("League one", leagueModel.getLeagueName(), "Failed to set league name in division object");
    }

    @Test
    void getConferencesTest() {
        LeagueModel leagueModel = new LeagueModel();
        leagueModel.setConferences(new ArrayList<ConferenceModel>());
        assertNotNull(leagueModel.getConferences(), "Failed to get Conferences in Division object");
    }

    @Test
    void setConferencesTest() {
        LeagueModel leagueModel = new LeagueModel();
        leagueModel.setConferences(new ArrayList<ConferenceModel>());
        assertNotNull(leagueModel.getConferences(), "Failed to set Conferences in Division object");
    }

    @Test
    void getFreeAgentsTest() {
        LeagueModel leagueModel = new LeagueModel();
        leagueModel.setFreeAgents(new ArrayList<FreeAgentModel>());
        assertNotNull(leagueModel.getFreeAgents(), "Failed to get FreeAgents in Division object");
    }

    @Test
    void setFreeAgentsTest() {
        LeagueModel leagueModel = new LeagueModel();
        leagueModel.setFreeAgents(new ArrayList<FreeAgentModel>());
        assertNotNull(leagueModel.getFreeAgents(), "Failed to set Free agents in Division object");
    }

    public static LeagueModel getLeagueObject() {
        LeagueModel leagueModel = new LeagueModel();
        GamePlayConfigModel gamePLayModel = new GamePlayConfigModel();
        TradingModel tradingModel = TradingModelTest.getTradingModel (8,0.05f,2,0.05f);
        InjuriesModel injuriesModel = InjuriesModelTest.getInjuriesModel(0.05f,1,260);
        AgingModel agingModel = AgingModelTest.getAgingModel(35,50);
        GameResolverModel gameResolverModel = GameResolverModelTest.getgameResolverModel(0.1f);

        leagueModel.setLeagueName("Dalhousie Hockey League");
        List<ConferenceModel> conferenceModelObjectList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ConferenceModel conferenceModel = ConferenceModelTest.getConferenceObject();
            conferenceModelObjectList.add(conferenceModel);
        }
        leagueModel.setConferences(conferenceModelObjectList);
        List<FreeAgentModel> freeAgentModelList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            FreeAgentModel freeAgentModel = FreeAgentModelTest.getFreeAgentModel("Roshan", "forward", 18,2.0f,5.0f,6.0f,7.0f);
            FreeAgentModel freeAgentModel1 = FreeAgentModelTest.getFreeAgentModel("Arthy", "defense", 18,2.0f,5.0f,6.0f,7.0f);
            FreeAgentModel freeAgentModel2 = FreeAgentModelTest.getFreeAgentModel("Zankruth", "goalie", 18,2.0f,5.0f,6.0f,7.0f);
            freeAgentModelList.add(freeAgentModel);
            freeAgentModelList.add((freeAgentModel1));
            freeAgentModelList.add(freeAgentModel2);
        }
        leagueModel.setFreeAgents(freeAgentModelList);
        List<CoachModel> coachModelsList = new ArrayList<>();
        for (int i = 0;i < 3; i++){
            CoachModel coachModel = CoachModelTest.getCoachModel("Arthy", 2.0f,5.0f,6.0f,7.0f);
            coachModelsList.add(coachModel);
        }
        List<String> generalManagers = new ArrayList<String>(){
            {
                add("Arthy");
                add("Roshan");
                add("Zankrut");
                add("Khanjiga");
            }
        };
        leagueModel.setCoaches(coachModelsList);
        leagueModel.setGeneralManagers(generalManagers);
        leagueModel.setGameplayConfig(gamePLayModel);
        gamePLayModel.setTrading(tradingModel);
        gamePLayModel.setGameResolver(gameResolverModel);
        gamePLayModel.setInjuries(injuriesModel);
        gamePLayModel.setAging(agingModel);
        return leagueModel;
    }

    @Test
    void getLeagueId() {
        MockLeaguePersistent mock = new MockLeaguePersistent();
        assertEquals(mock.getLeagueId("League name"), 1);
    }


}
