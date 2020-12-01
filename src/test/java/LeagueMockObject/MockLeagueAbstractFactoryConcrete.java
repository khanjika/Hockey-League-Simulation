package LeagueMockObject;

import database.IDeserializeObject;
import database.SerializeObjectAbstractFactory;
import leagueobjectmodel.*;

public class MockLeagueAbstractFactoryConcrete extends MockLeagueAbstractFactory {

    ILeagueModel leagueModel;

    @Override
    public ILeagueModel createLeague() {
        if (leagueModel == null) {
            IDeserializeObject parser = SerializeObjectAbstractFactory.instance().createParser();
            leagueModel = parser.parseJson("src/test/java/league.json");
        }
        return leagueModel;
    }

    @Override
    public void setLeague(ILeagueModel league) {
        leagueModel = league;
    }

    @Override
    public IPlayerModel createPlayer() {
        return new PlayerModel();
    }

    @Override
    public IFreeAgentModel createFreeAgent() {
        return new FreeAgentModel();
    }

    @Override
    public ICoachModel createCoachModel() {
        return new CoachModel();
    }

    public IPlayerModel createMockPlayer(){
        return leagueModel.getConferences().get(0).getDivisions().get(0).getTeams().get(0).getPlayers().get(0);
    }
}
