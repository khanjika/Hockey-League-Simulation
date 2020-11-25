package cli;

import leagueobjectmodel.CoachModel;
import leagueobjectmodel.FreeAgentModel;
import leagueobjectmodel.GeneralManagersModel;
import leagueobjectmodel.PlayerModel;

import java.util.List;

public interface IDisplayPersons {
    void displayTeamPlayers(List<PlayerModel> players);

    void displayCoaches(List<CoachModel> coaches);

    void displayManagers(List<GeneralManagersModel> generalManagers);

    void displayPlayers(List<FreeAgentModel> freeAgentModel);
}
