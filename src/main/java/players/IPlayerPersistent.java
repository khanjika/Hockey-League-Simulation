package players;

public interface IPlayerPersistent {

    int addPlayerInformation(String playerName, String position, boolean captaion,int teamId);

    boolean storePlayerId (int playerId,int teamId);
}
