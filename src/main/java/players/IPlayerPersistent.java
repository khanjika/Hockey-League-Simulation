package players;

import java.util.ArrayList;

public interface IPlayerPersistent {

    void addPlayerInformation(String playerName, String position, boolean caption,int teamId);

    ArrayList<PlayerModel> getPlayerInformation(int teamId);
}
