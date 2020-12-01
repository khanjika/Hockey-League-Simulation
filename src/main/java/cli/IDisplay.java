package cli;

import leagueobjectmodel.*;

import java.util.List;

public interface IDisplay {
    void displayTeamPlayers(List<PlayerModel> players);

    void displayCoaches(List<ICoachModel> coaches);

    void displayManagers(List<IGeneralManagersModel> generalManagers);

    void displayFreeAgents(List<IFreeAgentModel> freeAgentModel);
}
