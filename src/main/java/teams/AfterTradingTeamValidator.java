package teams;

import freeagent.FreeAgentModel;
import league.LeagueModel;
import players.PlayerModel;

import java.util.ArrayList;
import java.util.List;

public class AfterTradingTeamValidator implements IAfterTradingTeamValidator {
    ISortTeams sort = new SortTeams ();
    int skater = 6;
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
        List<FreeAgentModel> freeAgents = new ArrayList<> ();
        List<PlayerModel> players = new ArrayList<> ();
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
                int skatersRequired = skater - counterSkater;
                addSkatersFromFreeagent (skatersRequired, players, freeAgents);
            } else {
                int noOfSkatersRemoved = counterSkater - skater;
                removeSkaters (noOfSkatersRemoved, players, freeAgents);
            }

            if (counterGoalie < goalie) {
                int goaliesRequired = goalie - counterGoalie;
                addGoaliesFromFreeagent (goaliesRequired, players, freeAgents);
            } else {
                int noOfGoaliesRemoved = counterGoalie - goalie;
                removeGoalies (noOfGoaliesRemoved, players, freeAgents);
            }
            return leagueModel;
        }
    }

    public List<FreeAgentModel> addingFreeAgent(PlayerModel p, List<FreeAgentModel> freeAgents) {
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

    public void removeGoalies(int noOfGoaliesRemoved, List<PlayerModel> players, List<FreeAgentModel> freeAgents) {
        int counter = 0;
        List<PlayerModel> playersRemoved = new ArrayList<> ();
        players = sort.sortPlayersAscending (players);
        for (int i = 0; i < players.size (); i++) {
            if (counter < noOfGoaliesRemoved) {
                if (players.get (i).getPosition ().equals (playerPosition.goalie.toString ())) {
                    counter++;
                    PlayerModel p = players.get (i);
                    addingFreeAgent (p, freeAgents);
                    playersRemoved.add (players.get (i));
                }
            }
        }
        for (int j = 0; j < playersRemoved.size (); j++) {
            players.remove (playersRemoved.get (j));
        }
    }

    public void removeSkaters(int noOfSkatersRemoved, List<PlayerModel> players, List<FreeAgentModel> freeAgents) {
        int counter = 0;
        List<PlayerModel> playersRemoved = new ArrayList<> ();
        players = sort.sortPlayersAscending (players);
        for (int i = 0; i < players.size (); i++) {
            if (counter < noOfSkatersRemoved) {
                if (players.get (i).getPosition ().equals (playerPosition.forward.toString ()) || players.get (i).getPosition ().equals (playerPosition.defense.toString ())) {
                    counter++;
                    PlayerModel p = players.get (i);
                    addingFreeAgent (p, freeAgents);
                    playersRemoved.add (players.get (i));
                }
            }
        }
        for (int j = 0; j < playersRemoved.size (); j++) {
            players.remove (playersRemoved.get (j));
        }
    }

    public List<PlayerModel> addingPlayer(FreeAgentModel f, List<PlayerModel> players) {
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

    public void addGoaliesFromFreeagent(int goaliesRequired, List<PlayerModel> players, List<FreeAgentModel> freeAgents) {
        int counter = 0;
        List<FreeAgentModel> agentsRemoved = new ArrayList<> ();
        List<FreeAgentModel> sortFreeAgent = sort.sortFreeAgentDescending (freeAgents);
        for (int i = 0; i < sortFreeAgent.size (); i++) {
            if (counter <= goaliesRequired && sortFreeAgent.get (i).getPosition ().equals (playerPosition.goalie.toString ())) {
                counter++;
                FreeAgentModel f = freeAgents.get (i);
                addingPlayer (f, players);
                agentsRemoved.add (sortFreeAgent.get (i));
            }
        }
        for (int j = 0; j < agentsRemoved.size (); j++) {
            freeAgents.remove (agentsRemoved.get (j));
        }
    }

    public void addSkatersFromFreeagent(int skatersRequired, List<PlayerModel> players, List<FreeAgentModel> freeAgents) {
        int counter = 0;
        List<FreeAgentModel> AgentsRemoved = new ArrayList<> ();
        List<FreeAgentModel> sortFreeAgent = sort.sortFreeAgentDescending (freeAgents);

        for (int i = 0; i < sortFreeAgent.size (); i++) {
            if (counter < skatersRequired) {
                if (sortFreeAgent.get (i).getPosition ().equals (playerPosition.forward.toString ()) || sortFreeAgent.get (i).getPosition ().equals (playerPosition.defense.toString ())) {
                    counter++;
                    FreeAgentModel f = freeAgents.get (i);
                    addingPlayer (f, players);
                    AgentsRemoved.add (sortFreeAgent.get (i));
                }
            }
        }
        for (int j = 0; j < AgentsRemoved.size (); j++) {
            freeAgents.remove (AgentsRemoved.get (j));
        }
    }
}
