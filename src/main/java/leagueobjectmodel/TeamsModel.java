package leagueobjectmodel;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TeamsModel implements ITeamsModel {

    @Expose
    private String teamName;
    @Expose
    private GeneralManagersModel generalManager;
    @Expose
    private HeadCoachModel headCoach;
    @Expose
    private List<PlayerModel> players;
    private final IPlayerModel playerModel;
    private float teamStrength;
    private int winPoint;
    private int lossPoint;
    private int lossPointForTrading;
    private List<PlayerModel> activeRoasters;
    private List<PlayerModel> inactiveRoasters;
    private int isGoalieStrong;
    private int isForwardStrong;
    private int isDefenseStrong;
    private ITeamsModel[] draftTrade = new ITeamsModel[7];

    @Override
    public ITeamsModel[] getDraftTrade() {
        return draftTrade;
    }

    @Override
    public void setDraftTrade(ITeamsModel[] draftTrade) {
        this.draftTrade = draftTrade;
    }

    @Override
    public int getIsGoalieStrong() {
        return isGoalieStrong;
    }

    @Override
    public void setIsGoalieStrong(int isGoalieStrong) {
        this.isGoalieStrong = isGoalieStrong;
    }

    @Override
    public int getIsForwardStrong() {
        return isForwardStrong;
    }

    @Override
    public void setIsForwardStrong(int isForwardStrong) {
        this.isForwardStrong = isForwardStrong;
    }

    @Override
    public int getIsDefenseStrong() {
        return isDefenseStrong;
    }

    @Override
    public void setIsDefenseStrong(int isDefenseStrong) {
        this.isDefenseStrong = isDefenseStrong;
    }

    @Override
    public void setTeamStrength(float teamStrength) {
        this.teamStrength = teamStrength;
    }

    public int getLossPointForTrading() {
        return lossPointForTrading;
    }

    @Override
    public void setLossPointForTrading(int lossPointForTrading) {
        this.lossPointForTrading = lossPointForTrading;
    }

    @Override
    public boolean isUserCreatedTeam() {
        return isUserCreatedTeam;
    }

    @Override
    public void setUserCreatedTeam(boolean userCreatedTeam) {
        isUserCreatedTeam = userCreatedTeam;
    }

    private boolean isUserCreatedTeam;

    public TeamsModel() {
        playerModel = new PlayerModel ();
    }

    @Override
    public String getTeamName() {
        return teamName;
    }

    @Override
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    @Override
    public HeadCoachModel getHeadCoach() {
        return headCoach;
    }

    @Override
    public void setHeadCoach(HeadCoachModel headCoach) {
        this.headCoach = headCoach;
    }

    @Override
    public List<PlayerModel> getPlayers() {
        return players;
    }

    @Override
    public void setPlayers(List<PlayerModel> players) {
        this.players = players;
    }

    @Override
    public float getTeamStrength() {
        return teamStrength;
    }

    @Override
    public GeneralManagersModel getGeneralManager() {
        return generalManager;
    }

    @Override
    public void setGeneralManager(GeneralManagersModel generalManager) {
        this.generalManager = generalManager;
    }

    @Override
    public void calculateTeamStrength(ITeamsModel teamsModel) {
        ISortTeams sortTeams = new SortTeams ();
        this.teamStrength = 0;
        for (PlayerModel playerModel : teamsModel.getPlayers ()) {
            this.teamStrength += playerModel.getPlayerStrength ();
        }
        setActiveRoasters (sortTeams.sortActiveRoasters (teamsModel.getPlayers ()));
        setInactiveRoasters (teamsModel.getPlayers ().stream ()
                .filter (v -> !getActiveRoasters ().contains (v)).collect (Collectors.toList ()));
    }

    @Override
    public List<PlayerModel> getActiveRoasters() {
        return activeRoasters;
    }

    @Override
    public void setActiveRoasters(List<PlayerModel> activeRoasters) {
        this.activeRoasters = activeRoasters;
    }

    @Override
    public List<PlayerModel> getInactiveRoasters() {
        return inactiveRoasters;
    }

    @Override
    public void setInactiveRoasters(List<PlayerModel> inactiveRoasters) {
        this.inactiveRoasters = inactiveRoasters;
    }

    @Override
    public void roasterReplacement(PlayerModel currentPlayer) {
        List<PlayerModel> matchedInactivePlayers = new ArrayList<> ();
        if (currentPlayer.isPlayerInjured () == false) {
            return;
        }
        for (PlayerModel player : this.getInactiveRoasters ()) {
            if (player.getPosition ().equals (currentPlayer.getPosition ()) && player.isPlayerInjured () == false) {
                matchedInactivePlayers.add (player);
            }
        }
        if (matchedInactivePlayers.size () == 0) {
            return;
        }
        PlayerModel replacementPlayer = Collections.max (matchedInactivePlayers, Comparator.comparing (v -> v.getPlayerStrength ()));
        getActiveRoasters ().remove (currentPlayer);
        currentPlayer.setIsActive (false);
        getActiveRoasters ().add (replacementPlayer);
        replacementPlayer.setIsActive (true);
        System.out.println (currentPlayer.getPlayerName () + " replaced with " + replacementPlayer.getPlayerName ());
    }

    @Override
    public List<PlayerModel> getTotalForwards() {
        List<PlayerModel> forwards = new ArrayList<> ();
        for (PlayerModel player : this.getPlayers ()) {
            if (player.getPosition ().equals (PlayerPosition.FORWARD.toString ())) {
                forwards.add (player);
            }
        }
        return forwards;
    }

    @Override
    public List<PlayerModel> getTotalDefenses() {
        List<PlayerModel> defenses = new ArrayList<> ();
        for (PlayerModel player : this.getPlayers ()) {
            if (player.getPosition ().equals (PlayerPosition.DEFENSE.toString ())) {
                defenses.add (player);
            }
        }
        return defenses;
    }

    @Override
    public List<PlayerModel> getTotalGoalies() {
        List<PlayerModel> goalies = new ArrayList<> ();
        for (PlayerModel player : this.getPlayers ()) {
            if (player.getPosition ().equals (PlayerPosition.GOALIE.toString ())) {
                goalies.add (player);
            }
        }
        return goalies;
    }

    @Override
    public int getWinPoint() {
        return winPoint;
    }

    @Override
    public void setWinPoint(int winPoint) {
        this.winPoint = winPoint;
    }

    @Override
    public int getLossPoint() {
        return lossPoint;
    }

    @Override
    public void setLossPoint(int lossPoint) {
        this.lossPoint = lossPoint;
    }

    @Override
    public PlayerModel getBestGoalieFromTheTeam(List<PlayerModel> list) {
        if (list == null) {
            throw new NullPointerException ();
        }
        PlayerModel currentBestGoalie = null;
        for (PlayerModel playerModel : list) {
            if (playerModel.getPosition ().equals ("goalie")) {
                if (currentBestGoalie == null) {
                    currentBestGoalie = playerModel;
                } else if (playerModel.getSaving () > currentBestGoalie.getSaving ()) {
                    currentBestGoalie = playerModel;
                }
            }
        }
        return currentBestGoalie;
    }

    @Override
    public List<PlayerModel> sortPlayersOfTeamAscending(List<PlayerModel> players) {
        players.sort (Comparator.comparing (PlayerModel::getPlayerStrength));
        return players;
    }

    @Override
    public List<PlayerModel> sortPlayersOfTeamDescending(List<PlayerModel> players) {
        players.sort (Comparator.comparing (PlayerModel::getPlayerStrength).reversed ());
        return players;
    }
}
