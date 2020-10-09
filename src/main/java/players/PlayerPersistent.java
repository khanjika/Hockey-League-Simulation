package players;

import database.CallStoredProcedure;

public class PlayerPersistent implements IPlayerPersistent{
    @Override
    public int addPlayerInformation(String playerName, String position, boolean captaion, int teamId) {
        CallStoredProcedure proc = null;
        return 0;
    }

    @Override
    public boolean storePlayerId(int playerId, int teamId) {
        return false;
    }
}
