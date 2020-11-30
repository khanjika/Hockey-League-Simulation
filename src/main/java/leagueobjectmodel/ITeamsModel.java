package leagueobjectmodel;

import java.util.List;

public interface ITeamsModel {
    int getLossPointForTrading();

    void setLossPointForTrading(int lossPointForTrading);

    boolean isUserCreatedTeam();

    void setUserCreatedTeam(boolean userCreatedTeam);

    String getTeamName();

    void setTeamName(String teamName);

    HeadCoachModel getHeadCoach();

    void setHeadCoach(HeadCoachModel headCoach);

    void setTeamStrength(float teamStrength);

    List<PlayerModel> getPlayers();

    void setPlayers(List<PlayerModel> players);

    float getTeamStrength();

    GeneralManagersModel getGeneralManager();

    void setGeneralManager(GeneralManagersModel generalManager);

    void calculateTeamStrength(ITeamsModel teamsModel);

    List<PlayerModel> getTotalForwards();

    List<PlayerModel> getTotalDefenses();

    List<PlayerModel> getTotalGoalies();

    List<PlayerModel> getActiveRoasters();

    void setActiveRoasters(List<PlayerModel> activeRoasters);

    List<PlayerModel> getInactiveRoasters();

    void setInactiveRoasters(List<PlayerModel> inactiveRoasters);

    void roasterReplacement(PlayerModel currentPlayer);

    int getWinPoint();

    void setWinPoint(int winPoint);

    int getLossPoint();

    void setLossPoint(int lossPoint);


    PlayerModel getBestGoalieFromTheTeam(List<PlayerModel> list);

    List<PlayerModel> sortPlayersOfTeamAscending(List<PlayerModel> players);

    List<PlayerModel> sortPlayersOfTeamDescending(List<PlayerModel> players);

    int getIsGoalieStrong();

    void setIsGoalieStrong(int isGoalieStrong);

    int getIsForwardStrong();

    void setIsForwardStrong(int isForwardStrong);

    int getIsDefenseStrong();

    void setIsDefenseStrong(int isDefenseStrong);

    ITeamsModel[] getDraftTrade();

    void setDraftTrade(ITeamsModel[] draftTrade);

}
