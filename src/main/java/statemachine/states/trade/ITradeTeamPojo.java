package statemachine.states.trade;

import leagueobjectmodel.PlayerModel;
import java.util.List;

public interface ITradeTeamPojo {
    String getTeamName();

    void setTeamName(String teamName);

    String getDivisionName();

    void setDivisionName(String divisionName);

    String getConferenceName();

    void setConferenceName(String conferenceName);

    boolean isUserCreated();

    void setUserCreated(boolean userCreated);

    int getIsForwardStrong();

    void setIsForwardStrong(int isForwardStrong);

    int getIsDefenseStrong();

    void setIsDefenseStrong(int isDefenseStrong);

    int getIsGoalieStrong();

    void setIsGoalieStrong(int isGoalieStrong);

    void setPlayersList(List<PlayerModel> playersList);

    List<PlayerModel> getPlayersList();
}
