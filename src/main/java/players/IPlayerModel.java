package players;

import league.LeagueModel;
import teams.TeamsModel;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IPlayerModel {

    void storePlayerInformation(PlayerModel playerModel,int teamId);

    ArrayList<PlayerModel> getPlayerInformation(int teamId);

    void calculatePlayerStrength(PlayerModel playerModel);
    void checkPlayerInjury(LeagueModel leagueModel, TeamsModel teamsModel, LocalDate date);
    void recoverPlayer(LeagueModel leagueModel, TeamsModel teamsModel, LocalDate date);
    void aging(LeagueModel leagueModel, LocalDate date);
}
