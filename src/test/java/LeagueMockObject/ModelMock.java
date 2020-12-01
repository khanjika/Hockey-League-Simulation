package LeagueMockObject;

import database.IDeserializeObject;
import database.SerializeObjectAbstractFactory;
import leagueobjectmodel.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ModelMock {

    IDeserializeObject parse = SerializeObjectAbstractFactory.instance ().createParser ();


    public ILeagueModel leagueModel() {
        ILeagueModel league = parse.parseJson ("src/test/java/league.json");
        List<IFreeAgentModel> freeAgents = league.getFreeAgents ();
        for (IFreeAgentModel agent : freeAgents) {
            agent.calculateFreeAgentStrength (agent);
        }
        for (IConferenceModel conference : league.getConferences ()) {
            for (IDivisonModel division : conference.getDivisions ()) {
                for (ITeamsModel team : division.getTeams ()) {
                    List<PlayerModel> players = team.getPlayers ();
                    for (int i = 0; i < players.size (); i++) {
                        players.get (i).calculatePlayerStrength (players.get (i));
                    }
                    team.calculateTeamStrength (team);
                }
            }
        }
        return league;
    }

    public ITeamsModel teamModel() {
        ILeagueModel league = leagueModel ();
        ITeamsModel teamsModel = league.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1);
        return teamsModel;
    }

    public ITradingModel tradeModel() {
        ILeagueModel league = leagueModel ();
        ITradingModel tradeModel = league.getGameplayConfig ().getTrading ();
        return tradeModel;
    }


    public List<PlayerModel> playerList() {
        List<PlayerModel> offeredPlayer = new ArrayList<> ();
        ITeamsModel team;
        ILeagueModel league = leagueModel ();
        team = league.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1);
        PlayerModel p = team.getPlayers ().get (1);
        PlayerModel p1 = team.getPlayers ().get (4);
        offeredPlayer.add (p);
        offeredPlayer.add (p1);
        return offeredPlayer;
    }

    public HashMap strengthHashMapModel() {
        HashMap<String, Float> strengthMap = new HashMap<> ();
        strengthMap.put (PlayerPosition.FORWARD.toString (), (float) 456.5);
        strengthMap.put (PlayerPosition.DEFENSE.toString (), (float) 314.5);
        strengthMap.put (PlayerPosition.GOALIE.toString (), (float) 91);
        return strengthMap;
    }
}
