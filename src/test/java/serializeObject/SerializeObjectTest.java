package serializeObject;

import league.LeagueModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SerializeObjectTest {
    @Test
    void serializeLeagueObjectTest(){
        LeagueModel leagueModel = new LeagueModel();
        SerializeObject serializeObject = new SerializeObject();
        assertTrue(serializeObject.serializeLeagueObject(leagueModel));
    }
}
