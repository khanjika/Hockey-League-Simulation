package players;

import java.util.ArrayList;

public interface IPlayerPersistent {
//
//<<<<<<< HEAD
//    int addPlayerInformation(String playerName, String position, boolean captaion,int teamId);

    boolean storePlayerId (int playerId,int teamId);
    void addPlayerInformation(String playerName, String position, boolean caption,int teamId);

    ArrayList<PlayerModel> getPlayerInformation(int teamId);

}
