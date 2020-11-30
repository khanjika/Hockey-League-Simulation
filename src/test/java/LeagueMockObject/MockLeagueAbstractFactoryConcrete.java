package LeagueMockObject;

import database.IDeserializeObject;
import database.SerializeObjectAbstractFactory;
import leagueobjectmodel.ILeagueModel;

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
}
