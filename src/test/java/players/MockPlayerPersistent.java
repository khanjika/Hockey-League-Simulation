package players;

import java.util.ArrayList;

class MockPlayerPersistent {

    void addPlayerInformation() {
    }

    ArrayList<PlayerModel> getPlayerInformation() throws Exception {
        ArrayList<PlayerModel> playersInfo = new ArrayList<PlayerModel> ();
        PlayerModel player = new PlayerModel ();
        player.setPlayerName ("Player One");
        player.setPosition ("Forward");
        player.setCaptain (true);
        playersInfo.add (player);
        return playersInfo;
    }
}