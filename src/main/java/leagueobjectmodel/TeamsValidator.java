package leagueobjectmodel;

import cli.CliAbstractFactory;
import cli.ICli;
import database.IFileValidator;
import database.SerializeObjectAbstractFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeamsValidator implements ITeamsValidator {
    private static final IPlayerValidator playerValidator = new PlayerValidator ();
    private static final IHeadCoachValidator headCoachValidator = new HeadCoachValidator ();
    private static final IFileValidator fileValidator = SerializeObjectAbstractFactory.instance ().createFileValidator ();
    private static final int totalForward = 16;
    private static final int totalDefense = 10;
    private static final int totalGoalie = 4;
    private ITeamsModel teamsModel;
    private IFreeAgentModel freeAgent;
    private boolean isPlayerCaptain = false;
    private int defense = 0;
    private int goalie = 0;
    private int forward = 0;
    ICli cli = CliAbstractFactory.getInstance().getCli();

    public TeamsValidator() {
        teamsModel = LeagueObjectModelAbstractFactory.getInstance ().getTeams ();
        freeAgent = LeagueObjectModelAbstractFactory.getInstance ().getFreeAgent ();
    }

    @Override
    public boolean validateTeamObject(ITeamsModel teamsModel) {
        defense = 0;
        goalie = 0;
        forward = 0;
        if (Objects.nonNull (teamsModel.getGeneralManager ()) && isStringValid (teamsModel.getTeamName ())) {
            for (PlayerModel playerModel : teamsModel.getPlayers ()) {
                if (playerModel.getPosition ().equals (PlayerPosition.DEFENSE.toString ())) {
                    defense++;
                } else if (playerModel.getPosition ().equals (PlayerPosition.FORWARD.toString ())) {
                    forward++;
                } else {
                    goalie++;
                }
                if (playerValidator.validatePlayerObject (playerModel)) {
                    if (playerModel.isCaptain () && isPlayerCaptain == true) {
                        isPlayerCaptain = false;
                         cli.printOutput("There can be only one captain in the team ==>" + teamsModel.getTeamName ());
                        return false;
                    } else if (playerModel.isCaptain ()) {
                        isPlayerCaptain = true;
                    } else {
                        continue;
                    }
                    if (headCoachValidator.validateHeadCoachObject (teamsModel.getHeadCoach ())) {
                        continue;
                    }


                } else {
                    cli.printOutput("Encountered Problem while validating Players in team ==> " + teamsModel.getTeamName ());
                    return false;
                }
            }
        } else {
            return false;
        }
        if (isPlayerCaptain) {
            isPlayerCaptain = false;
            if (forward == 16 && defense == 10 && goalie == 4) {
                return true;
            } else {
                cli.printOutput ("Player Position Count is not valid in team --> " + teamsModel.getTeamName ());
                return false;
            }
        } else {
            cli.printOutput("There seems to be no captain in team -->" + teamsModel.getTeamName ());
            return false;
        }
    }

    @Override
    public boolean isTeamAlreadyExist(String teamName) {
        return fileValidator.isFileExist (teamName);
    }

    private boolean isStringValid(String str) {
        if(str==null || str.isEmpty()){
            return false;
        }
        else
            return true;
    }

    @Override
    public List<PlayerModel> isCaptainPresent(List<PlayerModel> teamPlayers) {
        int counter = 0;
        teamPlayers = teamsModel.sortPlayersOfTeamDescending (teamPlayers);
        for (int i = 0; i < teamPlayers.size (); i++) {
            if (teamPlayers.get (i).isCaptain ()) {
                counter++;
                if (counter == 2) {
                    teamPlayers.get (i).setCaptain (false);
                }
            }
        }
        if (counter == 0 && !teamPlayers.isEmpty ()) {
            teamPlayers.stream ().findFirst ().get ().setCaptain (true);
        }
        return teamPlayers;
    }

    @Override
    public ILeagueModel NoOfPlayersInTeam(List<PlayerModel> teamPlayers, ILeagueModel leagueModel) {
        int counterForward = 0;
        int counterDefense = 0;
        int counterGoalie = 0;

        List<IFreeAgentModel> freeAgents = leagueModel.getFreeAgents ();

        for (int i = 0; i < teamPlayers.size (); i++) {
            String position = teamPlayers.get (i).getPosition ();
            if (position.equals (PlayerPosition.FORWARD.toString ())) {
                counterForward = counterForward + 1;
            } else if (position.equals (PlayerPosition.GOALIE.toString ())) {
                counterGoalie = counterGoalie + 1;
            } else {
                counterDefense = counterDefense + 1;
            }
        }
        if (counterForward == totalForward && counterGoalie == totalGoalie && counterDefense == totalDefense) {
            return leagueModel;
        } else {
            if (counterForward < totalForward) {
                int forwardRequired = totalForward - counterForward;
                addFromFreeAgent (forwardRequired, teamPlayers, freeAgents, PlayerPosition.FORWARD.toString ());
            } else if (counterForward > totalForward) {
                int noOfForwardRemoved = counterForward - totalForward;
                removePlayers (noOfForwardRemoved, teamPlayers, freeAgents, PlayerPosition.FORWARD.toString ());
            }

            if (counterDefense < totalDefense) {
                int defenseRequired = totalDefense - counterDefense;
                addFromFreeAgent (defenseRequired, teamPlayers, freeAgents, PlayerPosition.DEFENSE.toString ());
            } else if (counterDefense > totalDefense) {
                int noOfDefenseRemoved = counterDefense - totalDefense;
                removePlayers (noOfDefenseRemoved, teamPlayers, freeAgents, PlayerPosition.DEFENSE.toString ());
            }

            if (counterGoalie < totalGoalie) {
                int goaliesRequired = totalGoalie - counterGoalie;
                addFromFreeAgent (goaliesRequired, teamPlayers, freeAgents, PlayerPosition.GOALIE.toString ());
            } else if (counterGoalie > totalGoalie) {
                int noOfGoaliesRemoved = counterGoalie - totalGoalie;
                removePlayers (noOfGoaliesRemoved, teamPlayers, freeAgents, PlayerPosition.GOALIE.toString ());
            }
            return leagueModel;
        }
    }

    @Override
    public List<IFreeAgentModel> removePlayers(int noOfRemovedPlayers, List<PlayerModel> players, List<IFreeAgentModel> freeAgents, String position) {
        int counter = 0;
        List<PlayerModel> playersRemoved = new ArrayList<> ();
        players = teamsModel.sortPlayersOfTeamAscending (players);
        for (int i = 0; i < players.size (); i++) {
            if (counter < noOfRemovedPlayers) {
                if (players.get (i).getPosition ().equals (position)) {
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
        return freeAgents;
    }

    @Override
    public List<IFreeAgentModel> addFromFreeAgent(int playersRequired, List<PlayerModel> players, List<IFreeAgentModel> freeAgents, String position) {
        int counter = 0;
        List<IFreeAgentModel> agentsRemoved = new ArrayList<> ();

        for (IFreeAgentModel agent : freeAgents) {
            agent.calculateFreeAgentStrength (agent);
        }

        List<IFreeAgentModel> sortFreeAgent = freeAgent.sortFreeAgentDescending (freeAgents);
        for (int i = 0; i < sortFreeAgent.size (); i++) {
            if (counter < playersRequired && sortFreeAgent.get (i).getPosition ().equals (position)) {
                counter++;
                IFreeAgentModel f = freeAgents.get (i);
                addingPlayer (f, players);
                agentsRemoved.add (sortFreeAgent.get (i));
            }
        }
        for (int j = 0; j < agentsRemoved.size (); j++) {
            freeAgents.remove (agentsRemoved.get (j));
        }
        return freeAgents;
    }

    @Override
    public List<PlayerModel> addingPlayer(IFreeAgentModel f, List<PlayerModel> players) {
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

    @Override
    public List<IFreeAgentModel> addingFreeAgent(PlayerModel p, List<IFreeAgentModel> freeAgents) {
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
}
