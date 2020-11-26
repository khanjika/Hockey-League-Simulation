package database.serializeobject;

import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.LeagueModelTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SerializeObjectTest {
    @Test
    void serializeLeagueObjectTest() {
        ILeagueModel leagueModel = LeagueModelTest.getLeagueObject();
        ISerializeObject serializeObject = SerializeObjectAbstractFactory.getInstance().getSerializeObject();
        assertTrue(serializeObject.serializeLeagueObject(leagueModel,"testing"));
    }
}
