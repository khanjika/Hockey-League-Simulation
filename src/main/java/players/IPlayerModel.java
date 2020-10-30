package players;

import league.LeagueModel;
import teams.TeamsModel;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IPlayerModel {

    void storePlayerInformation(PlayerModel playerModel,int teamId);

    ArrayList<PlayerModel> getPlayerInformation(int teamId);

    void calculatePlayerStrength(PlayerModel playerModel);
    void checkPlayerInjury(PlayerModel playerModel, LocalDate date);
    void recoverPlayer(PlayerModel playerModel, LocalDate date);
    void aging(PlayerModel playerModel, int daysToAge);
}
