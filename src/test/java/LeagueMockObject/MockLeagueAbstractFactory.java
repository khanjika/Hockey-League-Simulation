package LeagueMockObject;

import leagueobjectmodel.ICoachModel;
import leagueobjectmodel.IFreeAgentModel;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.IPlayerModel;

public abstract class MockLeagueAbstractFactory  {
    private static MockLeagueAbstractFactoryConcrete instance;

    public static MockLeagueAbstractFactory getMockInstance(){
        if(instance==null){
            instance=new MockLeagueAbstractFactoryConcrete();
        }
        return instance;
    }

    public abstract ILeagueModel createLeague();

    public abstract void setLeague(ILeagueModel league);

    public abstract IPlayerModel createPlayer();

    public abstract IFreeAgentModel createFreeAgent();

    public abstract ICoachModel createCoachModel();
}
