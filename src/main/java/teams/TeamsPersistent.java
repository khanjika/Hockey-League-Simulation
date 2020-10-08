package teams;

import database.CallStoredProcedure;
import league.LeagueModel;

import java.sql.ResultSet;

public class TeamsPersistent implements ITeamsPersistent{


    @Override
    public int addTeamInformation(String teamName, String headCoach, String generalManager, int divisionId) {

        return 0;
    }

    @Override
    public boolean isTeamNameExist(String teamName) {
      return false;
    }

    @Override
    //PENDING
    public void getTeamInformation(String teamName) {

    }


}
