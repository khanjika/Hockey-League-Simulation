package teams;

import freeagent.FreeAgentModel;
import league.LeagueModel;
import players.PlayerModel;

import java.util.ArrayList;
import java.util.List;

public class AfterTradingTeamValidator implements IAfterTradingTeamValidator {
    List<FreeAgentModel> freeAgents = new ArrayList<> ();
    List<PlayerModel> players = new ArrayList<> ();
    ISortTeams sort = new SortTeams ();
    int skater = 18;
    int goalie = 2;

    enum playerPosition {
        forward,
        defense,
        goalie
    }

    @Override
    public List<PlayerModel> isCaptainPresent(List<PlayerModel> teamPlayerDetails) {
        int counter = 0;
        teamPlayerDetails = sort.sortPlayersDescending (teamPlayerDetails);
        for (int i = 0; i < teamPlayerDetails.size (); i++) {
            if (teamPlayerDetails.get (i).isCaptain ()) {
                counter++;
                if (counter == 2) {
                    teamPlayerDetails.get (i).setCaptain (false);
                }
            }
        }

        if (counter == 0 && !teamPlayerDetails.isEmpty ()) {
            teamPlayerDetails.stream ().findFirst ().get ().setCaptain (true);
        }
        return teamPlayerDetails;
    }

    @Override
    public LeagueModel teamIsValid(List<PlayerModel> validatePlayers, LeagueModel leagueModel) {
        int counterSkater = 0;
        int counterGoalie = 0;

        freeAgents = leagueModel.getFreeAgents ();

        for (FreeAgentModel agent : freeAgents) {
            agent.calculateFreeAgentStrength (agent);
        }

        players = validatePlayers;
        int sizeOfTeam = players.size ();

        for (int i = 0; i < players.size (); i++) {
            String position = players.get (i).getPosition ();
            if (position.equals (playerPosition.forward.toString ()) || position.equals (playerPosition.defense.toString ())) {
                counterSkater = counterSkater + 1;
            } else if (position.equals (playerPosition.goalie.toString ())) {
                counterGoalie = counterGoalie + 1;
            }
        }

        if (counterSkater == skater && counterGoalie == goalie) {
            return leagueModel;
        } else {
            if (counterSkater < skater) {
                addSkatersFromFreeagent (counterSkater, players);
            } else {
                removeSkaters (counterSkater, players);
            }

            if (counterGoalie < goalie) {
                addGoaliesFromFreeagent (counterGoalie, players);
            } else {
                removeGoalies (counterGoalie, players);
            }
            return leagueModel;
        }
    }

    public List<FreeAgentModel> addingFreeAgent(PlayerModel p) {
        FreeAgentModel agent = new FreeAgentModel ();
        agent.setPlayerName (p.getPlayerName ());
        agent.setPosition (p.getPosition ());
        agent.setAge (p.getAge ());
        agent.setSkating (p.getSkating ());
        agent.setShooting (p.getShooting ());
        agent.setChecking (p.getChecking ());
        agent.setSaving (p.getSaving ());
        agent.calculateFreeAgentStrength (agent);
        freeAgents.add (agent);
        return freeAgents;
    }

    public void removeGoalies(int counterGoalie, List<PlayerModel> players) {
        int counter = 0;
        List<PlayerModel> playersRemoved = new ArrayList<> ();
        int noOfGoaliesRemoved = counterGoalie - goalie;
        players = sort.sortPlayersAscending (players);
        for (int i = 0; i < players.size (); i++) {
            if (counter < noOfGoaliesRemoved) {
                if (players.get (i).getPosition ().equals (playerPosition.goalie.toString ())) {
                    counter++;
                    PlayerModel p = players.get (i);
                    addingFreeAgent (p);
                    playersRemoved.add (players.get (i));
                }
            }
        }
        for (int j = 0; j < playersRemoved.size (); j++) {
            players.remove (playersRemoved.get (j));
        }
    }

    public void removeSkaters(int counterSkater, List<PlayerModel> players) {
        int counter = 0;
        List<PlayerModel> playersRemoved = new ArrayList<> ();
        int noOfSkatersRemoved = counterSkater - skater;
        players = sort.sortPlayersAscending (players);
        for (int i = 0; i < players.size (); i++) {
            if (counter < noOfSkatersRemoved) {
                if (players.get (i).getPosition ().equals (playerPosition.forward.toString ()) || players.get (i).getPosition ().equals (playerPosition.defense.toString ())) {
                    counter++;
                    PlayerModel p = players.get (i);
                    addingFreeAgent (p);
                    playersRemoved.add (players.get (i));
                }
            }
        }
        for (int j = 0; j < playersRemoved.size (); j++) {
            players.remove (playersRemoved.get (j));
        }
    }

    public List<PlayerModel> addingPlayer(FreeAgentModel f) {
        PlayerModel playerAdded = new PlayerModel ();
        playerAdded.setPlayerName (f.getPlayerName ());
        playerAdded.setPosition (f.getPosition ());
        playerAdded.setCaptain (false);
        playerAdded.setAge (f.getAge ());
        playerAdded.setSkating (f.getSkating ());
        playerAdded.setShooting (f.getShooting ());
        playerAdded.setChecking (f.getChecking ());
        playerAdded.setSaving (f.getSaving ());
        playerAdded.calculatePlayerStrength (playerAdded);
        players.add (playerAdded);
        return players;
    }

    public void addGoaliesFromFreeagent(int counterGoalie, List<PlayerModel> players) {
        int counter = 0;
        List<FreeAgentModel> agentsRemoved = new ArrayList<> ();
        List<FreeAgentModel> sortFreeAgent = sort.sortFreeAgentDescending (freeAgents);
        int goaliesRequired = goalie - counterGoalie;
        for (int i = 0; i < sortFreeAgent.size (); i++) {
            if (counter <= goaliesRequired && sortFreeAgent.get (i).getPosition ().equals (playerPosition.goalie.toString ())) {
                counter++;
                FreeAgentModel f = freeAgents.get (i);
                addingPlayer (f);
                agentsRemoved.add (sortFreeAgent.get (i));
            }
        }
        for (int j = 0; j < agentsRemoved.size (); j++) {
            freeAgents.remove (agentsRemoved.get (j));
        }
    }

    public void addSkatersFromFreeagent(int counterSkater, List<PlayerModel> players) {
        int counter = 0;
        List<FreeAgentModel> AgentsRemoved = new ArrayList<> ();
        List<FreeAgentModel> sortFreeAgent = sort.sortFreeAgentDescending (freeAgents);
        int skatersRequired = skater - counterSkater;
        for (int i = 0; i < sortFreeAgent.size (); i++) {
            if (counter < skatersRequired) {
                if (sortFreeAgent.get (i).getPosition ().equals (playerPosition.forward.toString ()) || sortFreeAgent.get (i).getPosition ().equals (playerPosition.defense.toString ())) {
                    counter++;
                    FreeAgentModel f = freeAgents.get (i);
                    addingPlayer (f);
                    AgentsRemoved.add (sortFreeAgent.get (i));
                }
            }
        }
        for (int j = 0; j < AgentsRemoved.size (); j++) {
            freeAgents.remove (AgentsRemoved.get (j));
        }
    }
}
