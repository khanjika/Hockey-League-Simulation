package players;

import java.util.ArrayList;

public interface IPlayerModel {

    void storePlayerInformation(PlayerModel playerModel,int teamId);

    ArrayList<PlayerModel> getPlayerInformation(int teamId);

    void calculatePlayerStrength(PlayerModel playerModel);
}
