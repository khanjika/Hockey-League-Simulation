package cli;

import leagueobjectmodel.CoachModel;
import leagueobjectmodel.FreeAgentModel;
import leagueobjectmodel.GeneralManagersModel;
import leagueobjectmodel.PlayerModel;

import java.util.List;

public interface IDisplay {
    void displayTeamPlayers(List<PlayerModel> players);

    void displayCoaches(List<CoachModel> coaches);

    void displayManagers(List<GeneralManagersModel> generalManagers);

    void displayFreeAgents(List<FreeAgentModel> freeAgentModel);

    void displayAwards(String trophy, String winner, int year);
}
