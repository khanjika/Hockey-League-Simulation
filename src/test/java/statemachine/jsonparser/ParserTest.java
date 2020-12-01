package statemachine.jsonparser;

import database.IDeserializeObject;
import database.SerializeObjectAbstractFactory;
import leagueobjectmodel.ILeagueModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParserTest {
    @Test
    void parseJsonTest(){
        IDeserializeObject parse = SerializeObjectAbstractFactory.instance().createParser();
        ILeagueModel league = parse.parseJson ("src/test/java/league.json");
        assertNotNull(league);
    }
}
