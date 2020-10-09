package league;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MockLeaguePersistent {

    int addLeagueInformation() {
       return 1;
    }

    boolean isLeagueAlreadyExist(String leagueName) {
        return true;
    }

    String getLeagueInformation() {
        return "Dalhousie Hockey League";
    }

    int getLeagueId(String leagueName){
        return 1;
    }
}
