package players;

import freeagent.FreeAgentModel;
import gameplayconfig.AgingModel;
import gameplayconfig.InjuriesModel;
import league.LeagueModel;
import teams.TeamsModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface IPlayerModel {

    void storePlayerInformation(PlayerModel playerModel,int teamId);

    ArrayList<PlayerModel> getPlayerInformation(int teamId);
    void calculatePlayerStrength(PlayerModel playerModel);
    void checkPlayerInjury(PlayerModel playerModel, LocalDate date);
    void recoverPlayer(PlayerModel playerModel, LocalDate date);
    void aging(PlayerModel playerModel, int daysToAge,LocalDate date);
    void setAgingModel(AgingModel agingModel);
    void setFreeAgentsList(List<FreeAgentModel> freeAgentList);
    void setInjuriesModel(InjuriesModel injuriesModel);
    InjuriesModel getInjuriesModel();
}
