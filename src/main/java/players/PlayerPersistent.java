package players;

import database.CallStoredProcedure;

public class PlayerPersistent implements IPlayerPersistent{
    @Override
    public void addPlayerInformation(String playerName, String position, boolean captaion, int teamId) {
        CallStoredProcedure proc = null;

    }
}
