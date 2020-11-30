package mock;

import database.IDeserializeObject;
import database.SerializeObjectAbstractFactory;
import leagueobjectmodel.*;
import statemachine.trade.ICalculateStrength;
import statemachine.trade.TradeAbstractFactory;

import java.util.HashMap;
import java.util.List;

public class ModelMock {

    IDeserializeObject parse = SerializeObjectAbstractFactory.instance().createParser();
    ICalculateStrength calculateStrength = TradeAbstractFactory.instance ().createStrength ();

    private enum playerPosition {
        forward,
        defense,
        goalie
    }

    public ILeagueModel leagueModel() {
        ILeagueModel league = parse.parseJson ("src/test/java/league.json");
        List<FreeAgentModel> freeAgents = league.getFreeAgents ();
        for (FreeAgentModel agent : freeAgents) {
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
                    HashMap x = calculateStrength.findPositionStrength (team);
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
        ITeamsModel teamsModel = teamModel ();
        List<PlayerModel> playerList = teamsModel.getPlayers ();
        return playerList;
    }

    public HashMap strengthHashMapModel() {
        HashMap<String, Float> strengthMap = new HashMap<> ();
        strengthMap.put (playerPosition.forward.toString (), (float) 456.5);
        strengthMap.put (playerPosition.defense.toString (), (float) 314.5);
        strengthMap.put (playerPosition.goalie.toString (), (float) 91);
        return strengthMap;
    }

}
