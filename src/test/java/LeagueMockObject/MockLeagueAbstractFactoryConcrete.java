package LeagueMockObject;

import leagueobjectmodel.ILeagueModel;
import statemachine.jsonparser.IParser;
import statemachine.jsonparser.ParserAbstractFactory;

public class MockLeagueAbstractFactoryConcrete extends MockLeagueAbstractFactory {

    ILeagueModel leagueModel;

    @Override
    public ILeagueModel createLeague() {
        if (leagueModel == null) {
            IParser parser = ParserAbstractFactory.getInstance().getParser();
            leagueModel = parser.parseJson("src/test/java/league.json");
        }
        return leagueModel;
    }

    @Override
    public void setLeague(ILeagueModel league) {
        leagueModel = league;
    }
}
