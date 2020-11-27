package leagueobjectmodel;

import java.util.Objects;

public class TeamsValidator implements ITeamsValidator {
    private static final IPlayerValidator playerValidator = new PlayerValidator();
    private static final IHeadCoachValidator headCoachValidator = new HeadCoachValidator();
    private static final IFileValidator fileValidator= SerializeObjectAbstractFactory.getInstance().getFileValidator();
    private boolean isPlayerCaptain = false;
    private int defense = 0;
    private int goalie = 0;
    private int forward = 0;

    @Override
    public boolean validateTeamObject(TeamsModel teamsModel) {
        defense = 0;
        goalie = 0;
        forward = 0;
        if (Objects.nonNull(teamsModel.getGeneralManager()) && isStringValid(teamsModel.getTeamName())) {
            for (PlayerModel playerModel : teamsModel.getPlayers()) {
                if(playerModel.getPosition().equals(PlayerPosition.DEFENSE.toString())){
                    defense++;
                }
                else if(playerModel.getPosition().equals(PlayerPosition.FORWARD.toString())){
                    forward++;
                }
                else{
                    goalie++;
                }
                if (playerValidator.validatePlayerObject(playerModel)) {
                    if (playerModel.isCaptain() && isPlayerCaptain == true) {
                        isPlayerCaptain = false;
                        System.out.println("There can be only one captain in the team ==>" + teamsModel.getTeamName());
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
                    System.out.println("Encountered Problem while validating Players in team ==> " + teamsModel.getTeamName());
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
                System.out.println(forward);
                System.out.println(defense);
                System.out.println(goalie);
                System.out.println("Player Position Count is not valid in team --> "+teamsModel.getTeamName());
                return false;
            }
        } else {
            System.out.println("There seems to be no captain in team -->" +teamsModel.getTeamName());
            return false;
        }
    }
    @Override
    public boolean isTeamAlreadyExist(String teamName){
        return fileValidator.isFileExist(teamName);
    }

    private boolean isStringValid(String str) {
        return str != null && str != "";
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

        List<FreeAgentModel> freeAgents = leagueModel.getFreeAgents ();

        for (int i = 0; i < teamPlayers.size (); i++) {
            String position = teamPlayers.get (i).getPosition ();
            if (position.equals (playerPosition.forward.toString ())) {
                counterForward = counterForward + 1;
            } else if (position.equals (playerPosition.goalie.toString ())) {
                counterGoalie = counterGoalie + 1;
            } else {
                counterDefense = counterDefense + 1;
            }
        }
        if (counterForward == forward && counterGoalie == goalie && counterDefense == defense) {
            return leagueModel;
        } else {
            if (counterForward < forward ) {
                int forwardRequired = forward - counterForward;
                addFromFreeAgent (forwardRequired, teamPlayers, freeAgents, playerPosition.forward.toString ());
            } else if(counterForward > forward) {
                int noOfForwardRemoved = counterForward - forward;
                removePlayers (noOfForwardRemoved, teamPlayers, freeAgents, playerPosition.forward.toString ());
            }

            if (counterDefense < defense) {
                int defenseRequired = defense - counterDefense;
                addFromFreeAgent (defenseRequired, teamPlayers, freeAgents, playerPosition.defense.toString ());
            } else if (counterDefense > defense){
                int noOfDefenseRemoved = counterDefense - defense;
                removePlayers (noOfDefenseRemoved, teamPlayers, freeAgents, playerPosition.defense.toString ());
            }

            if (counterGoalie < goalie) {
                int goaliesRequired = goalie - counterGoalie;
                addFromFreeAgent (goaliesRequired, teamPlayers, freeAgents, playerPosition.goalie.toString ());
            } else if (counterGoalie > goalie){
                int noOfGoaliesRemoved = counterGoalie - goalie;
                removePlayers (noOfGoaliesRemoved, teamPlayers, freeAgents, playerPosition.goalie.toString ());
            }
            return leagueModel;
        }
    }

    public void removePlayers(int noOfRemovedPlayers, List<PlayerModel> players, List<FreeAgentModel> freeAgents, String position) {
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
    }

    public void addFromFreeAgent(int playersRequired, List<PlayerModel> players, List<FreeAgentModel> freeAgents, String position) {
        int counter = 0;
        List<IFreeAgentModel> agentsRemoved = new ArrayList<> ();

        for (FreeAgentModel agent : freeAgents) {
            agent.calculateFreeAgentStrength (agent);
        }

        List<FreeAgentModel> sortFreeAgent = freeAgent.sortFreeAgentDescending (freeAgents);
        for (int i = 0; i < sortFreeAgent.size (); i++) {
            if (counter < playersRequired && sortFreeAgent.get (i).getPosition ().equals (position)) {
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
}
